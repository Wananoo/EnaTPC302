package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public boolean Cerrar(String ID) throws SQLException{
        boolean estado = false;
        PreparedStatement pst = null;
        try
         {
            String Consulta="DELETE FROM requerimientos WHERE ID = ?";
            pst = getconexion().prepareStatement(Consulta);
            pst.setString(1, ID);
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
        
        return estado;
    }
    
    
    public String NombreaID(String M, String Tabla) throws SQLException
    {
        String Consulta = "";
        Statement st=con.createStatement();
        ResultSet rs= null;
        M = "\""+M+"\"";
        Consulta="select ID from "+Tabla+" where "+Tabla+".Nombre = "+M+"order by ID desc limit 1";
        rs = st.executeQuery(Consulta);
        while(rs.next()){
                 M = rs.getString("ID");
         }
        return M;
    }
    
    public String IDaNombre(String M, String Tabla) throws SQLException
    {
        String Consulta = "";
        Statement st=con.createStatement();
        ResultSet rs= null;
        M = "\""+M+"\"";
        Consulta="select Nombre from "+Tabla+" where "+Tabla+".ID = "+M+"order by Nombre desc limit 1";
        rs = st.executeQuery(Consulta);
        while(rs.next()){
                 M = rs.getString("Nombre");
         }
        return M;
    }
    
    public List<ArrayList<String>> Buscar(String Gerencia, String Departamento, String Asignado) throws SQLException
    {
        String Nulo = null;
        String Consulta = "";
        List<ArrayList<String>>  Resultados = new ArrayList<ArrayList<String>>();
        Statement st=con.createStatement();
        ResultSet rs= null;
        boolean noge = false,node = false,noe = false;
        if (Gerencia==null || Gerencia.equals("Todas"))
                {
                    Gerencia = "";
                    noge=true;
                }
        else
        {
            Gerencia = " where Gerencia = \""+NombreaID(Gerencia,"Gerencias")+"\"";
        }if (Departamento==null|| Departamento.equals("Todos"))
                {
                    Departamento = "";
                }
        else
        {
            if (noge)
            {Departamento = "";node=true;}
            else
            {
                Departamento = " and Departamento = \""+NombreaID(Departamento,"Departamentos")+"\"";
            }
        }
        if (Asignado==null|| Asignado.equals("Todos"))
                {
                    Asignado = "";
                }
        else
        {
            if (node)
            Asignado = "";
            else
            {
                Asignado = " and Asignado = \""+NombreaID(Asignado,"Empleados")+"\"";
            }
        }
        Consulta="select * from requerimientos "+Gerencia+Departamento+Asignado;
        rs = st.executeQuery(Consulta);
        ArrayList<String> ResultadoTest = new ArrayList<String>();

        while(rs.next()){
            ArrayList<String> Resultado = new ArrayList<String>();
            Resultado.add(rs.getString("ID")) ;
            Resultado.add(rs.getString("Gerencia")) ;
            Resultado.add(rs.getString("Departamento")) ;
            Resultado.add(rs.getString("Asignado")) ;
            Resultado.add(rs.getString("Detalle")) ;
            Resultados.add(Resultado);
         }
        return Resultados;
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
        Gerencia = NombreaID(Gerencia,"Gerencias");
        Departamento = NombreaID(Departamento,"Departamentos");
        Asignado = NombreaID(Asignado,"Empleados");
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
    
