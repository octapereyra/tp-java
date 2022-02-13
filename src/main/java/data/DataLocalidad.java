package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Categoria;
import entities.Flete;
import entities.Localidad;
import entities.Producto;
import entities.Zona;

public class DataLocalidad {
	
	public LinkedList<Localidad> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Localidad> loc= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select cod_postal,descripcion,cod_zona from localidad");
			
			if(rs!=null) {
				while(rs.next()) {
					Localidad l= new Localidad();
					l.setCod_postal(rs.getInt("cod_postal"));
					l.setDescripcion(rs.getString("descripcion"));
					l.setZona(new Zona());
					l.getZona().setCod_zona(rs.getInt("cod_zona"));
					//l.getZona().setDescripcion(rs.getString("z.descripcion"));
					
					loc.add(l);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loc;
	}
	
	public Localidad getOne(int cod_postal) {
		
		Localidad l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT l.cod_postal,l.descripcion,l.cod_zona,f.id_flete "
					+ " from localidad l"
					+ " inner join zona z on z.cod_zona = l.cod_zona"
					+ " inner join flete f on f.id_flete = z.id_flete"
					+ " where cod_postal=?;");
			stmt.setInt(1, cod_postal);
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				l = new Localidad();
				l.setCod_postal(rs.getInt("cod_postal"));
				l.setDescripcion(rs.getString("descripcion"));
				l.setZona(new Zona());
				l.getZona().setCod_zona(rs.getInt("cod_zona"));
				l.getZona().setFlete(new Flete());
				l.getZona().getFlete().setId_flete(rs.getInt("id_flete"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return l;
	}
}