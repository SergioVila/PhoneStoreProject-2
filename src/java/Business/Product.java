/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author Megatronus
 */
public class Product 
{
    private int productID = -1;
    private String productName;
    private Double price;
    private String desc;
    private int stock;

    public Product() {
    }

    public Product(int productID,String productName, Double price, String desc, int stock) {
        setProductID(productID);
        setProductName(productName);
        setPrice(price);
        setDesc(desc);
        setStock(stock);
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.productID;
        hash = 23 * hash + Objects.hashCode(this.productName);
        hash = 23 * hash + Objects.hashCode(this.price);
        hash = 23 * hash + Objects.hashCode(this.desc);
        hash = 23 * hash + this.stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productID != other.productID) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        return true;
    }
    
    public String toString()
        {
            String product = "Product ID: "+this.productID+"\nProduct Name: "+this.productName+"\nPrice: "
                                +this.price+"\tAmount in Stock: "+this.stock+"\nDescription:"+this.desc;
            return product;
        }
}
