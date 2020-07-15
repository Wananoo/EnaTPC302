<%-- 
    Document   : CerradoErr
    Created on : Jul 15, 2020, 1:22:21 AM
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
        <title>Error</title>
    </head>
    <body>
        <div class="content">
        <h1>Error al Cerrar Requerimiento ID= <%=request.getParameter("ID")%></h1>
        <div>
            <p><a href="Menu.jsp"> <button>Volver al Menu</button></a>
        </div>
        <div>
            <p><a href="CerrarR.jsp"> <button>Reintentar Cerrar requerimiento</button></a>
        </div>
        <div>
            <p><a href="IngresarR.jsp"> <button>Ingresar requerimiento</button></a>
        </div>
        <div>
            <p><a href="ConsultarR.jsp"> <button>Consultar Requerimiento</button></a>
        </div>
        </div>
    </body>
</html>