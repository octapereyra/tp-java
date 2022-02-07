package logic;

import data.DataVenta;
import entities.Producto;
import entities.Venta;

public class LogicVenta {
	
	private DataVenta dv;
	
	public LogicVenta() {
		dv = new DataVenta();
	}
	
	public void confirmarVenta(Venta v, Producto p, int cantidad)  {
		
		dv.confirmarVenta(v, p, cantidad);
	}
	
}
