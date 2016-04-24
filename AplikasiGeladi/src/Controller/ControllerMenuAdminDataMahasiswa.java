/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Mahasiswa;
import View.MenuAdminDatamahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ARFIATNA
 */
public class ControllerMenuAdminDataMahasiswa extends MouseAdapter implements ActionListener,FocusListener {
     
    Aplikasi model;
    MenuAdminDatamahasiswa view;
    Mahasiswa m;
    
    public ControllerMenuAdminDataMahasiswa(Aplikasi model) {
        this.model = model;
        view = new MenuAdminDatamahasiswa();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);
        this.m = null;
        try {
            view.setListNim(model.getListNimMahasiswa());
            view.setListNim1(model.getListNimMahasiswa());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.view.getTfNim().addFocusListener(this);
        this.view.getTfNama().addFocusListener(this);
        this.view.getTfJK().addFocusListener(this);
        this.view.getTfJurusan().addFocusListener(this);
        this.view.getTfNim1().addFocusListener(this);
        this.view.getTfNama1().addFocusListener(this);
        this.view.getTfJK1().addFocusListener(this);
        this.view.getTfJurusan1().addFocusListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAddMahasiswa())) {
            String nama = view.getNama();
            String nim = view.getNim();
            String JK = view.getJK();
            String jurusan = view.getJurusan();
            if (m == null) {
                try {
                    String nimm = model.createMahasiswa(nama, JK, nim, jurusan);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.showMessage(view, "Berhasil Ditambahkan! ");
                view.setNama("");
                view.setJK("");
                view.setNim("");
                view.setJurusan("");
                new Controller.ControllerMenuAdminDataMahasiswa(model);
                view.dispose();
            }
        } else if (source.equals(view.getBtnEdit())) {
           
                String nama = view.getNama1();
                String nim = view.getNim1();
                String JK = view.getJK1();
                String jurusan = view.getJurusan1();
                
                String NIM = view.getSelectedNim1();
                Mahasiswa M;
                
            try {
                M = model.getMahasiswa(NIM);
                M.setNama(nama);
                M.setNIM(nim);
                M.setJurusan(jurusan);
                M.setJenisKelamin(JK);
                model.updateMahasiswa(M);
                view.showMessage(view, "Berhasil Diupdate! ");
                new Controller.ControllerMenuAdminDataMahasiswa(model);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } else if (source.equals(view.getBtnDelete())){
            try {
                String nim = view.getSelectedNim();
                Mahasiswa m = model.getMahasiswa(nim);
                model.deleteMahasiswa(m);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Controller.ControllerMenuAdminDataMahasiswa(model);
            view.dispose();
        } else if (source.equals(view.getBtnExit())){
            new Controller.ControllerMenuAdminUtama(model);
            view.dispose();
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListNim())) {
            try {
                String NIM = view.getSelectedNim();
                Mahasiswa m = model.getMahasiswa(NIM);
                view.setDetilMahasiswa(m.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getListNim1())){
                String NIM = view.getSelectedNim1();
                Mahasiswa m;
            try {
                m = model.getMahasiswa(NIM);
                view.setNama1(m.getNama());
                view.setJK1(m.getJenisKelamin());
                view.setNim1(m.getNIM());
                view.setJurusan1(m.getJurusan());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
