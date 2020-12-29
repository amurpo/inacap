package cl.inacap.automovilApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.inacap.automovilApp.frames.EliminarFrame;
import cl.inacap.automovilApp.frames.IngresarFrame;
import cl.inacap.automovilApp.frames.MostrarFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private IngresarFrame ingresarFrame;
	private MostrarFrame verFrame;
	private EliminarFrame eliminarFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 572);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ingresar Automoviles");
		mntmNewMenuItem.addActionListener(e->ingresar());
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ver Automoviles");
		mntmNewMenuItem_1.addActionListener(e->ver());
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar Automoviles");
		mntmNewMenuItem_2.addActionListener(e->eliminar());
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
	}

	private void eliminar() {
		if(eliminarFrame != null) {
			desktopPane.remove(eliminarFrame);
			
		}
		eliminarFrame = new EliminarFrame();
		desktopPane.add(eliminarFrame);
		eliminarFrame.setVisible(true);
	}

	private void ver() {
		if(verFrame != null) {
			desktopPane.remove(verFrame);
		}
		verFrame = new MostrarFrame();
		desktopPane.add(verFrame);
		verFrame.setVisible(true);
		centrar(verFrame);
	}

	private void ingresar() {
		
				if(ingresarFrame != null) {
			desktopPane.remove(ingresarFrame);
		}
		ingresarFrame = new IngresarFrame();
		desktopPane.add(ingresarFrame);
		ingresarFrame.setVisible(true);
		centrar(ingresarFrame);
		
			
	}

	private void centrar(JInternalFrame marco) {
		Dimension desktopSize = desktopPane.getSize();
		Dimension jInternalFrameSize = marco.getSize();
		marco.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
	}

}
