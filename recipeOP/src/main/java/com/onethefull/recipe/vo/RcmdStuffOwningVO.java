package com.onethefull.recipe.vo;

import java.math.BigDecimal;

public class RcmdStuffOwningVO extends RcmdStuffVO {
	private String userId;
	private BigDecimal qty;
	private String unit;
	private String expirationDate;

	public RcmdStuffOwningVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


}
