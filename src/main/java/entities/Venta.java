package entities;

import java.sql.Date;
import java.sql.Time;

public class Venta {
	private int id_venta;
	private int id_usuario;
	private int cod_postal;
	private int id_flete;
	private Date fechaVenta;
	private Time horaVenta;
	
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getCod_postal() {
		return cod_postal;
	}
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	public int getId_flete() {
		return id_flete;
	}
	public void setId_flete(int id_flete) {
		this.id_flete = id_flete;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Time getHoraVenta() {
		return horaVenta;
	}
	public void setHoraVenta(Time horaVenta) {
		this.horaVenta = horaVenta;
	}
	
	
	
}
