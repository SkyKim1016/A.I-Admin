package com.onethefull.recipe.mapper;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.req.RecipeStuffReq;

@Repository("adminMapper")
public interface AdminMapper {

	public int adminStuff(RecipeStuffReq req);

}
