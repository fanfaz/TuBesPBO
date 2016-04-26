/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author USER
 */
public class Kelompok implements Serializable{
    private int nomor;
    private Mahasiswa[] anggota;
    private int nAnggota = 1; //jumlah maksimal anggota
    
    public Kelompok(int nomor){
        this.nomor = nomor;
        this.anggota = new Mahasiswa[5];
    }
    
    public void addAnggota(Mahasiswa m){
        if (nAnggota<=5){
        anggota[nAnggota] = m;
        nAnggota++; 
    }else {System.out.println("Kelompok penuh!");}
        
    }
    
    public void deleteAnggota(Mahasiswa m){
        for (int i=0;i<=3;i++){
           if (anggota[i].getNIM()==m.getNIM()){
               if (i==0){ //delete first
                    anggota[i]=null;       
                    for (int a=0; a<=3; a++){
                    anggota[a]=anggota[a+1];
               }}else if(i!=0 || i!=3){ //deleteafter
                       anggota[i] = null;
                       for(int a=i; a<=3; a++){
                        anggota[a]=anggota[a+1];
                       }
               } else if(i==3){ //delete last
                       anggota[i] = null;
                       nAnggota--;
                }
               
           }
        }
        }
    


    public int getNomor() {
        return nomor;
    }

    public Mahasiswa getAnggota(int n) {
        if(n<nAnggota){
            return this.anggota[n];
        } else {
            return null;
        }
    }

    public int getnAnggota() {
        return nAnggota;
    }
    
    
}
