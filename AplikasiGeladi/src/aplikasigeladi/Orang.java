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
public abstract class Orang {
    private String nama;
    private String jenisKelamin;
    
    public Orang(String nama, String jenisKelamin) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }
    
    public void setName() {
        this.nama = nama;
    }
    
     public String getName() {
        return nama;
    }
    
    public void setJenisKelamin() {
        this.jenisKelamin = jenisKelamin;
    }
    
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    
    
    
    
}
