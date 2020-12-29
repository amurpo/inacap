package cl.inacap.automovilApp.frames;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import cl.inacap.automovilModel.dao.AutomovilesDAO;
import cl.inacap.automovilModel.dto.Automovil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarFrame extends JInternalFrame {
	private JComboBox<Automovil> automovilesCbx;

	
 public EliminarFrame() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				List<Automovil> autos = new AutomovilesDAO().getAll();
				if(autos.isEmpty()) {
					JOptionPane.showMessageDialog(null,"No hay automoviles para eliminar" );
					EliminarFrame.this.dispose();
				}else {
					autos.forEach(a->{
						automovilesCbx.addItem(a);
					});
					
				}
			}
		});
		setClosable(true);
		setTitle("Eliminar Automovil");
		setBounds(100, 100, 640, 300);
		getContentPane().setLayout(null);
		
		automovilesCbx = new JComboBox<Automovil>();
		automovilesCbx.setBounds(12, 66, 606, 27);
		getContentPane().add(automovilesCbx);
		
		JButton eliminarBtn = new JButton("Eliminar Automovil");
		eliminarBtn.addActionListener(e->eliminar());
		eliminarBtn.setBounds(215, 125, 178, 27);
		getContentPane().add(eliminarBtn);

	}



	private void eliminar() {

		Automovil seleccionado = (Automovil)automovilesCbx.getSelectedItem();
		new AutomovilesDAO().delete(seleccionado);
		JOptionPane.showMessageDialog(null,"Automovil Eliminado");
		this.dispose();
	}

}