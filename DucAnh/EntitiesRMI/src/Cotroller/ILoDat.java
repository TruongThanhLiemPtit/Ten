/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotroller;

import Model.LoDat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ILoDat extends Remote{
    public boolean Add(LoDat ld) throws RemoteException;
    public boolean EditChuLo(int index,String chulo) throws RemoteException;
    public boolean EditDTCay(int index, double dt) throws RemoteException;
    public int Find(String ID) throws RemoteException;
    public ArrayList<LoDat> GetAll() throws RemoteException;
    public boolean Find2(String name) throws RemoteException;
    public ArrayList<LoDat> GetChuLo(String name) throws RemoteException;
    
}
