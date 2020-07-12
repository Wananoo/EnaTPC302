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
    
    
public boolean IngresarReq(String Gerencia, String Departamento, String Asignado, String Detalle) throws SQLException{
        int ID = 0;
        Statement st=con.createStatement();
         ResultSet rs= null;     
         String Consulta="select ID from requerimientos";
         rs = st.executeQuery(Consulta);
         while(rs.next()){
             ID++;
         }
         rs= null; 
        Gerencia = "\""+Gerencia+"\"";
        Consulta="select top 1 ID from Gerencias where Nombre="+Gerencia;
        rs = st.executeQuery(Consulta);
        if (rs.next()){Gerencia = rs.getString("ID");}
        rs= null; 
        Departamento = "\""+Departamento+"\"";
        Consulta="select top 1 ID from Departamentos where Nombre="+Departamento;
        rs = st.executeQuery(Consulta);
        if (rs.next()){Departamento = rs.getString("ID");}
        rs= null; 
        Asignado = "\""+Asignado+"\"";
        Consulta="select top 1 ID from Empleados where Nombre="+Asignado;
        rs = st.executeQuery(Consulta);
        if (rs.next()){Asignado = rs.getString("ID");}
        rs= null; 
        PreparedStatement pst = null;
        boolean estado = false;
        try 
        {
         String consulta = "insert into requerimientos(ID,Gerencia,Departamento,Asignado,Detalle) Values (?,?,?,?,?)";
         pst = getconexion().prepareStatement(consulta);
         pst.setString(1, Integer.toString(ID));
         pst.setString(2, Gerencia);
         pst.setString(3, Departamento);
         pst.setString(4, Asignado);
         pst.setString(5, Detalle);
         //------------------------------
         if (pst.executeUpdate() == 1)
         {
          estado = true;   
         }//fin if
         //------------------------------
        }//fin try
        //------------------------------
        catch(SQLException ex)
        {
          System.out.println("Error en SQL" + ex.toString());
        }//fin catch
        //-------------------------------
        return estado;
    }
           
    
    public List<String> Listar(String tabla,String argumentos) throws SQLException{
        
        List<String> lista = new ArrayList<>();
        try
        {
        Statement st=con.createStatement();
         ResultSet rs= null;     
         String Consulta="select "+tabla+".Nombre from "+argumentos;
         rs = st.executeQuery(Consulta);
        while (rs.next())
        {
            lista.add(rs.getString("Nombre"));
        }
        return lista;
        }
        catch(SQLException E)
        {
            return lista;
        }
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
    
