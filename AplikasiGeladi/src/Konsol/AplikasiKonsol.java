/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konsol;
import Model.Kelompok;
import Model.Lokasi;
import Model.Mahasiswa;
import Model.Pembimbing;
import java.io.*;
import java.util.*;
/**
 *
 * @author Arfia
 */
public class AplikasiKonsol {
    private ArrayList<Lokasi> listLokasi;
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Pembimbing> listPembimbing;
    int i=0;
    
    
    public AplikasiKonsol() {
        listLokasi = new ArrayList<>();
        listMahasiswa = new ArrayList<>();
        listPembimbing = new ArrayList<>();
    }
    
    public void saveData(AplikasiKonsol app){
        try {
            FileOutputStream save = new FileOutputStream("data.txt");
            ObjectOutputStream o = new ObjectOutputStream(save);
            o.writeObject(app);
            o.flush();
        }
        catch (IOException e) {
            System.out.println("ERROR!" + e);
        }
    }
    public AplikasiKonsol loadData(){
        AplikasiKonsol app = null;
        try {    
            FileInputStream load = new FileInputStream("data.txt");
            ObjectInputStream o = new ObjectInputStream(load);
            while((app = (AplikasiKonsol) o.readObject())!=null) {}
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("L");
        }
        finally { return app; }
    }
    
    public void insertLokasi(String daerah, String namaPerusahaan){
        listLokasi.add(new Lokasi(daerah,namaPerusahaan));
	}
    
    public void insertKelompok(int nomor){
        new Kelompok(i);
        i++;
    }
    
    public void insertMahasiswa(String nama, String jenisKelamin, String NIM, String jurusan){
        listMahasiswa.add(new Mahasiswa(nama,jenisKelamin,NIM,jurusan));
    }
    
    public void insertPembimbing(String nama, String jenisKelamin, long NIP){
        listPembimbing.add(new Pembimbing(nama,jenisKelamin,NIP));
    }
    
     public Lokasi getLokasiByDaerah(String Daerah) {
        for (Lokasi K : listLokasi){                                  
             if(K.getDaerah().equals(Daerah)){
                return K;}
    }return null;
    }
     
    public Lokasi getLokasiByDaerah(String Daerah, String namaperusahaan) {
        for (Lokasi K : listLokasi){                                  
             if(K.getDaerah().equals(Daerah) && K.getDaerah().equals(namaperusahaan) ){
                return K;}
    }return null;
    }
     
     public Lokasi getKelompok(int nomor) {
        for(Lokasi K : listLokasi)
        {
            if(K.getKelompok(i).getNomor()==nomor)
                return K;
                i++;
        }
        return null;
    }
     
    public Mahasiswa getMahasiswaByNIM(String NIM) {
        for(Mahasiswa M : listMahasiswa)
        {
            if(M.getNIM()==NIM)
                return M;
        }
        return null;
    }
    
    public Pembimbing getPembimbingByNIP(long NIP) {
        for(Pembimbing P : listPembimbing)
        {
            if(P.getNIP()==NIP)
                return P;
        }
        return null;
    }
    
    public void removeMahasiswa(String NIM){
        for (int i = 0; i < listMahasiswa.size(); i++){
            Mahasiswa m = listMahasiswa.get(i);
            if (m.getNIM()==NIM) {
                listMahasiswa.remove(i);
            }
        }
    }
    
    public void removePembimbing(long NIP){
        for (int i = 0; i < listPembimbing.size(); i++){
            Pembimbing p = listPembimbing.get(i);
            if (p.getNIP()==NIP) {
                listPembimbing.remove(i);
            }
        }
    }
    
    public void removeKelompok(int nomor){
        for (int i = 0; i < listLokasi.size(); i++){
            Lokasi l = listLokasi.get(i);
            if (l.getKelompok(i).getNomor()==nomor) {
                listLokasi.remove(i);
            }
        }
    }
    
    public void removeLokasi(String daerah, String namaperusahaan){
        for (int i = 0; i < listLokasi.size(); i++){
            Lokasi l = listLokasi.get(i);
            if (l.getDaerah().equals(daerah) && l.getDaerah().equals(namaperusahaan)){
                listLokasi.remove(i);
            }
        }
    }
    
    public void viewPembimbing(long NIP){
        for (Pembimbing p : listPembimbing){
            if ( p.getNIP()==NIP){
            System.out.println("-----");
            System.out.println(p.toString());
            }
        }
    }
    
    public void viewLokasi(String namaDaerah){
        for (Lokasi l : listLokasi){
            if (l.getDaerah().equals(namaDaerah)){
            System.out.println("-----");
            System.out.println(l.toString());
            }
        }
    }
    
    
    public void viewMahasiswa(String NIM){
        for (Mahasiswa m : listMahasiswa){
            if (m.getNIM()==NIM){
            System.out.println("-----");
            System.out.println(m.toString());
            }
        }
    }
    
    public void viewKelompok(int nomor){
        for (Lokasi k : listLokasi){
            System.out.println("-----");
            System.out.println(k.getKelompok(nomor).toString());
            for (int i=0; i<=k.getKelompok(nomor).getnAnggota();i++){
            System.out.println(k.getKelompok(nomor).getAnggota(i).toString());
            }
        }
    } 
    
    /*public boolean LoginMahasiwa(long username,long password){
        for (Mahasiswa p : listMahasiswa){
            if (p.getUsername()==(username) && p.getPassword()==(password)){
                return true;
            }
        } return false;
    }*/
    
}                       
    
   


    
   
    
