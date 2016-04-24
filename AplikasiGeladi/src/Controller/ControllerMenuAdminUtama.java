/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import View.menuutamaadmin;
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

public class ControllerMenuAdminUtama implements ActionListener{
        Aplikasi model;
        menuutamaadmin view;
        
        public ControllerMenuAdminUtama(Aplikasi model) {
        this.model = model;
        view = new menuutamaadmin();
        view.setVisible(true);
        view.addListener(this);}
        
        
        @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnDataKelGeladi())) {
            new Controller.ControllerMenuAdminDataKelompok();
            view.dispose();
        }else if(source.equals(view.getBtnDataMahasiswa())){
            new Controller.ControllerMenuAdminDataMahasiswa(model);
            view.dispose();
        }else if (source.equals(view.getBtnDataPem())){
            new Controller.ControllerMenuAdminDataPembimbing();
            view.dispose();
        }else if (source.equals(view.getBtnLogout())){
            new Controller.ControllerLogin(model);
            view.dispose();
        }
    }
    
}

