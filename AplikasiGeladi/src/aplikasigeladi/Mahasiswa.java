/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;

/**
 *
 * @author Fazrial AN
 */
public class Mahasiswa extends Orang {
    private long NIM;
    private String jurusan;
    
    public long getNIM() {
        return NIM;
    }
    
    public void setNIM() {
        this.NIM = NIM;
    }
    
    public Mahasiswa(String nama, String jenisKelamin, long NIM, String jurusan) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.NIM = NIM;
        this.jurusan = jurusan;
    }
}
