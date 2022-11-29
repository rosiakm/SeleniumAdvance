package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalOrderCost = new BigDecimal("0.00");

    public void addProduct(Product product) {
        if (containsName(products, product.getProductName())) {
            increaseQuantity(product);
            recalculateTotalPrice(product);
        } else {
            products.add(product);
        }
        recalculateTotalOrderCost(product.getProductPrice(), product.getQuantity());
    }

    private void recalculateTotalPrice(Product product) {
        Product myProduct = getProductByName(product);
        myProduct.setTotalPrice(myProduct.getProductPrice() * myProduct.getQuantity());
    }

    private void recalculateTotalOrderCost(Double productPrice, int productQuantity) {
        totalOrderCost = totalOrderCost.add(new BigDecimal(String.valueOf(productPrice * productQuantity)));
    }

    private void increaseQuantity(Product product) {
        Product myProduct = getProductByName(product);
        int actualQuantity = myProduct.getQuantity();
        myProduct.setQuantity(actualQuantity + product.getQuantity());
    }

    private boolean containsName(List<Product> productList, String name) {
        return productList.stream().anyMatch(product -> product.getProductName().equals(name));
    }

    private Product getProductByName(Product product) {
        Map<String, Product> map = new LinkedHashMap<>();
        for (Product myProduct : products) {
            map.put(myProduct.getProductName(), myProduct);
        }
        return map.get(product.getProductName());
    }
}
