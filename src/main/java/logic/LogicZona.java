package logic;

import java.util.LinkedList;

import data.DataZona;
import entities.Zona;

public class LogicZona {
private DataZona dz;
	
	public LogicZona() {
		dz=new DataZona();
	}

	public LinkedList<Zona> getAll(){
		return dz.getAll();
	}
	
	public void add(Zona z) {
		dz.add(z);
	}

	public void update(Zona z) {
		dz.update(z);
		
	}

	public void delete(Zona z) {
		dz.delete(z);
		
	}
}
