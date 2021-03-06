package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import modelo.clientesDAO;
import modelo.clientesDTO;
import modelo.detalleventasDAO;
import modelo.detalleventasDTO;
import modelo.proDAO;
import modelo.productosDTO;
import modelo.ventasDAO;
import modelo.ventasDTO;

/**
 * Servlet implementation class Servletventas
 */
@WebServlet("/Servletventas")
public class Servletventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva,iva1,iva2;   
	int  cant1,cant2,cant3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletventas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		PrintWriter out=response.getWriter();
		ventasDAO vendao=new ventasDAO();
		if(request.getParameter("confirmar")!=null) {
		int cedula,ced;
		String nom;
	
		
		clientesDTO listado;
		cedula=Integer.parseInt(request.getParameter("cedula_cli"));
		clientesDAO clidao=new clientesDAO();
		clientesDTO clidto=new clientesDTO(cedula);
		listado=clidao.consultarcliente(clidto);
		
		
		//ced=listadto.getCedula();
		//nom=listadto.getNombre();
		 sesion.setAttribute("cliente",listado);
		 sesion.setAttribute("cliente",listado);
		 //request.setAttribute("clientenombre",nom);
		 //JOptionPane.showMessageDialog(null, ced+nom);
		 request.getRequestDispatcher("ventas.jsp").forward(request, response);
	
		
		//if(cedula>1) {
			//int codv;
		//ventasDTO codado;
		//codv=Integer.parseInt(request.getParameter("cod_venta"));
		//ventasDAO dbtdao=new ventasDAO();
		//ventasDTO dbtdto=new ventasDTO(codv);
		//codado=dbtdao.consultarcodventa();
		
		//}
		}
		
		if(request.getParameter("conpro")!=null) {
			
			int codpro;
			productosDTO listapro;
			codpro=Integer.parseInt(request.getParameter("cod_producto"));
			productosDTO podto=new productosDTO(codpro);
			proDAO prdao=new proDAO();
			listapro=prdao.consultarproducto(podto);
			if (listapro!=null) {
				iva= listapro.getIva_compra() ;
				sesion.setAttribute("producto",listapro);
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "C?digo de producto no existe");
				response.sendRedirect("ventas.jsp");
			}
			
		} 
		
		if(request.getParameter("conpro1")!=null) {
			int codpro;
			productosDTO listapro1;
			codpro=Integer.parseInt(request.getParameter("codigo1"));
			productosDTO podto=new productosDTO(codpro);
			proDAO prdao=new proDAO();
			listapro1=prdao.consultarproducto(podto);
			if (listapro1!=null) {
				iva1= listapro1.getIva_compra() ;
				sesion.setAttribute("producto1",listapro1);
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "C?digo de producto no existe");
				response.sendRedirect("ventas.jsp");
			}
			
			
		} 
		if(request.getParameter("conpro2")!=null) {
			int codpro;
			productosDTO listapro2;
			codpro=Integer.parseInt(request.getParameter("codigo2"));
			productosDTO podto=new productosDTO(codpro);
			proDAO prdao=new proDAO();
			listapro2=prdao.consultarproducto(podto);
			if (listapro2!=null) {
				iva2= listapro2.getIva_compra();
				sesion.setAttribute("producto2",listapro2);
				request.getRequestDispatcher("ventas.jsp").forward(request, response);
			}
			else {
				JOptionPane.showMessageDialog(null, "C?digo de producto no existe");
				response.sendRedirect("ventas.jsp");
			}
			
			
		} 
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
		
	
		
		
		if(request.getParameter("valor_total")!=null) {
		   double total1,total2,total3,tott, tott1, tott2;
		
		   int aux = 0;		
           if(request.getParameter("can") == "" || request.getParameter("can") == "0"){
				aux = aux + 1;
			} 
			if(request.getParameter("can1") == "" || request.getParameter("can1") == "0"){
				aux = aux + 1;
			}
			if(request.getParameter("can2") == "" || request.getParameter("can2") == "0"){
				aux = aux + 1;
			}
			if(aux == 0){			
			cant1=Integer.parseInt(request.getParameter("can"));
			cant2=Integer.parseInt(request.getParameter("can1"));
			cant3=Integer.parseInt(request.getParameter("can2"));
			
			tot=Double.parseDouble(request.getParameter("precio"));
			tot1=Double.parseDouble(request.getParameter("precio1"));
			tot2=Double.parseDouble(request.getParameter("precio2"));
			
			
			res=cant1*tot;
			res1=cant2*tot1;
			res2=cant3*tot2;
			total1=res*iva/100;
			total2=res1*iva1/100;
			total3=res2*iva2/100;
			tott=res+total1;
			tott1=res1+total2;
			tott2=res2+total3;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
		    
			int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		     //JOptionPane.showMessageDialog(null, "impriendo la i"+i);
		    if(i==0) {
			    String cedcli,cedusu, codventa, nom;
			    int cc,cu,cv;
			    double iva,tv,vv;
			    boolean ress;
			    cedcli=(request.getParameter("cedula_cli"));
			    nom=(request.getParameter("nombre"));
			    cedusu=(request.getParameter("cu"));
			    codventa=(request.getParameter("cv"));
			    iva=totaliva;
			    tv=totalsiniva;
			    vv=totaldesiva;
			    cc=Integer.parseInt(cedcli);
			    cu=Integer.parseInt(cedusu);
			    ventasDTO ven=new ventasDTO(cc, nom, cu, tv,iva, vv);
			    ress=vendao.insertarventa(ven);
			    if(ress==true) {
			    JOptionPane.showMessageDialog(null, "Venta registrada");
			    int can, codvn;
			    double iv,dtv,dvv;
			    boolean x;
			    ventasDTO venn;
			    detalleventasDTO dd;
			    detalleventasDAO dedao;
			    int codpro=Integer.parseInt(request.getParameter("cod_producto"));
			    int codpro1=Integer.parseInt(request.getParameter("codigo1"));
			    int codpro2=Integer.parseInt(request.getParameter("codigo2"));
			    ventasDAO vend=new ventasDAO();
			    venn=vend.consultarcodventa();
			    codvn= venn.getCod_venta();			    
			    JOptionPane.showMessageDialog(null, "CODIGO DE VENTA: " + codvn);
			     can=cant1;
			     if(can>0) {

				    cv=venn.getCod_venta();
				    iv=ven.getIvaventa();
				    dtv=ven.getTotalventa();
				    dvv=ven.getValorventa();
				    dd=new detalleventasDTO(cv, can, codpro, res, total1, tott);
				    dedao=new detalleventasDAO();
				    x=dedao.Inserta_Cliente(dd);
			    	codpro=dd.getCod_producto();
				    	if(x) {
				    		//JOptionPane.showMessageDialog(null, "detalle insertado");
				    	}
			     }
			     
			     
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant2;
			     if(can>0) {
					   
					    cv=venn.getCod_venta();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new detalleventasDTO(cv, can, codpro1, res1, total2, tott1);
					    dedao=new detalleventasDAO();
					    x=dedao.Inserta_Cliente(dd);
				    	codpro1=dd.getCod_producto();
					    	if(x) {
					    		//JOptionPane.showMessageDialog(null, "detalle insertado");
					    	}
					     }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant3;
			     if(can>0) {
					   
					    cv=venn.getCod_venta();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new detalleventasDTO(cv, can, codpro2, res2, total3, tott2);
					    dedao=new detalleventasDAO();
					    x=dedao.Inserta_Cliente(dd);
				    	codpro2=dd.getCod_producto();
					    if(x) {
					    	JOptionPane.showMessageDialog(null, "Detalle insertado");
					    	response.sendRedirect("ventas.jsp");
					    }
				 }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			    }	     
			     
			    else {
			    	JOptionPane.showMessageDialog(null, "Venta NO registrada");
			    }
		    }
		}
		   else{
				JOptionPane.showMessageDialog(null, "Cantidad no puede estar vac?a o en cero");
				response.sendRedirect("ventas.jsp");
			}
			if(aux == 0){
			}
        if(request.getParameter("btnconvencli")!=null) {
			    }
        //JOptionPane.showMessageDialog(null, "Gson");
		ArrayList<ventasDTO>lista=new ArrayList<>();
		vendao=new ventasDAO();
		lista=vendao.consultageneralven();
		Gson gson=new Gson();
		out.print(gson.toJson(lista));
		}
		}
	}

