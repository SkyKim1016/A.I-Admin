package com.onethefull.recipe.vo;

public class StepIngr {
	String stepSeq;
	String ingriSeq;
	String ingriName;
	String ingreImgURL;
	
	public StepIngr(){}
	public String getIngreImgURL() {
		return ingreImgURL;
	}
	public void setIngreImgURL(String ingreImgURL) {
		this.ingreImgURL = ingreImgURL;
	}
	String ingriType;
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
	public String getIngriType() {
		return ingriType;
	}
	public void setIngriType(String ingriType) {
		this.ingriType = ingriType;
	}
	public StepIngr(String stepSeq, String ingriSeq, String ingriName,
			String ingriType, String ingreImgURL) {
		super();
		this.stepSeq = stepSeq;
		this.ingriSeq = ingriSeq;
		this.ingriName = ingriName;
		this.ingriType = ingriType;
		this.ingreImgURL = ingreImgURL;
	}
}
