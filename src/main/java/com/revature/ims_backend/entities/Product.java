package com.revature.ims_backend.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int unitCost;
	
	@Column(name="PACK_SIZE")
	private String packSize;
	
	@Column(name="REORDER_QUANTITY")
	private int reorderQuantity;
	
	@Column(name="RETAIL_PRICE")
	private int retailPrice;
	
	@Column(name="PRODUCT_WEIGHT")
	private int weight;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_IMAGE_ID")
	private ProductImage image;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="products")
	private Set<Category> categories; // Lazy-load (probably)

	
	public Product(int upc, String name, String description, String shortName, int unitCost, String packSize,
			int reorderQuantity, int retailPrice, int weight, ProductImage image, Set<Category> categories) {
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

	public Product(int upc, String name, String description, String shortName, int unitCost, String packSize,
			int reorderQuantity, int retailPrice, int weight, ProductImage image) {
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
	}

	public Product() {
		super();
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

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public String getPackSize() {
		return packSize;
	}

	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public int getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
		this.image = image;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
