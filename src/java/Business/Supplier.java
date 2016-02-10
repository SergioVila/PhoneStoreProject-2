/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author BrianMcM
 */
public class Supplier {
    
    int supplierId;
    String supplierName;
    String email;
    String address;
    String county;
    String country;
    String phone;

    public Supplier() {
    }

    public Supplier(int supplerId, String supplierName, String email, String address,String county, String country, String phone) {
        this.supplierId = supplerId;
        this.supplierName = supplierName;
        this.email = email;
        this.address = address;
        this.county = county;
        this.country = country;
        this.phone = phone;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplerId) {
        this.supplierId = supplerId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.supplierId;
        hash = 19 * hash + Objects.hashCode(this.supplierName);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + Objects.hashCode(this.phone);
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
        final Supplier other = (Supplier) obj;
        if (this.supplierId != other.supplierId) {
            return false;
        }
        if (!Objects.equals(this.supplierName, other.supplierName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplerId=" + supplierId + ", supplierName=" + supplierName + ", email=" + email + ", address=" + address + ", phone=" + phone + '}';
    }
    
    
    
}
