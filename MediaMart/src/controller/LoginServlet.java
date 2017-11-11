package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.control.Alert;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
    String user = request.getParameter("user");
    String pass = request.getParameter("password");
    HttpSession session = request.getSession();

    Account myuser = new Account();
    session.setAttribute("MYUSER", myuser);
    if (user.equals("admin") && pass.equals("1234")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
      dispatcher.forward(request, response);
    } else if (user.equals("hung") && pass.equals("1234")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
      dispatcher.forward(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
      dispatcher.forward(request, response);
      String s = "false";
      request.setAttribute("ALERT", s);
    }
  }

}