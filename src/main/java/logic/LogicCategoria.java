package logic;
import java.util.LinkedList;

import data.DataCategoria;
import entities.Categoria;

public class LogicCategoria {
private DataCategoria dc;
	
	public LogicCategoria() {
		dc=new DataCategoria();
	}

	public LinkedList<Categoria> getAll(){
		return dc.getAll();
	}
	
	public void add(Categoria c) {
		dc.add(c);
	}

	public void update(Categoria c) {
		dc.update(c);
		
	}

	public void delete(Categoria c) {
		dc.delete(c);
		
	}
	
	public Categoria getByDenominacion(String denominacion) {
		return dc.getByDenominacion(denominacion);
	}
}
