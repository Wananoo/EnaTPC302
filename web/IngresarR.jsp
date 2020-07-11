<%-- 
    Document   : IngresarR
    Created on : Jul 11, 2020, 12:51:28 AM
    Author     : wanan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <body>
        <div class="content">
        <h1>Ingresar Requerimiento </h1>
        <form action="Subir" method="post" onload="Combo">
        Gerencia <%= request.getParameter("test") %>:&nbsp;
        <% List<String> list = (List<String>)request.getAttribute("listaGerencia");%>
        <select name="Gerencia">
            <c:forEach items="${listaGerencia}" var="itemgerencia">
                <option>${itemgerencia}</option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Guardar" />
        </form>
        </div>
    </body>
</html>
