/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rakeshgowda
 */
public class User extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TBookingBE</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet TBookingBE at " + request.getContextPath() + "</h1>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");
            String sql = "select * from addmovie";
   
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
           
            // out.println("<form method = 'post' action='ConfirmTicket'>");
            out.println("<table  border=\"10px\" bordercolor=\"orange\" align=\"center\" cellspacing=\"7px\" padding=\"15px\">");
            
            out.println("<tr><th>Theatre Name</th>"
                    + "<th>Movie Name</th><th>Screen </th>"
                    + "<th>Shows</th><th>Start Date</th><th>End Date</th>"
                   + "<th>City</th>"       
                    + "</tr>");
           
                while (rs.next()) {
                    out.println("<tr>");
                  //out.println("<td>" + rs.getLong(2) + "</td>");
                    out.println("<td>" + rs.getString(3) + "</td>");
                  //out.println("<td>" + rs.getString(1) + "</td>");
                    out.println("<td>" + rs.getString(6) + "</td>");
                    out.println("<td>" + rs.getString(4) + "</td>");
                    out.println("<td>" + rs.getString(5) + "</td>");
                    out.println("<td>" + rs.getString(8) + "</td>");
                    out.println("<td>" + rs.getString(9) + "</td>");
                    
                    
                    String sql1="select entercity from addtheatre where theatre_id='"+rs.getLong(2)+"'";
                    PreparedStatement ps1=con.prepareStatement(sql1);
                    ResultSet rs1 = ps1.executeQuery();
                    
                    while(rs1.next()){
                       out.println("<td>" + rs1.getString(1) + "</td>"); 
                    }
                    
                    out.println("</tr>");
                }
                //out.println("<td><button><a href='MovieDashBoard.html' align='center'>Log Out</a></button></td>");
                out.println("<tfoot> <th colspan='7'><button><a href='MovieDashBoard.html'>Log Out</a></button> </th> </tfoot>");
                //<tfoot><th colspan="5">2023</th></tfoot>
                out.println("</table>");
                out.println("<br>");
            
         
            con.close();
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
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
