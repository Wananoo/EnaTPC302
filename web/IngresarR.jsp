<%-- 
    Document   : IngresarR
    Created on : Jul 11, 2020, 12:51:28 AM
    Author     : wanan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
              background: lightgray;
            }
            .content {
              max-width: 500px;
              margin: auto;
              text-align: center;
              background: white;
              padding: 10px;
            }
            div {
                margin-bottom: 20px;
            }
        </style>
        <title>Ingresar Requerimiento</title>
    </head>
    <body onload="GerenciaDrop.freeze()">
        <jsp:useBean id= "ConsultaJSP" scope= "page" class= "Modelo.Consultas" type= "Modelo.Consultas">
        <div class="content">
        <h1>Ingresar Requerimiento </h1>
        <form action="#" name="form1">
        Gerencia:&nbsp;
        <% 
            Consultas cons = new Consultas();
            List<String> Drop = cons.Listar("Gerencias","Gerencias  "); 
        %>
        <select id = "GerenciaDrop" name="GerenciaDrop" onchange="submit();">>
            <%for (int i = 0; i<Drop.size();i++){%>
            <option><%=Drop.get(i)%></option>
            <%}%>
        </select>
         <br>
        Departamento:&nbsp;
        <% 
            String Gerencia = request.getParameter("GerenciaDrop");
            Gerencia = "\""+Gerencia+"\"";
            List<String> Departamentos = cons.Listar("Departamentos","Departamentos inner join Gerencias on Gerencias.ID=Departamentos.Gerencia where Gerencias.Nombre="+Gerencia);
        %>
        <select name="DepartamentosDrop" onselect="GerenciaDrop.freeze();" onchange="submit();">
            <%for (int i = 0; i<Departamentos.size();i++){%>
            <option><%=Departamentos.get(i)%></option>
            <%}%>
        </select>
         <br>
        Encargado:
        <% 
            String Departamento = request.getParameter("DepartamentosDrop");
            Departamento = "\""+Departamento+"\"";
            List<String> Encargado = cons.Listar("Empleados","Empleados inner join Departamentos on Departamentos.ID=Empleados.Departamento where Departamentos.Nombre="+Departamento);
        %>
        <select name="EncargadoDrop" onselect="DepartamentosDrop.freeze();">
            <%for (int i = 0; i<Encargado.size();i++){%>
            <option><%=Encargado.get(i)%></option>
            <%}%>
        </select>
         <br>
         Requerimiento:
         <br>
         <textarea  id="req" name="req" rows="4" cols="50"></textarea>
         <br><br>
        <input type="submit" formaction="Subir" value="Guardar" />
        </form>
        
        </div>
        </jsp:useBean>
    </body>
</html>
