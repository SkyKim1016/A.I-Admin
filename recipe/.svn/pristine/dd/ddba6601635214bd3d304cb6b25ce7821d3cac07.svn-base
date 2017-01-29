package com.onethefull.recipe.vo;

import org.apache.commons.lang.builder.EqualsBuilder;

public class RcmdStuffVO implements Comparable<RcmdStuffVO> {
	private String stuffId;
	private String stuffName;
	private String quantityInfo;

	public RcmdStuffVO() {}

	public String getStuffId() {
		return stuffId;
	}

	public void setStuffId(String stuffId) {
		this.stuffId = stuffId;
	}

	public String getStuffName() {
		return stuffName;
	}

	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}
	
	
	public String getQuantityInfo() {
		return quantityInfo;
	}

	public void setQuantityInfo(String quantityInfo) {
		this.quantityInfo = quantityInfo;
	}

	@Override
	public int compareTo(RcmdStuffVO o) {
		return this.getStuffId().compareTo(o.getStuffId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.stuffId == null)
			return false;
	    if (obj instanceof RcmdStuffVO) {
	    	RcmdStuffVO other = (RcmdStuffVO) obj;
	        return new EqualsBuilder().append(getStuffId(), other.getStuffId()).isEquals();
	    }
	    return false;
	}	

}
