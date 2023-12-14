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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class RecieptBE extends HttpServlet {

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
            out.println("<title>Servlet RecieptBE</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>alert('Thank you For Booking!');</script>");
            // out.println("<h1>Servlet RecieptBE at " + request.getContextPath() + "</h1>");
            String availseats = null;
            double price;
            String email = request.getParameter("email");
            String pwd = request.getParameter("password");

            String tname = request.getParameter("tname");
            String mname = request.getParameter("moviename");
            String show= request.getParameter("show");
            int screen = Integer.parseInt(request.getParameter("screen"));
            String showtime = request.getParameter("showtime");

            String showname = request.getParameter("showname");
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");

            String city = request.getParameter("city");
            String address = request.getParameter("Address");
            int seats = Integer.parseInt(request.getParameter("seats"));
            double cost = Double.parseDouble(request.getParameter("cost"));

            String name = request.getParameter("uname");
            String mobile = request.getParameter("mobile");
            int ticket = Integer.parseInt(request.getParameter("tickets"));
            String date = request.getParameter("date");

            price = cost * ticket;

            // Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();
            // Create a DateTimeFormatter object to format the date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String formattedDateTime = currentDateTime.format(formatter);
            String datetime = formattedDateTime;


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");

            if (seats >= ticket) {
                int tkt = seats - ticket;
                availseats = String.valueOf(tkt);

                String sql = "UPDATE screenseats SET availseats=? where theatrename=? and screen=?";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, availseats);
                ps.setString(2, tname);
                ps.setInt(3, screen);

                int i = ps.executeUpdate();
            } else {
                out.println("<script>alert('Booking Failed!')</script>");
           
//                request.getRequestDispatcher("RecieptBE").include(request, response);
            }
            
            String sql1="INSERT INTO confirmticket VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps=con.prepareStatement(sql1);
           ps.setString(1,name);
           ps.setString(2, mobile);
           ps.setString(3, tname);
           ps.setString(4,mname);
           ps.setString(5, String.valueOf(screen));
           ps.setString(6,show);
           
           ps.setString(7,showtime);
           ps.setString(8, showname);
           ps.setString(9, date);
           ps.setString(10,city);
           ps.setString(11, address);
           
           ps.setString(12,String.valueOf(ticket));
           ps.setString(13,String.valueOf(price));
           ps.setString(14,datetime);
                     
          ps.execute();
            
            out.println("<form method=post >");
            out.println("<link rel='stylesheet' href='style1.css'>");
            out.println("<h3>Booking Details</h3>");
            out.println("Name:<input type=text name=uname value=" + name + " readonly><br>");
            out.println("Mobile:<input type=tel name=mobile value=" + mobile + " readonly><br>");
//            out.println("Email:<input type=email name=email value=" +email + " readonly><br>");
            out.println("Theatre Name:<input type=text name=tname value=" + tname + " readonly><br>");
            out.println("Movie Name:<input type=text name=mname value=" + mname + " readonly><br>");
            
            out.println("screen:<input type=text name=screen value=" + screen + " readonly><br>");
            out.println("Show:<input type=text name=show value=" + show + " readonly><br>");
            out.println("Show Time:<input type=text name=showtime value=" + showtime + " readonly><br>");
            
            out.println("Show Name:<input type=text name=showname value=" + showname + " readonly><br>");
            out.println("Movie Date:<input type=text name=mdate value=" + date + " readonly><br>");
            out.println("City:<input type=text name=city value=" + city + " readonly><br>");
            out.println("Address:<input type=text name=address value=" +address + " readonly><br>");
            out.println("No. of Tickets Booked:<input type=text name=tickets value=" + ticket + " readonly><br>");
            out.println("Ticket price:<input type=text name=price value=" + price + " readonly><br>");
                        
            out.println("Booked Date:<input type=text name=refmno value=" + datetime + "readonly><br><br>");
            out.println("<button name='Print' onclick='window.print()'>Print </button> ");
            out.println("<a href='MovieDashBoard.html'>Logout</a> ");
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
            Logger.getLogger(RecieptBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecieptBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecieptBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecieptBE.class.getName()).log(Level.SEVERE, null, ex);
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
