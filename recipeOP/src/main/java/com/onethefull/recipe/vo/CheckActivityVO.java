package com.onethefull.recipe.vo;

public class CheckActivityVO {
	private String description;
	private int level;
	private int isSelected;

	public CheckActivityVO() {}
	
	public CheckActivityVO(String description, int level, int isSelected) {
		this.setDescription(description);
		this.setLevel(level);
		this.setIsSelected(isSelected);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getIsSelected() {
		return isSelected == 1;
	}

	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}

}
