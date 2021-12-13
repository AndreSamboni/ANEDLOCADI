package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.clientesDAO;
import modelo.clientesDTO;
//import com.google.gson.Gson;
import modelo.productosDAO;
import modelo.productosDTO;


/**
 * Servlet implementation class Servletproductos
 */
@WebServlet("/Servletproductos")
@MultipartConfig
public class Servletproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletproductos() {
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
		//If(request.getParameter("cargar")!=null){
		//PrintWriter out=response.getWriter();
		Part archivo=request.getPart("archivo");
		//String Url="C:\\\\Users\\\\Andre\\\\Downloads\\\\Anedlocadi\\\\src\\\\main\\\\webapp\\\\archivos\\\\";
		String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		if(request.getParameter("cargar")!=null){
			
		try {
			InputStream file=archivo.getInputStream();
			//JOptionPane.showMessageDialog(null,Url);
			File copia=new File(Url+"archivo11.csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num=file.read();
			while(num !=-1){

				escribir.write(num);
				num=file.read();
			}
			file.close();
			escribir.close();

			boolean x;
			JOptionPane.showMessageDialog(null,"Se cargó el archivo correctamente");

			productosDAO prodao=new productosDAO();
			x=prodao.cargarproductos(Url+"archivo11.csv");
			if(x){JOptionPane.showMessageDialog(null,"Datos cargados en la BD");
			}
			else
			{
			JOptionPane.showMessageDialog(null,"No se cargaron los datos en la BD");
			}
				
			} catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error al cargar el archivo");
			}
			}
			
			//Consultar todos los datos
			JOptionPane.showInternalMessageDialog(null, Url);
			//ArrayList<LineasDTO>lista=new ArrayList<>();
			//lindao=new LineasDAO();
			//lista=lindao.consultageneral();
			//Gson gson=new Gson();
			//out.print(gson.toJson(lista));
			
		PrintWriter out=response.getWriter();
		int codproducto,nit_proveedor;
		double precio_compra, iva_compra, precio_venta;
		String nombre_producto;
		productosDTO prodto;
		productosDAO prodao;
		productosDTO conpro;
		
			//Insertar un producto
			if(request.getParameter("btnins")!=null) {
				boolean inspro;
				codproducto=Integer.parseInt(request.getParameter("cod_producto"));
				nombre_producto=request.getParameter("nombre_producto");
				nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
				precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
				iva_compra=Double.parseDouble(request.getParameter("iva_compra"));
				precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
				JOptionPane.showMessageDialog(null, codproducto + nombre_producto + nit_proveedor + precio_compra + iva_compra + precio_venta);
				prodto=new productosDTO(codproducto, nombre_producto, nit_proveedor, precio_compra, iva_compra, precio_venta);
				prodao=new productosDAO();
				inspro=prodao.insertarproducto(prodto);
				if(inspro==false) {
					JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
					response.sendRedirect("productos.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Producto no se registró");
					response.sendRedirect("productos.jsp");			
				}
			}
			
			//Consultar un producto
			if (request.getParameter("btncon")!=null) {
				int cod, nitpro;
				double precom, ivacom, preven;
				String nopro;
				codproducto=Integer.parseInt(request.getParameter("cod_producto"));
				prodto=new productosDTO(codproducto);
				prodao=new productosDAO();
				conpro=prodao.consultarproducto(prodto);
				cod=conpro.getCodproducto();
				nopro=conpro.getNombre_producto();
				nitpro=conpro.getNit_proveedor();
				precom=conpro.getPrecio_compra();
				ivacom=conpro.getIva_compra();
				preven=conpro.getPrecio_venta();
				JOptionPane.showMessageDialog(null, cod + nopro + nitpro + precom + ivacom + preven);
				response.sendRedirect("productos.jsp?co="+cod+"&&no="+nopro+"&&ni="+nitpro+"&&pc="+precom+"&&ic="+ivacom+"&&pv="+preven);
			}
			//Actualizar un producto
			if(request.getParameter("btnact")!=null){
				int dat;
				codproducto=Integer.parseInt(request.getParameter("cod_producto"));
				nombre_producto=request.getParameter("nombre_producto");
				nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
				precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
				iva_compra=Double.parseDouble(request.getParameter("iva_compra"));
				precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
				prodto=new productosDTO(codproducto, nombre_producto, nit_proveedor, precio_compra, iva_compra, precio_venta);
				prodao=new productosDAO();
				dat=prodao.actualizar(prodto);
				if(dat > 0){
					JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
					response.sendRedirect("productos.jsp");
				
				}else {
					JOptionPane.showMessageDialog(null, "Producto no actualizado");
					response.sendRedirect("productos.jsp");
				}	
			}
			//Eliminar un producto
			if(request.getParameter("btneli")!=null){
				int dat;
				codproducto=Integer.parseInt(request.getParameter("cod_producto"));
				nombre_producto=request.getParameter("nombre_producto");
				nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
				precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
				iva_compra=Double.parseDouble(request.getParameter("iva_compra"));
				precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
				prodto=new productosDTO(codproducto);
				prodao=new productosDAO();
				dat=prodao.eliminar(prodto);
				if(dat>0) {
					JOptionPane.showMessageDialog(null, "Producto eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "No se eliminó el producto");
				}
				response.sendRedirect("productos.jsp");
				}
			if(request.getParameter("btnconcli")!=null) {	
				
			}
			
			//JOptionPane.showMessageDialog(null, "Gson");
			ArrayList<productosDTO>lista=new ArrayList<>();
			prodao=new productosDAO();
			lista=prodao.consultageneralpro();
			Gson gson=new Gson();
			out.print(gson.toJson(lista));
			}
	}
	
				
					