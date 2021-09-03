package entities;

public class Usuario {
	
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String nombreUusuario;
	private String email;
	public enum tipoUsuario{
		usuario, administrador, superAdministrador;
	};
	private String clave;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreUusuario() {
		return nombreUusuario;
	}
	public void setNombreUusuario(String nombreUusuario) {
		this.nombreUusuario = nombreUusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	

}
