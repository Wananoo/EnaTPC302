package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Consultas;

public final class IngresarR_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("              background: lightgray;\n");
      out.write("            }\n");
      out.write("            .content {\n");
      out.write("              max-width: 500px;\n");
      out.write("              margin: auto;\n");
      out.write("              text-align: center;\n");
      out.write("              background: white;\n");
      out.write("              padding: 10px;\n");
      out.write("            }\n");
      out.write("            div {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>Ingresar Requerimiento</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"GerenciaDrop.freeze()\">\n");
      out.write("        ");
      Modelo.Consultas ConsultaJSP = null;
      synchronized (_jspx_page_context) {
        ConsultaJSP = (Modelo.Consultas) _jspx_page_context.getAttribute("ConsultaJSP", PageContext.PAGE_SCOPE);
        if (ConsultaJSP == null){
          ConsultaJSP = new Modelo.Consultas();
          _jspx_page_context.setAttribute("ConsultaJSP", ConsultaJSP, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("        <div class=\"content\">\n");
          out.write("        <h1>Ingresar Requerimiento </h1>\n");
          out.write("        <form action=\"#\" name=\"form1\">\n");
          out.write("        Gerencia:&nbsp;\n");
          out.write("        ");
 
            Consultas cons = new Consultas();
            List<String> GerenciasDrop = cons.Listar("Gerencias","Gerencias  "); 
        
          out.write("\n");
          out.write("        <select id = \"GerenciaDrop\" name=\"GerenciaDrop\" onchange=\"submit();\">>\n");
          out.write("            <option>--Seleccione--</option>\n");
          out.write("            ");
for (int i = 0; i<GerenciasDrop.size();i++){
            if (GerenciasDrop.get(i).equals(request.getParameter("GerenciaDrop")))
            {
                
          out.write("<option selected>");
          out.print(GerenciasDrop.get(i));
          out.write("</option>");

            }
            else
            {
                
          out.write("<option>");
          out.print(GerenciasDrop.get(i));
          out.write("</option>");

            }
            
            }
          out.write("\n");
          out.write("        </select>\n");
          out.write("         <br>\n");
          out.write("        Departamento:&nbsp;\n");
          out.write("        ");
 
            String Gerencia = request.getParameter("GerenciaDrop");
            Gerencia = "\""+Gerencia+"\"";
            List<String> Departamentos = cons.Listar("Departamentos","Departamentos inner join Gerencias on Gerencias.ID=Departamentos.Gerencia where Gerencias.Nombre="+Gerencia);
        
          out.write("\n");
          out.write("        <select name=\"DepartamentosDrop\" onchange=\"submit();\">\n");
          out.write("            <option>--Seleccione--</option>\n");
          out.write("            ");
for (int j = 0; j<Departamentos.size();j++){
            if (Departamentos.get(j).equals(request.getParameter("DepartamentosDrop")))
            {
                
          out.write("<option selected>");
          out.print(Departamentos.get(j));
          out.write("</option>");

            }
            else
            {
                
          out.write("<option>");
          out.print(Departamentos.get(j));
          out.write("</option>");

            }
            
            }
          out.write("\n");
          out.write("        </select>\n");
          out.write("         <br>\n");
          out.write("        Encargado:\n");
          out.write("        ");
 
            String Departamento = request.getParameter("DepartamentosDrop");
            Departamento = "\""+Departamento+"\"";
            List<String> Encargado = cons.Listar("Empleados","Empleados inner join Departamentos on Departamentos.ID=Empleados.Departamento where Departamentos.Nombre="+Departamento);
        
          out.write("\n");
          out.write("        <select name=\"EncargadoDrop\">\n");
          out.write("            <option>--Seleccione--</option>\n");
          out.write("            ");
for (int i = 0; i<Encargado.size();i++){
            if (Encargado.get(i).equals(request.getParameter("EncargadoDrop")))
            {
                
          out.write("<option selected>");
          out.print(Encargado.get(i));
          out.write("</option>");

            }
            else
            {
                
          out.write("<option>");
          out.print(Encargado.get(i));
          out.write("</option>");

            }
            
            }
          out.write("\n");
          out.write("        </select>\n");
          out.write("         <br>\n");
          out.write("         Requerimiento:\n");
          out.write("         <br>\n");
          out.write("         <textarea  id=\"req\" name=\"req\" rows=\"4\" cols=\"50\"></textarea>\n");
          out.write("         <br><br>\n");
          out.write("        <input type=\"submit\" formaction=\"Subir\" value=\"Guardar\" />\n");
          out.write("        </form>\n");
          out.write("        \n");
          out.write("        </div>\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
