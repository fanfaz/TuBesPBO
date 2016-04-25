/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Mahasiswa;
import View.MenuAdminDatamahasiswa;
import View.UpdateDataKelompok;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ARFIATNA
 */
public class ControllerUpdateDataKelompok extends MouseAdapter implements ActionListener{
    Aplikasi model;
    UpdateDataKelompok view;
    Mahasiswa m;
    int idLokasi;
    int nomor;
    
    public ControllerUpdateDataKelompok(Aplikasi model,int idLokasi,int nomor){
        try {
            this.model = model;
            view = new UpdateDataKelompok();
            view.setVisible(true);
            view.addAdapter(this);
            view.addListener(this);
            this.idLokasi=idLokasi;
            this.nomor=nomor;
            this.m = null;
            view.setListNim(model.getListNimMahasiswa());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUpdateDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAdd())){
            try {
                String NIM = view.getSelectedNim();
                Mahasiswa m = model.getMahasiswa(NIM);
                model.getLokasi(idLokasi).getKelompok(nomor).addAnggota(m);
                view.showMessage(view, NIM + " berhasil ditambahkan ke kelompok " + nomor);
                new Controller.ControllerMenuAdminDataKelompok(model);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerUpdateDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListNim())) {
            try {
                String NIM = view.getSelectedNim();
                Mahasiswa m = model.getMahasiswa(NIM);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControllerUpdateDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
            
}
