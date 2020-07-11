<%-- 
    Document   : index
    Created on : Jul 9, 2020, 9:31:28 PM
    Author     : wanan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seleccion</h1>
        <jsp:useBean id="N" scope="application" class= "Modelo.conexion" type= "Modelo.conexion" beanName = "Modelo.conexion" >
        <form action="Combo" method="get">
            
        <p>Selecciona: 
            <select name="nombre">
                <option>Seleccione una opcion</option>
                <option>
                    <% 
                        Statement st=con.createStatement();
        
         ResultSet rs= null;     
         String Consulta="select * from Usuarios";
         rs = st.executeQuery(Consulta); %>
                </option>
            </select>
        </p>
        </form>
        </jsp:useBean>
    </body>
</html>
