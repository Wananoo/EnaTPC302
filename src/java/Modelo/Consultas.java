package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Consultas extends conexion{
    
    
    public boolean Login(String user, String pass) throws SQLException{
        Statement st=con.createStatement();
        
         ResultSet rs= null;     
         String Consulta="select * from Empleados";
         rs = st.executeQuery(Consulta);
         
         while(rs.next()){
             if(user.equals(rs.getString("Nombre"))&&pass.equals(rs.getString("password")))
                 return true;
         }
         
        return false;
    }
    
    public boolean Mostrar() throws SQLException{
        Statement st=con.createStatement();
        
         ResultSet rs= null;     
         String Consulta="select * from Usuarios";
         rs = st.executeQuery(Consulta);
         
         while(rs.next()){
             if(user.equals(rs.getString("Nombre"))&&pass.equals(rs.getString("password")))
                 return true;
         }
         
        return false;
    }
    
    



    
    public static void main(String [] args) throws SQLException{
        Consultas cons = new Consultas();
    }
    
}
    
