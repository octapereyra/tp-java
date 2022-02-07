package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Venta;

import entities.Producto;

public class DataVenta {
	
	public void confirmarVenta(Venta v, Producto p, int cantidad) {
		
		PreparedStatement insertarVenta = null;
		PreparedStatement descontarStock = null;
		PreparedStatement insertarVentaProducto = null;
		try {
			insertarVenta = DbConnector.getInstancia().getConn_Transaccion().prepareStatement(
					"INSERT INTO venta (fechaVenta, horaVenta, id_usuario, cod_postal, id_flete) " + 
					"VALUES (?, ?, ?, ?, ?); " 
					);
	
		insertarVenta.setDate(1, v.getFechaVenta());
		insertarVenta.setTime(2, v.getHoraVenta());
		insertarVenta.setInt(3, v.getId_usuario());
		insertarVenta.setInt(4, v.getCod_postal());
		insertarVenta.setInt(5, v.getId_flete());
		insertarVenta.executeUpdate();
		
		insertarVentaProducto = DbConnector.getInstancia().getConn_Transaccion().prepareStatement(
				"INSERT INTO venta_producto (id_producto, id_venta, cantidad) " + 
				"VALUES (?, ?, ?); " 
				);

		insertarVentaProducto.setInt(1, p.getId());
		insertarVentaProducto.setInt(2, v.getId_venta());
		insertarVenta.setInt(3, cantidad);
		insertarVenta.executeUpdate();
		
		descontarStock = DbConnector.getInstancia().getConn_Transaccion().prepareStatement("UPDATE producto " + 
				"SET stock = ? WHERE id_producto = ?" 
				);

		descontarStock.setInt(1, p.getStock()-1);
		descontarStock.setInt(2, p.getId());
		descontarStock.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(insertarVenta!=null) {insertarVenta.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}

