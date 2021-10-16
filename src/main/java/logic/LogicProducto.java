package logic;

import java.util.LinkedList;

import data.DataProducto;
import entities.Producto;

public class LogicProducto {
	
	private DataProducto dp;
	
	public LogicProducto() {
		dp=new DataProducto();
	}
	
	public LinkedList<Producto> getbyPrecio(Producto pro, String cond){
		return dp.getByPrecio(pro, cond);
	}

}
