package com.onethefull.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.req.AscDescType;
import com.onethefull.recipe.comm.req.SearchFilterReq;
import com.onethefull.recipe.comm.req.SearchFilterType;
import com.onethefull.recipe.comm.req.SearchFilterUnitReq;
import com.onethefull.recipe.comm.req.SearchSortReq;
import com.onethefull.recipe.comm.req.SearchSortType;
import com.onethefull.recipe.comm.req.SearchSortUnitReq;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.RcmdMapper;
import com.onethefull.recipe.req.AIRecipeSurpriseLevel;
import com.onethefull.recipe.req.AiRecipeDetailReq;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.req.UserMealReq;
import com.onethefull.recipe.res.RcmdRecipe;
import com.onethefull.recipe.res.RcmdRecipeBase;
import com.onethefull.recipe.vo.RcmdRecipeVO;
import com.onethefull.recipe.vo.RcmdStuffOwningVO;
import com.onethefull.recipe.vo.RcmdStuffPMIVO;
import com.onethefull.recipe.vo.RcmdStuffVO;
import com.onethefull.recipe.vo.RecipeStuffVO;
import com.onethefull.recipe.vo.StatisticMealofUserVO;

@Service("recipeRcmdService")
public class RecipeRcmdService {
	
	@Resource(name = "rcmdMapper")
	private RcmdMapper rcmdMapper;
	
	@Resource(name = "recipeSetService")
	private RecipeSetService recipeSetService;
	
	public ResultWithData getRcmdStuffPMI(RcmdRecipeReq rcmdRecipeReq) {
		
		// ������� ������ ���
		List<RcmdStuffOwningVO> userStufflist = rcmdMapper.getUserStuffs(rcmdRecipeReq);
		if(!userStufflist.isEmpty()) {
			
		}
		
		List<RcmdStuffPMIVO> stuffList = null;
		rcmdRecipeReq.seperateIds();
		switch (rcmdRecipeReq.getStuffCount()) {
		case 1 : stuffList = rcmdMapper.getStuffsPMI1Var(rcmdRecipeReq); break;
		case 2 : stuffList = rcmdMapper.getStuffsPMI2Var(rcmdRecipeReq); break;
		case 3 : stuffList = rcmdMapper.getStuffsPMI3Var(rcmdRecipeReq); break;
		case 4 : stuffList = rcmdMapper.getStuffsPMI4Var(rcmdRecipeReq); break;
		}
		
		this.checkStuffHaving(userStufflist, stuffList);
	
		return ResultWithData.succcessResult().addData("list", stuffList);
	}
	
	private void checkStuffHaving(List<RcmdStuffOwningVO> userStufflist, List<RcmdStuffPMIVO> stuffList) {
		if(stuffList == null || stuffList.isEmpty()) return;
		
		ArrayList<String> userStuffArray = new ArrayList<String>();
		
		for(RcmdStuffVO userStuff : userStufflist) {
			userStuffArray.add(userStuff.getStuffId());
		}
		
		for(RcmdStuffPMIVO stuff : stuffList) {
			stuff.setStuffOwning1(userStuffArray.contains(stuff.getStuffId1()));
			stuff.setStuffOwning2(userStuffArray.contains(stuff.getStuffId2()));
			stuff.setStuffOwning3(userStuffArray.contains(stuff.getStuffId3()));
			stuff.setStuffOwning4(userStuffArray.contains(stuff.getStuffId4()));
		}
		return;
	}

