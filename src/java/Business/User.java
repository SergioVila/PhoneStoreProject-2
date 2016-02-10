/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BrianMcM
 */
public class User {
    private int userId;
    private String fName;
    private String lName;
    private String address;
    private String county;
    private String country;
    private String email;
    private String phone;
    private String password;
    private boolean isAdmin;

    public User() {
    }

    public User(char[] password, String fName, String lName, String address, String county, String country, String email, String phone) {
        
        setPassword(password);
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.county = county;
        this.country = country;
        this.email = email;
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordHashed(String password) {
        this.password = password;
    }
    
    public void setPassword(char[] password)
    {
        this.password = getHash(password);
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.userId;
        hash = 37 * hash + Objects.hashCode(this.fName);
        hash = 37 * hash + Objects.hashCode(this.lName);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.county);
        hash = 37 * hash + Objects.hashCode(this.country);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.phone);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.county, other.county)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", county=" + county + ", country=" + country + ", email=" + email + ", phone=" + phone + ", password=" + password + '}';
    }
    
    private String toHex(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public byte[] charToByteArray(char[] pass) {

        byte[] b = new byte[pass.length];

        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) pass[i];
        }

        return b;
    }

    public String getHash(char[] pass) {
        
        byte[] digest = null;
        byte[] buffer = charToByteArray(pass);
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
            
            return toHex(digest);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toHex(digest);
    }

}