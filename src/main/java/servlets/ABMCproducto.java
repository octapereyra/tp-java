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

/*
	Servlet implementation class ABMCproducto
 */
@WebServlet("/ABMCproducto")
public class ABMCproducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ABMCproducto() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogicProducto lp = new LogicProducto();
		LogicCategoria lc = new LogicCategoria();
		String accion;
		LinkedList<Producto> listaProductos;
		RequestDispatcher distpacher = null;
		
		accion = request.getParameter("accion");

		if(accion == null || accion.isEmpty()) {
			
			distpacher = request.getRequestDispatcher("listProducts.jsp");
			listaProductos = lp.getAll();
			request.setAttribute("lista", listaProductos);
			
		}else if("nuevo".equals(accion)) {
			
			distpacher = request.getRequestDispatcher("nuevoProducto.jsp");
			
		}else if("insert".equals(accion)) {
			Producto pr = new Producto();
			Categoria cat;
			
			pr.setDescripcion(request.getParameter("descripcion"));
			pr.setPrecio(Double.parseDouble(request.getParameter("precio"))); 
			pr.setStock(Integer.parseInt(request.getParameter("stock")));
			cat = lc.getByDenominacion(request.getParameter("tipoProducto"));
			pr.setCategoria(cat);
			lp.add(pr);
			
			
			listaProductos = lp.getAll();
			request.setAttribute("lista", listaProductos);
			distpacher = request.getRequestDispatcher("listProducts.jsp");
		}else if("modificar".equals(accion)) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			Producto prod = lp.getOne(id);
			request.setAttribute("producto", prod);
			distpacher = request.getRequestDispatcher("modificarProducto.jsp");
			
		}else if("update".equals(accion)) {
			Producto pr = new Producto();
			Categoria cat;
			
			pr.setId(Integer.parseInt(request.getParameter("id")));;
			pr.setDescripcion(request.getParameter("descripcion"));
			pr.setPrecio(Double.parseDouble(request.getParameter("precio")));
			pr.setStock(Integer.parseInt(request.getParameter("stock")));
			cat = lc.getByDenominacion(request.getParameter("tipoProducto"));
			pr.setCategoria(cat);
			lp.update(pr);
			
			
			listaProductos = lp.getAll();
			request.setAttribute("lista", listaProductos);
			distpacher = request.getRequestDispatcher("listProducts.jsp");
		}else if("eliminar".equals(accion)) {
			Producto pr = new Producto();
			
			pr.setId(Integer.parseInt(request.getParameter("id")));
			
			lp.delete(pr);	
			
			listaProductos = lp.getAll();
			request.setAttribute("lista", listaProductos);
			distpacher = request.getRequestDispatcher("listProducts.jsp");
		}
		
		distpacher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
