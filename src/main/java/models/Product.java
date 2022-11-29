package models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public class Product {
    private String productName;
    private Double productPrice;
    private int quantity;
    private double totalPrice;

    public Product(String productName, Double productPrice, int quantity, double totalPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Product(WebElement cartItem) {
        this.productName = cartItem.findElement(By.cssSelector(".product-line-info a")).getText();
        this.productPrice = Double.parseDouble(cartItem.findElement(By.cssSelector(".current-price")).getText().
                replace(System.getProperty("currency"),""));
        this.quantity = Integer.parseInt(cartItem.findElement(By.cssSelector(".js-cart-line-product-quantity")).
                getAttribute("value"));
        this.totalPrice = Double.parseDouble(cartItem.findElement(By.cssSelector(".product-price strong")).getText().
                replace(System.getProperty("currency"),""));
    }
}
