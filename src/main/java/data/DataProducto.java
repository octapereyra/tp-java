package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Categoria;
import entities.Producto;
import entities.TipoUsuario;
import entities.Usuario;


public class DataProducto {
	
	public LinkedList<Producto> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT p.id_producto,p.descripcion,p.precio,p.stock,c.id_categoria,c.denominacion "
					+ "FROM producto p "
					+ "inner join categoria c on c.id_categoria = p.id_categoria;");
			
			if(rs!=null) {
				while(rs.next()) {
					Producto p= new Producto();
					p.setId(rs.getInt(1));
					p.setDescripcion(rs.getString(2));
					p.setPrecio(rs.getDouble(3));
					p.setStock(rs.getInt(4));
					p.setCategoria(new Categoria());
					p.getCategoria().setId_categoria(rs.getInt(5));;
					p.getCategoria().setDenominacion(rs.getString(6));
					productos.add(p);
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
		return productos;
	}

	
	public Producto getOne(int id) {
		
		Producto p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT p.id_producto,p.descripcion,p.precio,p.stock,c.id_categoria,c.denominacion "
							+ "FROM producto p "
							+ "inner join categoria c on c.id_categoria = p.id_categoria "
							+ "where p.id_producto=?;"
					);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p= new Producto();
				p.setId(rs.getInt(1));
				p.setDescripcion(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setCategoria(new Categoria());
				p.getCategoria().setId_categoria(rs.getInt(5));;
				p.getCategoria().setDenominacion(rs.getString(6));
				
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
		
		return p;
	}

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
	
	public LinkedList<Producto> getByCategoria(String denominacion){
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select p.id_producto,p.descripcion,p.precio from producto p "
					+ "inner join categoria c on p.id_categoria=c.id_categoria "
					+ "where c.denominacion=?;"
					);
			stmt.setString(1, denominacion);
			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Producto p= new Producto();
					p.setId(rs.getInt("id_producto"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setPrecio(rs.getDouble("precio"));
					
					productos.add(p);
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
		return productos;
	}
	
	public void add(Producto p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into producto(descripcion, precio, stock, id_categoria) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getDescripcion());
			stmt.setDouble(2, p.getPrecio());
			stmt.setInt(3, p.getStock());
			stmt.setInt(4, p.getCategoria().getId_categoria());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
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
	
	public void update(Producto p) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("UPDATE producto " + 
					"SET descripcion = ?, precio = ?, stock = ?, id_categoria = ? " 
					+ "WHERE id_producto = ?"
					);
			
			stmt.setString(1, p.getDescripcion());
			stmt.setDouble(2, p.getPrecio());
			stmt.setInt(3, p.getStock());
			stmt.setInt(4, p.getCategoria().getId_categoria());
			stmt.setInt(5, p.getId());
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
	
	public void delete(Producto p) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM producto where id_producto = ?");

			stmt.setInt(1, p.getId());
			
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
	
	
