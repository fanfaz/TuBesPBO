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
import View.MenuAdminKel;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ARFIATNA
 */
public class ControllerMenuAdminDataKelompok extends MouseAdapter implements ActionListener, FocusListener {

    Aplikasi model;
    MenuAdminKel view;
    Mahasiswa m;
    Pembimbing p;
    Kelompok k;
    Lokasi l;
    int nomorkel;

    public ControllerMenuAdminDataKelompok(Aplikasi model) {
        this.model = model;
        view = new MenuAdminKel();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);
        this.l = null;
        try {
            view.setListLokasi(model.getListDaerah());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenuMahasiswaDaftar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAdd())) {
            try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L;
                if (Per == null) {
                    JOptionPane.showMessageDialog(null, "asdasdasdasd");
                } else {
                    L = model.getLokasiPerusahaan(Per);
                    int I = L.getIdLokasi();
                    int a = model.getLokasi(I).getnKelompok();
                    if (a < 3) {
                        model.getLokasi(I).addKelompok(a + 1);
                        view.showMessage(view, "Berhasil ditambahkan kelompok" + (a+1));
                    } else {
                        view.showMessage(view, "Jumlah Kelompok Pada Lokasi ini sudah maksimal");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getBtnDel())) {
            try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L;
                L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                model.getLokasi(I).deleteKelompok();
                view.dispose();
                new Controller.ControllerMenuAdminDataKelompok(model);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getBtnKel1())) {
            try {
                nomorkel = 0;
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                if (model.getLokasi(I).getKelompok(0).getAnggota(1) != null) {
                    view.setAnggota1(model.getLokasi(I).getKelompok(0).getAnggota(1).toString());
                } else {
                    view.setAnggota1("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(2) != null) {
                    view.setAnggota2(model.getLokasi(I).getKelompok(0).getAnggota(2).toString());
                } else {
                    view.setAnggota2("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(3) != null) {
                    view.setAnggota3(model.getLokasi(I).getKelompok(0).getAnggota(3).toString());
                } else {
                    view.setAnggota3("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(0).getAnggota(4) != null) {
                    view.setAnggota4(model.getLokasi(I).getKelompok(0).getAnggota(4).toString());
                } else {
                    view.setAnggota4("Belum ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getBtnKel2())) {
            try {
                nomorkel = 1;
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                if (model.getLokasi(I).getKelompok(1).getAnggota(1) != null) {
                    view.setAnggota1(model.getLokasi(I).getKelompok(1).getAnggota(1).toString());
                } else {
                    view.setAnggota1("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(2) != null) {
                    view.setAnggota2(model.getLokasi(I).getKelompok(1).getAnggota(2).toString());
                } else {
                    view.setAnggota2("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(3) != null) {
                    view.setAnggota3(model.getLokasi(I).getKelompok(1).getAnggota(3).toString());
                } else {
                    view.setAnggota3("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(1).getAnggota(4) != null) {
                    view.setAnggota4(model.getLokasi(I).getKelompok(1).getAnggota(4).toString());
                } else {
                    view.setAnggota4("Belum ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getBtnKel3())) {
            try {
                nomorkel = 2;
                String Per = view.getSelectedPerusahaan();
                Lokasi L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                if (model.getLokasi(I).getKelompok(2).getAnggota(1) != null) {
                    view.setAnggota1(model.getLokasi(I).getKelompok(2).getAnggota(1).toString());
                } else {
                    view.setAnggota1("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(2) != null) {
                    view.setAnggota2(model.getLokasi(I).getKelompok(2).getAnggota(2).toString());
                } else {
                    view.setAnggota2("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(3) != null) {
                    view.setAnggota3(model.getLokasi(I).getKelompok(2).getAnggota(3).toString());
                } else {
                    view.setAnggota3("Belum ada");
                }
                if (model.getLokasi(I).getKelompok(2).getAnggota(4) != null) {
                    view.setAnggota4(model.getLokasi(I).getKelompok(2).getAnggota(4).toString());
                } else {
                    view.setAnggota4("Belum ada");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (source.equals(view.getBtnExit())) {
            new Controller.ControllerMenuAdminUtama(model);
            view.dispose();
        } else if ((source.equals(view.getBtnUpdate1())) || (source.equals(view.getBtnUpdate2())) || (source.equals(view.getBtnUpdate3())) || (source.equals(view.getBtnUpdate4()))) {
            try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L;
                L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                new Controller.ControllerUpdateDataKelompok(model, I, nomorkel);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if ((source.equals(view.getBtnDelAng1())) || (source.equals(view.getBtnDelAng2())) || (source.equals(view.getBtnDelAng3())) || (source.equals(view.getBtnDelAng4()))){
            try {
                String Per = view.getSelectedPerusahaan();
                Lokasi L;
                L = model.getLokasiPerusahaan(Per);
                int I = L.getIdLokasi();
                model.getLokasi(I).deleteKelompok();
                view.dispose();
                new Controller.ControllerMenuAdminDataKelompok(model);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMenuAdminDataKelompok.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
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
