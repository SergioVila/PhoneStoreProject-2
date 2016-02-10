/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author BrianMcM
 */
public class OrderProduct {
    int orderId;
    int productId;
    int Qty;

    public OrderProduct() {
        orderId = -1;
        productId = -1;
        Qty = 0;
    }

    public OrderProduct(int orderId, int productId, int Qty) {
        this.orderId = orderId;
        this.productId = productId;
        this.Qty = Qty;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.orderId;
        hash = 59 * hash + this.productId;
        hash = 59 * hash + this.Qty;
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
        final OrderProduct other = (OrderProduct) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        if (this.Qty != other.Qty) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order_Product{" + "orderId=" + orderId + ", productId=" + productId + ", Qty=" + Qty + '}';
    }
    
    
    
}
