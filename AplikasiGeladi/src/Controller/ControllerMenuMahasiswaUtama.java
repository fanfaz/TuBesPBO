/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Mahasiswa;
import View.menuutamamahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ARFIATNA
 */
public class ControllerMenuMahasiswaUtama implements ActionListener{
    Aplikasi model;
    Mahasiswa m;
    menuutamamahasiswa view;
    
    public ControllerMenuMahasiswaUtama(Aplikasi model,Mahasiswa m) {
        this.model = model;
        view = new menuutamamahasiswa();
        this.m=m;
        view.setVisible(true);
        view.addListener(this);}
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnDaftarGeladi())) {
            new Controller.ControllerMenuMahasiswaDaftar(model, m);
            view.dispose();
    }   else if (source.equals(view.getBtnLogout())){
            new Controller.ControllerLogin(model);
            view.dispose();
    }
    }
    
}
