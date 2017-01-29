package com.onethefull.recipe.vo;

public class AiRecipePhaseVO {
	String id_recipe, seq, phasecode, cnt, priority, process_info;
	
	public AiRecipePhaseVO(){}

	public AiRecipePhaseVO(String id_recipe, String seq, String phasecode,
			String cnt, String priority, String process_info) {
		super();
		this.id_recipe = id_recipe;
		this.seq = seq;
		this.phasecode = phasecode;
		this.cnt = cnt;
		this.priority = priority;
		this.process_info = process_info;
	}

	public String getId_recipe() {
		return id_recipe;
	}

	public void setId_recipe(String id_recipe) {
		this.id_recipe = id_recipe;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getPhasecode() {
		return phasecode;
	}

	public void setPhasecode(String phasecode) {
		this.phasecode = phasecode;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProcess_info() {
		return process_info;
	}

	public void setProcess_info(String process_info) {
		this.process_info = process_info;
	}
}
