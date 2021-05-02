package com.dipen.ods.models;

public enum CustomMessages {
	ORDER_NOW("Order Now"), ORDERED("Ordered"), BUY_NOW("Buy Now"), BOUGHT("Bought");

	private final String name;

	private CustomMessages(String name) {
		this.name = name;
	}

	public boolean equalsName(String otherName) {
		return name.equals(otherName);
	}

	public String toString() {
		return this.name;
	}
}
