/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Pembimbing;
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
public class ControllerMenuAdminDataPembimbing extends MouseAdapter implements ActionListener,FocusListener {
     
    Aplikasi model;
    MenuAdminDatamahasiswa view;
    Pembimbing p;
    
    public ControllerMenuAdminDataPembimbing(Aplikasi model) {
        this.model = model;
        view = new MenuAdminDatamahasiswa();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);
        this.p = null;
        try {
            view.setListNim(model.getListNipPembimbing());
            view.setListNim1(model.getListNipPembimbing());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenuAdminDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.view.getTfNim().addFocusListener(this);
        this.view.getTfNama().addFocusListener(this);
        this.view.getTfJK().addFocusListener(this);
        
        this.view.getTfNim1().addFocusListener(this);
        this.view.getTfNama1().addFocusListener(this);
        this.view.getTfJK1().addFocusListener(this);
     
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAddMahasiswa())) {
            String nama = view.getNama();
            String nim = view.getNim();
            String JK = view.getJK();
            if (p == null) {
                try {
                    String nip = model.createPembimbing(nama, JK, nim);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMenuAdminDataPembimbing.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.showMessage(view, "Berhasil Ditambahkan! ");
                view.setNama("");
                view.setJK("");
                view.setNim("");
                new Controller.ControllerMenuAdminDataPembimbing(model);
                view.dispose();
            }
        } else if (source.equals(view.getBtnEdit())) {
           
                String nama = view.getNama1();
                String nim = view.getNim1();
                String JK = view.getJK1();
                
                String NIM = view.getSelectedNim1();
                Pembimbing P;
                
            try {
                P = model.getPembimbing(NIM);
                P.setNama(nama);
                P.setNIP(NIM);
                P.setJenisKelamin(JK);
                model.updatePembimbing(P);
                view.showMessage(view, "Berhasil Diupdate! ");
                new Controller.ControllerMenuAdminDataPembimbing(model);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataPembimbing.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } else if (source.equals(view.getBtnDelete())){
            try {
                String nim = view.getSelectedNim();
                Pembimbing P = model.getPembimbing(nim);
                //model.deletePembimbing(p);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataPembimbing.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Controller.ControllerMenuAdminDataPembimbing(model);
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
                Pembimbing p = model.getPembimbing(NIM);
                view.setDetilMahasiswa(p.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataPembimbing.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getListNim1())){
                String NIM = view.getSelectedNim1();
                Pembimbing p;
            try {
                p = model.getPembimbing(NIM);
                view.setNama1(p.getNama());
                view.setJK1(p.getJenisKelamin());
                view.setNim1(p.getNIP());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataPembimbing.class.getName()).log(Level.SEVERE, null, ex);
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
