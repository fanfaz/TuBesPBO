/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
public class Lokasi {
    private String daerah;
    private String namaPerusahaan;
    private Pembimbing[] pembimbing;
    private int idLokasi; //
    private Kelompok[] kelompok = new Kelompok[100];
    private int nPembimbing=1;
    private int nKelompok;
    
    public Lokasi(String daerah, String namaPerusahaan){
        this.daerah = daerah;
        this.namaPerusahaan = namaPerusahaan;
        this.pembimbing = new Pembimbing[1];
        idLokasi=-1;
    }
    
    public Lokasi(int idLokasi,String daerah, String namaPerusahaan){
        this.idLokasi=idLokasi;
        this.daerah=daerah;
        this.namaPerusahaan=namaPerusahaan;
        this.pembimbing = new Pembimbing[1];
    }
    
    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getDaerah() {
        return daerah;
    }
       
    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
    
    public void addPembimbing(Pembimbing p){
        if(pembimbing[0]==null){
            pembimbing[0] = p;
            
        }else {
            System.out.println("Sudah punya pembimbing");
       }
    }
    
    public int getnPembimbing() {
        return nPembimbing;
    }

    public void addKelompok(int nomor){
        if(nKelompok <= 3){
            kelompok[nKelompok] = new Kelompok(nomor);
            nKelompok++;
        }else {
            System.out.println("Kelompok di lokasi ini sudah 3");
        }
    }
    
    public void deleteKelompok(){
        kelompok[nKelompok]=null;
        nKelompok--;
        
    }
    
   
    

    public int getnKelompok() {
        return nKelompok;
    }

    public void setIdLokasi(int idLokasi) {
        this.idLokasi = idLokasi;
    }

    public int getIdLokasi() {
        return idLokasi;
    }

    public void setPembimbing(Pembimbing[] pembimbing) {
        this.pembimbing = pembimbing;
    }

    public void setKelompok(Kelompok[] kelompok) {
        this.kelompok = kelompok;
    }

    public void setnPembimbing(int nPembimbing) {
        this.nPembimbing = nPembimbing;
    }

    public void setnKelompok(int nKelompok) {
        this.nKelompok = nKelompok;
    }

    public Pembimbing getPembimbing(int i) {
        return pembimbing[i];
    }

    public Kelompok getKelompok(int i) {
        return kelompok[i];
    }
    
    
    
}
