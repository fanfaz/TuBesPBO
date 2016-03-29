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
 * @author Fazrial AN
 */
public class Mahasiswa extends Orang implements Serializable {
    private long NIM;
    private String jurusan;
    
      public Mahasiswa(String nama, String jenisKelamin, long NIM, String jurusan) {
        super(nama, jenisKelamin);
        this.NIM = NIM;
        this.jurusan = jurusan;
    }
    
    public long getNIM() {
        return NIM;
    }
    
    public void setNIM() {
        this.NIM = NIM;
    }
    
  
}
