<%-- 
    Document   : ConsultarR
    Created on : Jul 14, 2020, 9:21:11 PM
    Author     : wanan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Consultas"%>
<%@page import="java.util.List"%>
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
            table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
        </style>
        <title>Consultar Requerimiento</title>
    </head>
    <body>
        <jsp:useBean id= "ConsultaJSP" scope= "page" class= "Modelo.Consultas" type= "Modelo.Consultas">
        <div class="content">
        <h1>Consultar Requerimiento </h1>
        <form action="#" name="form1">
        Gerencia:&nbsp;
        <% 
            Consultas cons = new Consultas();
            List<String> GerenciasDrop = cons.Listar("Gerencias","Gerencias  "); 
        %>
        <select id = "GerenciaDrop" name="GerenciaDrop" onchange="submit();">>
            <option selected>Todas</option>
            <%for (int i = 0; i<GerenciasDrop.size();i++){
            if (GerenciasDrop.get(i).equals(request.getParameter("GerenciaDrop")))
            {
                %><option selected><%=GerenciasDrop.get(i)%></option><%
            }
            else
            {
                %><option><%=GerenciasDrop.get(i)%></option><%
            }
            
            }%>
        </select>
         <br>
        Departamento:&nbsp;
        <% 
            String Gerencia = request.getParameter("GerenciaDrop");
            Gerencia = "\""+Gerencia+"\"";
            List<String> Departamentos = cons.Listar("Departamentos","Departamentos inner join Gerencias on Gerencias.ID=Departamentos.Gerencia where Gerencias.Nombre="+Gerencia);
        %>
        <select name="DepartamentosDrop" onchange="submit();">
            <option selected>Todos</option>
            <%for (int j = 0; j<Departamentos.size();j++){
            if (Departamentos.get(j).equals(request.getParameter("DepartamentosDrop")))
            {
                %><option selected><%=Departamentos.get(j)%></option><%
            }
            else
            {
                %><option><%=Departamentos.get(j)%></option><%
            }
            
            }%>
        </select>
         <br>
        Encargado:
        <% 
            String Departamento = request.getParameter("DepartamentosDrop");
            Departamento = "\""+Departamento+"\"";
            List<String> Encargado = cons.Listar("Empleados","Empleados inner join Departamentos on Departamentos.ID=Empleados.Departamento where Departamentos.Nombre="+Departamento);
        %>
        <select name="EncargadoDrop">
            <option selected>Todos</option>
            <%for (int i = 0; i<Encargado.size();i++){
            if (Encargado.get(i).equals(request.getParameter("EncargadoDrop")))
            {
                %><option selected><%=Encargado.get(i)%></option><%
            }
            else
            {
                %><option><%=Encargado.get(i)%></option><%
            }
            
            }%>
        </select>
         <br><br>
        <input type="submit" value="Buscar" />
        </form>
        <table style="margin-left:auto;margin-right:auto;">
            <tr>
                <th>ID</th>
                <th>Gerencia</th>
                <th>Departamento</th>
                <th>Encargado</th>
                <th>Detalle</th>
            </tr>
        <%
            List<ArrayList<String>> Buscar = cons.Buscar(request.getParameter("GerenciaDrop"),
                    request.getParameter("DepartamentosDrop"),request.getParameter("EncargadoDrop"));
            for (int i=0; i<Buscar.size();i++)
            {
        %>
                <tr>
                    <td><%=Buscar.get(i).get(0)%></td>
                    <td><%=cons.IDaNombre(Buscar.get(i).get(1),"Gerencias") %></td>
                    <td><%=cons.IDaNombre(Buscar.get(i).get(2),"Departamentos") %></td>
                    <td><%=cons.IDaNombre(Buscar.get(i).get(3),"Empleados") %></td>
                    <td><%=Buscar.get(i).get(4)%></td>
                </tr>
            <%}
        %>
        </table>
        <p><p><p><a href="Menu.jsp"> <button>Volver al Menu</button></a>
        </div>
        </jsp:useBean>
    </body>
</html>

