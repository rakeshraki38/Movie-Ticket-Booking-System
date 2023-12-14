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
public class AddMovieBE extends HttpServlet {

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
            out.println("<title>Servlet AddMovieBE</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AddMovieBE at " + request.getContextPath() + "</h1>");
            int theaterId = Integer.parseInt(request.getParameter("theaterId"));
            String theaterName = request.getParameter("theaterName");
            int screen = Integer.parseInt(request.getParameter("screen"));
            int shows = Integer.parseInt(request.getParameter("shows"));
            String movieName = request.getParameter("moviename");
//            String imageUrl = request.getParameter("image");
            String startDate = request.getParameter("startdate");
            String endDate = request.getParameter("enddate");

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");

            // Create SQL query
            String sql = "INSERT INTO addmovie (theatre_id, theatrename, screen, shows, moviename,  startdate, enddate) VALUES (?,  ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, theaterId);
            ps.setString(2, theaterName);
            ps.setInt(3, screen);
            ps.setInt(4, shows);
            ps.setString(5, movieName);
//            ps.setString(6, imageUrl);
            ps.setString(6, startDate);
            ps.setString(7, endDate);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<script>alert('Movie Added successful!')</script>");
                request.getRequestDispatcher("ManagerDashBoard.html").include(request, response);
            } else {
                out.println("<script>alert('Failed! Please Tryagain')</script>");
                request.getRequestDispatcher("ManagerDashBoard.html").include(request, response);
            }

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
            Logger.getLogger(AddMovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMovieBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddMovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddMovieBE.class.getName()).log(Level.SEVERE, null, ex);
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
