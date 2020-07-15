<%-- 
    Document   : IngresadoCor
    Created on : Jul 11, 2020, 4:11:28 PM
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
        <title>Ingresado Correctamente</title>
    </head>
    <body>
        <div class="content">
        <h1>Ingresado Correctamente!</h1>
        <div>
            <p><a href="Menu.jsp"> <button>Volver al Menu</button></a>
        </div>
        <div>
            <p><a href="IngresarR.jsp"> <button>Ingresar otro requerimiento</button></a>
        </div>
        <div>
            <p><a href="ConsultarR.jsp"> <button>Consultar Requerimiento</button></a>
        </div>
        <div>
            <p><a href="CerrarR.jsp"> <button>Cerrar requerimiento</button></a>
        </div>
        </div>
    </body>
</html>
