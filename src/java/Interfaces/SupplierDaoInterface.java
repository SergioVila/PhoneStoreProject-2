/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Business.Supplier;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface SupplierDaoInterface {
    
    public ArrayList<Supplier> getAllSuppliers();
    
    public Supplier getSupplierById(int id);
    
    public boolean insertSupplier(Supplier nSupplier);
    
    public boolean deleteSupplierById(int id);
    
    public boolean updateSupplier(Supplier nSupplier);
}
