package com.onethefull.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.comm.util.FileUtil;
import com.onethefull.recipe.req.ConditionReq;
import com.onethefull.recipe.req.ProfileReq;
import com.onethefull.recipe.req.RecipeReq;
import com.onethefull.recipe.service.UploadService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
	
	@Resource(name = "uploadService")
	private UploadService uploadService;
	
	/*
	 * 프로필 사진 업로드
	 * parameter : ProfileReq
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData updateProfile(HttpServletRequest request, @ModelAttribute("profileReq") ProfileReq profileReq) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		profileReq.setUserId(user.getId());
		return uploadService.updateProfile(user, profileReq);
	}	
	
	/*
	 * 냉장고 사진 업로드
	 * parameter : MultipartFile
	 * 2016-4-19
	 * 김성준
	 */
	@RequestMapping(value = "/condition", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData insertCondition(HttpServletRequest request, @ModelAttribute("file") MultipartFile file) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		ConditionReq conditionReq = new ConditionReq();
		conditionReq.setUserId(user.getId());
		conditionReq.setFile(file);
		return uploadService.insertCondition(conditionReq);
	}
	
	/*
	@RequestMapping(value = "/condition", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData insertCondition(HttpServletRequest request, @ModelAttribute("conditionReq") ConditionReq conditionReq) {
		return uploadService.insertCondition(conditionReq);
	}
	*/
	
	/*
	 * 레시피 정보 업로드
	 * parameter : RecipeReq
	 * 2016-5-15
	 * 김성준
	 */
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData insertRecipe(HttpServletRequest request, @ModelAttribute("recipeReq") RecipeReq recipeReq) {
		return uploadService.insertRecipe(recipeReq);
	}
	
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public void uploadImage(HttpServletRequest request) throws IOException{
		String fileName = null;
		String menuName = null;
		String userEmail = null;
		String upload_path = "C:\\Users\\Tony\\workspace\\recipe\\src\\main\\webapp";
		int sizeLimit = 50 * 1024 * 1024 ; // 50메가까지 제한 넘어서면 예외발생
		MultipartRequest multi = new MultipartRequest(request, upload_path, sizeLimit, new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		//파일 정보가 있다면
		if(files.hasMoreElements()) {
		     String name = (String)files.nextElement();
		     fileName = multi.getFilesystemName(name);
		}
		userEmail = fileName.split("__")[0];
		menuName = fileName.split("__")[1];
		System.out.println("★★★★★★★★★★★★★★★★★ 이미지 업로드 완료 메뉴명은? : " + menuName);
		System.out.println("★★★★★★★★★★★★★★★★★ 이미지 업로드 완료 파일명은? : " + fileName);	
		
		File up_dir2 = new File(upload_path + "/" + menuName);
		if(!up_dir2.exists() && !up_dir2.isDirectory()) {
			up_dir2.mkdirs();
		} 
		String newName = FileUtil.fileRename(upload_path, fileName, upload_path + "/" + menuName, fileName);
		
		File tmp_file = new File(upload_path + "/" + fileName);
		if(tmp_file.exists() && tmp_file.isFile()) {
			tmp_file.delete();
		}
	}
		
}
