package com.inhatc.domain;

public class FoodVO {
	private int foodID;
	private String manufacturer;
	private String foodName;
	private String ingredient;
	private String crossContamination;
	private String category;
	private int risk;
	private String image;
	
	@Override
	public String toString() {
		return "FoodVO [foodID=" + foodID + ", manufacturer=" + manufacturer + ", foodName=" + foodName
				+ ", ingredient=" + ingredient + ", crossContamination=" + crossContamination + ", category=" + category
				+ ", risk=" + risk + ", image=" + image + "]";
	}
	
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getCrossContamination() {
		return crossContamination;
	}
	public void setCrossContamination(String crossContamination) {
		this.crossContamination = crossContamination;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRisk() {
		return risk;
	}
	public void setRisk(int risk) {
		this.risk = risk;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
