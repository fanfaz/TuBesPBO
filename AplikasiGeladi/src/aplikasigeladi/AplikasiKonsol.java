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
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Pembimbing> listPembimbing;
    public static Scanner s1;
    public static Scanner s2;
    public static Scanner s3;
    Lokasi[] lokasi = new Lokasi[10];
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
        listLokasi.add(addKelompok(nomor));
    }
    
    public void insertMahasiswa(String nama, String jenisKelamin, long NIM, String jurusan){
        listMahasiswa.add(new Mahasiswa(nama,jenisKelamin,NIM,jurusan));
    }
    
    public void insertPembimbing(String nama, String jenisKelamin, long NIP){
        listPembimbing.add(new Pembimbing(nama,jenisKelamin,NIP));
    }
    
     public Lokasi getLokasiByDaerah(String Daerah) {
        for (int i=0; i<=listLokasi.size(); i++);
             if(lokasi[i].getDaerah().equals(Daerah)){
                return lokasi[i];}
             return null;
    }
     
    public Lokasi getLokasiByDaerah(String Daerah, String namaperusahaan) {
        for (int i=0; i<=listLokasi.size(); i++);
             if(lokasi[i].getDaerah().equals(Daerah) && lokasi[i].getDaerah().equals(namaperusahaan)){
                return lokasi[i];}
             return null;
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
        for (int i = 0; i < listLokasi.size(); i++){
            Lokasi l = listLokasi.get(i);
            if (l.getKelompok(i).getNomor()==nomor) {
                listLokasi.remove(i);
            }
        }
    }
    
    public void removeLokasi(String daerah, String namaperusahaan){
        for (int i = 0; i <= listLokasi.size(); i++){
            if (lokasi[i].getDaerah().equals(daerah) && lokasi[i].getDaerah().equals(namaperusahaan)) {
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
    
    
    public void viewMahasiswa(long NIM){
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
            for (int i=0; i<=k.getKelompok(nomor).getNAnggota();i++){
            System.out.println(k.getKelompok(nomor).getAnggota(i).toString());
            }
        }
    }
    
    
    public static int inputInteger() {
        try {
            return s1.nextInt();
        } catch (InputMismatchException e){
            throw new InputMismatchException("Input must be integer");
        } finally {
            s1 = new Scanner(System.in);
        }
    }
    
    public static int MainMenu() throws IOException {
        System.out.println("APLIKASI GELADI");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("Masukkan Pilihan");
        int pil = inputInteger();
        switch (pil) {
            case 1:System.out.println("1. Admin");
                   System.out.println("2. Mahasiswa");
                   System.out.println("0. Exit");
                   System.out.println("Masukkan Pilihan");
                   int menuLogin = inputInteger();
                        switch (menuLogin){
                            case 1: System.out.println("Username :");
                                    String Uname = s2.nextLine();
                                    System.out.println("Password :");
                                    String Pass = s2.nextLine();
                                    Orang p;
                                    if (Uname==p.getUsername() && Pass==p.getPassword()){ //login belum
                                        System.out.println("1. Data Pembimbing");
                                        System.out.println("2. Data Kelompok");
                                        System.out.println("3. Data Mahasiswa");
                                        System.out.println("4. Manage Lokasi");
                                        System.out.println("0. Exit");
                                        int menuAdmin = inputInteger();
                                        do{
                                        switch (menuAdmin) {
                                             case 1 :System.out.println("1. Add Pembimbing");
                                                     System.out.println("2. Delete Pembimbing");
                                                     System.out.println("3. View Pembimbing");
                                                     System.out.println("0. Exit");
                                                     int menuDataPembimbing = inputInteger();
                                                     switch (menuDataPembimbing) {
                                                        case 1 :System.out.println("1. Nama Pembimbing :");
                                                                String namaPembimbing = s2.nextLine();
                                                                System.out.println("2. NIP Pembimbing :");
                                                                Long nipPembimbing = s2.nextLong();
                                                                System.out.println("3. Jenis Kelamin :");
                                                                String jKelaminPembimbing = s2.nextLine();
                                                                insertPembimbing(namaPembimbing,jKelaminPembimbing,nipPembimbing); //penggunaan method belum mengerti
                                                                break;
                                                        case 2 :System.out.println("Masukkan NIP Pembimbing :");
                                                                nipPembimbing = s2.nextLong();
                                                                if (getPembimbingByNIP(nipPembimbing)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {removePembimbing(nipPembimbing);}
                                                                break;
                                                        case 3 :System.out.println("Masukkan NIP Pembimbing :");
                                                                nipPembimbing = s2.nextLong();
                                                                viewPembimbing(nipPembimbing);
                                                                break;}
                                                     break;
                                             case 2 :System.out.println("1. Add Kelompok");
                                                     System.out.println("2. Delete Kelompok");
                                                     System.out.println("3. View Kelompok");
                                                     int menuDataKelompok = inputInteger();
                                                     switch (menuDataKelompok) {
                                                        case 1 :System.out.println("Masukkan Nomor Kelompok :");
                                                                int nomor = s2.nextInt();
                                                                insertKelompok(nomor);
                                                                break;
                                                        case 2 :
                                                                System.out.println("Masukkan Nomor Kelompok :");
                                                                int nomor = s2.nextInt();
                                                                removeKelompok(nomor);
                                                                break;
                                                        case 3 :
                                                                System.out.println("Masukkan Nomor Kelompok :");
                                                                int nomor = s2.nextInt();
                                                                viewKelompok(nomor);
                                                                break;}
                                                     break;
                                            case 3 :System.out.println("1. Add Mahasiswa");
                                                     System.out.println("2. Delete Mahasiswa");
                                                     System.out.println("3. View Mahasiswa");
                                                     int menuDataMahasiswa = inputInteger();
                                                     switch (menuDataMahasiswa) {
                                                        case 1 :System.out.println("1. Nama Mahasiswa :");
                                                                String namaMahasiswa = s2.nextLine();
                                                                System.out.println("2. NIM :");
                                                                Long nimMahasiswa = s2.nextLong();
                                                                System.out.println("3. Jenis Kelamin :");
                                                                String jKelaminMahasiswa = s2.nextLine();
                                                                System.out.println("4. Jurusan :");
                                                                String jurusan = s2.nextLine()
                                                                insertMahasiswa(namaMahasiswa,jKelaminMahasiswa,nimMahasiswa,jurusan);
                                                                break;
                                                        case 2 :System.out.println("Masukkan NIM  :");
                                                                nimMahasiswa = s2.nextLong();
                                                                if (getMahasiswaByNIM(nimMahasiswa)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {removeMahasiswa(nimMahasiswa);}
                                                                break;
                                                        case 3 :System.out.println("Masukkan NIM :");
                                                                nimMahasiswa = s2.nextLong();
                                                                viewMahasiswa(nimMahasiswa);
                                                                break;}
                                                     break;
                                             case 4 :System.out.println("1. Add Lokasi");
                                                     System.out.println("2. Delete Lokasi");
                                                     System.out.println("3. View Lokasi");
                                                     int menuDataLokasi = inputInteger();
                                                     switch (menuDataLokasi) {
                                                        case 1 :System.out.println("1. Nama Daerah :");
                                                                String namaDaerah = s2.nextLine();
                                                                System.out.println("2. Nama Perusahaan :");
                                                                String namaPerusahaan = s2.nextLine();
                                                                insertLokasi(namaDaerah,namaPerusahaan);
                                                                break;
                                                        case 2 :System.out.println("1. Nama Daerah :");
                                                                namaDaerah = s2.nextLine();
                                                                System.out.println("2. Nama Perusahaan :");
                                                                namaPerusahaan = s2.nextLine();
                                                                if (getLokasiByDaerah(namaDaerah,namaPerusahaan)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {removeLokasi(namaDaerah,namaPerusahaan);}
                                                                break;
                                                        case 3 :System.out.println("1. Nama Daerah :");
                                                                namaDaerah = s2.nextLine();
                                                                viewLokasi(namaDaerah);
                                                                break;}
                                                     break;
                                            default: throw new IllegalStateException("Salah Input");
                                        } } while(menuAdmin!=0); return pil;
                                    }
                            case 2: System.out.println("Username :");
                                    Uname = s2.nextLine();
                                    System.out.println("Password :");
                                    Pass = s2.nextLine();
                                    Mahasiswa m;
                                    if (Uname==m.getUsername() && Pass==m.getPassword()){ //login belum
                                         System.out.println("1. Pilih Lokasi");
                                         System.out.println("2. Daftar Kelompok");
                                         System.out.println("0. Exit");
                                         int menuMahasiswa = inputInteger();
                                         do {
                                         switch(menuMahasiswa){
                                             case 1:System.out.println("Nama Daerah :");
                                                    String namaDaerah = s2.nextLine();
                                                    if (getLokasiByDaerah(namaDaerah)==null){
                                                        System.out.println("Daerah tidak tersedia");
                                                    } else {viewLokasi(namaDaerah);
                                                        System.out.println("Pilih Nama Perusahaan :");
                                                        String namaPerusahaan = s2.nextLine();
                                                        if (getLokasiByDaerah(namaDaerah,namaPerusahaan)==null){
                                                        System.out.println("Daerah tidak tersedia");
                                                        }else {insertLokasi(namaDaerah,namaPerusahaan).addKelompok(i).addAnggota(m);
                                                        }
                                                    }
                                                     break;
                                             case 2:;
                                         }
                                    }while (menuMahasiswa!=0); return pil;}
              
          }
        }
    }
                    
                
        
       
}                       
    
   


    
   
    
