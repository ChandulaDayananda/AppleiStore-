/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import business.Cashier;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public interface ICashier {
    boolean add(Cashier cashier);
    ArrayList<Cashier> getAll();
    Cashier get(String cashierUsername);
    boolean delete (String cashierUsername);
    boolean update (Cashier cashier);
}
