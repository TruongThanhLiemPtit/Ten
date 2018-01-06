/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Cotroller.ILoDat;
import Model.LoDat;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class views {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int lc;
        do{
                   System.out.println("\n==================Menu=================="
                + "\n1.Them Lo Dat"
                + "\n2.Sua Thong Tin Chu Lo"
                + "\n3.Sua Dien Tich Cay"
                + "\n4.Thong Ke Thong Tin Cac Lo So Huu Cua Minh"
                + "\n5.Thong Ke Lich Su Thay Doi Cua Mot Lo"
                           + "\n6.DAnh Sach Lo Dat"
                + "\n===>Moi Ban Chon : ");
                   lc=in.nextInt();
                 if(lc==1){
                       try {
                           in.nextLine();
                           ILoDat ild=(ILoDat) Naming.lookup("rmi://localhost:1099/QLLD");
                           System.out.println("\nNhap ma lo dat : ");
                           String Ma=in.nextLine();
                           System.out.println("\nNhap Chu Lo : ");
                           String ChuLo=in.nextLine();
                           System.out.println("\nNhap Dia Diem : ");
                           String DiaDiem =in.nextLine();
                           System.out.println("\nDien Tich Dat : ");
                           double DTD=in.nextDouble();
                           double DTC;
                           do{
                           System.out.println("\nDien Tich cay : ");
                           DTC=in.nextDouble();
                           if(DTC>DTD)
                                   System.out.println("Moi ban nhap lai !!!");
                           }while(DTC>DTD);
                           LoDat ld=new LoDat(Ma, ChuLo, DiaDiem, DTD, DTC);
                           boolean Check=ild.Add(ld);
                           if(Check)
                               System.out.println("----->Them Thanh Cong");
                           else
                               System.out.println("----->Ma Trung->Them That Bai");
                       } catch (NotBoundException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (MalformedURLException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (RemoteException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
                 else if(lc==2){
                           try {
                           in.nextLine();
                           ILoDat ild=(ILoDat) Naming.lookup("rmi://localhost:1099/QLLD");
                           System.out.println("\nNhap ma lo dat can sua thong tin chu lo  : ");
                           String Ma=in.nextLine();
                           int index=ild.Find(Ma);
                           if(index==-1)
                                   System.out.println("---> ko co ma lo dat trong danh sach");
                           else{
                               System.out.println("Nhap Ten Chu Lo thay the : ");
                               String chulo=in.nextLine();
                               boolean check=ild.EditChuLo(index, chulo);
                               if(check)
                                   System.out.println("---->Sua Thanh Cong");
                           }

                       } catch (NotBoundException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (MalformedURLException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (RemoteException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
                 else if(lc==3){
                          try {
                           in.nextLine();
                           ILoDat ild=(ILoDat) Naming.lookup("rmi://localhost:1099/QLLD");
                           System.out.println("\nNhap ma lo dat can sua Dien Tich Cay : ");
                           String Ma=in.nextLine();
                           int index=ild.Find(Ma);
                           if(index==-1)
                                   System.out.println("---> ko co ma lo dat trong danh sach");
                           else{
                               System.out.println("\nNhap Dien Tich Thay Cay Thay The ");
                               double dt=in.nextDouble();
                               boolean check=ild.EditDTCay(index, dt);
                               if(check)
                                   System.out.println("---->Sua Thanh Cong");
                               else 
                                   System.out.println("--->Sua That Bai Do DTC>DTD");
                           }

                       } catch (NotBoundException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (MalformedURLException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (RemoteException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
                 else if(lc==4){
                           try {
                           in.nextLine();
                           ILoDat ild=(ILoDat) Naming.lookup("rmi://localhost:1099/QLLD");
                           System.out.println("\nNhap ten chu lo can liet ke : ");
                           String ten=in.nextLine();
                           boolean check=ild.Find2(ten);
                           if(!check)
                                   System.out.println("---> ko co ten chu  lo trong danh sach");
                           else{
                               System.out.println("\n\tDanh Sach Lo Dat Co ten chu lo la : "+ten);
                              ArrayList<LoDat> list=ild.GetChuLo(ten);
                               for (LoDat loDat : list) {
                                   
                                   System.out.println(loDat.toString());
                               }
                           }

                       } catch (NotBoundException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (MalformedURLException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (RemoteException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
                 else if(lc==6){
                           try {
                       
                           ILoDat ild=(ILoDat) Naming.lookup("rmi://localhost:1099/QLLD");
                               System.out.println("\n\tDanh Sach Lo Dat");
                               ArrayList<LoDat> list=ild.GetAll();
                               for (LoDat loDat : list) {
                                   System.out.println(loDat.toString());
                               }

                       } catch (NotBoundException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (MalformedURLException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (RemoteException ex) {
                           Logger.getLogger(views.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }
        }while(lc!=0);

    }
}
