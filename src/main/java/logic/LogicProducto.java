package logic;

import java.util.LinkedList;

import data.DataProducto;
import entities.Producto;
import entities.Usuario;

public class LogicProducto {
	
	private DataProducto dp;
	
	public LogicProducto() {
		dp=new DataProducto();
	}
	
	public LinkedList<Producto> getAll(){
		return dp.getAll();
	}
	
	public LinkedList<Producto> getbyPrecio(Producto pro, String cond){
		return dp.getByPrecio(pro, cond);
	}
	
	public void add(Producto p) {
		dp.add(p);
	}
}
