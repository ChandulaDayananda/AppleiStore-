/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Cashier;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author chand
 */
public class CashierDB implements ICashier{

    private ArrayList <Cashier> cashierList;
    private File cashierOBJ;
    
    public CashierDB() {
        cashierList = new ArrayList<> ();
        cashierOBJ = new File ("c:\\AppleiStore\\cashier.txt");
    }

    @Override
    public boolean add(Cashier cashier) {
        try {
            FileWriter filewriter = new FileWriter(cashierOBJ,true);
            String line = cashier.getCashierUsername() + ":" + 
                          cashier.getCashierPassword() + "\n";
            filewriter.append(line);
            filewriter.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
//        return cashierList.add(cashier);
    }

    @Override
    public ArrayList<Cashier> getAll() {
//        return cashierList;
        ArrayList <Cashier> cashierList = new ArrayList<> ();
        try {
            Scanner scanner = new Scanner(cashierOBJ);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(":");
                String cashierUsername = arr[0];
                String cashierPassword = arr[1];
                Cashier cashier = new Cashier (cashierUsername, cashierPassword);
                cashierList.add(cashier);
            }
            scanner.close();
            return cashierList;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            return null; 
        }
    }

    @Override
    public Cashier get(String cashierUsername) {
        ArrayList<Cashier> cashierlist = getAll();
        for (Cashier cashier:cashierlist){
            if(cashier.getCashierUsername().equals(cashierUsername)){
                return cashier;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String cashierUsername) {
        try{
            ArrayList <Cashier> cashierList = getAll();
            ArrayList <Cashier> cashierToDelete = new ArrayList<>();
            
            for (Cashier cashier : cashierList) {
                if (cashier.getCashierUsername().equals(cashierUsername)) {
                    cashierToDelete.add(cashier);
                    break;
                }
            }
            
            if(!cashierToDelete.isEmpty()) {
                cashierList.removeAll(cashierToDelete);
                
                FileWriter filewriter1 = new FileWriter(cashierOBJ);
                filewriter1.write("");
                filewriter1.close();
                
                for (Cashier cashier : cashierList) {
                    add(cashier);
                }
                return true;
            } else {
                 return false;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Cashier cashier) {
        try {
            ArrayList <Cashier> cashierList = getAll();
            FileWriter filewriter1 = new FileWriter(cashierOBJ);
            filewriter1.write("");
            filewriter1.close();
            
            for (Cashier cashier1 : cashierList) {
                if (cashier1.getCashierUsername().equals(cashier.getCashierUsername())){
                    cashierList.remove(cashier1);
                    cashierList.add(cashier);
                    break;
                }
            }
            for (Cashier cashier2 : cashierList) {
                add(cashier2);
            }
            return true;
        } catch (Exception e ) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
