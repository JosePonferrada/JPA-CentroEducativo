package ejercicio15_CentroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio15_CentroEducativo.controladores.ControladorEstudiante;
import ejercicio15_CentroEducativo.controladores.ControladorMateria;
import ejercicio15_CentroEducativo.controladores.ControladorProfesor;
import ejercicio15_CentroEducativo.controladores.ControladorValoracionMateria;
import ejercicio15_CentroEducativo.entities.Estudiante;
import ejercicio15_CentroEducativo.entities.Materia;
import ejercicio15_CentroEducativo.entities.Profesor;
import ejercicio15_CentroEducativo.entities.ValoracionMateria;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JComboBox<Integer> jcbNota;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Materia> jcbMateria;
	private JList listaSeleccionado;
	private JList listaNoSeleccionado;
	
	private List<Estudiante> listAllEstudiantes = 
			(List<Estudiante>) ControladorEstudiante.getInstance().findAll();
	
	private DefaultListModel<Estudiante> listModelEstudiantesSelected = null;
	private DefaultListModel<Estudiante> listModelEstudiantesNotSelected = null;
	
	private Materia matActual;
	private Profesor profActual;
	private int notaActual;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 193, 241));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel_1.add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel_1.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel_1.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel_1.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota:");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel_1.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox<Integer>();
		int i = 0;
		for(i = 0; i <= 10; i++) {
			jcbNota.addItem(i);
		}
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel_1.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizar = new JButton("Botón actualizar alumnado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadAllEstudiantesInJLists();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel_1.add(btnActualizar, gbc_btnActualizar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(145, 65, 172));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAlumnoNoSeleccionado = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblAlumnoNoSeleccionado = new GridBagConstraints();
		gbc_lblAlumnoNoSeleccionado.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlumnoNoSeleccionado.gridx = 0;
		gbc_lblAlumnoNoSeleccionado.gridy = 0;
		panel.add(lblAlumnoNoSeleccionado, gbc_lblAlumnoNoSeleccionado);
		
		JLabel lblAlumnosSeleccionados = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblAlumnosSeleccionados = new GridBagConstraints();
		gbc_lblAlumnosSeleccionados.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlumnosSeleccionados.gridx = 2;
		gbc_lblAlumnosSeleccionados.gridy = 0;
		panel.add(lblAlumnosSeleccionados, gbc_lblAlumnosSeleccionados);
		
		listaNoSeleccionado = new JList(this.getDefaultListModelNotSelected());
		GridBagConstraints gbc_listaNoSeleccionado = new GridBagConstraints();
		gbc_listaNoSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_listaNoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_listaNoSeleccionado.gridx = 0;
		gbc_listaNoSeleccionado.gridy = 1;
		panel.add(listaNoSeleccionado, gbc_listaNoSeleccionado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 163, 72));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnDeselectAll = new JButton("<<");
		GridBagConstraints gbc_btnDeselectAll = new GridBagConstraints();
		gbc_btnDeselectAll.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeselectAll.gridx = 0;
		gbc_btnDeselectAll.gridy = 0;
		panel_2.add(btnDeselectAll, gbc_btnDeselectAll);
		
		JButton btnDeselectOne = new JButton("<");
		GridBagConstraints gbc_btnDeselectOne = new GridBagConstraints();
		gbc_btnDeselectOne.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeselectOne.gridx = 0;
		gbc_btnDeselectOne.gridy = 1;
		panel_2.add(btnDeselectOne, gbc_btnDeselectOne);
		
		JButton btnSelectOne = new JButton(">");
		GridBagConstraints gbc_btnSelectOne = new GridBagConstraints();
		gbc_btnSelectOne.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelectOne.gridx = 0;
		gbc_btnSelectOne.gridy = 2;
		panel_2.add(btnSelectOne, gbc_btnSelectOne);
		
		JButton btnSelectAll = new JButton(">>");
		GridBagConstraints gbc_btnSelectAll = new GridBagConstraints();
		gbc_btnSelectAll.gridx = 0;
		gbc_btnSelectAll.gridy = 3;
		panel_2.add(btnSelectAll, gbc_btnSelectAll);
		
		listaSeleccionado = new JList(this.getDefaultListModelSelected());
		GridBagConstraints gbc_listaSeleccionado = new GridBagConstraints();
		gbc_listaSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_listaSeleccionado.gridx = 2;
		gbc_listaSeleccionado.gridy = 1;
		panel.add(listaSeleccionado, gbc_listaSeleccionado);
		
		JButton btnSaveSelected = new JButton("Guardar las notas de todos los alumnos seleccionados");
		GridBagConstraints gbc_btnSaveSelected = new GridBagConstraints();
		gbc_btnSaveSelected.anchor = GridBagConstraints.EAST;
		gbc_btnSaveSelected.gridx = 0;
		gbc_btnSaveSelected.gridy = 2;
		contentPane.add(btnSaveSelected, gbc_btnSaveSelected);
		
		loadAllMaterias(); //Cargamos todas las materias al iniciar
		
		loadAllProfesores();
		
	}

	private void loadAllMaterias() {
		
		List<Materia> materias = (List<Materia>) ControladorMateria.getInstance().findAll();
		
		for (Materia materia : materias) {
//			System.out.println(materia);
			this.jcbMateria.addItem(materia);
		}
		
	}
	
	private void loadAllProfesores() {
		
		List<Profesor> profesores = (List<Profesor>) ControladorProfesor.getInstance().findAll();
		
		for (Profesor profesor : profesores) {
//			System.out.println(materia);
			this.jcbProfesor.addItem(profesor);
		}
		
	}
	
	private DefaultListModel getDefaultListModelSelected () {
		this.listModelEstudiantesSelected = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesSelected;
	}
	
	private DefaultListModel getDefaultListModelNotSelected () {
		this.listModelEstudiantesNotSelected = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesNotSelected;
	}

	private void loadAllEstudiantesInJLists() {
		this.listModelEstudiantesNotSelected.clear();
		this.listModelEstudiantesSelected.clear();
		
		this.matActual = (Materia) this.jcbMateria.getSelectedItem();
		this.profActual = (Profesor) this.jcbProfesor.getSelectedItem();
		this.notaActual = (int) this.jcbNota.getSelectedItem();

		
		
		for (Estudiante estudiante : listAllEstudiantes) {
			ValoracionMateria vm = 
					ControladorValoracionMateria.getInstance()
					.findVMByMateriaProfesorAndEstudiante(matActual, profActual, estudiante);
			
			if(vm != null && vm.getValoracion() == this.notaActual) {
				//Si existe con la misma nota que tiene el alumno lo metemos en la lista de seleccionados
				this.listModelEstudiantesSelected.addElement(estudiante);
				
			} else {
				this.listModelEstudiantesNotSelected.addElement(estudiante);
				
			}
		}
	
	}
	
	
	
}
