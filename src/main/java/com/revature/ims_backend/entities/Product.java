package com.revature.ims_backend.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_UPC")
	private int upc;
	
	@Column(name="PRODUCT_NAME")
	private String name;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String description;
	
	@Column(name="SHORT_NAME")
	private String shortName;
	
	@Column(name="UNIT_COST")
	private double unitCost;
	
	@Column(name="PACK_SIZE")
	private int packSize;

	@Column(name="REORDER_QUANTITY")
	private int reorderQuantity;
	
	@Column(name="RETAIL_PRICE")
	private double retailPrice;
	
	@Column(name="PRODUCT_WEIGHT")
	private double weight;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_IMAGE_ID")
	private ProductImage image;
	
	@ManyToMany(mappedBy="products")
	private List<Category> categories; // Lazy-load (probably)

	
	public Product(int upc, String name, String description, String shortName, double unitCost, int packSize,
			int reorderQuantity, double retailPrice, double weight, ProductImage image, List<Category> categories) {
		super();
		this.upc = upc;
		this.name = name;
		this.description = description;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.weight = weight;
		this.image = image;
		this.categories = categories;
	}

	public Product(int upc, String name, String description, String shortName, double unitCost, int packSize,
			int reorderQuantity, double retailPrice, double weight, ProductImage image) {
		super();
		this.upc = upc;
		this.name = name;
		this.description = description;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.weight = weight;
		this.image = image;
		this.categories = new ArrayList<Category>();
	}

	public Product() {
		super();
		this.categories = new ArrayList<Category>();
	}

	public int getUpc() {
		return upc;
	}

	public void setUpc(int upc) {
		this.upc = upc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getPackSize() {
		return packSize;
	}

	public void setPackSize(int packSize) {
		this.packSize = packSize;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
		this.image = image;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	

	@Override
	public String toString() {
		return "Product [upc=" + upc + ", name=" + name + ", description=" + description + ", shortName=" + shortName
				+ ", unitCost=" + unitCost + ", packSize=" + packSize + ", reorderQuantity=" + reorderQuantity
				+ ", retailPrice=" + retailPrice + ", weight=" + weight + ", image=" + image + ", categories="
				+ categories + "]";
	}
	
}
