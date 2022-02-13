package logic;

import data.DataVenta;
import entities.Producto;
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
	
}
