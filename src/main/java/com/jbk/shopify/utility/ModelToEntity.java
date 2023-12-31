package com.jbk.shopify.utility;

import org.springframework.stereotype.Component;

import com.jbk.shopify.entity.CategoryEntity;
import com.jbk.shopify.entity.ProductEntity;
import com.jbk.shopify.entity.SupplierEntity;
import com.jbk.shopify.model.Category;
import com.jbk.shopify.model.Product;
import com.jbk.shopify.model.Supplier;

@Component
public class ModelToEntity {

	public CategoryEntity convertToEntity(Category category) {

		CategoryEntity entity = new CategoryEntity();
		entity.setCategoryId(category.getCategoryId());
		entity.setCategoryName(category.getCategoryName());
		entity.setDeliveryCharge(category.getDeliveryCharge());
		entity.setDiscount(category.getDiscount());
		entity.setDiscription(category.getDiscription());
		entity.setGst(category.getGst());

		return entity;

	}

	public SupplierEntity convertToEntity(Supplier supplier) {
		SupplierEntity entity = new SupplierEntity();

		entity.setSupplierId(supplier.getSupplierId());
		entity.setSupplierName(supplier.getSupplierName());
		entity.setPostalCode(supplier.getPostalCode());
		entity.setMobileNo(supplier.getMobileNo());
		entity.setCountryName(supplier.getCountryName());
		entity.setCity(supplier.getCity());

		return entity;

	}

	public ProductEntity convertToEntity(Product product) {
		ProductEntity entity = new ProductEntity();

		entity.setProductId(product.getProductId());
		entity.setProductName(product.getProductName());
		entity.setProductPrice(product.getProductPrice());
		entity.setProductQty(product.getProductQty());

		entity.setCategory(convertToEntity(product.getCategory()));
		entity.setSupplier(convertToEntity(product.getSupplier()));

		return entity;

	}
}
