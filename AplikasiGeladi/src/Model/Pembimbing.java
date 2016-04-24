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
    private long NIP;
    
    public Pembimbing(String nama, String jenisKelamin, long NIP){
        super(nama, jenisKelamin);
        this.NIP = NIP;
    }

    public long getNIP() {
        return NIP;
    }

    public void setNIP(long NIP) {
        this.NIP = NIP;
    }
    
     @Override
    public String toString(){
        return "\nNIP Pembimbing  = " + NIP
                + "\nNama = " + getNama()
                + "\nJenis Kelamin = " + getJenisKelamin();
    }
}
