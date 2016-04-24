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
    private int nAnggota = 7; //jumlah maksimal anggota
    
    public Kelompok(int nomor){
        this.nomor = nomor;
        this.anggota = new Mahasiswa[nAnggota];
    }
    
    public void addAnggota(Mahasiswa m){
        anggota[nAnggota] = m;
        nAnggota++;
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
