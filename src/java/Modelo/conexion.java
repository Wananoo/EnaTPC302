package Modelo;


import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class conexion {
    public String user="root";
    public String pass="babo997711X";
    public String host="localhost";
    public String port="3306";
    public String database="certamen2";
    public String classname="com.mysql.jdbc.Driver";
    public String url="jdbc:mysql://" +host+ ":" +port+ "/" +database;
    
    
    public java.sql.Connection con;

    public conexion() 
        {
        try{
            Class.forName(classname);
            con = DriverManager.getConnection(url, user, pass);
        }
        //------------------------------------------------------------
        catch(ClassNotFoundException ex)
        {
        System.out.println("Error - Clase no encontrada"+ex.toString());
        }
        //------------------------------------------------------------
        catch(SQLException ex)
        {
        System.out.println("Error - SQL"+ex.toString());
        }
        //------------------------------------------------------------
        }
    public java.sql.Connection getconexion(){
        return con;
    }
    
}
