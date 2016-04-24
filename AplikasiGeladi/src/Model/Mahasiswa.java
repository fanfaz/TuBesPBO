/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
/**
 *
 * @author USER
 */
public class Mahasiswa extends Orang implements Serializable{
    private String NIM;
    private String jurusan;
    
    public Mahasiswa(String nama, String jenisKelamin, String NIM, String jurusan) {
        super(nama, jenisKelamin);
        this.NIM = NIM;
        this.jurusan = jurusan;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }
   
    public String getNIM() {
        return NIM;
    }
    
    @Override
    public String toString(){
        return "\n NIM Mahasiswa = " + NIM
                + "\n Nama = " + getNama()
                + "\n Jenis Kelamin = " + getJenisKelamin()
                + "\n Jurusan = "+ jurusan;
    }
    
}
