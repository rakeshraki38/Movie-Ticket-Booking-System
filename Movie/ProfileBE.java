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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ProfileBE extends HttpServlet {

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
            out.println("<title>Servlet ProfileBE</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet ProfileBE at " + request.getContextPath() + "</h1>");
           String name = request.getParameter("name");
            String mobile = request.getParameter("mobile");
            
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");

            String sql = "select * from confirmticket where name='" + name + "' and mobile='" + mobile + "'";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            
            out.println("<table  border=\"10px\" bordercolor=\"orange\" align=\"center\" cellspacing=\"7px\" padding=\"15px\">");
            
            out.println("<tr><th>Name</th>"
                    + "<th>mobile</th>"
                    + "<th>Theatre Name</th>"
                    + "<th>Movie Name</th>"
                    + "<th>Screen</th>"
                   
                    + "<th>Show</th>"
                    + "<th>Showtime</th>"
                    + "<th>Show Name</th>"
                    
                    + "<th>Movie Date</th>"
                    + "<th>City</th>"
                    + "<th>address</th>"
                    + "<th>No. of Tickets</th>"
                    + "<th>Ticket Price</th>"
                    + "<th>Booked Date</th>"
                    
                    + "</tr>"
            );
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("<td>" + rs.getString(6) + "</td>");
                out.println("<td>" + rs.getString(7) + "</td>");
                out.println("<td>" + rs.getString(8) + "</td>");
                out.println("<td>" + rs.getString(9) + "</td>");
                out.println("<td>" + rs.getString(10) + "</td>");
                out.println("<td>" + rs.getString(11) + "</td>");
                out.println("<td>" + rs.getString(12) + "</td>");
                out.println("<td>" + rs.getString(13) + "</td>");
                out.println("<td>" + rs.getString(14) + "</td>");
            }

            out.println("<footer><button><a href=\"MovieDashBoard.html\">Logout</a></button></footer>");
            
           
           out.println("</table>");
           
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
            Logger.getLogger(ProfileBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProfileBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBE.class.getName()).log(Level.SEVERE, null, ex);
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
