package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Flete;
import entities.Zona;

public class DataZona {
	
	public LinkedList<Zona> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Zona> zonas= new LinkedList<>();
		Flete flete = new Flete();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT z.cod_zona, z.descripcion, z.id_flete, f.nombre "
					+ "FROM zona z inner join flete f on f.id_flete = z.id_flete;");
			
			if(rs!=null) {
				while(rs.next()) {
					Zona z= new Zona();
					z.setCod_zona(rs.getInt("z.cod_zona"));
					z.setDescripcion(rs.getString("z.descripcion"));
					flete.setId_flete(rs.getInt("z.id_flete"));
					flete.setNombre(rs.getString("f.nombre"));
					z.setFlete(flete);
					
					zonas.add(z);
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
		return zonas;
	}
	
	public void add(Zona z) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into zona(descripcion, id_flete) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, z.getDescripcion());
			stmt.setInt(2, z.getFlete().getId_flete());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                z.setCod_zona(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }

	public void update(Zona z) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("UPDATE zona " + 
					"SET descripcion = ?, id_flete = ? " 
					+ "WHERE cod_zona = ?"
					);
			
			stmt.setString(1, z.getDescripcion());
			stmt.setInt(2, z.getFlete().getId_flete());
			stmt.setInt(3, z.getCod_zona());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void delete(Zona z) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM zona where cod_zona= ?");

			stmt.setInt(1, z.getCod_zona());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}