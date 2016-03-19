/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;

/**
 *
 * @author Fazrial AN
 */
public class Pembimbing extends Orang {
    private long NIP;

    public Pembimbing(String nama, String jenisKelamin) {
        super(nama, jenisKelamin);
    }

    public long getNIP() {
        return NIP;
    }
    
    public void setNIP(long NIP){
        this.NIP = NIP;
    }
}
