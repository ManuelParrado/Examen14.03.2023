package View;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerCentroEducativo;
import Controller.ControllerMateria;
import Controller.ControllerNivel;
import Model.CentroEducativo;
import Model.Materia;
import Model.Nivel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jId;
	private JTextField jNombre;
	private JTextField jCodigo;
	private JTextField jURL;
	private JTextField jFecha;
	private Checkbox chkMateria;
	private JComboBox<Nivel> comboNivel;
	private JComboBox<CentroEducativo> comboCentro;
	private JComboBox<Materia> comboMateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de Materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Centro:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboCentro = new JComboBox<CentroEducativo>();
		GridBagConstraints gbc_comboCentro = new GridBagConstraints();
		gbc_comboCentro.gridwidth = 2;
		gbc_comboCentro.insets = new Insets(0, 0, 5, 5);
		gbc_comboCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCentro.gridx = 1;
		gbc_comboCentro.gridy = 1;
		contentPane.add(comboCentro, gbc_comboCentro);

		JButton btCargarNiveles = new JButton("Cargar Niveles");
		btCargarNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filtrarNivelesPorCentro();

			}
		});
		GridBagConstraints gbc_btCargarNiveles = new GridBagConstraints();
		gbc_btCargarNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_btCargarNiveles.gridx = 3;
		gbc_btCargarNiveles.gridy = 1;
		contentPane.add(btCargarNiveles, gbc_btCargarNiveles);

		JLabel lblNewLabel_1_1 = new JLabel("Nivel:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		comboNivel = new JComboBox<Nivel>();
		GridBagConstraints gbc_comboNivel = new GridBagConstraints();
		gbc_comboNivel.gridwidth = 2;
		gbc_comboNivel.insets = new Insets(0, 0, 5, 5);
		gbc_comboNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboNivel.gridx = 1;
		gbc_comboNivel.gridy = 2;
		contentPane.add(comboNivel, gbc_comboNivel);

		JButton btCargarMaterias = new JButton("Cargar Materias");
		btCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filtrarMateriaPorNivel();
			}
		});
		GridBagConstraints gbc_btCargarMaterias = new GridBagConstraints();
		gbc_btCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btCargarMaterias.gridx = 3;
		gbc_btCargarMaterias.gridy = 2;
		contentPane.add(btCargarMaterias, gbc_btCargarMaterias);

		JLabel lblNewLabel_1_1_1 = new JLabel("Materia:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		comboMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboMateria = new GridBagConstraints();
		gbc_comboMateria.gridwidth = 2;
		gbc_comboMateria.insets = new Insets(0, 0, 5, 5);
		gbc_comboMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMateria.gridx = 1;
		gbc_comboMateria.gridy = 3;
		contentPane.add(comboMateria, gbc_comboMateria);

		JButton btVerMateria = new JButton("Ver Materia");
		btVerMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostrarInformacionMateria(
						((Materia) comboMateria.getSelectedItem()).getId());

			}
		});
		GridBagConstraints gbc_btVerMateria = new GridBagConstraints();
		gbc_btVerMateria.insets = new Insets(0, 0, 5, 0);
		gbc_btVerMateria.gridx = 3;
		gbc_btVerMateria.gridy = 3;
		contentPane.add(btVerMateria, gbc_btVerMateria);

		JLabel lblNewLabel_2 = new JLabel("Datos de la Materia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1_2 = new JLabel("Id:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 5;
		contentPane.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		jId = new JTextField();
		GridBagConstraints gbc_jId = new GridBagConstraints();
		gbc_jId.insets = new Insets(0, 0, 5, 5);
		gbc_jId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jId.gridx = 2;
		gbc_jId.gridy = 5;
		contentPane.add(jId, gbc_jId);
		jId.setColumns(10);
		jId.setEnabled(false);

		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_2_1.gridy = 6;
		contentPane.add(lblNewLabel_1_2_1, gbc_lblNewLabel_1_2_1);

		jNombre = new JTextField();
		jNombre.setColumns(10);
		GridBagConstraints gbc_jNombre = new GridBagConstraints();
		gbc_jNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jNombre.gridx = 2;
		gbc_jNombre.gridy = 6;
		contentPane.add(jNombre, gbc_jNombre);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Código:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_2_1_1, gbc_lblNewLabel_1_2_1_1);

		jCodigo = new JTextField();
		jCodigo.setColumns(10);
		GridBagConstraints gbc_jCodigo = new GridBagConstraints();
		gbc_jCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCodigo.gridx = 2;
		gbc_jCodigo.gridy = 7;
		contentPane.add(jCodigo, gbc_jCodigo);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("URL Classroom:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1.gridy = 8;
		contentPane.add(lblNewLabel_1_2_1_1_1, gbc_lblNewLabel_1_2_1_1_1);

		jURL = new JTextField();
		jURL.setColumns(10);
		GridBagConstraints gbc_jURL = new GridBagConstraints();
		gbc_jURL.insets = new Insets(0, 0, 5, 5);
		gbc_jURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_jURL.gridx = 2;
		gbc_jURL.gridy = 8;
		contentPane.add(jURL, gbc_jURL);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Fecha inicio:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_2_1_1_1_1.gridy = 9;
		contentPane.add(lblNewLabel_1_2_1_1_1_1, gbc_lblNewLabel_1_2_1_1_1_1);

		jFecha = new JTextField();
		jFecha.setColumns(10);
		GridBagConstraints gbc_jFecha = new GridBagConstraints();
		gbc_jFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jFecha.gridx = 2;
		gbc_jFecha.gridy = 9;
		contentPane.add(jFecha, gbc_jFecha);

		JCheckBox chkMatricula = new JCheckBox("Admite matrícula");
		chkMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_chkMatricula = new GridBagConstraints();
		gbc_chkMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_chkMatricula.gridx = 2;
		gbc_chkMatricula.gridy = 10;
		contentPane.add(chkMatricula, gbc_chkMatricula);

		JButton btGuardar = new JButton("Guardar");
		btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardar();
			}
		});
		GridBagConstraints gbc_btGuardar = new GridBagConstraints();
		gbc_btGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btGuardar.gridx = 2;
		gbc_btGuardar.gridy = 11;
		contentPane.add(btGuardar, gbc_btGuardar);

		cargarCentrosEnCombo();
	}

	private void cargarCentrosEnCombo() {

		List<CentroEducativo> centros = ControllerCentroEducativo.findAll();
		for (CentroEducativo c : centros) {
			this.comboCentro.addItem(c);
		}

	}

	/**
	 * 
	 */
	private void filtrarNivelesPorCentro() {
		int idCentro = ((CentroEducativo) this.comboCentro.getSelectedItem()).getId();

		this.comboNivel.removeAllItems();

		List<Nivel> niveles = ControllerNivel.findByCentro(idCentro);
		for (Nivel n : niveles) {
			this.comboNivel.addItem(n);
		}
	}

	/**
	 * 
	 */
	private void filtrarMateriaPorNivel() {
		
		int idNivel = ((Nivel) this.comboNivel.getSelectedItem()).getId();
		
		this.comboMateria.removeAllItems();

		List<Materia> materias = ControllerMateria.findByNivel(idNivel);
		for (Materia m : materias) {
			this.comboMateria.addItem(m);
		}
	}

	private void mostrarInformacionMateria(int idMateria) {

		Materia m = ControllerMateria.cargarDetallesMateria(idMateria);

	
		if (m != null) {
			
			jId.setText(Integer.toString(m.getId()));
			jNombre.setText(m.getNombre());
			jCodigo.setText(m.getCodigo());
			jURL.setText(m.getUrlClassroom());
			jFecha.setText("" + m.getFechaInicio());
	
		}
	
	}
	
	private void guardar() {
		
		Materia m = (Materia) this.comboMateria.getSelectedItem();
		
		int row = ControllerMateria.modificar(m);
		
		if (row == 1) {
			JOptionPane.showInternalMessageDialog(null, 
					"Han sido afectadas "+row+" filas");
		} else {
			JOptionPane.showInternalMessageDialog(null, 
					"Error, no se ha modicado ningun registro");
		}
		
	}

}
