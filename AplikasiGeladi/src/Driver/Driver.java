/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerLogin;
import Model.Aplikasi;
import Model.Lokasi;
import Model.Mahasiswa;
import Model.Pembimbing;
import Model.Kelompok;
import java.sql.SQLException;

/**
 *
 * @author Arfiatnaprambudi
 */
public class Driver {
    public static void main(String[] args) throws SQLException {
    Aplikasi model = new Aplikasi();
    
    model.getLokasi(1).addKelompok(1);
    model.getLokasi(1).addKelompok(2);
    model.getLokasi(1).addKelompok(3);
    
    
    model.getLokasi(2).addKelompok(1);
    model.getLokasi(2).addKelompok(2);
    model.getLokasi(2).addKelompok(3);
    
    
    model.getLokasi(3).addKelompok(1);
    model.getLokasi(3).addKelompok(2);
    model.getLokasi(3).addKelompok(3);
    
    Mahasiswa m1 = model.getMahasiswa("1301144007");
    model.getLokasi(1).getKelompok(0).addAnggota(m1);
    Mahasiswa m2 = model.getMahasiswa("1301144999");
    model.getLokasi(2).getKelompok(1).addAnggota(m2);
    System.out.println(model.getLokasi(1).getKelompok(0).getAnggota(1).toString());
    
    Pembimbing p1 = model.getPembimbing("1301144097");
    model.getLokasi(1).addPembimbing(p1);
    Pembimbing p2 = model.getPembimbing("1301144101");
    model.getLokasi(2).addPembimbing(p2);
    Pembimbing p3 = model.getPembimbing("1301144102");
    model.getLokasi(3).addPembimbing(p3);
    System.out.println(model.getLokasi(1).getPembimbing(0).toString());
    
    
    
    
    new ControllerLogin(model);
    
    
    /*Mahasiswa m;
    Lokasi l;
    Pembimbing p;
    
    model.createLokasi("Bandung", "Telkom Indonesia");
    model.createPembimbing("Dwi", "Laki-Laki", 1301144097);
    
    Long[] daftarNim = model.getListNimMahasiswa();
        for (int i = 0; i < daftarNim.length; i++) {
            System.out.println(daftarNim[i]);} */
        
    
    
    
    
    
    }
}
