package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Venta;

import java.util.ArrayList;
import java.util.LinkedList;
import entities.Producto;
import logic.LogicProducto;

public class DataVenta {
	
	public void confirmarVenta(Venta v, ArrayList<int[]> listaCarrito) {
		
		PreparedStatement insertarVenta = null;
		PreparedStatement descontarStock = null;
		PreparedStatement insertarVentaProducto = null;
		Producto p;
		LogicProducto lp = new LogicProducto();
		try {
			insertarVenta = DbConnector.getInstancia().getConn_Transaccion().prepareStatement(
					"INSERT INTO venta (fechaVenta, horaVenta, id_usuario, cod_postal, id_flete) " + 
					"VALUES (?, ?, ?, ?, ?); " 
					);
	
		insertarVenta.setObject(1, v.getFechaVenta());
		insertarVenta.setObject(2, v.getHoraVenta());
		insertarVenta.setInt(3, v.getId_usuario());
		insertarVenta.setInt(4, v.getCod_postal());
		insertarVenta.setInt(5, v.getId_flete());
		insertarVenta.executeUpdate();
		
		for(int i=0; i<listaCarrito.size(); i++) {
			
			if(listaCarrito.get(i)[1] == 1) {
				
				p = lp.getOne(listaCarrito.get(i)[0]);
				
				insertarVentaProducto = DbConnector.getInstancia().getConn_Transaccion().prepareStatement(
						"INSERT INTO venta_producto (id_producto, id_venta, cantidad) " + 
						"VALUES (?, ?, ?); " 
						);

				insertarVentaProducto.setInt(1, p.getId());
				insertarVentaProducto.setInt(2, v.getId_venta());
				insertarVenta.setInt(3, 1);
				insertarVenta.executeUpdate();
				
				descontarStock = DbConnector.getInstancia().getConn_Transaccion().prepareStatement("UPDATE producto " + 
						"SET stock = ? WHERE id_producto = ?" 
						);

				descontarStock.setInt(1, p.getStock()-1);
				descontarStock.setInt(2, p.getId());
				descontarStock.executeUpdate();
				
			}else {
				
				p = lp.getOne(listaCarrito.get(i)[0]);
				
				insertarVentaProducto = DbConnector.getInstancia().getConn_Transaccion().prepareStatement(
						"INSERT INTO venta_producto (id_producto, id_venta, cantidad) " + 
						"VALUES (?, ?, ?); " 
						);

				insertarVentaProducto.setInt(1, p.getId());
				insertarVentaProducto.setInt(2, v.getId_venta());
				insertarVenta.setInt(3, listaCarrito.get(i)[1]);
				insertarVenta.executeUpdate();
				
				descontarStock = DbConnector.getInstancia().getConn_Transaccion().prepareStatement("UPDATE producto " + 
						"SET stock = ? WHERE id_producto = ?" 
						);

				descontarStock.setInt(1, p.getStock()-1);
				descontarStock.setInt(2, p.getId());
				descontarStock.executeUpdate();
	
			}
			
			
		}
		
		
			
		DbConnector.getInstancia().getConn_Transaccion().commit();
		
		} catch (SQLException e) {
			try {
				DbConnector.getInstancia().getConn_Transaccion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(insertarVenta!=null) {insertarVenta.close();}
				if(insertarVentaProducto !=null) {insertarVentaProducto.close();}
				if(descontarStock !=null) {descontarStock.close();}
				DbConnector.getInstancia().getConn_Transaccion().setAutoCommit(true);
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}

