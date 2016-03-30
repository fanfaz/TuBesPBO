/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Arfiatna
 */
public class Kelompok implements Serializable {
    private int nomor;
	private Mahasiswa[] anggota;
	private int nAnggota;
	
	
	public Kelompok(int nomor){
		this.nomor=nomor;
		this.anggota=new Mahasiswa[nAnggota];
	}
	
	public void addAnggota(Mahasiswa m){
		if (anggota.length>nAnggota){
			anggota[nAnggota] = m;
			nAnggota++;
		} else {
			System.out.println("Kelompok sudah penuh!");
		}
	}
	
	public Mahasiswa getAnggota(int n){
		if (n<nAnggota){
			return anggota[n];
		} else {
			return null;
		}
	}
	
	public int getNAnggota(){
		return this.nAnggota;
	}
        
        public int getNomor(){
		return this.nomor;
	}
        
    @Override
        public String toString(){
        return "\nNomor Kelompok  = " + nomor;
    }
        
}
