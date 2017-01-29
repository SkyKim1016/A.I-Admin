package com.onethefull.recipe.vo;

public class CheckJobVO {
	private String id;
	private String name;
	private int isSelected;

	public CheckJobVO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsSelected() {
		return isSelected == 1;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}
}
