package com.onethefull.recipe.req;

public enum AIRecipeSurpriseLevel {
	NONE('N'), HIGH('H'), MIDDLE('M'), LOW('L');
	
	private char code;
	
	AIRecipeSurpriseLevel(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static AIRecipeSurpriseLevel getByCode(char val) {
		for(AIRecipeSurpriseLevel e:AIRecipeSurpriseLevel.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return AIRecipeSurpriseLevel.defaultAIRecipeSurpriseLevel();
	}
	
	public static AIRecipeSurpriseLevel defaultAIRecipeSurpriseLevel() {
		return AIRecipeSurpriseLevel.LOW;
	}
}
