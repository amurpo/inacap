package cl.inacap.automovilModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.automovilModel.dto.Automovil;
import cl.inacap.automovilModel.utils.DB;

public class AutomovilesDAO {

	private DB db = new DB();
	
	public void save(Automovil a) {
		
		try {
			db.conectar();
			String sql = "INSERT INTO automoviles(patente,kilometraje,nombrecontacto,tipoatencion,tipomotor) VALUES(?,?,?,?,?)";
						
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, a.getPatente());
			st.setInt(2, a.getKilometraje());
			st.setString(3, a.getNombreContacto());
			st.setString(4, a.getTipoAtencion());
			st.setString(5, a.getTipoMotor());
			st.executeUpdate();
			
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	public List<Automovil> getAll(){
		try {
			List<Automovil> autos = new ArrayList<Automovil>();
			db.conectar();
			String sql = "SELECT id,patente,kilometraje,nombrecontacto,tipoatencion,tipomotor FROM automoviles WHERE tipomotor=?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Automovil a = new Automovil();
				a.setId(rs.getInt(1));
				a.setPatente(rs.getString(2));
				a.setKilometraje(rs.getInt(3));
				a.setNombreContacto(rs.getString(4));
				a.setTipoAtencion(rs.getString(5));
				a.setTipoMotor(rs.getString(6));
				autos.add(a);
			}
			rs.close();
			return autos;
		}catch(Exception ex) {
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public void delete(Automovil a) {
		try {
			db.conectar();
			String sql = "DELETE FROM automoviles WHERE id=?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, a.getId());
			st.executeUpdate();
			
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
}
