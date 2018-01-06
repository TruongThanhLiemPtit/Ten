/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cotroller.ILoDat;
import Model.LoDat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MyRemote extends UnicastRemoteObject implements ILoDat{

    public MyRemote() throws RemoteException{
        
    }
    public void GhiFile(String Name,ArrayList<LoDat> list){
        try(FileOutputStream fos=new FileOutputStream(new File(Name))){
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
        }
        catch(Exception e){
            
        }
    }
    public ArrayList<LoDat> DocFile(String Name){
        ArrayList<LoDat> list=new ArrayList<>();
         try(FileInputStream fos=new FileInputStream(new File(Name))){
            ObjectInputStream oos=new ObjectInputStream(fos);
            list=(ArrayList<LoDat>) oos.readObject();
        }
        catch(Exception e){
            
        }
        return list;
    }
    @Override
    public boolean Add(LoDat ld) throws RemoteException {
        ArrayList<LoDat> list=DocFile("LODAT.DAT");
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMa().equals(ld.getMa()))
                return false;
        }
        list.add(ld);
        GhiFile("LODAT.DAT", list);
        return true;
    }

    @Override
    public boolean EditChuLo(int index, String chulo) throws RemoteException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         ArrayList<LoDat> list=DocFile("LODAT.DAT");
         list.get(index).setChuLo(chulo);
         GhiFile("LODAT.DAT", list);
         return true;
    }

    @Override
    public boolean EditDTCay(int index, double dt) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 ArrayList<LoDat> list=DocFile("LODAT.DAT");
                 if(list.get(index).getDTD()<dt)
                     return false;
         list.get(index).setDTC(dt);
         GhiFile("LODAT.DAT", list);
         return true;
    }

    @Override
    public int Find(String ID) throws RemoteException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ArrayList<LoDat> list=DocFile("LODAT.DAT");
         for(int i=0;i<list.size();i++){
            if(list.get(i).getMa().equals(ID))
               return i;
        }
         return -1;
    }

    @Override
    public ArrayList<LoDat> GetAll() throws RemoteException {
        ArrayList<LoDat> list=DocFile("LODAT.DAT");
        return list;
    }

    
    @Override
    public boolean Find2(String name) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ArrayList<LoDat> list=DocFile("LODAT.DAT");
        for (LoDat loDat : list) {// ctrl+cach
            if(loDat.getChuLo().equals(name))
                return true;
            
        }
        return false;
     
    }

    @Override
    public ArrayList<LoDat> GetChuLo(String name) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ArrayList<LoDat> list=DocFile("LODAT.DAT");
       ArrayList<LoDat> list2=new ArrayList<>();
        for (LoDat loDat : list) {
            if(loDat.getChuLo().equals(name))
                list2.add(loDat);
        }
        return list2;
    }
    
}
