package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Producto;
import logic.LogicCategoria;
import logic.LogicProducto;

/**
 * Servlet implementation class ABMCcategoria
 */
@WebServlet("/ABMCcategoria")
public class ABMCcategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMCcategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion;
		RequestDispatcher distpacher = null;
		
		accion = request.getParameter("accion");

		if("nuevo".equals(accion)) {

			distpacher = request.getRequestDispatcher("nuevaCategoria.jsp");

			
	} else if ("insert".equals(accion)) {
		LogicCategoria lc = new LogicCategoria();
		Categoria cat= new Categoria();
		
		cat.setDenominacion(request.getParameter("denominacion"));
		lc.add(cat);
		distpacher = request.getRequestDispatcher("listProducts.jsp");
		
	}
		
		distpacher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
