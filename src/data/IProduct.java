/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import business.Products;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public interface IProduct {
    boolean add(Products products);
    ArrayList<Products> getAll();
    Products get(String productID);
    boolean delete (String productID);
    boolean update (Products products);
}
