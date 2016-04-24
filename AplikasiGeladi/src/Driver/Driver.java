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
    
    
    new ControllerLogin(model);
    Pembimbing p = model.getPembimbing("1301144097");
    model.getLokasi(1).addPembimbing(p);
    
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
