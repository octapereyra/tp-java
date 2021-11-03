package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.TipoUsuario;
import entities.Usuario;
import logic.LogicUsuario;

/**
 * Servlet implementation class Register
 */
@WebServlet({ "/Register", "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		TipoUsuario tu = new TipoUsuario();
		LogicUsuario lu = new LogicUsuario();
		
		user.setNombre(request.getParameter("name"));
		user.setApellido(request.getParameter("surname"));
		user.setNombreUsuario(request.getParameter("username"));
		user.setEmail(request.getParameter("mail"));
		user.setClave(request.getParameter("password"));
		tu.setId_TipoUsuario(2);
		user.setTipoUsuario(tu);
		
		//validar que no exista el mismo username
		
		
		lu.add(user);
		response.sendRedirect("index.jsp");
	}

}
