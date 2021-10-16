package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Categoria;
import entities.Producto;


public class DataProducto {
	
	
public LinkedList<Producto> getByPrecio(Producto pro, String cond) {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> listProd = new LinkedList<>();
		String c = null;
			
		
		try {
			if(cond.equalsIgnoreCase("mayor")) {c = ">";}
			if(cond.equalsIgnoreCase("menor")) {c = "<";}		
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT pr.id_producto, pr.descripcion, pr.precio, pr.stock, ca.denominacion\r"
					+ "FROM producto pr\r"
					+ "INNER JOIN categoria ca ON pr.id_categoria = ca.id_categoria\r"
					+ "WHERE pr.precio "+c+" ?"
					);
			stmt.setDouble(1, pro.getPrecio());
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
				Producto pr= new Producto();
				Categoria cat = new Categoria();
				pr.setId(rs.getInt(1));
				pr.setDescripcion(rs.getString(2));
				pr.setPrecio(rs.getDouble(3));
				pr.setStock(rs.getInt(4));
				cat.setDenominacion(rs.getString(5));
				
				pr.setCategoria(cat);
				
				listProd.add(pr);
				}	
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
		
		return listProd;
	}

}
