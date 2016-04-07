/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ARFIATNA
 */
public class Konsol {
    public static AplikasiKonsol model;
    public static Scanner s1;
    public static Scanner s2;
    public static Scanner s3;
    
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
                                    if (Uname=="admin" && Pass=="admin"){ //login belum
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
                                                                model.insertPembimbing(namaPembimbing,jKelaminPembimbing,nipPembimbing); //penggunaan method belum mengerti
                                                                break;
                                                        case 2 :System.out.println("Masukkan NIP Pembimbing :");
                                                                nipPembimbing = s2.nextLong();
                                                                if (model.getPembimbingByNIP(nipPembimbing)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {model.removePembimbing(nipPembimbing);}
                                                                break;
                                                        case 3 :System.out.println("Masukkan NIP Pembimbing :");
                                                                nipPembimbing = s2.nextLong();
                                                                model.viewPembimbing(nipPembimbing);
                                                                break;}
                                                     break;
                                             case 2 :System.out.println("1. Add Kelompok");
                                                     System.out.println("2. Delete Kelompok");
                                                     System.out.println("3. View Kelompok");
                                                     int menuDataKelompok = inputInteger();
                                                     switch (menuDataKelompok) {
                                                        case 1 :System.out.println("Masukkan Nomor Kelompok :");
                                                                int nomor = s2.nextInt();
                                                                model.insertKelompok(nomor);
                                                                break;
                                                        case 2 :
                                                                System.out.println("Masukkan Nomor Kelompok :");
                                                                nomor = s2.nextInt();
                                                                model.removeKelompok(nomor);
                                                                break;
                                                        case 3 :
                                                                System.out.println("Masukkan Nomor Kelompok :");
                                                                nomor = s2.nextInt();
                                                                model.viewKelompok(nomor);
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
                                                                String jurusan = s2.nextLine();
                                                                model.insertMahasiswa(namaMahasiswa,jKelaminMahasiswa,nimMahasiswa,jurusan);
                                                                break;
                                                        case 2 :System.out.println("Masukkan NIM  :");
                                                                nimMahasiswa = s2.nextLong();
                                                                if (model.getMahasiswaByNIM(nimMahasiswa)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {model.removeMahasiswa(nimMahasiswa);}
                                                                break;
                                                        case 3 :System.out.println("Masukkan NIM :");
                                                                nimMahasiswa = s2.nextLong();
                                                                model.viewMahasiswa(nimMahasiswa);
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
                                                                model.insertLokasi(namaDaerah,namaPerusahaan);
                                                                break;
                                                        case 2 :System.out.println("1. Nama Daerah :");
                                                                namaDaerah = s2.nextLine();
                                                                System.out.println("2. Nama Perusahaan :");
                                                                namaPerusahaan = s2.nextLine();
                                                                if (model.getLokasiByDaerah(namaDaerah,namaPerusahaan)==null){
                                                                    System.out.println("Data tidak ada");
                                                                } else {model.removeLokasi(namaDaerah,namaPerusahaan);}
                                                                break;
                                                        case 3 :System.out.println("1. Nama Daerah :");
                                                                namaDaerah = s2.nextLine();
                                                                model.viewLokasi(namaDaerah);
                                                                break;}
                                                     break;
                                            default: throw new IllegalStateException("Salah Input");
                                        } } while(menuAdmin!=0); return pil;
                                    }
                            case 2: System.out.println("Username :");
                                    long Usname = s2.nextLong();
                                    System.out.println("Password :");
                                    long Passw = s2.nextLong();
                                    Mahasiswa m;
                                    if ((model.getMahasiswaByNIM(Usname))!=null){ 
                                         System.out.println("1. Pilih Lokasi");
                                         System.out.println("2. Daftar Kelompok");
                                         System.out.println("0. Exit");
                                         int menuMahasiswa = inputInteger();
                                         do {
                                         switch(menuMahasiswa){
                                             case 1:System.out.println("Nama Daerah :");
                                                    String namaDaerah = s2.nextLine();
                                                    if (model.getLokasiByDaerah(namaDaerah)==null){
                                                        System.out.println("Daerah tidak tersedia");
                                                    } else {model.viewLokasi(namaDaerah);
                                                        System.out.println("Pilih Nama Perusahaan :");
                                                        String namaPerusahaan = s2.nextLine();
                                                        if (model.getLokasiByDaerah(namaDaerah,namaPerusahaan)==null){
                                                        System.out.println("Daerah tidak tersedia");
                                                        }else {Lokasi l = model.getLokasiByDaerah(namaDaerah,namaPerusahaan);
                                                        //if (namaDaerah=="Jawa Barat"){ //belum buat method pengelompokan
                                                        //l.getKelompok(0).addAnggota(m);
                                                        }}
                                                    
                                                     break;
                                             case 2:break;}
                                         }while(menuMahasiswa!=0);
                                    } 
           return pil;}
        }
    return pil;}
    
    public static void main(String[] args) {
        int pil=-1;
        model = new AplikasiKonsol();
        s1 = new Scanner (System.in);
        s2 = new Scanner (System.in);
        
        do {
            try {
                pil= MainMenu();
            } catch (Exception e) {
                System.out.println("error:"+e.getMessage());
            }
        }while (pil!=0);
        
    }
    
    
}
          

