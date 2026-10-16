package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	private String user = "root";
	private String psw = "admin";
	private String path = "jdbc:mysql://localhost:3306/bd_53";

	int filas;

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(path, user, psw);

			System.out.println("se conecto");
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return conexion;
	}

	public void agregar() {
		String sql = "INSERT INTO `tabla`(`id`,`nombre`,`dni`)VALUES(1,'Lautaro',12345678) , (2,'Yamile',48856758) ;";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
			filas = stnt.executeUpdate(sql);
			System.out.println(filas);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
	
	public void eliminar()
	{
		String sql = "DELETE FROM `tabla`WHERE id = 1;";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
			filas = stnt.executeUpdate(sql);
			System.out.println("se elimino");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void eliminarFiltro(String id)
	{
		String sql = "DELETE FROM `tabla`WHERE id = " + id +";";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
			filas = stnt.executeUpdate(sql);
			System.out.println("se elimino por filtro");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void actualizar()
	{
		String sql = "UPDATE `tabla` SET `nombre` = 'Rubi', `dni` = 12345678 WHERE `id` = 2;";
		Connection conexion = null;
		try {
			conexion = conectar();
			Statement stnt = conexion.createStatement();
			filas = stnt.executeUpdate(sql);
			System.out.println("se actualizo");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	

}
