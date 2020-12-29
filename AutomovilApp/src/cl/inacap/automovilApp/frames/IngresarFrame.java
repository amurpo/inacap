package cl.inacap.automovilApp.frames;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import cl.inacap.automovilApp.utils.TipoUtils;
import cl.inacap.automovilModel.dao.AutomovilesDAO;
import cl.inacap.automovilModel.dto.Automovil;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class IngresarFrame extends JInternalFrame {
	private JTextField patenteTxt;
	private JComboBox<String> tipoCbx;
	private JTextField nombreTxt;
	private JSpinner kilometrajex;
	private JRadioButton petroTxt;
	private JRadioButton bencinTxt;
	private JRadioButton elecTxt;
	private ButtonGroup gbutton;

	public IngresarFrame() {
		setTitle("Ingresar Automovil");
		setClosable(true);
		setBounds(100, 100, 346, 500);
		getContentPane().setLayout(null);
		
		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setBounds(136, 23, 61, 16);
		getContentPane().add(lblPatente);
		
		patenteTxt = new JTextField();
		patenteTxt.setBounds(106, 51, 130, 26);
		getContentPane().add(patenteTxt);
		patenteTxt.setColumns(10);

		JLabel lblKilo = new JLabel("Kilometraje");
		lblKilo.setBounds(116, 89, 117, 16);
		getContentPane().add(lblKilo);
		
		SpinnerModel value = new SpinnerNumberModel(30, 30, 999999999, 1);
		kilometrajex = new JSpinner(value);
		kilometrajex.setBounds(67, 117, 192, 26);

		getContentPane().add(kilometrajex);
		
		JLabel lblNContacto = new JLabel("Nombre de Contacto");
		lblNContacto.setBounds(90, 155, 185, 16);
		getContentPane().add(lblNContacto);
		
		nombreTxt = new JTextField();
		nombreTxt.setColumns(10);
		nombreTxt.setBounds(33, 178, 279, 26);
		getContentPane().add(nombreTxt);
		
		JLabel lblTipoDeAtencion = new JLabel("Tipo de Atencion");
		lblTipoDeAtencion.setBounds(104, 216, 143, 16);
		getContentPane().add(lblTipoDeAtencion);
		
		tipoCbx = new JComboBox<>();
		tipoCbx.setBounds(67, 244, 208, 24);
		getContentPane().add(tipoCbx);

		for(String tipo : TipoUtils.TIPOS) {
			tipoCbx.addItem(tipo);
		}
		
		
		petroTxt = new JRadioButton("Petrolero");
		petroTxt.setBounds(33, 291, 149, 23);
		getContentPane().add(petroTxt);
		
		bencinTxt = new JRadioButton("Bencinero");
		bencinTxt.setBounds(33, 336, 149, 23);
		getContentPane().add(bencinTxt);
		
		elecTxt = new JRadioButton("Electrico");
		elecTxt.setBounds(33, 378, 149, 23);
		elecTxt.setActionCommand("Electrico");
		getContentPane().add(elecTxt);
		
		gbutton = new ButtonGroup();
		gbutton.add(petroTxt);
		gbutton.add(bencinTxt);
		gbutton.add(elecTxt);
		
		JButton registrarBtn = new JButton("Ingresar");
		registrarBtn.addActionListener(e->registrar());
		registrarBtn.setBounds(207, 427, 117, 29);
		getContentPane().add(registrarBtn);
		

		}


	private void registrar() {
		
		try {
		String patente = this.patenteTxt.getText().trim();
		int kilometraje = (int) this.kilometrajex.getValue();
		String nombreContacto = this.nombreTxt.getText().trim();
		String tipoAtencion = (String) this.tipoCbx.getSelectedItem();
		String tipoMotor = this.gbutton.getSelection().getActionCommand();
		
		if (patenteTxt.getText().isEmpty()||(nombreTxt.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos");
		}else {
	
		Automovil a = new Automovil();
		a.setPatente(patente);
		a.setKilometraje(kilometraje);
		a.setNombreContacto(nombreContacto);
		a.setTipoAtencion(tipoAtencion);
		a.setTipoMotor(tipoMotor);
	
		new AutomovilesDAO().save(a);
		
		JOptionPane.showMessageDialog(null, "Automovil registrado!");
		this.dispose();
		
	}
		}catch(Exception ex) {
		}
	}
}