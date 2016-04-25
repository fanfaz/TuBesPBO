/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package Controller;
import Model.Aplikasi;
import Model.Mahasiswa;
import View.login;
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
 * @author Arfiatnaprambudi
 */
public class ControllerLogin implements ActionListener, FocusListener {
        Aplikasi model;
        login view;
        Mahasiswa m;
        
        public ControllerLogin(Aplikasi model) {
        this.model = model;
        view = new login();
        view.setVisible(true);
        view.addListener(this);
        this.m = null;
        
        this.view.getTfnim().addFocusListener(this);
        this.view.getTfpassword().addFocusListener(this);
    }

    public ControllerLogin(Aplikasi model, Mahasiswa m) {
        this.model = model;
        view = new login();
        view.setVisible(true);
        view.addListener(this);
        this.m = m;
        view.setUsername(m.getNIM());
        view.setPassword(m.getNIM());
        view.setUsernameAdmin("admin");
        view.setPasswordAdmin("admin");
        view.getBtnLogin().setText("");
        view.setTitle("LOGIN FORM");
        /*view.setNama(p.getNama());
        view.setAlamat(p.getAlamat());
        view.getBtnAdd().setText("Update");
        view.setTitle("Edit Pelanggan");*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        Mahasiswa m = null;

        if (source.equals(view.getBtnLogin())) {
               String usernameAdmin = view.getUsernameAdmin();
               String passwordAdmin = view.getPasswordAdmin();
               
               if((usernameAdmin.equalsIgnoreCase("admin")) && (passwordAdmin.equalsIgnoreCase("admin"))){
                   new Controller.ControllerMenuAdminUtama(model);
                   view.dispose();
               }else{
            
            try {
                String username = view.getUsername();
                String password = view.getPassword();
                
                
                m = model.getMahasiswa(username);
                
                if (m != null) {
                    if (password.equals(m.getNIM())){
                        new Controller.ControllerMenuMahasiswaUtama(model, m);
                        view.dispose();
                    
                    }else{
                        view.showMessage(view, "Password anda salah!");
                    }
                } else 
                {
                        view.showMessage(view, "Username atau password anda salah!");
        }

    }       catch (SQLException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }}

        @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.equals(this.view.getTfnim())){
            if(this.view.getTfnim().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Mohon isi form");
            }
        }
    }
    
}