	public ResultWithData getRcmdRecipe(RcmdRecipeReq req) {
		
		// 필터 지정 
		SearchFilterReq searchFilterReq = this.setSearchFilterReq(req);
		if(searchFilterReq != null) {
			req.setFilterReq(searchFilterReq);
		}
		
		// 정열 순서 
		// SearchSortReq tmpSearchSortReq = req.getSortReq();
		SearchSortReq searchSortReq = this.setSearchSortReq(req.getSortReq());
		if(searchSortReq != null) {
			req.setSortReq(searchSortReq);
		}
		
		PageInfoVO pageInfoVO = rcmdMapper.getRecommendRecipiesPageInfo(req);
		pageInfoVO.setCurrentPageNum(req.getPageNum());
		pageInfoVO.setPageSize(req.getPageSize());
		
		
		List<RcmdRecipeVO> list = rcmdMapper.getRecommendRecipies(req);
		List<RcmdRecipe> recipeList = new ArrayList<RcmdRecipe>();
		
		// 창작을 함께 할 경우, list 목록이 5개 이하면 부족한 수만큼 창작한다.
		int cnt = 0;
		if(list != null && !list.isEmpty()) {
			cnt = list.size();
		}
		
		// 식자재 조건을 바꿔서 더 찾아본다.
		// 3개 이상이면 2개로 해본다.
		// 2개 이상이면 1개로 한다.
		
		int arrCnt = 0;
		if(req.getStuffIds() != null && !req.getStuffIds().isEmpty()) {
			arrCnt = req.getStuffIds().size();
		}
		
		boolean isAddCreate = false;
		
		if(req.isIsCreate() && arrCnt > 1 && cnt < 10) {
			
			boolean isBreak = false;
			int iter = 0;
			
			while(!isBreak && cnt < 10) {
				
				RcmdRecipeReq tmpReq = new RcmdRecipeReq(req);
				tmpReq.setLanguageId(req.getLanguageId());
			
				if(tmpReq.getStuffIds() != null && !tmpReq.getStuffIds().isEmpty()) {
					
					if(arrCnt >= 3) {
						
						List<String> arr = new ArrayList<String>();
						
						if(iter == 0) {
							arr.add(tmpReq.getStuffIds().get(0));
							arr.add(tmpReq.getStuffIds().get(1));
						} else if(iter == 1) {
							arr.add(tmpReq.getStuffIds().get(1));
							arr.add(tmpReq.getStuffIds().get(2));
						} else {
							arr.add(tmpReq.getStuffIds().get(0));
							arr.add(tmpReq.getStuffIds().get(2));
							isBreak = true;
						}
						tmpReq.setStuffIds(arr);
					} else if(arrCnt == 2) {
						
						List<String> arr = new ArrayList<String>();
						
						if(iter == 0) {
							arr.add(tmpReq.getStuffIds().get(0));
						} else {
							arr.add(tmpReq.getStuffIds().get(1));
							isBreak = true;
						}
						tmpReq.setStuffIds(arr);					
					}
				} 
				
				isAddCreate = true; // 한번이라도 갯수가 모자란 경우
				
				List<RcmdRecipeVO> list2 = rcmdMapper.getRecommendRecipies(tmpReq);
				
				if(list2 != null && !list2.isEmpty()) {
					list.addAll(list2);
					cnt += list2.size();
				}
				
				iter++;
				
				if(isBreak && arrCnt == 3 && cnt <10) {
					arrCnt = 2;  // 한단계 낮춘다.
					iter = 0;
					isBreak = false;
				}
			}
		}
		
		
		int iter = 0;
		int addCnt = 0;
		
		// 한국어인 경우에만 창작된다.
		if("KOR".equals(req.getLanguageId())) {
			
			if(req.isIsCreate() && ( cnt < 2 || isAddCreate)) {
				
				while(cnt < 2) {
					AiRecipeDetailReq aiReq = new AiRecipeDetailReq();
					aiReq.setUserId(req.getUserId());
					aiReq.setStuffIds(req.getStuffIds());
					aiReq.setIsCreate(req.isIsCreate());
					aiReq.setAiSurpriseLevel(AIRecipeSurpriseLevel.LOW);
					
					RcmdRecipeVO vo = recipeSetService.getCreatedRecipe(aiReq);
					if(vo != null) {
						list.add(vo);
						cnt++;
						addCnt++;
					}
					
					iter++;
					
					if(iter > 4) break;  // 무한루프 방지
				}
				
				// 여전히 없다면 하나씩만 추가한다.
				if(addCnt < 2 && req.getStuffIds() != null && !req.getStuffIds().isEmpty()) {
					AiRecipeDetailReq aiReq = new AiRecipeDetailReq();
					aiReq.setUserId(req.getUserId());
					aiReq.addStuffId(req.getStuffIds().get(0));
					aiReq.setIsCreate(req.isIsCreate());
					aiReq.setAiSurpriseLevel(AIRecipeSurpriseLevel.LOW);
					
					RcmdRecipeVO vo = recipeSetService.getCreatedRecipe(aiReq);
					if(vo != null) {
						list.add(vo);
						cnt++;
						addCnt++;
					}
				}
				
				if(addCnt < 2 && req.getStuffIds() != null && !req.getStuffIds().isEmpty() && req.getStuffIds().size() > 1) {
					AiRecipeDetailReq aiReq = new AiRecipeDetailReq();
					aiReq.setUserId(req.getUserId());
					aiReq.addStuffId(req.getStuffIds().get(1));
					aiReq.setIsCreate(req.isIsCreate());
					aiReq.setAiSurpriseLevel(AIRecipeSurpriseLevel.LOW);
					
					RcmdRecipeVO vo = recipeSetService.getCreatedRecipe(aiReq);
					if(vo != null) {
						list.add(vo);
						cnt++;
						addCnt++;
					}
				}
				
				if(addCnt < 2 && req.getStuffIds() != null && !req.getStuffIds().isEmpty() && req.getStuffIds().size() > 2) {
					AiRecipeDetailReq aiReq = new AiRecipeDetailReq();
					aiReq.setUserId(req.getUserId());
					aiReq.addStuffId(req.getStuffIds().get(2));
					aiReq.setIsCreate(req.isIsCreate());
					aiReq.setAiSurpriseLevel(AIRecipeSurpriseLevel.LOW);
					
					RcmdRecipeVO vo = recipeSetService.getCreatedRecipe(aiReq);
					if(vo != null) {
						list.add(vo);
						cnt++;
						addCnt++;
					}
				}
				
				if(addCnt < 2 && req.getStuffIds() != null && !req.getStuffIds().isEmpty() && req.getStuffIds().size() > 3) {
					AiRecipeDetailReq aiReq = new AiRecipeDetailReq();
					aiReq.setUserId(req.getUserId());
					aiReq.addStuffId(req.getStuffIds().get(3));
					aiReq.setIsCreate(req.isIsCreate());
					aiReq.setAiSurpriseLevel(AIRecipeSurpriseLevel.LOW);
					
					RcmdRecipeVO vo = recipeSetService.getCreatedRecipe(aiReq);
					if(vo != null) {
						list.add(vo);
						cnt++;
						addCnt++;
					}
				}
				
			}
			
			if(isAddCreate) {
				pageInfoVO.setItemSize(cnt);			
			}
		}
		
		
		if(list != null && !list.isEmpty()) {
			for(RcmdRecipeVO recipe : list) {
				RcmdRecipe rr = new RcmdRecipe();			
				rr.setRecipeId(recipe.getRecipeId());
				rr.setRecipeName(recipe.getRecipeName());
				rr.setCategoryName(recipe.getCategoryName());
				rr.setRecipeImageOriginalUrl(recipe.getImageOriginalUrl());
				rr.setRecipeImageThumbUrl(recipe.getImageThumbUrl());
				rr.setRecipeImageUrl(recipe.getImageUrl());
				rr.setRecipeBaseOn(recipe.getBaseOn());		
				rr.setHealthLevel(recipe.getHealthLevel());
				rr.setIsRcmdbyHeath(recipe.getIsRcmdbyHeath());
				rr.setIsPopular(recipe.getIsPopular());
				rr.setIsTaste(recipe.getIsTaste());
				rr.setIsAIRecipe(recipe.getIsAIRecipe());
				rr.setCookingTime(String.valueOf(recipe.getCookingTime()) + "분");
				rr.setCookDifficulty(recipe.getCookDifficulty());
				rr.setRateHealth(recipe.getRateHealth());
				rr.setRatePopular(recipe.getRatePopular());
				rr.setRateTaste(recipe.getRateTaste());
				
				if(req.getUserId() != null && req.getIsIncludedStaticInfo()) {
					StatisticMealofUserVO statisticInfo = rcmdMapper.getStatisticMealofUser(new UserMealReq(req.getUserId(), recipe.getRecipeId()));
					rr.setStatisticInfo(statisticInfo);
				}
				recipeList.add(rr);
			}
		}

		return ResultWithData.succcessResult().addData("list", recipeList).addData("pageInfo", pageInfoVO);
	}
	
