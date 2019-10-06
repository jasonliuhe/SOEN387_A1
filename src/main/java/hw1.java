/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author liuhe
 */
public class hw1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Task1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Task1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String format = new String(request.getParameter("format").getBytes("ISO8859-1"),"UTF-8");
        String param1 = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String param2 = new String(request.getParameter("email").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(format);PrintWriter out = response.getWriter();
        Enumeration names = request.getHeaderNames();
        
        String docType = "<!DOCTYPE html> \n";
        
        
        if(format.equals("text")) {
            out.println("Request Method: GET\nRequest Headers:");
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("\t" + name + ": " + value);
                  }
                }
            }
            out.println("Query String:\n\tformat: " + format + "\n\tname: " + param1 + "\n\temail: "+ param2);
        } else if(format.equals("xml"))  {
            out.println("<response>");
            out.println("\t<Request Method>GET</Request Method>");
            out.println("\t<Request Headers>");
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("\t\t<header name=\"" + name + "\">" + value + "</header>");
                  }
                }
            }
            out.println("\t</Request Headers>");
            
            out.println("<query String>\n\t<format>" + format + "</format>" + "\n\t<name>" + param1 + "</name>" + "\n\t<email>" + param2 + "</email>\n" + "</query String>");
            out.println("</response>");
        } else {
            out.print(docType +
            "<html>\n" + 
            "<head>\n" +
                "<style>\n" +
                    "table, th, td {\n" +
                        "  border: 1px solid black;\n" +
                        "  border-collapse: collapse;\n" +
                        "}\n" +
                    "th, td {\n" +
                        "  padding: 5px;\n" +
                        "  text-align: left;    \n" +
                        "}\n" +
                "</style>" +
            "</head>" + 
            "<body>\n" +
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td>Request Method: </td>" + 
                            "<td>GET</td>" + 
                        "</tr>" + 
                    "</table><br>" +
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td colspan = \"2\">Request Headers: </td>");
            
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("<tr><td>" + name + ": " + "</td> <td>" + value + "</td></tr>");
                  }
                }
            }                 
                    
            out.print("</tr>" + 
                    "</table><br>" + 
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td colspan = \"2\">Query String: </td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>format: </td>" + 
                            "<td>text </td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>name: </td>" + 
                            "<td>"+param1+"</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>email: </td>" + 
                            "<td>"+param2+"</td>" +
                        "</tr>" + 
            "</body></html>");  
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String format = new String(request.getParameter("format").getBytes("ISO8859-1"),"UTF-8");
        String param1 = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String param2 = new String(request.getParameter("email").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(format);PrintWriter out = response.getWriter();
        Enumeration names = request.getHeaderNames();
        
        String docType = "<!DOCTYPE html> \n";
        
        
        if(format.equals("text")) {
            out.println("Request Method: GET\nRequest Headers:");
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("\t" + name + ": " + value);
                  }
                }
            }
            out.println("Query String:\n\tformat: " + format + "\n\tname: " + param1 + "\n\temail: "+ param2);
        } else if(format.equals("xml"))  {
            out.println("<response>");
            out.println("\t<Request Method>GET</Request Method>");
            out.println("\t<Request Headers>");
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("\t\t<header name=\"" + name + "\">" + value + "</header>");
                  }
                }
            }
            out.println("\t</Request Headers>");
            
            out.println("<query String>\n\t<format>" + format + "</format>" + "\n\t<name>" + param1 + "</name>" + "\n\t<email>" + param2 + "</email>\n" + "</query String>");
            out.println("</response>");
        } else {
            out.print(docType +
            "<html>\n" + 
            "<head>\n" +
                "<style>\n" +
                    "table, th, td {\n" +
                        "  border: 1px solid black;\n" +
                        "  border-collapse: collapse;\n" +
                        "}\n" +
                    "th, td {\n" +
                        "  padding: 5px;\n" +
                        "  text-align: left;    \n" +
                        "}\n" +
                "</style>" +
            "</head>" + 
            "<body>\n" +
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td>Request Method: </td>" + 
                            "<td>GET</td>" + 
                        "</tr>" + 
                    "</table><br>" +
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td colspan = \"2\">Request Headers: </td>");
            
            while(names.hasMoreElements()){
                String name = (String) names.nextElement();
                Enumeration values = request.getHeaders(name); // support multiple values
                if (values != null) {
                  while (values.hasMoreElements()) {
                    String value = (String) values.nextElement();
                    out.println("<tr><td>" + name + ": " + "</td> <td>" + value + "</td></tr>");
                  }
                }
            }                 
                    
            out.print("</tr>" + 
                    "</table><br>" + 
                    "<table border=\"2\" bordercolor=\"black\" width=\"800\" cellspacing=\"0\" cellpadding=\"5\">" + 
                        "<tr>" + 
                            "<td colspan = \"2\">Query String: </td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>format: </td>" + 
                            "<td>text </td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>name: </td>" + 
                            "<td>"+param1+"</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td>email: </td>" + 
                            "<td>"+param2+"</td>" +
                        "</tr>" + 
            "</body></html>");  
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
