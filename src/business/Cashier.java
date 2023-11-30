/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author chand
 */
public class Cashier {
    private String cashierUsername;
    private String cashierPassword;

    public Cashier() {
    }

    public Cashier(String cashierUsername, String cashierPassword) {
        this.cashierUsername = cashierUsername;
        this.cashierPassword = cashierPassword;
    }

    public String getCashierUsername() {
        return cashierUsername;
    }

    public void setCashierUsername(String cashierUsername) {
        this.cashierUsername = cashierUsername;
    }

    public String getCashierPassword() {
        return cashierPassword;
    }

    public void setCashierPassword(String cashierPassword) {
        this.cashierPassword = cashierPassword;
    }
    
    
}
