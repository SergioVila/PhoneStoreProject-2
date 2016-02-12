/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author BrianMcM
 */
public class Account {
    private String email = null;
    private int attempts = 0;
    private Time date = null;
    private String accountStatus = null;

    public Account() {
    }

    public Account(String email, int attempts, Time date, String accountStatus) {
        this.email = email;
        this.attempts = attempts;
        this.date = date;
        this.accountStatus = accountStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + this.attempts;
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Objects.hashCode(this.accountStatus);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.attempts != other.attempts) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.accountStatus, other.accountStatus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "email=" + email + ", attempts=" + attempts + ", date=" + date + ", accountStatus=" + accountStatus + '}';
    }
    
    

   
    
    
    
    
    
}
