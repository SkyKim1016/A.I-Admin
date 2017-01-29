package com.onethefull.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.req.BaseReq;
import com.onethefull.recipe.mapper.RcmdMapper;
import com.onethefull.recipe.mapper.RecipeMapper;
import com.onethefull.recipe.req.AIRecipeReq;
import com.onethefull.recipe.req.AIRecipeSeqReq;
import com.onethefull.recipe.req.FridgeIngrReq;
import com.onethefull.recipe.req.RecipeReq;
import com.onethefull.recipe.res.FridgeIngr;
import com.onethefull.recipe.res.RecipeDetail;
import com.onethefull.recipe.res.RecipeDetailNutrient;
import com.onethefull.recipe.res.RecipeDetailProcess;
import com.onethefull.recipe.vo.AiRecipeDetailVO;
import com.onethefull.recipe.vo.AiRecipeIngriVO;
import com.onethefull.recipe.vo.AiRecipePhaseVO;
import com.onethefull.recipe.vo.CookingStep;
import com.onethefull.recipe.vo.FridgeIngrVO;
import com.onethefull.recipe.vo.RecipeIngrVOwithDday;
import com.onethefull.recipe.vo.RecipeMasterVO;
import com.onethefull.recipe.vo.StuffVO;

@Service("recipeService")
public class RecipeService {

	@Value("#{serverProperty['domain.url']}")
	private String domainUrl;

	@Resource(name = "recipeMapper")
	private RecipeMapper recipeMapper;
	
