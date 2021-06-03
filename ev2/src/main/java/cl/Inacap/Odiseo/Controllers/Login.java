package cl.Inacap.Odiseo.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.Inacap.Odiseo.DAO.LibroDAO;
import cl.Inacap.Odiseo.DTO.Libro;


@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("site/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		Funciones fn=new Funciones();
		
		String usuario=request.getParameter("nombreUsuario").toString();
		String password=fn.EncriptarMd5(request.getParameter("passUsuario").toString()); 
				
		File miArchivo=new File("/home/amurpo/Eclipse/ev2/assetslogin.txt");
		FileReader fr= new FileReader(miArchivo);
		BufferedReader br= new BufferedReader(fr);
		
		
			
		String linea;
		String linea2;
		Boolean swIngresa=false;
		while((linea=br.readLine())!=null) {
			String [] data=linea.split(";");
			if(usuario.equals(data[0]) && password.equals(data[1])) {
				
				File miArchivo2=new File("/home/amurpo/Eclipse/ev2/libros.txt");
				FileReader fr2= new FileReader(miArchivo2);
				BufferedReader br2= new BufferedReader(fr2);
				
				while((linea2=br2.readLine())!=null) {
					String [] data2=linea2.split(";");
					Libro l = new Libro();
					l.setId(Integer.parseInt(data2[0]));
					l.setAutor(data2[1]);
					l.setNumpag(Integer.parseInt(data2[2]));
					l.setDestacado(Boolean.parseBoolean(data2[3]));
					l.setNumpag(Integer.parseInt(data2[4]));
					l.setEstrellas(Integer.parseInt(data2[5]));
					
					new LibroDAO().AddLibro(l);
				
					

				}
				HttpSession misession=request.getSession(true);
				misession.setAttribute("SwLogin", true);
				misession.setAttribute("User", usuario);
			
				
				swIngresa=true;
				break;
			}
		}
		br.close();		
	}

}