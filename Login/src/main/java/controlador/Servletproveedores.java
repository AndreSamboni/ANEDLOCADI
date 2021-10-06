package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.proveedoresDAO;
import modelo.proveedoresDTO;

/**
 * Servlet implementation class Servletproveedores
 */
@WebServlet("/Servletproveedores")
public class Servletproveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletproveedores() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Insertar proveedor
		boolean insprov;
		int nitprov;
		String nombreprov, direccionprov, telefonoprov, ciudadprov;
		proveedoresDTO provdto;
		proveedoresDAO provdao;
		proveedoresDTO conprov;
		
		if(request.getParameter("btnins")!=null) {		
			nitprov=Integer.parseInt(request.getParameter("nit_proveedor"));
			nombreprov=request.getParameter("nombre_prov");
			direccionprov=request.getParameter("direccion_prov");
			telefonoprov=request.getParameter("telefono_prov");
			ciudadprov=request.getParameter("ciudad_prov");
			provdto=new proveedoresDTO(nitprov, nombreprov, direccionprov, telefonoprov, ciudadprov);
			provdao=new proveedoresDAO();
			insprov=provdao.insertarproveedor(provdto);
			if(insprov==false) {
				JOptionPane.showMessageDialog(null, "Proveedor registrado correctamente");
				response.sendRedirect("proveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Proveedor no se registró");
				response.sendRedirect("proveedores.jsp");			
			}
		}
		
		//Consultar un proveedor
		if (request.getParameter("btncon")!=null) {
			int nit;
			String nprov, dprov, tprov, cprov;
			nitprov=Integer.parseInt(request.getParameter("nit_proveedor"));
			provdto=new proveedoresDTO(nitprov);
			provdao=new proveedoresDAO();
			conprov=provdao.consultarproveedor(provdto);
			nit=conprov.getNitprov();
			nprov=conprov.getNombreprov();
			dprov=conprov.getDireccionprov();
			tprov=conprov.getTelefonoprov();
			cprov=conprov.getCiudadprov();
			JOptionPane.showMessageDialog(null, nit + nprov + dprov + tprov + cprov);
			response.sendRedirect("proveedores.jsp?co="+nit+"&&nom="+nprov+"&&dir="+dprov+"&&tel="+tprov+"&&ciu="+cprov);
		}
		//Actualizar un usuario
		if(request.getParameter("btnact")!=null){
			int info;
			nitprov=Integer.parseInt(request.getParameter("nit_proveedor"));
			nombreprov=request.getParameter("nombre_prov");
			direccionprov=request.getParameter("direccion_prov");
			telefonoprov=request.getParameter("telefono_prov");
			ciudadprov=request.getParameter("ciudad_prov");
			provdto=new proveedoresDTO(nitprov, nombreprov, direccionprov, telefonoprov, ciudadprov);
			provdao=new proveedoresDAO();
			info=provdao.actualizar(provdto);
			if(info > 0){
				JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente");
				response.sendRedirect("proveedores.jsp");
			
			}else {
				JOptionPane.showMessageDialog(null, "Proveedor no actualizado");
				response.sendRedirect("proveedores.jsp");
			}	
		}
		//Eliminar
		if(request.getParameter("btneli")!=null){
			int info;
			nitprov=Integer.parseInt(request.getParameter("nit_proveedor"));
			nombreprov=request.getParameter("nombre_prov");
			direccionprov=request.getParameter("direccion_prov");
			telefonoprov=request.getParameter("telefono_prov");
			ciudadprov=request.getParameter("ciudad_prov");
			provdto=new proveedoresDTO(nitprov, nombreprov, direccionprov, telefonoprov, ciudadprov);
			provdao=new proveedoresDAO();
			info=provdao.eliminar(provdto);
			if(info>0) {
				JOptionPane.showMessageDialog(null, "Proveedor eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "No se eliminó el proveedor");
			}
			response.sendRedirect("proveedores.jsp");
		}
	}
}