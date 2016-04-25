/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Lokasi;
import Model.Pembimbing;
import Model.Kelompok;
import Model.Mahasiswa;
import View.MenuMahasiswaDaftarGeladi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Arfiatnaprambudi
 */
public class ControllerMenuMahasiswaDaftar extends MouseAdapter implements ActionListener,FocusListener{
    Aplikasi model;
    MenuMahasiswaDaftarGeladi view;
    Mahasiswa m;
    Pembimbing p;
    Kelompok k;
    Lokasi l;
    
    public ControllerMenuMahasiswaDaftar(Aplikasi model,Mahasiswa m){
        this.model = model;
        view = new MenuMahasiswaDaftarGeladi();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);
        this.m=m;
        this.l=null;
        try {
            view.setListLokasi(model.getListDaerah());
           // view.setListPembimbing(model.getListListPembimbing());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenuMahasiswaDaftar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnOk())) {
            if(view.but1()==true){
                try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                model.getLokasi(I).getKelompok(0).addAnggota(m);
                view.setPembimbing(model.getLokasi(I).getPembimbing(0).toString());
                if (model.getLokasi(I).getKelompok(0).getAnggota(1)!=null){
                    view.setAnggota1(model.getLokasi(I).getKelompok(0).getAnggota(1).toString());
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(2)!=null){
                    view.setAnggota2(model.getLokasi(I).getKelompok(0).getAnggota(2).toString());
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(3)!=null){
                    view.setAnggota3(model.getLokasi(I).getKelompok(0).getAnggota(3).toString());
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(4)!=null){
                    view.setAnggota4(model.getLokasi(I).getKelompok(0).getAnggota(4).toString());
                }
                view.showMessage(view, "Anda telah terdaftar ke Perusahaan "+view.getSelectedPerusahaan()+" di Kelompok 1");
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMenuMahasiswaDaftar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(view.but2()==true){
                try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                model.getLokasi(I).getKelompok(1).addAnggota(m);
                view.setPembimbing(model.getLokasi(I).getPembimbing(0).toString());
                if (model.getLokasi(I).getKelompok(1).getAnggota(1)!=null){
                    view.setAnggota1(model.getLokasi(I).getKelompok(1).getAnggota(1).toString());
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(2)!=null){
                    view.setAnggota2(model.getLokasi(I).getKelompok(1).getAnggota(2).toString());
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(3)!=null){
                    view.setAnggota3(model.getLokasi(I).getKelompok(1).getAnggota(3).toString());
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(4)!=null){
                    view.setAnggota4(model.getLokasi(I).getKelompok(1).getAnggota(4).toString());
                }
                view.showMessage(view, "Anda telah terdaftar ke Perusahaan "+view.getSelectedPerusahaan()+" di Kelompok 2");
                
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMenuMahasiswaDaftar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(view.but3()==true){
                try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                model.getLokasi(I).getKelompok(2).addAnggota(m);
                view.setPembimbing(model.getLokasi(I).getPembimbing(0).toString());
                if (model.getLokasi(I).getKelompok(2).getAnggota(1)!=null){
                    view.setAnggota1(model.getLokasi(I).getKelompok(2).getAnggota(1).toString());
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(2)!=null){
                    view.setAnggota2(model.getLokasi(I).getKelompok(2).getAnggota(2).toString());
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(3)!=null){
                    view.setAnggota3(model.getLokasi(I).getKelompok(2).getAnggota(3).toString());
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(4)!=null){
                    view.setAnggota4(model.getLokasi(I).getKelompok(2).getAnggota(4).toString());
                }
                view.showMessage(view, "Anda telah terdaftar ke Perusahaan "+view.getSelectedPerusahaan()+" di Kelompok 3");
                
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerMenuMahasiswaDaftar.class.getName()).log(Level.SEVERE, null, ex);
                }
            if (source.equals(view.getBtnExit())){
                new Controller.ControllerMenuMahasiswaUtama(model, m);
                view.dispose();
            }
        }
    }else if(source.equals(view.getBtnExit())){
        new Controller.ControllerMenuMahasiswaUtama(model, m);
        view.dispose();
    }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListLokasi())) {
            try {
                String Lok = view.getSelectedDaerah();
                Lokasi L = model.getLokasiDaerah(Lok);
                view.setListPerusahaan(model.getListPerusahaan(L));
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
