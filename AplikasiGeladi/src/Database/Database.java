/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Kelompok;
import Model.Lokasi;
import Model.Mahasiswa;
import Model.Pembimbing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Database {
    private String server;
    private String dbuser;
    private String dbpasswd;
    private java.sql.Statement statement;
    private java.sql.Connection connection;
    
    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db_geladi", "arfiatna", "");
            statement = connection.createStatement();
            System.out.println("Anda berhasil terkoneksi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   public void disconnect() {
        try {
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
  /* public boolean manipulasiData(String query){
        try {
            if(statement.executeUpdate(query)>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } */
   
   ////MAHASISWA
   
   public void saveMahasiswa(Mahasiswa m) throws SQLException{
        String query = "insert into mahasiswa(NAMA_MHS,JNS_KELAMIN,NIM_MHS,JURUSAN) values('" +  m.getNama() + "', '" + m.getJenisKelamin() + "'," + m.getNIM()
                        + ", '" + m.getJurusan() + "')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
    }
   
   
   public Mahasiswa getMahasiswa(String nim) throws SQLException{
        Mahasiswa m = null;
        String query = "SELECT * FROM mahasiswa WHERE NIM_MHS="+nim;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            m = new Mahasiswa(rs.getString(2), rs.getString(4), rs.getString(1), rs.getString(3));   
        }
        return m;
   }
       
    public void updateMahasiswa(Mahasiswa m){
        try {
            String query= "update mahasiswa set nama_mhs= '"+m.getNama()+"',jurusan='"+m.getJurusan()+"' "+"where nim_mhs = "+m.getNIM();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteMahasiswa(Mahasiswa m){
        String query= "delete mahasiswa where nim_mhs = "+m.getNIM();
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getListNimMahasiswa() throws SQLException{
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT NIM_MHS FROM mahasiswa";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
    
    ////LOKASI
    
    public void saveLokasi(Lokasi l) throws SQLException{
        String query = "insert into lokasi(daerah,nama_perusahaan) values('" +  l.getDaerah() + "', '" + l.getNamaPerusahaan() + "')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()){
            generatedId=rs.getInt(1);
        }
        l.setIdLokasi(generatedId);
    }
    
     public String[] getListIdLokasi() throws SQLException{
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT idLokasi FROM lokasi";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
     
     public Integer[] getIdLokasi(String per) throws SQLException{
        ArrayList<Integer> listId = new ArrayList();
        String query = "SELECT idLokasi FROM lokasi where nama_perusahaan='"+per+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getInt(1));
        }
        return listId.toArray(new Integer[0]);
    }
     
     public String[] getListDaerah() throws SQLException{
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT Daerah FROM lokasi";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
     
     
     
     public String[] getListPerusahaan(Lokasi L) throws SQLException{
        int id = L.getIdLokasi();
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT Nama_Perusahaan FROM lokasi where idLokasi="+id;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
     
    
     
     
    public Lokasi getLokasi(int idLokasi) throws SQLException{
        Lokasi l = null;
        String query = "SELECT * FROM lokasi WHERE idLokasi="+ idLokasi;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            l = new Lokasi(rs.getInt(1), rs.getString(2), rs.getString(3));   
        }
        return l;
    }
    
    
    public Lokasi getLokasiByDaerah(String daerah) throws SQLException{
        Lokasi l = null;
        String query = "SELECT * FROM lokasi WHERE Daerah='"+ daerah +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            l = new Lokasi(rs.getInt(1), rs.getString(2), rs.getString(3));   
        }
        return l;
    }   
    
    public Lokasi getLokasiByPerusahaan(String per) throws SQLException{
        Lokasi l = null;
        String query = "SELECT * FROM lokasi WHERE Nama_Perusahaan='"+ per +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            l = new Lokasi(rs.getInt(1), rs.getString(2), rs.getString(3));   
        }
        return l;
    }   

     public void updateLokasi(Lokasi l) throws SQLException{
        String query= "update lokasi set daerah= '"+l.getDaerah()+"',nama_perusahaan='"+l.getNamaPerusahaan()+"' "+"where idLokasi = "+ l.getIdLokasi();
        statement.executeUpdate(query);
    }
     
    ///PEMBIMBING
     
     public void savePembimbing(Pembimbing p) throws SQLException{
        String query = "insert into pembimbing(NAMA_PMB,JNS_KELAMIN_PMB,NIP_PMB) values('" + p.getNama() + "', '" + p.getJenisKelamin() + "'," + p.getNIP()
                        + ")";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
    }
   
   
   public Pembimbing getPembimbing(String nip) throws SQLException{
        Pembimbing p = null;
        String query = "SELECT * FROM pembimbing WHERE NIP_PMB="+ nip;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            p = new Pembimbing(rs.getString(2), rs.getString(3), rs.getString(1));   
        }
        return p;
    }
   
   public String[] getListNamaPem() throws SQLException{
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT NAMA_PMB FROM pembimbing";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
       
    public void updatePembimbing(Pembimbing p) throws SQLException{
        String query= "update pembimbing set nama_pmb= '"+p.getNama()+ "where nim_mhs = "+p.getNIP();
        statement.executeUpdate(query);
    }
    
    public String[] getListNipPembimbing() throws SQLException{
        ArrayList<String> listId = new ArrayList();
        String query = "SELECT NIP_PMB FROM pembimbing";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            listId.add(rs.getString(1));
        }
        return listId.toArray(new String[0]);
    }
    
    
    
    ///KELOMPOK
    
    
    
     
     
     
   
   
    
   
   /*public ResultSet getData(String query){
        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
