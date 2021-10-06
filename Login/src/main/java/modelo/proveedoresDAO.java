package modelo;
	
import java.sql.*;
import java.util.ArrayList;

import controlador.Conexion;

	public class proveedoresDAO {
		Conexion con=new Conexion();
		Connection cx=con.conexionbd();
		PreparedStatement ps;
		ResultSet rs;
		proveedoresDTO provdto=null;
		//Insertar cliente
		public boolean insertarproveedor(proveedoresDTO prov) {
			int c;
			boolean info=false;
		
		try {
			ps=cx.prepareStatement("INSERT INTO proveedores Values(?,?,?,?,?)");
			ps.setInt(1, prov.getNitprov());
			ps.setString(2, prov.getNombreprov());
			ps.setString(3, prov.getDireccionprov());
			ps.setString(4, prov.getTelefonoprov());
			ps.setString(5, prov.getCiudadprov());
			ps.executeUpdate();
			c=ps.executeUpdate();
			if(c>0) {
				info=true;
			}
			else {
				info=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		}
		//Consultar cliente
		public proveedoresDTO consultarproveedor(proveedoresDTO prov) {
			try {
			ps=cx.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor=?");
			ps.setInt(1, prov.getNitprov());
			rs=ps.executeQuery();
			if(rs.next()) {
			prov=new proveedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			else {
				return null;
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prov;
		}
	
	//Actualizar cliente
		public int actualizar(proveedoresDTO prov) {
			int  x=0;
			
				try {
					ps=cx.prepareStatement("UPDATE proveedores SET nombre_prov=?,direccion_prov=?,telefono_prov=?,ciudad_prov=? WHERE nit_proveedor=?");
					ps.setString(1, prov.getNombreprov());
					ps.setString(2, prov.getDireccionprov());
					ps.setString(3, prov.getTelefonoprov());
					ps.setString(4, prov.getCiudadprov());
					ps.setInt(5, prov.getNitprov());
					x=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			return x;
		}
		
		//Eliminar cliente
		public int eliminar (proveedoresDTO prov) {
			int x=0;
			try {
				ps=cx.prepareStatement("DELETE FROM proveedores WHERE nit_proveedor=?");
				ps.setInt(1, prov.getNitprov());
				//ps.setString(2, prov.getNombreprov());
				//ps.setString(3, prov.getDireccionprov());
				//ps.setString(4, prov.getTelefonoprov());
				//ps.setString(5, prov.getCiudadprov());
				x=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO  Auto-generated catch block
				e.printStackTrace();
			}
			
			return x;
		}
		//Consulta general proveedores
		public ArrayList<proveedoresDTO> consultageneralprov(){
			ArrayList<proveedoresDTO>lista=new ArrayList<proveedoresDTO>();
			try {
				ps=cx.prepareStatement("SELECT * FROM proveedores");
				rs=ps.executeQuery();
				while(rs.next()) {
					provdto=new proveedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					lista.add(provdto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}

	}