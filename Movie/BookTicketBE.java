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
public class BookTicketBE extends HttpServlet {

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
            out.println("<title>Servlet BookTicketBE</title>");
            out.println("</head>");
            out.println("<body>");

            String email = request.getParameter("email");
            String pwd = request.getParameter("password");

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

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");

//            out.println("<form method=post action='RecieptBE'>");
//            out.println("Theatre Name:<input type=text name=pid value=" + tname + " readonly><br>");
//            out.println("Movie Name:<input type=text name=pname value=" + mname + "readonly><br>");
//            out.println("Screen:<input type=text name=age value=" + age + "readonly><br>");
//            out.println("show:<input type=text name=mno value=" + mno + "readonly><br>");
//            out.println("showtime:<input type=text name=disease value=" + disease + "readonly><br>");
//            out.println("showname:<input type=text name=ward value=" + ward + "readonly><br>");
//            out.println("city:<input type=text name=refmno value=" + refmno + "readonly><br>");
//            out.println("Address:<input type=text name=refmno value=" + refmno + "readonly><br>");
//            out.println("<input type='submit' value='Update'>");
            
            out.println("<form method='post' action='RecieptBE?tname=" + tname
                    + "&moviename=" + mname
                    + "&screen=" + screen
                    + "&show=" + show
                    + "&showtime=" + showtime
                    + "&showname=" + showname
                    + "&startdate=" + startdate
                    + "&enddate=" + enddate
                    + "&city=" + city
                    + "&Address=" + address
                    + "&seats=" + seats
                    + "&cost=" + cost
                    + "'>");
            //out.println("<h1>Login</h1>");
            out.println("<link rel='stylesheet' href='Styles.css'>");
            out.println("Enter Your Name:<input type='text' name='uname' required><br><br>");
            out.println("Mobile:<input type='tel' name='mobile' required><br><br>");
            out.println("No. of Tickets:<input type='number' name='tickets' required><br><br>");
            out.println("Date:<input type='date' name='date' required><br><br>");
            
            out.println("<input type='submit' value='Confirm'>");

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
            Logger.getLogger(BookTicketBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookTicketBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BookTicketBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookTicketBE.class.getName()).log(Level.SEVERE, null, ex);
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
