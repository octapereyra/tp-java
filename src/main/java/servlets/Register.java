package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		tu.setId_TipoUsuario(2); //se registra como usuario normal
		user.setTipoUsuario(tu);
		
		//validar que no exista el mismo username
		if(checkUsername(user)) {
			//ya existe
			request.setAttribute("msg", "Nombre de usuario ya existente. Por favor elija uno distinto");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			//valido
			lu.add(user);
			//sendMail(user.getEmail());
			response.sendRedirect("index.jsp");
		}
	}
	
	private boolean checkUsername(Usuario us) {
		LogicUsuario lu = new LogicUsuario();
		LinkedList<Usuario> users = lu.getAll();
		Boolean check = false;
		
		for(Usuario u : users) {
			if(u.getNombreUsuario().equals(us.getNombreUsuario())) {
				check = true;
			}
		}
		return check;
	}

	
	private void sendMail(String to) {

        // Sender's email ID needs to be mentioned
        String from = "toaddress@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        
     // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
     // Get the Session object.// and pass username and password
     Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
    	 protected PasswordAuthentication getPasswordAuthenticator() {
    		 return new PasswordAuthentication("maildesalida@mail.com", "*******");
    	 }
     });
     
  // Used to debug SMTP issues
     session.setDebug(true);
     
     try {
  // Create a default MimeMessage object.
     MimeMessage message = new MimeMessage(session);

     // Set From: header field of the header.
     message.setFrom(new InternetAddress(from));

     // Set To: header field of the header.
     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

     // Set Subject: header field
     message.setSubject("Bienvenido!!");

     // Now set the actual message
     message.setText("Te has registrado en nuestro sistema.");

     // Send message
     Transport.send(message);
     
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
				
	}
}
