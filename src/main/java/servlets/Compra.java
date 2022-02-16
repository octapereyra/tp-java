package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Localidad;
import entities.Usuario;
import entities.Producto;
import entities.Venta;
import logic.LogicLocalidad;
import logic.LogicVenta;
import logic.LogicProducto;

@WebServlet({ "/Compra", "/compra" })
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Compra() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher distpacher = null;
		Producto p;
		LogicProducto lp = new LogicProducto();
		ArrayList<int[]> listaCarrito = (ArrayList<int[]>)request.getSession().getAttribute("listaCarrito");
		

		Venta v = new Venta();
		LogicVenta lv = new LogicVenta();
		Usuario us = (Usuario) request.getSession().getAttribute("user");
		LogicLocalidad logicloc= new LogicLocalidad();
		int cod_postal = Integer.parseInt(request.getParameter("localidad"));
		Localidad loc = logicloc.getOne(cod_postal);
		

	        
		v.setFechaVenta(LocalDate.now());
		v.setHoraVenta(LocalTime.now());
		v.setId_usuario(us.getId_usuario());
		v.setCod_postal(cod_postal);
		v.setId_flete(loc.getZona().getFlete().getId_flete());
		v.setEstado("pendiente");
			
		try{
			lv.confirmarVenta(v, listaCarrito);
				
			listaCarrito.clear();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		distpacher = request.getRequestDispatcher("MisCompras.jsp");

		distpacher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
