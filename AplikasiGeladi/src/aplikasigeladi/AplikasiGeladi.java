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
    //public static void main(String[] args) {
        Lokasi L1 = new Lokasi("Jawa Barat","Telkom");
        Pembimbing P1 = new Pembimbing("Asep","Laki-laki", 111111111);
        
        Mahasiswa a = new Mahasiswa("Arfi", "Laki-laki", 1301140299, "Teknik Informatika");
        Mahasiswa b = new Mahasiswa("Fazri", "Laki-laki", 1301140298, "Teknik Informatika");
        Mahasiswa c = new Mahasiswa("Dwi", "Laki-laki", 1301140297, "Teknik Informatika");
        
        L1.addPembimbing(P1);
        L1.addKelompok(0);
        L1.getKelompok(0).addAnggota(a);
        L1.getKelompok(0).addAnggota(a);
        
        System.out.println(L1.toString());
        System.out.println(L1.getKelompok(0).toString());
        System.out.println(L1.getPembimbing(0).toString());
        System.out.println(L1.getKelompok(0).getAnggota(0).toString());
        
         
        
        

        
        
        
        
        
    }
    
}
