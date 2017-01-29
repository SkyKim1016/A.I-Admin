package com.onethefull.recipe.type;

public enum ImageType {
	ORIGINAL('O'), MIDDLE('M'), THUMBNAIL('T');
	
	private char code;
	
	ImageType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static ImageType getByCode(char val) {
		for(ImageType e:ImageType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return ImageType.defaultImageType();
	}
	
	public static ImageType defaultImageType() {
		return ImageType.ORIGINAL;
	}
}
