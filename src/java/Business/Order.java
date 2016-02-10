/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BrianMcM
 */
public class Order {
    int orderId = -1;
    int userId = -1;
    Date dateOrdered = null;

    public Order() {
    }

    public Order(int orderId, int userId, Date dateOrdered) {
        this.orderId = orderId;
        this.userId = userId;
        this.dateOrdered = dateOrdered;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.orderId;
        hash = 79 * hash + Objects.hashCode(this.dateOrdered);
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
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (!Objects.equals(this.dateOrdered, other.dateOrdered)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", date_ordered=" + dateOrdered + '}';
    }
    
    
    
}
