package logic;

import java.util.LinkedList;

import data.DataLocalidad;
import entities.Categoria;
import entities.Localidad;

public class LogicLocalidad {
	
	private DataLocalidad dl;
	
	public LogicLocalidad() {
		dl=new DataLocalidad();
	}
	
	public LinkedList<Localidad> getAll(){
		return dl.getAll();
	}
	
	public Localidad getOne(int cod_postal) {
		return dl.getOne(cod_postal);
	}

}
