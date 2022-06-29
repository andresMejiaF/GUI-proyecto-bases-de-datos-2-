package sqlDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;

import model.Habitacion;
import model.Hotel;
import model.SubEmpresa;

public class DatabaseConnection {

	private final String stringConnection = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	
	public DatabaseConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() {
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			java.sql.Statement myStatement = myConnection.createStatement();
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM prueba");
			
			//recorrer la consulta
			while (myResultSet.next()) {
				System.out.println(myResultSet.getInt("ID")+" "+myResultSet.getString("NOMBRE"));
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		return myConnection;
	}
	
	public String  prueba() {
		
		Connection myConnection = null;
		String prueba= "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			java.sql.Statement myStatement = myConnection.createStatement();
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM prueba");
			
			//recorrer la consulta
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		return prueba;
		
	}
	
	
	public static void main(String[]args) {
		if(new DatabaseConnection().getConnection() != null) {
			System.out.println("Conectado");
		}else {
			System.out.println("No se conect贸");
		}
	}

	public ArrayList<Hotel> cargarHoteles() {
		
		Connection myConnection = null;
		ArrayList<Hotel> listaHoteles = new ArrayList<>();
		Hotel hotel;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			java.sql.Statement myStatement = myConnection.createStatement();
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM HOTEL");
			
			//recorrer la consulta
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				hotel = new Hotel();
				
				hotel.setId_hotel(myResultSet.getInt("id_hotel"));
				hotel.setNombre(myResultSet.getString("NOMBRE"));
				hotel.setTipo(myResultSet.getString("TIPO"));
			
			
				listaHoteles.add(hotel);				
				
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		return listaHoteles;
	
	}

	public ArrayList<Habitacion> cargarHabitaciones() {
		
		Connection myConnection = null;
		ArrayList<Habitacion> listaHabitaciones= new ArrayList<>();
		Habitacion habitacion;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			java.sql.Statement myStatement = myConnection.createStatement();
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM HABITACION");
			
			//recorrer la consulta
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				habitacion = new Habitacion();
				
			
				
				habitacion.setId_habitacion(myResultSet.getInt("id_habitacion"));
				habitacion.setNumero(myResultSet.getInt("NUMERO"));
				habitacion.setId_hotel(myResultSet.getInt("id_hotel"));
				habitacion.setDescripcion(myResultSet.getString("DESCRIPCION"));
				habitacion.setTipo(myResultSet.getString("TIPO"));
				habitacion.setNivel(String.valueOf(myResultSet.getInt("Nivel")));
				habitacion.setPrecio_noche(myResultSet.getFloat("PRECIO_NOCHE"));
			
				listaHabitaciones.add(habitacion);
				
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
	
		
		return listaHabitaciones;
	}

	public String obtenerInstalaciones(int id_hotel) {
		String notificacion="";
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM Instalacion WHERE ID_HOTEL =?");
			pstmt.setInt(1, id_hotel);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				
				notificacion += " Hotel: " + myResultSet.getInt("id_hotel")+ " id instalacion: "+ myResultSet.getInt("id_instalacion") + " nombre: " + myResultSet.getString("NOMBRE")+
						"\n";
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		
		return notificacion;
	}

	public String obtenerPoliticas(int id_hotel) {
		String notificacion="";
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM politica WHERE ID_HOTEL =?");
			pstmt.setInt(1, id_hotel);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				
				notificacion += "Hotel: " + myResultSet.getInt("id_hotel")+ " id politica: "+ myResultSet.getInt("id_politica") + "nombre: " + myResultSet.getString("NOMBRE")+
						" Descripcion: "+ myResultSet.getString("DESCRIPCION")+"\n";
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		
		return notificacion;
	}

	public model.SubEmpresa consultarVendedor(String email, String contrase馻) {
		
		SubEmpresa vendedor= new SubEmpresa();
	
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM subEmpresa WHERE EMAIL =? and CONTRASE袮 =?");
			pstmt.setString(1, email);
			pstmt.setString(2, contrase馻);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
		
			while (myResultSet.next()) {
			//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
				//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				vendedor.setEmail(myResultSet.getString("EMAIL"));
				vendedor.setContrase馻(myResultSet.getString("CONTRASE袮"));
				vendedor.setNombre(myResultSet.getString("NOMBRE"));
				vendedor.setTelefono(myResultSet.getString("TELEFONO"));
				vendedor.setId_subEmpresa(myResultSet.getInt("id_subempresa"));
				return vendedor;
			}
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}

		return null;
	}

