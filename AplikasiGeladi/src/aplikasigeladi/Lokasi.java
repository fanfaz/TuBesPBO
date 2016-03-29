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
public class Lokasi implements Serializable {
	private String daerah;
	private String namaPerusahaan;
	private Pembimbing[] pembimbing;
	private int nPembimbing;
	private Kelompok[] kelompok = new Kelompok[100];
	private int nKelompok;
	
	public Lokasi(String daerah, String namaPerusahaan, int n){
		this.daerah=daerah;
		this.namaPerusahaan=namaPerusahaan;
		this.pembimbing=new Pembimbing[n];
	}
    
	public void setDaerah(String daerah){
		this.daerah = daerah;
	}
	
	public String getDaerah(){
		return daerah;
	}
	
	public void setNamaPerusahaan(String namaPerusahaan){
		this.namaPerusahaan = namaPerusahaan;
	}
	
	public String getNamaPerusahaan(){
		return namaPerusahaan;
	}
	
	public void addPembimbing (Pembimbing p){
		if (pembimbing.length>nPembimbing){
			pembimbing[nPembimbing] = p;
			nPembimbing++;
		} else {
			System.out.println("Sudah punya pembimbing");
		}
	}
	
		public Pembimbing getPembimbing(int n){
		if (n<nPembimbing){
			return pembimbing[n];
		} else {
			return null;
		}
	}
	
	
	public int getNPembimbing(){
		return this.nPembimbing;
	}
	
	
	public void addKelompok(int nomor, int n){
		if (nKelompok<100){
			kelompok[nKelompok] = new Kelompok(nomor,n);
			nKelompok++;
		} else {
			System.out.println("Kuota kelompok sudah penuh");
		}
	}
	
	public Kelompok getKelompok(int n){
		if (n<100){
			return kelompok[n];
		} else {
			return null;
		}
	}
	
	public int getNKelompok(){
		return nKelompok;
	}
	
	
}
