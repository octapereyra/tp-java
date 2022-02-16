package logic;

import data.DataVenta;
import entities.Venta_Producto;
import entities.Venta;

import java.util.ArrayList;
import java.util.LinkedList;

public class LogicVenta {
	
	private DataVenta dv;
	
	public LogicVenta() {
		dv = new DataVenta();
	}
	
	public void confirmarVenta(Venta v, ArrayList<int[]> listaCarrito)  {
		
		dv.confirmarVenta(v, listaCarrito);
	}
	
	public LinkedList<Venta_Producto> getAllVentaProducto(int id_usuario){
		return dv.getAllVentaProducto(id_usuario);
	}
	
}
