package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlDB.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Habitacion;
import model.Hotel;
import model.SubEmpresa;

import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class hospedajeVW extends JFrame {

	private JPanel contentPane;
	private DatabaseConnection db = new DatabaseConnection();
	private JTable tableHoteles;
	private JTable tableHabitaciones;
	private JTextField textIdHotel;
	private JTextField textEmailVendedor;
	private JTextField textConstraseña;
	private boolean inicio=false;
	private SubEmpresa  vendedor = new SubEmpresa();
	private JTextField textIdCliente;
	private JTextField textNombreCliente;
	private JTextField textTelefonoCliente;
	private JTextField textEmailCliente;
	private JTextField textNroHabitaciones;
	private JTextField textRegimen;
	private JTextField textFecha;
	private JTextField textNroPersonas;
	private JTextField textNroNoches;
	private JTextField textEstado;
	private JTextField textHabitacionReserva;
	private JTextField textIdReserva;
	private JTextField textFechaFactura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospedajeVW frame = new hospedajeVW();
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
	public hospedajeVW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reserva de habitaciones");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(489, 11, 232, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informacion relevante");
		lblNewLabel_1.setBounds(801, 71, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(917, 166, 197, 124);
		contentPane.add(scrollPane);
		
		tableHoteles = new JTable();
		tableHoteles.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID_HOTEL", "NOMBRE", "TIPO"
			}
		));
		scrollPane.setViewportView(tableHoteles);
		
		JButton btnCargarHoteles = new JButton("Cargar hoteles");
		btnCargarHoteles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ArrayList<Cliente> listaCliente = conexion.cargarClientes();
				ArrayList<Hotel> listaHoteles = db.cargarHoteles();

 
				String matrizInfo[][] = new String[listaHoteles.size()][3];

				for (int i = 0; i < listaHoteles.size(); i++) {
					
					
					matrizInfo[i][0] = listaHoteles.get(i).getId_hotel() + "";
					matrizInfo[i][1] = listaHoteles.get(i).getNombre() + "";
					matrizInfo[i][2] = listaHoteles.get(i).getTipo() + "";

				}


				tableHoteles.setModel(new DefaultTableModel(matrizInfo
						, new String[] { "ID_HOTEL", "NOMBRE", "TIPO"}));
				
			}
		});
		btnCargarHoteles.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCargarHoteles.setBounds(917, 301, 116, 23);
		contentPane.add(btnCargarHoteles);
		
		JLabel lblNewLabel_2 = new JLabel("Hoteles disponibles");
		lblNewLabel_2.setBounds(917, 141, 151, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(500, 389, 614, 175);
		contentPane.add(scrollPane_1);
		
		tableHabitaciones = new JTable();
		tableHabitaciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID_HABITACION", "NUMERO", "ID_HOTEL", "DESCRIPCION", "TIPO", "NIVEL", "PRECIO_NOCHE"
			}
		));
		scrollPane_1.setViewportView(tableHabitaciones);
		
		JLabel lblNewLabel_3 = new JLabel("Habitaciones disponibles");
		lblNewLabel_3.setBounds(500, 352, 164, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCargarHabitaciones = new JButton("Cargar habitaciones");
		btnCargarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<Habitacion> listaHabitaciones = db.cargarHabitaciones();
				
				
				String matrizInfo[][] = new String[listaHabitaciones.size()][7];

				for (int i = 0; i < listaHabitaciones.size(); i++) {
					
					
					matrizInfo[i][0] = listaHabitaciones.get(i).getId_habitacion()+"";
					matrizInfo[i][1] = listaHabitaciones.get(i).getNumero()+"";
					matrizInfo[i][2] = listaHabitaciones.get(i).getId_hotel() +"";
					matrizInfo[i][3] = listaHabitaciones.get(i).getDescripcion() +"";
					matrizInfo[i][4] = listaHabitaciones.get(i).getTipo() +"";
					matrizInfo[i][5] = listaHabitaciones.get(i).getNivel() +"";
					matrizInfo[i][6] = listaHabitaciones.get(i).getPrecio_noche() +"";
				
				}
				
				

				tableHabitaciones.setModel(new DefaultTableModel(matrizInfo
						, new String[] { "ID_HABITACION", "NUMERO", "ID_HOTEL", "DESCRIPCION",
								"TIPO", "NIVEL", "PRECIO_NOCHE"}));
				
			}
		});
		btnCargarHabitaciones.setBounds(898, 585, 187, 23);
		contentPane.add(btnCargarHabitaciones);
		
		JLabel loguitoH = new JLabel("");
		loguitoH.setIcon(new ImageIcon(hospedajeVW.class.getResource("/images/hotel (3).png")));
		loguitoH.setBounds(500, 149, 128, 141);
		contentPane.add(loguitoH);
		
		JLabel lblNewLabel_4 = new JLabel("ID HOTEL");
		lblNewLabel_4.setBounds(655, 173, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		textIdHotel = new JTextField();
		textIdHotel.setBounds(775, 170, 86, 20);
		contentPane.add(textIdHotel);
		textIdHotel.setColumns(10);
		
		JButton btnInstalaciones = new JButton("Consultar Lista de Instalaciones");
		btnInstalaciones.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(inicio) {
				String notificacion="";
				if(textIdHotel.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Campos vacios");
				}else {
					notificacion = db.obtenerInstalaciones(Integer.parseInt(textIdHotel.getText()));
					JOptionPane.showMessageDialog(null, notificacion);

				}
			}else {
				JOptionPane.showMessageDialog(null, "inicie sesion primero");
			}
			}
		});
		btnInstalaciones.setBounds(655, 198, 206, 23);
		contentPane.add(btnInstalaciones);
		
		JButton btnPoliticas = new JButton("Consultar politicas del hotel");
		btnPoliticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inicio) {
				String notificacion="";
				if(textIdHotel.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Campos vacios");
				}else {
					notificacion = db.obtenerPoliticas(Integer.parseInt(textIdHotel.getText()));
					JOptionPane.showMessageDialog(null, notificacion);

				}
			}else {
				JOptionPane.showMessageDialog(null, "inicie sesion primero");

			}
			}
		});
		btnPoliticas.setBounds(655, 231, 206, 23);
		contentPane.add(btnPoliticas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 1124, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(764, 96, 197, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("Reserva");
		lblNewLabel_5.setBounds(176, 71, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(102, 96, 197, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("Email del vendedor");
		lblNewLabel_6.setBounds(30, 128, 110, 14);
		contentPane.add(lblNewLabel_6);
		
		textEmailVendedor = new JTextField();
		textEmailVendedor.setBounds(196, 125, 182, 20);
		contentPane.add(textEmailVendedor);
		textEmailVendedor.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Constrase\u00F1a del vendedor");
		lblNewLabel_7.setBounds(30, 173, 151, 14);
		contentPane.add(lblNewLabel_7);
		
		textConstraseña = new JTextField();
		textConstraseña.setBounds(196, 170, 182, 20);
		contentPane.add(textConstraseña);
		textConstraseña.setColumns(10);
		
		JButton btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  vendedor = db.consultarVendedor(textEmailVendedor.getText(), textConstraseña.getText());
				if(vendedor!=null) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
					inicio=true;
				}else {
					JOptionPane.showMessageDialog(null, "este vendedor no se encuentra registrado en la base de datos");

				}
			}
		});
		btnInicioSesion.setBounds(134, 211, 128, 23);
		contentPane.add(btnInicioSesion);
		
		JLabel lblNewLabel_8 = new JLabel("cedula");
		lblNewLabel_8.setBounds(30, 263, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textIdCliente = new JTextField();
		textIdCliente.setBounds(83, 260, 179, 20);
		contentPane.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("nombre");
		lblNewLabel_9.setBounds(30, 294, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setBounds(83, 291, 179, 20);
		contentPane.add(textNombreCliente);
		textNombreCliente.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Telefono");
		lblNewLabel_10.setBounds(30, 325, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		textTelefonoCliente = new JTextField();
		textTelefonoCliente.setBounds(83, 322, 179, 20);
		contentPane.add(textTelefonoCliente);
		textTelefonoCliente.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Email");
		lblNewLabel_11.setBounds(30, 352, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textEmailCliente = new JTextField();
		textEmailCliente.setBounds(83, 349, 179, 20);
		contentPane.add(textEmailCliente);
		textEmailCliente.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Nro Habitaciones");
		lblNewLabel_12.setBounds(30, 467, 110, 14);
		contentPane.add(lblNewLabel_12);
		
		textNroHabitaciones = new JTextField();
		textNroHabitaciones.setBounds(134, 464, 128, 20);
		contentPane.add(textNroHabitaciones);
		textNroHabitaciones.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Regimen");
		lblNewLabel_13.setBounds(30, 383, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		textRegimen = new JTextField();
		textRegimen.setBounds(83, 380, 179, 20);
		contentPane.add(textRegimen);
		textRegimen.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Fecha Reserva");
		lblNewLabel_14.setBounds(30, 414, 86, 14);
		contentPane.add(lblNewLabel_14);
		
		textFecha = new JTextField();
		textFecha.setBounds(134, 411, 128, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Nro personas");
		lblNewLabel_15.setBounds(30, 492, 86, 14);
		contentPane.add(lblNewLabel_15);
		
		textNroPersonas = new JTextField();
		textNroPersonas.setBounds(134, 492, 128, 20);
		contentPane.add(textNroPersonas);
		textNroPersonas.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Nro noches");
		lblNewLabel_16.setBounds(30, 526, 86, 14);
		contentPane.add(lblNewLabel_16);
		
		textNroNoches = new JTextField();
		textNroNoches.setBounds(134, 523, 128, 20);
		contentPane.add(textNroNoches);
		textNroNoches.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Estado");
		lblNewLabel_17.setBounds(30, 554, 46, 14);
		contentPane.add(lblNewLabel_17);
		
		textEstado = new JTextField();
		textEstado.setBounds(134, 551, 128, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("id Habitacion");
		lblNewLabel_18.setBounds(30, 585, 66, 14);
		contentPane.add(lblNewLabel_18);
		
		textHabitacionReserva = new JTextField();
		textHabitacionReserva.setBounds(134, 582, 128, 20);
		contentPane.add(textHabitacionReserva);
		textHabitacionReserva.setColumns(10);
		
		JButton btnTotalPagar = new JButton("Consulta el total a pagar");
		btnTotalPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				private JTextField textNroHabitaciones;
//				private JTextField textHabitacionReserva;
//				private JTextField textNroNoches;
				float precioHabitacion =(float) 0.0;
				float totalPagar=0;

				if(inicio) {
			
					if(textNroHabitaciones.getText().equalsIgnoreCase("") || textHabitacionReserva.getText().equalsIgnoreCase("")||
							textNroNoches.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios");
					}else {
						
						precioHabitacion=db.traerPrecioHabitacion(Integer.parseInt(textHabitacionReserva.getText()));
						
						totalPagar=( Integer.parseInt(textNroHabitaciones.getText()) * precioHabitacion) * Integer.parseInt(textNroNoches.getText());
						JOptionPane.showMessageDialog(null, "Se pagaria un total de: "+totalPagar);

					}
				}else {
					JOptionPane.showMessageDialog(null, "inicie sesion primero");

				}
			}
		});
		btnTotalPagar.setHorizontalAlignment(SwingConstants.TRAILING);
		btnTotalPagar.setBounds(299, 348, 157, 23);
		contentPane.add(btnTotalPagar);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float precioHabitacion =(float) 0.0;
				float totalPagar=0;
				String notificacion="";
				if(inicio) {
					
					if(textTelefonoCliente.getText().equalsIgnoreCase("") || textEmailCliente.getText().equalsIgnoreCase("")
						||textFecha.getText().equalsIgnoreCase("")||	textIdReserva.getText().equalsIgnoreCase("")||textEstado.getText().equalsIgnoreCase("")	||textNroPersonas.getText().equalsIgnoreCase("")	||textRegimen.getText().equalsIgnoreCase("") ||textNombreCliente.getText().equalsIgnoreCase("")||textIdCliente.getText().equalsIgnoreCase("")||textNroHabitaciones.getText().equalsIgnoreCase("") || textHabitacionReserva.getText().equalsIgnoreCase("")||
						textFechaFactura.getText().equalsIgnoreCase("")	||textNroNoches.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios");
					}else {
						
						precioHabitacion=db.traerPrecioHabitacion(Integer.parseInt(textHabitacionReserva.getText()));
						
						totalPagar=( Integer.parseInt(textNroHabitaciones.getText()) * precioHabitacion) * Integer.parseInt(textNroNoches.getText());
						Date fechaVisita = Date.valueOf(textFecha.getText());
						Date fechaFactura = Date.valueOf(textFechaFactura.getText());

						notificacion = db.realizarReservaHotel(Integer.parseInt(textIdCliente.getText())
								,textNombreCliente.getText(), textTelefonoCliente.getText(),
								textEmailCliente.getText(), vendedor.getId_subEmpresa(), Integer.parseInt(textIdReserva.getText()),
								Integer.parseInt(textNroHabitaciones.getText()),textRegimen.getText(), fechaVisita,
								Integer.parseInt(textNroPersonas.getText()), Integer.parseInt(textNroNoches.getText()), textEstado.getText(),totalPagar,
								Integer.parseInt(textHabitacionReserva.getText()), fechaFactura);
						
						JOptionPane.showMessageDialog(null, notificacion);


					}
				}else {
					JOptionPane.showMessageDialog(null, "inicie sesion primero");

				}
				
			}
		});
		btnReservar.setBounds(299, 410, 157, 23);
		contentPane.add(btnReservar);
		
		JLabel lblNewLabel_19 = new JLabel("id Reserva");
		lblNewLabel_19.setBounds(30, 610, 66, 14);
		contentPane.add(lblNewLabel_19);
		
		textIdReserva = new JTextField();
		textIdReserva.setBounds(134, 607, 128, 20);
		contentPane.add(textIdReserva);
		textIdReserva.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Fecha factura");
		lblNewLabel_20.setBounds(30, 442, 86, 14);
		contentPane.add(lblNewLabel_20);
		
		textFechaFactura = new JTextField();
		textFechaFactura.setBounds(134, 439, 128, 20);
		contentPane.add(textFechaFactura);
		textFechaFactura.setColumns(10);
		
		
	}
}
