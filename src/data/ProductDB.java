/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Products;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author chand
 */
public class ProductDB implements IProduct{

    private ArrayList <Products> productsList;
    private File productsOBJ;
    
    public ProductDB() {
        productsList = new ArrayList<>();
        productsOBJ = new File ("c:\\AppleiStore\\products.txt");
    }

    @Override
    public boolean add(Products products) {
        try {
            FileWriter filewriter  =  new FileWriter(productsOBJ , true) ;
            String line =  products.getProductID() + ":" +
                           products.getCategoryID() + ":" +  
                           products.getProductName() + ":" + 
                           products.getProductPrice() + ":"  +
                           products.getProductSerialNumber() + ":" +
                           products.getProductQuantity() + "\n";
            filewriter.append(line);
            filewriter.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
//        return productsList.add(products);
    }

    @Override
    public ArrayList<Products> getAll() {
//        return productsList;
        ArrayList <Products> productsList = new ArrayList<> ();
        try {
            Scanner scanner = new Scanner(productsOBJ);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine() ;
                String[] arr = line.split(":");
                String  productID = arr[0];
                String categoryID = arr[1];
                String productName = arr[2];
                int productPrice = Integer.valueOf(arr[3]);
                String ProductSerialNumber = arr[4];
                int productQuantity = Integer.valueOf(arr[5]);
                Products products = new Products(productID, categoryID, productName, productPrice, ProductSerialNumber, productQuantity);
                productsList.add(products);
            }
            scanner.close();
            return productsList;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    @Override
    public Products get(String productID) {
        ArrayList <Products> productslist = getAll();
        for (Products products:productslist) {
            if(products.getProductID().equals(productID)){
                return products;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String productID) {
        try{
            ArrayList<Products> productsList = getAll();
            ArrayList<Products> productstoDelete = new ArrayList<>();
            
            for (Products products : productsList) {
                if (products.getProductID().equals(productID)) {
                    productstoDelete.add(products);
                    break;
                }
            }
            if (!productstoDelete.isEmpty()) {
                productsList.removeAll(productstoDelete);
                
                FileWriter filewriter1 = new FileWriter(productsOBJ);
                filewriter1.write("");
                filewriter1.close();
                
                for (Products products : productsList) {
                    add(products);
                } return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Products products) {
        try{
            ArrayList <Products> productsList = getAll();
            FileWriter filewriter1 = new FileWriter(productsOBJ);
            filewriter1.write("");
            filewriter1.close();
            
            for (Products products1 : productsList) {
                if (products1.getProductID().equals(products.getProductID())) {
                    productsList.remove(products1);
                    productsList.add(products);
                    break;
                }
            }
            
            for (Products products2 : productsList) {
                add(products2);
            }
            return true;
        } catch (IOException e ) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }    
    }    
}
