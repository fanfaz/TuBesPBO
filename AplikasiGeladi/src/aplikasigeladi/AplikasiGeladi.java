/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigeladi;

/**
 *
 * @author Arfiatna
 */
public class AplikasiGeladi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mahasiswa a = new Mahasiswa("Arfi", "Laki-laki", 1301140299, "Teknik Informatika");
        Mahasiswa b = new Mahasiswa("Fazri", "Laki-laki", 1301140298, "Teknik Informatika");
        Mahasiswa c = new Mahasiswa("Dwi", "Laki-laki", 1301140297, "Teknik Informatika");
        
        Kelompok n = new Kelompok(3);
        n.addAnggota(a);
        n.addAnggota(b);
        n.addAnggota(c);
        
        
    }
    
}
