package com.online.ecommerce.service;

import com.online.ecommerce.dao.ProductDAO;
import com.online.ecommerce.exception.ProductOutOfStockException;
import com.online.ecommerce.model.Product;

import java.sql.SQLException;

public class InventoryService {
    private final ProductDAO productDAO = new ProductDAO();

    public synchronized void reduceStock(int productId, int quantity) throws SQLException, ProductOutOfStockException {
        Product product = productDAO.getProductById(productId);
        if (product == null) {
            throw new ProductOutOfStockException("Product not found");
        }
        if (product.getStock() < quantity) {
            throw new ProductOutOfStockException("Not enough stock for product: " + product.getName());
        }
        product.setStock(product.getStock() - quantity);
        productDAO.addProduct(product); // Simplified: in real case, should be update
    }
}