	@Resource(name = "rcmdMapper")
	private RcmdMapper rcmdMapper;
	
	
	public ResultWithData getRecipeDetail(RecipeReq req) {

		RecipeDetail detail = this.getRecipeDetail(req, "ALL");
		
		if(detail == null) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NOTEXIST).setMessage("recipe does not exist");
		}
		
		return ResultWithData.succcessResult().addData("recipe", detail);

	}

	public RecipeDetail getRecipeDetail(RecipeReq req, String dtype) {

		// 조회수 증가
		try {
			recipeMapper.increaseViewCount(req);
		} catch(Exception e) {
			
		}

		RecipeMasterVO recipevo = recipeMapper.getRecipeDetailMaster(req);
		
		if(recipevo == null) {
			return null;
		}
		List<FridgeIngr> stuffs = new ArrayList<FridgeIngr>();
		List<RecipeIngrVOwithDday> FridgeIngrList = recipeMapper.getRecipeStuffs(req);
		if (FridgeIngrList != null && !FridgeIngrList.isEmpty()) {
			for (RecipeIngrVOwithDday vo : FridgeIngrList) {
				String imageurl = vo.getIngredientImageUrl();
				if (imageurl != null && !imageurl.isEmpty()) {
					imageurl = ((imageurl.indexOf("http")<0)? this.domainUrl : "") + imageurl;
				} else if (vo.getIngrCategoryImageUrl() != null) {
					imageurl = ((vo.getIngrCategoryImageUrl().indexOf("http")<0)? this.domainUrl : "") + vo.getIngrCategoryImageUrl();
				}

				stuffs.add(new FridgeIngr(vo.getIngrCategoryId(), vo.getIngrCategoryName(),
						new RecipeIngrVOwithDday(vo.getIngredientId(), vo.getIngredientName(), vo.getIngredientQnt(),
								vo.getIngredientDday(), imageurl, vo.getExpStatus())));
			}
		}
		
		RecipeDetail recipeDetail = new RecipeDetail();
		recipeDetail.setRecipeId(recipevo.getRecipeId());
		recipeDetail.setRecipeName(recipevo.getRecipeName());
		recipeDetail.setCategoryId(recipevo.getCategoryId());
		recipeDetail.setCategoryName(recipevo.getCategoryName());
		recipeDetail.setWriter(recipevo.getWriter());
		recipeDetail.setWriterImageUrl(recipevo.getWriterImageUrl());
		recipeDetail.setCookDifficulty(recipevo.getCookDifficulty());
		recipeDetail.setCountView(recipevo.getCountView());
		recipeDetail.setCookingTime(String.valueOf(recipevo.getCookingTime()) + "분");
		recipeDetail.setPerPerson(recipevo.getPerPerson());
		recipeDetail.setImageUrl(recipevo.getImageUrl());
		recipeDetail.setReferedUrl(recipevo.getReferedUrl());
		recipeDetail.setCalorie(recipevo.getCalorie());
		recipeDetail.setMemo(recipevo.getMemo());
		recipeDetail.setStorageInfo(recipevo.getStorageInfo());
		recipeDetail.setStuffs(stuffs);
		recipeDetail.setHealthLevel(recipevo.getHealthLevel());
		recipeDetail.setIsRcmdbyHeath(recipevo.getIsRcmdbyHeath());
		recipeDetail.setIsPopular(recipevo.getIsPopular());
		recipeDetail.setIsTaste(recipevo.getIsTaste());
		recipeDetail.setIsAIRecipe(recipevo.getIsAIRecipe());
		recipeDetail.setIsLike(recipevo.getIsLike());

		List<RecipeDetailNutrient> nutrients = null;
		List<RecipeDetailProcess> processes = null;
		
		if("ALL".equals(dtype)) {
			nutrients = recipeMapper.getRecipeNutrients(req);			
			processes = recipeMapper.getRecipeProcesses(req);
			recipeDetail.setNutrients(nutrients);
			recipeDetail.setProcesses(processes);
		}
		

		return recipeDetail;
	}
	
	public ResultWithData getRecipeDetailProcess(RecipeReq req) {
		
		String baseRecipeId = req.getRecipeId();
		
		// baseRecipeId 의 조리과정을 가져온다.
		List<RecipeDetailProcess> baseProcesses = null;
		baseProcesses = recipeMapper.getRecipeProcesses(new RecipeReq(baseRecipeId));
		
		if(baseProcesses!=null && !baseProcesses.isEmpty()) {
			
		}
			
		// baseRecipe 상세정보에서 제목, 이미지 url 가져오기
		String recipeName = null;
		String imageUrl = null;		
		RecipeMasterVO recipevo = recipeMapper.getRecipeDetailMaster(new RecipeReq(baseRecipeId));
		if(recipevo != null) {
			recipeName = recipevo.getRecipeName();
			imageUrl = recipevo.getImageUrl();
		}	
		
		//basic 레시피의 전체 프로세스 리스트를 가져온다
		AIRecipeReq aiRecipeReq = new AIRecipeReq();
		aiRecipeReq.setRecipeId(baseRecipeId);
		List<AiRecipePhaseVO> listAiWholeProcess = rcmdMapper.getPhaseList(aiRecipeReq);
		
		
		//전체 프로세스
		List<AiRecipePhaseVO> stepIngrList = new ArrayList<AiRecipePhaseVO>();
		
		// 두 레시피를 합친다.
		// 추가된 프로세스는 3,4 단계만 추가한다.
		if(listAiWholeProcess != null && !listAiWholeProcess.isEmpty()) {
			for(AiRecipePhaseVO aiIngriVO : listAiWholeProcess) {
				
				stepIngrList.add(aiIngriVO);
				
			}
		}
		
		//빈 페이즈 리스트를 만든다
		List<CookingStep> cookingStepList = new ArrayList<CookingStep>();

		
		for(AiRecipePhaseVO aiIngriVO : stepIngrList)
		{
			//페이즈에 맞는 식자재 리스트를 가져온다
			int i = Integer.parseInt(aiIngriVO.getSeq());
			AIRecipeSeqReq aiRSeqReq = new AIRecipeSeqReq(aiIngriVO.getId_recipe(),i);
			List<AiRecipeIngriVO> listPhaseBySeq = rcmdMapper.getPhaseBySeq(aiRSeqReq);
			
			if(aiIngriVO.getSeq().equals(Integer.toString(i)))
			{
				String imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/cook.png";
				if(aiIngriVO.getPhasecode().equals("세척 및 손질"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/wash.png";
				else if(aiIngriVO.getPhasecode().equals("끓이기"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/boil.png";
				else if(aiIngriVO.getPhasecode().equals("썰기"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/cut.png";
				else if(aiIngriVO.getPhasecode().equals("요리"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/cook.png";
				else if(aiIngriVO.getPhasecode().equals("간하기"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/source.png";
				else if(aiIngriVO.getPhasecode().equals("굽기"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/fry.png";
				else if(aiIngriVO.getPhasecode().equals("마무리"))
					imgUrl = "https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/finish.png";
				cookingStepList.add(new CookingStep(aiIngriVO.getSeq(), aiIngriVO.getPhasecode(), imgUrl, listPhaseBySeq, aiIngriVO.getProcess_info()));
			}
		}

		AiRecipeDetailVO recipe = new AiRecipeDetailVO(req.getUserId(), baseRecipeId, recipeName, "", imageUrl, String.valueOf(recipevo.getCookingTime()) + "분", String.valueOf(recipevo.getCookDifficulty()), cookingStepList);
		recipe.setHealthLevel(recipevo.getHealthLevel());
		recipe.setIsRcmdbyHeath(recipevo.getIsRcmdbyHeath());
		recipe.setIsPopular(recipevo.getIsPopular());
		recipe.setIsTaste(recipevo.getIsTaste());
		recipe.setIsAIRecipe(recipevo.getIsAIRecipe());
		
		return ResultWithData.succcessResult().addData("recipe", recipe );
	
	}

	public ResultWithData getFridgeIngr(FridgeIngrReq fridgeIngrReq) {
		List<FridgeIngr> friIngrList = new ArrayList<FridgeIngr>();
		List<FridgeIngrVO> FridgeIngrList = recipeMapper.getFridgeIngr(fridgeIngrReq);
		if (FridgeIngrList != null && !FridgeIngrList.isEmpty()) {
			for (FridgeIngrVO vo : FridgeIngrList) {
				String imageurl = vo.getIngredientImageUrl();
				if (imageurl != null && !imageurl.isEmpty()) {
					imageurl = ((imageurl.indexOf("http")<0)? this.domainUrl : "") + imageurl;
				} else if (vo.getIngrCategoryImageUrl() != null) {
					imageurl = ((vo.getIngrCategoryImageUrl().indexOf("http")<0)? this.domainUrl : "")+ vo.getIngrCategoryImageUrl();
				}

				friIngrList.add(new FridgeIngr(vo.getIngrCategoryId(), vo.getIngrCategoryName(),
						new RecipeIngrVOwithDday(vo.getIngredientId(), vo.getIngredientName(), vo.getIngredientQnt(),
								vo.getIngredientDday(), imageurl, vo.getExpStatus())));
			}
		}
		return ResultWithData.succcessResult().addData("list", friIngrList);
	}

	public ResultWithData updateFridgeIngr(FridgeIngrReq fridgeIngrReq) {
		ResultWithData resultWithData = ResultWithData.succcessResult();
		recipeMapper.updateFridgeIngr(fridgeIngrReq);
		if(fridgeIngrReq.getResultCode() != ErrorCode.SUCCESS) {
			resultWithData.setCode(ErrorCode.DB_ERROR).setMessage("DB error");
		}
		return resultWithData;
	}

	public ResultWithData getIngrList(BaseReq baseReq) {
		//TODO 추후 카테고리별 리스트 분류하기
		ResultWithData result = ResultWithData.succcessResult();
		List<StuffVO> stuffVOList = recipeMapper.getIngrList(baseReq);
		result.addData("list", stuffVOList);
		return result;
	}
	
	public ResultWithData getIngrListforCREATE(BaseReq baseReq) {
		ResultWithData result = ResultWithData.succcessResult();
		List<StuffVO> stuffVOList = recipeMapper.getIngrListforCREATE(baseReq);
		result.addData("list", stuffVOList);
		return result;
	}

	public ResultWithData updateRecipeLike(RecipeReq req, final boolean type) {
		ResultWithData result = ResultWithData.succcessResult();
		if(type) {
			recipeMapper.insertRecipeLike(req);
		} else {
			recipeMapper.deleteRecipeLike(req);
		}
		if(req.getResultCode() != ErrorCode.SUCCESS) {
			result.setCode(req.getResultCode());
			if(req.getResultCode() == ErrorCode.NOTEXIST) {
				result.setMessage("recipe or user is not exist");
			} else {
				result.setMessage("DB error");
			}
		} else {
			result.addData("recipeId", req.getRecipeId()).addData("isLike", (type ? "Y" : "N"));
		}
		return result;
	}
}