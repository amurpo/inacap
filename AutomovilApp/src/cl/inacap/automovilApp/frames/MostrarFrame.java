package cl.inacap.automovilApp.frames;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import cl.inacap.automovilApp.utils.TipoUtils;
import cl.inacap.automovilModel.dao.AutomovilesDAO;
import cl.inacap.automovilModel.dto.Automovil;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MostrarFrame extends JInternalFrame {
	private JComboBox<String> tipoM;

	JTable automovilesTable;

	public MostrarFrame() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				List<Automovil> autos = new AutomovilesDAO().getAll();
				if(autos.isEmpty()) {
					JOptionPane.showMessageDialog(null
							,"No hay automoviles registrados" );
					MostrarFrame.this.dispose();
				} else {
					DefaultTableModel modelo = new DefaultTableModel();
					modelo.addColumn("Patente"); 
					modelo.addColumn("Nombre de Contacto" ); 
					modelo.addColumn("Tipo de Atencion");
					autos.forEach(a->{
						Object[] fila = new Object[3];
						fila[0] = a.getPatente();
						fila[1] = a.getNombreContacto();
						fila[2] = a.getTipoAtencion();
						modelo.addRow(fila);		
					});
					automovilesTable.setModel(modelo);
				}
				
			}
		});
		setClosable(true);
		setTitle("Lista de Automoviles");
		setBounds(100, 100, 586, 454);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 450, 396);
		getContentPane().add(scrollPane);
		
		automovilesTable = new JTable();
		automovilesTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(automovilesTable);
		
		JLabel lblNewLabel = new JLabel("Tipo de motor");
		lblNewLabel.setBounds(463, 12, 101, 15);
		getContentPane().add(lblNewLabel);
		
		tipoM = new JComboBox<String>();
		tipoM.setBounds(463, 39, 108, 24);
		getContentPane().add(tipoM);
		
		for(String tipo : TipoUtils.TIPOSM) {
			tipoM.addItem(tipo);
		}

	}
}