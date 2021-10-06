package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
//import com.google.gson.Gson;
import modelo.productosDAO;


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
	}
				
}
					