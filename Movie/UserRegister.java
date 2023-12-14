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
public class UserRegister extends HttpServlet {

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
            out.println("<title>Servlet UserRegister</title>");
            out.println("</head>");
            out.println("<body>");
            String tname = request.getParameter("tname");
            String mname = request.getParameter("moviename");
            String screen = request.getParameter("screen");
            String show = request.getParameter("show");
            String showtime = request.getParameter("showtime");

            String showname = request.getParameter("showname");
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");

            String city = request.getParameter("city");
            String address = request.getParameter("Address");
            String seats = request.getParameter("seats");
            String cost = request.getParameter("cost");

//            out.println(cost);
//            out.println(startdate);
//            out.println(enddate);
//            out.println(screen);
//            out.println(tname);
//
//            out.println(seats);
//            out.println(address);
//            out.println(city);
//            out.println(showname);
//            out.println(showtime);
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");

            out.println("<link rel='stylesheet' href='style.css'>");
            out.println("<form method='post' action='UserBE?tname="+tname
                    + "&moviename=" + mname 
                        + "&screen=" + screen
                        + "&show=" + show
                    + "&showtime=" + showtime
                        + "&showname=" + showname
                    + "&startdate=" +startdate
                       + "&enddate=" + enddate
                        + "&city=" + city
                        + "&Address=" + address
                        + "&seats=" + seats
                        + "&cost=" + cost
                    +"'>");
            out.println("<h1>Login</h1>");
            out.println("Email:<input type='email' name='email' required><br><br>");
            out.println("Password:<input type='password' name='password' required><br><br>");
            out.println("<input type='submit' value='Login'>");
            out.println("<br><br>");
            out.println("<div class='create-account-link'>");
            out.println("Don't have an account?  <a href='UserRegisterFE.html'>Create Account</a>");
            out.println("</div>");
            out.println("</form>");

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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
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

