/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;

/**
 *
 * @author Arfiatna
 */
public class Kelompok {
    private int nomor;
	private Mahasiswa[] anggota;
	private int nAnggota;
	
	
	public Kelompok(int nomor, int n){
		this.nomor=nomor;
		this.anggota=new Mahasiswa[n];
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
}
