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
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ARFIATNA
 */

public class ControllerMenuAdminUtama extends MouseAdapter implements ActionListener,FocusListener{
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
            new Controller.ControllerMenuAdminDataKelompok(model);
            view.dispose();
        }else if(source.equals(view.getBtnDataMahasiswa())){
            new Controller.ControllerMenuAdminDataMahasiswa(model);
            view.dispose();
        }else if (source.equals(view.getBtnDataPem())){
            new Controller.ControllerMenuAdminDataPembimbing(model);
            view.dispose();
        }else if (source.equals(view.getBtnLogout())){
            new Controller.ControllerLogin(model);
            view.dispose();
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

