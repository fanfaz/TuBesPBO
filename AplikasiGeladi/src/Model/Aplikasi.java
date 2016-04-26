/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arfiatnaprambudi
 */
public class Aplikasi {
    private ArrayList<Mahasiswa> daftarMahasiswa;
    private ArrayList<Lokasi> daftarLokasi;
    private ArrayList<Pembimbing> daftarPembimbing;
    private Database connection;
    
    public Aplikasi() throws SQLException{
        this.daftarMahasiswa = new ArrayList<>();
        this.daftarLokasi = new ArrayList<>();
        this.daftarPembimbing = new ArrayList<>();
        this.connection = new Database();
        connection.connect();
    }
    
    ////MAHASISWA
    
    public String createMahasiswa(String nama, String jenisKelamin, String NIM, String jurusan) throws SQLException{
        Mahasiswa m = new Mahasiswa(nama,jenisKelamin,NIM,jurusan);
        daftarMahasiswa.add(m);
        connection.saveMahasiswa(m);
        return m.getNIM();
    }
    
    
    public Mahasiswa getMahasiswa(String nim) throws SQLException{
       /* for (Mahasiswa m : daftarMahasiswa){
            if (m.getNIM().equalsIgnoreCase(nim)){
                return m;
            }
        } */
        Mahasiswa m = connection.getMahasiswa(nim);
        daftarMahasiswa.add(m);
        return m;
    }
    
    public String[] getListNimMahasiswa() throws SQLException{
        return connection.getListNimMahasiswa();
    }
    
   public void updateMahasiswa(Mahasiswa m) throws SQLException{
        connection.updateMahasiswa(m);
    }
    
   public void deleteMahasiswa(Mahasiswa m) throws SQLException{
        connection.deleteMahasiswa(m);
    }
   
   /////LOKASI
   
   
    public int createLokasi(String daerah,String namaPerusahaan) throws SQLException{
        Lokasi l = new Lokasi(daerah, namaPerusahaan);
        daftarLokasi.add(l);
        connection.saveLokasi(l);
        return l.getIdLokasi();
    }
    
    public Lokasi getLokasi(int idLokasi) throws SQLException{
        for (Lokasi l : daftarLokasi){
            if (l.getIdLokasi()==idLokasi){
                return l;
            }
        }
        Lokasi l = connection.getLokasi(idLokasi);
        daftarLokasi.add(l);
        return l;
    }
    
    public Lokasi getLokasiDaerah(String Daerah) throws SQLException{
        for (Lokasi l : daftarLokasi){
            if (l.getDaerah()==Daerah){
                return l;
            }
        }
        Lokasi l = connection.getLokasiByDaerah(Daerah);
        daftarLokasi.add(l);
        return l;
    }
    
    public Lokasi getLokasiPerusahaan(String per) throws SQLException{
        for (Lokasi l : daftarLokasi){
            if (l.getNamaPerusahaan()==per){
                return l;
            }
        }
        Lokasi l = connection.getLokasiByPerusahaan(per);
        daftarLokasi.add(l);
        return l;
    }
    
    public String[] getListIdLokasi() throws SQLException{
        return connection.getListIdLokasi();
    }
    
    public String[] getListDaerah() throws SQLException{
        return connection.getListDaerah();
    }
    
    public Integer[] getIdLokasi(String per) throws SQLException{
        return connection.getIdLokasi(per);
    }
    
    public String[] getListPerusahaan(Lokasi L) throws SQLException{
        return connection.getListPerusahaan(L);
    }
    
    public void updateLokasi(Lokasi l) throws SQLException{
        connection.updateLokasi(l);
    }
   
    
    /////LOKASI
    
    public String createPembimbing(String nama, String jenisKelamin, String NIP) throws SQLException{
        Pembimbing p = new Pembimbing(nama,jenisKelamin,NIP);
        daftarPembimbing.add(p);
        connection.savePembimbing(p);
        return p.getNIP();
    }
    
    
    public Pembimbing getPembimbing(String nip) throws SQLException{
        for (Pembimbing p : daftarPembimbing){
            if (p.getNIP()==nip){
                return p;
            }
        }
        Pembimbing p = connection.getPembimbing(nip);
        daftarPembimbing.add(p);
        return p;
    }
    
    public String[] getListNipPembimbing() throws SQLException{
        return connection.getListNipPembimbing();
    }
    
   public void updatePembimbing(Pembimbing p) throws SQLException{
        connection.updatePembimbing(p);
    }
   
   public String[] getListListPembimbing() throws SQLException{
        return connection.getListNamaPem();
    }
   
   
   public void deletePembimbing(Pembimbing p) throws SQLException{
        connection.deletePembmbing(p);
    }
   
   ///KELOMPOK
   
   
   
   
}
