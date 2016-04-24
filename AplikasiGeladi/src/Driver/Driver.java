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
import java.sql.SQLException;

/**
 *
 * @author Arfiatnaprambudi
 */
public class Driver {
    public static void main(String[] args) throws SQLException {
    Aplikasi model = new Aplikasi();
    
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
