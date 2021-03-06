/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

import loginapp.controller.UserLoginController;
import loginapp.business.UserLoginSession;

/**
 *
 * @author selva
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

  @Inject UserLoginSession userLoginSession;

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
      out.println("<title>Servlet ProfileServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
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
    getServletContext()
      .getRequestDispatcher("/WEB-INF/profile.jsp")
      .forward(request, response);
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
    String action = request.getParameter("action");

    if (action.equals("update_password")) {
      UserLoginController.updatePassword(
            userLoginSession,
            request.getParameter("oldPassword"),
            request.getParameter("newPassword"),
            request.getParameter("confirmPassword"));
      getServletContext()
        .getRequestDispatcher("/WEB-INF/profile.jsp")
        .forward(request, response);
    }
    else if (action.equals("logout")) {
      UserLoginController.logout(userLoginSession);
      response.sendRedirect("");
    }
    else if (action.equals("delete_account")) {
      if (UserLoginController.deleteUser(userLoginSession)) {
        response.sendRedirect("");
      }
      else {
        getServletContext()
          .getRequestDispatcher("/WEB-INF/profile.jsp")
          .forward(request, response);
      }
    }
    else {
      getServletContext()
        .getRequestDispatcher("/WEB-INF/profile.jsp")
        .forward(request, response);
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
