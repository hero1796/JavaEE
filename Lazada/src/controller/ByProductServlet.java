package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import model.Cart;

/**
 * Servlet implementation class ByProductServlet
 */
@WebServlet("/ByProductServlet/*")
public class ByProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ByProductServlet() {
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
//    response.getWriter().append("Served at: ").append(request.getContextPath());
    //
    int id = Integer.parseInt(request.getParameter("id"));
    try {
      CartDao cDao = new CartDao();
      Cart c = new Cart(id, 1);
      ArrayList<Cart> listCart= cDao.getCart();
      int count=0;
      for(Cart cart: listCart) {
        if(id==cart.getIdProduct()) {
          int number=cart.getNumber()+1;
          cDao.updateCart(cart.getId(), id, number);
          break;
        }else {
          count ++;
        }
      }
      if(count==listCart.size()) {
        int row = cDao.insertCart(c);
      }
      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
      dispatcher.forward(request, response);
      
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
