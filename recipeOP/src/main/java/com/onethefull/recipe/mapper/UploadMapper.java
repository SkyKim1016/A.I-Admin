package com.onethefull.recipe.mapper;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.req.RecipeReq;

@Repository("uploadMapper")
public interface UploadMapper {
	
	public int insertRecipe(RecipeReq recipeReq);
	
}
