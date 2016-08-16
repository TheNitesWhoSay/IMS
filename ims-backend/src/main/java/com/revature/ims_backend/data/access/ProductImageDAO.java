package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.ims_backend.entities.ProductImage;

@Entity
@Table(name="IMS_PRODUCT_IMAGE")
public class ProductImageDAO {
	
	public ProductImage getProductImage(int id) {
		return new ProductImage();
	}
	
	public Set<ProductImage> getProductImages(int id) {
		return new HashSet<ProductImage>();
	}
	
	public boolean addProductImage(ProductImage productImage) {
		return false;
	}
	
	public boolean updateProductImage(ProductImage productImage) {
		return false;
	}
	
	public boolean removeProductImage(ProductImage productImage) {
		return false;
	}
	
	
}
