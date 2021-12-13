package modelo;
	
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;

	public class productosDAO {
		Conexion con=new Conexion();
		Connection cx=con.conexionbd();
		PreparedStatement ps;
		ResultSet rs;
		productosDTO prodto=null;
		
		//Carga masiva de productos
		public boolean cargarproductos(String URL) {
			JOptionPane.showMessageDialog(null,"en dao"+URL);
			boolean resul=false;
			try {
			
			ps=cx.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n';");
			resul=ps.executeUpdate()>0;
				
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al registrar productos: "+e);
				//e.printStackTrace();
		}
			return resul;
		}
		//Insertar un producto
		public boolean insertarproducto(productosDTO pro) {
			int c;
			boolean dat=false;
				
			try {
				ps=cx.prepareStatement("INSERT INTO productos Values(?,?,?,?,?,?)");
				ps.setInt(1, pro.getCodproducto());
				ps.setString(2, pro.getNombre_producto());
				ps.setInt(3, pro.getNit_proveedor());
				ps.setDouble(4, pro.getPrecio_compra());
				ps.setDouble(5, pro.getIva_compra());
				ps.setDouble(6, pro.getPrecio_venta());
				ps.executeUpdate();
				c=ps.executeUpdate();
				if(c>0) {
					dat=true;
				}
				else {
					dat=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dat;
			}
		//Consultar un producto
		public productosDTO consultarproducto(productosDTO pro) {
			try {
				ps=cx.prepareStatement("SELECT * FROM productos WHERE cod_producto=?");
				ps.setInt(1, pro.getCodproducto());
				rs=ps.executeQuery();
				if(rs.next()) {
				pro=new productosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
				}
				else {
					return null;
				}
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pro;
			}
			
		//Actualizar un producto
		public int actualizar(productosDTO pro) {
			int  x=0;
					
			try {
				ps=cx.prepareStatement("UPDATE productos SET nombre_producto=?,nit_proveedor=?,precio_compra=?,iva_compra=?,precio_venta=? WHERE cod_producto=?");
				ps.setString(1, pro.getNombre_producto());
				ps.setInt(2, pro.getNit_proveedor());
				ps.setDouble(3, pro.getPrecio_compra());
				ps.setDouble(4, pro.getIva_compra());
				ps.setDouble(5, pro.getPrecio_venta());
				ps.setInt(6, pro.getCodproducto());
				x=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return x;
			}
				
		//Eliminar un producto
		public int eliminar (productosDTO pro) {
			int x=0;
			try {
				ps=cx.prepareStatement("DELETE FROM productos WHERE cod_producto=?");
				ps.setInt(1, pro.getCodproducto());
				//ps.setString(2, pro.getNombre_producto());
				//ps.setString(3, pro.getNit_proveedor());
				//ps.setString(4, pro.getPrecio_compra());
				//ps.setString(5, pro.getIva_compra());
				//ps.setString(6, pro.getPrecio_venta());
				x=ps.executeUpdate();
						
			} catch (SQLException e) {
				// TODO  Auto-generated catch block
				e.printStackTrace();
			}
					
			return x;
			}
		//Consulta general productos
				public ArrayList<productosDTO> consultageneralpro(){
					ArrayList<productosDTO>lista=new ArrayList<productosDTO>();
					try {
						ps=cx.prepareStatement("SELECT * FROM productos");
						rs=ps.executeQuery();
						while(rs.next()) {
							prodto=new productosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
							lista.add(prodto);
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return lista;
				}

			}
		