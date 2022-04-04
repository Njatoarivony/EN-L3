/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Etudiant {
    private int id;
    private String firstname;
    private String name;
    private String birth;
    private String adress;
    private String departement;
    private String mail;
    
    public int getId(){
        return this.id;
    }
    public void setId(int ID){
        this.id = ID;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public void setFirstname(String FIRSTNAME){
        this.firstname = FIRSTNAME;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String NAME){
        this.name = NAME;
    }
    public String getBirth(){
        return this.birth;
    }
    public void setBirth(String BIRTH){
        this.birth = BIRTH;
    }
    public String getAdress(){
        return this.adress;
    }
    public void setAdress(String ADRESS){
        this.adress = ADRESS;
    }
    
    public String getDepartement(){
        return this.departement;
    }
    public void setDepartement(String DEPARTEMENT){
        this.departement = DEPARTEMENT;
    }
    public String getMail(){
        return this.mail;
    }
    public void setMail(String MAIL){
        this.mail = MAIL;
    }
    
    
    public Etudiant(){}
    public Etudiant(int ID, String FIRSTNAME,String NAME, String BIRTH,String ADRESS,  String DEPARTEMENT, String MAIL){
        this.id=ID;
        this.firstname=FIRSTNAME;
        this.name= NAME;
        this.birth= BIRTH;
        this.adress=ADRESS;
        this.departement=DEPARTEMENT;
        this.mail=MAIL;
    
    
    }
    
    
            //a function to get new etudiant
            //the etudiant in the database
    
    public boolean addNewEtudiante(Etudiant etudiant){
    
        PreparedStatement ps;
        String addQuery="INSERT INTO `etudiant`( `firstname`, `name`, `birth`, `adress`, `departement`, `mail`) VALUES (?,?,?,?,?,?)";
        
        try {
            ps = Conn.getTheConnection().prepareStatement(addQuery);
            ps.setString(1, etudiant.getFirstname());
            ps.setString(2, etudiant.getName());
            ps.setString(3, etudiant.getBirth());
            ps.setString(4, etudiant.getAdress());
            ps.setString(5, etudiant.getDepartement());
            ps.setString(6, etudiant.getMail());
            
            return (ps.executeUpdate() >0 );
            
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    //create a funtion to edith
    public boolean EdithEtudiant(Etudiant etudiant)
        {
             PreparedStatement ps;
        String edithQuery="UPDATE `etudiant` SET `firstname`=?,`name`=?,`birth`=?,`adress`=?,`departement`=?,`mail`=? WHERE `id`=?";
        
        try {
            ps = Conn.getTheConnection().prepareStatement(edithQuery);
            ps.setString(1, etudiant.getFirstname());
            ps.setString(2, etudiant.getName());
            ps.setString(3, etudiant.getBirth());
            ps.setString(4, etudiant.getAdress());
            ps.setString(5, etudiant.getDepartement());
            ps.setString(6, etudiant.getMail());
            ps.setInt(7, etudiant.getId());
            
            return (ps.executeUpdate() >0 );
            
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
    
    //create a function to delete
    public boolean DeleteEtudiant(int etudiantId)
        {
              PreparedStatement ps;
        String deleteQuery="DELETE FROM `etudiant` WHERE `id`=?";
        
        try {
            ps = Conn.getTheConnection().prepareStatement(deleteQuery);
            ps.setInt(1,etudiantId);
            
            return (ps.executeUpdate() >0 );
            
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
    
    //create a function 'arraylist' of Student
    
    public ArrayList<Etudiant> Studentlist()
    {
        ArrayList<Etudiant> list= new ArrayList<>();
        Statement st;
        ResultSet rs;
        String selectQuery="SELECT * FROM `etudiant` ";
        
        try {
            st = Conn.getTheConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            
            Etudiant etudiant;
            
            
            while(rs.next() ){
                etudiant = new Etudiant(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getString(7) );
                
                list.add(etudiant);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return list;
    }

    
}
