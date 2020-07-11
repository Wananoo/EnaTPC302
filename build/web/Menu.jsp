<%-- 
    Document   : Menu
    Created on : Jul 11, 2020, 12:37:28 AM
    Author     : wanan
--%>

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
        <title>Menu</title>
    </head>
    <body>
        <div class="content">
        <h1>Menu Principal</h1>
        <div>
            <p><a href="IngresarR.jsp"> <button>Ingresar Requerimiento</button></a>
        </div>
        <div>
            <p><a href="ConsultarR.jsp"> <button>Consultar Requerimientos</button></a>
        </div>
        <div>
            <p><a href="CerrarR.jsp"> <button>Cerrar Requerimiento</button></a>
        </div>
        </div>
    </body>
</html>
