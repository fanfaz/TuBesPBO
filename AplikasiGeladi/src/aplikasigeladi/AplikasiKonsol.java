/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;
import java.io.*;
import java.util.*;
/**
 *
 * @author Arfia
 */
public class AplikasiKonsol {
    private ArrayList<Lokasi> listLokasi;
    private ArrayList<Kelompok> listKelompok;
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Pembimbing> listPembimbing;
    
    
    public AplikasiKonsol() {
        listLokasi = new ArrayList<>();
        listKelompok = new ArrayList<>();
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
    
    public void insertLokasi(String daerah, String namaPerusahaan, int n){
	listLokasi.add(new Lokasi(daerah, namaPerusahaan, n));
	}
    
    public void insertKelompok(int nomor){
        listKelompok.add(new Kelompok(nomor));
    }
    
    public void insertMahasiswa(String nama, String jenisKelamin, long NIM, String jurusan){
        listMahasiswa.add(new Mahasiswa(nama,jenisKelamin,NIM,jurusan));
    }
    
    public void insertPembimbing(String nama, String jenisKelamin, long NIP){
        listPembimbing.add(new Pembimbing(nama,jenisKelamin,NIP));
    }
    
     public Lokasi getLokasiByDaerah(String Daerah, String namaperusahaan) {
        for(Lokasi L : listLokasi)
        {
            if(L.getDaerah().equals(Daerah) && L.getDaerah().equals(namaperusahaan))
                return L;
        }
        return null;
    }
     
     public Kelompok getKelompok(int nomor) {
        for(Kelompok K : listKelompok)
        {
            if(K.getNomor()==nomor)
                return K;
        }
        return null;
    }
     
    public Mahasiswa getMahasiswaByNIM(long NIM) {
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
    
    public void removeMahasiswa(long NIM){
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
        for (int i = 0; i < listKelompok.size(); i++){
           Kelompok k = listKelompok.get(i);
            if (k.getNomor()==nomor) {
                listKelompok.remove(i);
            }
        }
    }
    
    public void removeLokasi(String daerah, String namaperusahaan){
        for (int i = 0; i < listLokasi.size(); i++){
            Lokasi L = listLokasi.get(i);
            if (L.getDaerah().equals(daerah) && L.getDaerah().equals(namaperusahaan)) {
                listMahasiswa.remove(i);
            }
        }
    }
    
    
    
    
   


    
}