	protected SearchFilterReq setSearchFilterReq(RcmdRecipeReq req) {
		SearchFilterReq rSearchFilterReq = req.getFilterReq();
		SearchSortReq rSearchSortReq = req.getSortReq();
				
		SearchFilterReq filterReq = new SearchFilterReq();
		List<SearchFilterUnitReq> listFilter = new ArrayList<SearchFilterUnitReq>();
		List<SearchSortUnitReq> listSort = new ArrayList<SearchSortUnitReq>();
		
		// CREATED 타입이거나 isCreate가 true 이면 창작 레시피만 필터링 
		boolean isCreate = false;
		
		if (req.isIsCreate()) {
			isCreate = true;
			
			SearchFilterUnitReq unit = new SearchFilterUnitReq();
			unit.setFilterType(SearchFilterType.CREATED);
			listFilter.add(unit);
			
		} else if(rSearchFilterReq != null && rSearchFilterReq.getConditions() != null && !rSearchFilterReq.getConditions().isEmpty()) {
		
			for(SearchFilterUnitReq unit : rSearchFilterReq.getConditions()) {
				listFilter.add(unit);
				if(unit.getFilterType().equals(SearchFilterType.TASTE)) {
					SearchSortUnitReq realUnitOrg = new SearchSortUnitReq();
					realUnitOrg.setSortType(SearchSortType.HEALTH);
					listSort.add(realUnitOrg);
					
				} else if(unit.getFilterType().equals(SearchFilterType.HEALTH)) {
					SearchSortUnitReq realUnitOrg = new SearchSortUnitReq();
					realUnitOrg.setSortType(SearchSortType.HEALTH);
					listSort.add(realUnitOrg);		
					
				} else if(unit.getFilterType().equals(SearchFilterType.CREATED)) {
					isCreate = true;
				}
			}
		}
		
		if(isCreate) {
			
			SearchSortUnitReq realUnitOrg = new SearchSortUnitReq();
			realUnitOrg.setSortType(SearchSortType.CREATED);
			listSort.add(realUnitOrg);
		}
		
		filterReq.setConditions(listFilter);
				
		if(rSearchSortReq == null || rSearchSortReq.getConditions() == null || rSearchSortReq.getConditions().isEmpty()) {
			rSearchSortReq = new SearchSortReq();
		}
		
		rSearchSortReq.setConditions(listSort);
		req.setSortReq(rSearchSortReq);

		return filterReq;
	}		
	
	
	protected SearchSortReq setSearchSortReq(SearchSortReq rSearchSortReq) {
		
		// 정렬순 지정이 없으면 최신순
		if(rSearchSortReq == null || rSearchSortReq.getConditions() == null || rSearchSortReq.getConditions().isEmpty()) {
			rSearchSortReq = new SearchSortReq();
			
			List<SearchSortUnitReq> conditions = new ArrayList<SearchSortUnitReq>();
			SearchSortUnitReq unit = new SearchSortUnitReq();
			unit.setSortType(SearchSortType.defaultSearchSortType());
			conditions.add(unit);
				
			rSearchSortReq.setConditions(conditions);
		}
		
		SearchSortReq sortReq = new SearchSortReq();
		List<SearchSortUnitReq> list = new ArrayList<SearchSortUnitReq>();
		
		boolean isTasted = false;
		boolean isLatest = false;
				
		for(SearchSortUnitReq unit : rSearchSortReq.getConditions()) {
			if(SearchSortType.POPULAR.equals(unit.getSortType())) {
				SearchSortUnitReq realUnit = new SearchSortUnitReq();
				realUnit.setKeyCol("count_view");
				realUnit.setAscDescType(AscDescType.DESC);
				list.add(realUnit);		
				
				// 인기순으로 한 경우 마지막으로 id별 소팅을 추가해야 한다.
				isTasted = true;
				isLatest = true;
				
			} else if(SearchSortType.LATEST.equals(unit.getSortType())) {
				isLatest = true;

			} else if(SearchSortType.NAME.equals(unit.getSortType())) {
				SearchSortUnitReq realUnit = new SearchSortUnitReq();
				realUnit.setKeyCol("r.name");
				realUnit.setAscDescType(AscDescType.ASC);
				list.add(realUnit);
				
				// 이름순으로 한 경우 마지막으로 id별 소팅을 추가해야 한다.
				isTasted = true;
				isLatest = true;
			
			} else if(SearchSortType.TASTE.equals(unit.getSortType())) {

				// 창작순으로 한 경우 마지막으로 id별 소팅을 추가해야 한다.
				isTasted = true;
				isLatest = true;
			
			} else if(SearchSortType.HEALTH.equals(unit.getSortType())) {
				SearchSortUnitReq realUnit = new SearchSortUnitReq();
				realUnit.setKeyCol("sim.sim_h");
				realUnit.setAscDescType(AscDescType.DESC);
				list.add(realUnit);
				
				// 창작순으로 한 경우 마지막으로 id별 소팅을 추가해야 한다.
				isLatest = true;
			
			} else {
				list.add(unit);	
				
				isLatest = true;
			}
		}
		
		if(isTasted) {
			
			boolean isExist = false;
			if(list != null && !list.isEmpty()) {
				for(SearchSortUnitReq unit : list) {
					if(SearchSortType.TASTE.equals(unit.getSortType())) {
						isExist = true;
						break;
					}
				}
			}
			
			if(!isExist) {
				SearchSortUnitReq realUnit = new SearchSortUnitReq();
				realUnit.setKeyCol("sim.sim");
				realUnit.setAscDescType(AscDescType.DESC);
				list.add(realUnit);					
			}
		}
		
		if(isLatest) {
			boolean isExist = false;
			if(list != null && !list.isEmpty()) {
				for(SearchSortUnitReq unit : list) {
					if(SearchSortType.LATEST.equals(unit.getSortType())) {
						isExist = true;
						break;
					}
				}
			}
			
			if(!isExist) {
				SearchSortUnitReq realUnit = new SearchSortUnitReq();
				realUnit.setKeyCol("sim.id_recipe");
				realUnit.setAscDescType(AscDescType.DESC);
				list.add(realUnit);					
			}
			
		}
		
		sortReq.setConditions(list);
		return sortReq;
	}		

