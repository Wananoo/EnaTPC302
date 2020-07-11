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
         String Consulta="select * from Usuarios";
         rs = st.executeQuery(Consulta);
         
         while(rs.next()){
             if(user.equals(rs.getString("Usuario"))&&pass.equals(rs.getString("pass")))
                 return true;
         }
         
        return false;
    }
           
    
    public List<String> Listar(String tipo) throws SQLException{
        List<String> lista = new ArrayList<>();
        Statement st=con.createStatement();
         ResultSet rs= null;     
         String Consulta="select Nombre from "+tipo;
         rs = st.executeQuery(Consulta);
        while (rs.next())
        {
            System.out.println(rs.getString("Nombre"));
            lista.add(rs.getString("Nombre"));
        }
        return lista;
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
    