	public float traerPrecioHabitacion(int idHabitacion) {
		// TODO Auto-generated method stub
		float precio = 0;		
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT precio_noche FROM Habitacion WHERE ID_HABITACION =?");
			pstmt.setInt(1, idHabitacion);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
			
			while (myResultSet.next()) {
				//	System.out.println(myResultSet.getInt("id")+""+myResultSet.getString("nombre"));
					//prueba += "id: "+Integer.toString(myResultSet.getInt("id")) + "nombre: "+myResultSet.getString("nombre") ;
				precio = myResultSet.getFloat("precio_noche");
				}
			
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}

		return precio;
	}

	public String realizarReservaHotel(int idCliente, String nombreCliente, String telefonoCliente, String emailCliente, int id_subEmpresa,
			int id_reserva, int nroHabitaciones, String regimen, Date fechaReserva, int nroPersonas, int nroNoches, String estado, float totalPagar, int id_habitacion, Date fechaFactura) {
	
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("insert into CLIENTE (ID,NOMBRE,TELEFONO,EMAIL,ID_SUBEMPRESA) values (?,?,?,?,?)");
			pstmt.setInt(1, idCliente);
			pstmt.setString(2, nombreCliente);
			pstmt.setString(3, telefonoCliente);
			pstmt.setString(4, emailCliente);
			pstmt.setInt(5, id_subEmpresa);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
			
			llenarReserva(id_reserva, nroHabitaciones, regimen, id_subEmpresa, fechaReserva,  idCliente, nroPersonas,
					nroNoches, estado, totalPagar, id_habitacion, fechaFactura );
			
			return "Reserva realizada con exito";
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		
		return null;
	}

	private void llenarReserva(int id_reserva, int nroHabitaciones, String regimen, int id_subEmpresa,
			Date fechaReserva, int idCliente, int nroPersonas, int nroNoches, String estado, float totalPagar, int id_habitacion, Date fechaFactura) {
		
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("insert into RESERVA (ID_RESERVA,ID_CLIENTE,N_HABITACIONES,REGIMEN,ESTADO,FECHA,NUMERO_PERSONAS,NUMERO_NOCHES,ID_SUBEMPRESA) values (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, id_reserva);
			pstmt.setInt(2, idCliente);
			pstmt.setInt(3, nroHabitaciones);
			pstmt.setString(4, regimen);
			pstmt.setString(5, estado);
			pstmt.setDate(6, fechaReserva);
			pstmt.setInt(7, nroPersonas);
			pstmt.setInt(8, nroNoches);
			pstmt.setInt(9, id_subEmpresa);
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
		
			llenarFactura(id_habitacion, id_reserva,  totalPagar , fechaFactura);
			
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		
		
	}

	private void llenarFactura(int id_habitacion, int id_reserva,  float totalPagar, Date fechaFactura) {
		// TODO Auto-generated method stub
		
		
		Connection myConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			myConnection = DriverManager.getConnection(stringConnection, "CLIENTE", "am5589uq");
			
			PreparedStatement pstmt = myConnection.prepareStatement("insert into FACTURA_RESERVA (ID_HABITACION,ID_RESERVA,TOTAL_PAGAR,FECHA) values (?,?,?,?)");
			pstmt.setInt(1, id_habitacion);
			pstmt.setInt(2, id_reserva);
			pstmt.setFloat(3, totalPagar);
			pstmt.setDate(4, fechaFactura);
		
			ResultSet myResultSet = pstmt.executeQuery();
			//recorrer la consulta
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error en el driver, posiblemente falta la librer铆a en el proyecto, agreguela en el Build Path");
		} catch (SQLException e) {
			System.out.println("No conecta sql");
			} catch (Exception e) {
				System.out.println("No conect贸");
				e.printStackTrace();
				}
		
		
		
	}
}
