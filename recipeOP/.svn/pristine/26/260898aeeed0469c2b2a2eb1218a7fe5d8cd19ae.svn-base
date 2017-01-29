package com.onethefull.recipe.vo;

public class AiRecipeIngriVO {
	
	private final String DOMAIN_URL = "http://104.199.135.28:8080/recipe";  //***** VO 밖으로  

	String stepSeq;
	String ingriSeq;
	String ingriName;
	String ingreImgURL;

	public AiRecipeIngriVO(){}

	public String getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(String stepSeq) {
		this.stepSeq = stepSeq;
	}

	public String getIngriSeq() {
		return ingriSeq;
	}

	public void setIngriSeq(String ingriSeq) {
		this.ingriSeq = ingriSeq;
	}

	public String getIngriName() {
		return ingriName;
	}

	public void setIngriName(String ingriName) {
		this.ingriName = ingriName;
	}

	public String getIngreImgURL() {
		if(this.ingreImgURL == null || this.ingreImgURL.isEmpty()) {
			return this.DOMAIN_URL + "/resources/img/icon/radish.png";
		}
		return ingreImgURL;
	}

	public void setIngreImgURL(String ingreImgURL) {
		if(ingreImgURL != null && !ingreImgURL.isEmpty()) {
			this.ingreImgURL = ((ingreImgURL.indexOf("http")<0)? this.DOMAIN_URL : "") + ingreImgURL;
		}
	}

	public AiRecipeIngriVO(String stepSeq, String ingriSeq, String ingriName,
			String ingreImgURL) {
		super();
		this.setStepSeq(stepSeq);
		this.setIngriSeq(ingriSeq);
		this.setIngriName(ingriName);
		this.setIngreImgURL(ingreImgURL);
	}

}
