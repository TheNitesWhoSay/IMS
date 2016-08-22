package com.revature.ims_backend.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="IMS_PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_UPC")
	@Range(min=0)
	@Digits(integer=20, fraction=0)
	private int upc;
	
	@Column(name="PRODUCT_NAME")
	@NotEmpty
	private String name;
	
	@Column(name="PRODUCT_DESCRIPTION")
	@NotEmpty
	private String description;
	
	@Column(name="SHORT_NAME")
	@NotEmpty
	@Size(min=1, max=5)
	private String shortName;
	
	@Column(name="UNIT_COST")
	@Digits(fraction=2, integer=6)
	private Double unitCost;
	
	@Column(name="PACK_SIZE")
	@NotNull
	private Integer packSize;

	@Column(name="REORDER_QUANTITY")
	@NotNull
	private Integer reorderQuantity;
	
	@Column(name="RETAIL_PRICE")
	@NotNull
	private Double retailPrice;
	
	@Column(name="PRODUCT_WEIGHT")
	@NotNull
	private Double weight;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_IMAGE_ID")
	private ProductImage image;
	
	@ManyToMany(mappedBy="products", fetch=FetchType.EAGER)
	@NotEmpty
	private List<Category> categories; // Lazy-load (probably)
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_STOCK_ID")
	private Stock stock;

	
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
		this.stock = new Stock(-1, 0);
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
		this.stock = new Stock(-1, 0);
	}

	public Product() {
		super();
		this.categories = new ArrayList<Category>();
		this.stock = new Stock(-1, 0);
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

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [upc=" + upc + ", name=" + name + ", description=" + description + ", shortName=" + shortName
				+ ", unitCost=" + unitCost + ", packSize=" + packSize + ", reorderQuantity=" + reorderQuantity
				+ ", retailPrice=" + retailPrice + ", weight=" + weight + ", image=" + image + ", categories="
				+ categories + "]";
	}
	
}
