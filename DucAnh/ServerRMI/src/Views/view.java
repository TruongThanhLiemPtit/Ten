/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.MyRemote;
import Cotroller.ILoDat;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class view {
    public static void main(String[] args) {
        try {
            ILoDat ild=new MyRemote();
            LocateRegistry.createRegistry(1099);// dành riêng cho RMI
            Naming.rebind("QLLD", ild);
            System.out.println("DATA IS READLY...");
            
        } catch (RemoteException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
