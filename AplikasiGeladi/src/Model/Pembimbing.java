/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author USER
 */
public class Pembimbing extends Orang implements Serializable{
    private String NIP;
    
    public Pembimbing(String nama, String jenisKelamin, String NIP){
        super(nama, jenisKelamin);
        this.NIP = NIP;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
    
     @Override
    public String toString(){
        return "\nNIP Pembimbing  = " + NIP
                + "\nNama = " + getNama()
                + "\nJenis Kelamin = " + getJenisKelamin();
    }
}