	public ResultWithData getUserStuffOwningList(RcmdRecipeReq req) {
		List<RcmdStuffOwningVO> userStufflist = rcmdMapper.getUserStuffs(req);
		return ResultWithData.succcessResult().addData("list", userStufflist);
	}

	public ResultWithData getRcmdRecipeList(RcmdRecipeReq req) {
		List<RecipeStuffVO> recipeLists = rcmdMapper.getStuffsofRecipe(req);
		return ResultWithData.succcessResult().addData("list", recipeLists);
	}

	public ResultWithData getRcmdRecipeforMina(RcmdRecipeReq req) {
		req.setPageSize(20);
		
		SearchFilterReq filterReq = new SearchFilterReq();
		List<SearchFilterUnitReq> conditions = new ArrayList<SearchFilterUnitReq>();
		SearchFilterUnitReq unit = new SearchFilterUnitReq();
		unit.setFilterType(SearchFilterType.CREATED);
		conditions.add(unit);
		
		filterReq.setConditions(conditions);
		req.setFilterReq(filterReq);

		
		// 정열 순서 
		// SearchSortReq tmpSearchSortReq = req.getSortReq();
		SearchSortReq searchSortReq = this.setSearchSortReq(req.getSortReq());
		if(searchSortReq != null) {
			req.setSortReq(searchSortReq);
		}

		List<RcmdRecipeVO> list = rcmdMapper.getRecommendRecipies(req);
		List<RcmdRecipeBase> recipeList = new ArrayList<RcmdRecipeBase>();
		
		if(list != null && !list.isEmpty()) {
			
			List<Integer> targets = new ArrayList<Integer>();
			int num = 0;
			num = list.size();

			while(recipeList.size() < 3) {
				int random = (int) (Math.random() * num);				
				if(!targets.contains(random)) {
					targets.add(random);
					
					RcmdRecipeVO recipe = list.get(random);
					
					RcmdRecipeBase rr = new RcmdRecipeBase();			
					rr.setRecipeId(recipe.getRecipeId());
					rr.setRecipeName(recipe.getRecipeName());
					rr.setCategoryName(recipe.getCategoryName());
					rr.setRecipeImageUrl(recipe.getImageUrl());

					recipeList.add(rr);
				}
			}
			
		}
		return ResultWithData.succcessResult().addData("list", recipeList);
	}
}
