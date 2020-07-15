<%-- 
    Document   : index
    Created on : Jul 9, 2020, 9:31:28 PM
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
        </style>
        <title>Login</title>
        <div class="content">
        <h1>Autenticacion</h1>
        <%if (request.getParameter("error").equals("1"))
        {%><script type="text/javascript">
    alert("Credenciales incorrectas");
</script> <%}%>
        <form action="Login" method="get">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td>:</td>
                    <td><input type="text" name="user" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><input type="password" name="pass" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Ingresar" /></td>
                </tr>
            </table>
        </form>
        </div>
    </head>
    <body>
        
    </body>
</html>
