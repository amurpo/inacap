package cl.inacap.automovilModel.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	private Connection con;
	private String servidor = "localhost";
	private String baseDatos = "automovil_db";
	private String usuario = "root";
	private String pass = "";
	public boolean conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://"+servidor+"/"+baseDatos;
			this.con = DriverManager.getConnection(url,usuario,pass);
			return true;
		}catch(Exception ex) {
			return false;
			
		}
	}
	
	public void desconectar() {
		try {
			this.con.close();
		}catch(Exception ex) {
			
		}
	}
	
	
	public Connection getCon() {
		return con;
	}
}