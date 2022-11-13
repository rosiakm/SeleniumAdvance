package models;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    private List<Product> products;
    private BigDecimal totalOrderCost;

    public Cart(List<Product> products, BigDecimal totalOrderCost) {
        this.products = products;
        this.totalOrderCost = totalOrderCost;
    }

    public void addProduct(Product product){
        if(products.contains(product.getProductName())){

        }
    }
}
