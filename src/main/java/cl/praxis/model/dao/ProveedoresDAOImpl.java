package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.conexion.Conexion;
import cl.praxis.model.dto.Proveedores;

/*
 * C = create - crear
 * R = read - leer
 * U = update - actualizar
 * D = delete - borrar
 */

public class ProveedoresDAOImpl implements ProveedoresDAO {

	@Override
	public void create(Proveedores p) {
		String sql = "insert into proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) values ('"
				+ p.getNombre() + "', '" + p.getRut() + "', '" + p.getDireccion() + "', '" + p.getCorreo() + "', '"
				+ p.getTelefono() + "', '" + p.getContacto() + "', '" + p.getTelefonoContacto() + "')";
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			System.out.println("ERROR en método create()");
			e.printStackTrace();
		}
	}

	@Override
	public Proveedores read(int id) {
		Proveedores p = null;

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto from proveedores where id = "
					+ id;

			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				p = new Proveedores(rs.getInt("id"), rs.getString("nombre"), rs.getString("rut"),
						rs.getString("direccion"), rs.getString("correo"), rs.getString("telefono"),
						rs.getString("contacto"), rs.getString("telefono_contacto"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR en método read(id)");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Proveedores> read() {

		List<Proveedores> proveedores = new ArrayList<Proveedores>();

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto from proveedores";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				proveedores.add(new Proveedores(rs.getInt("id"), rs.getString("nombre"), rs.getString("rut"),
						rs.getString("direccion"), rs.getString("correo"), rs.getString("telefono"),
						rs.getString("contacto"), rs.getString("telefono_contacto")));

			}

		} catch (SQLException e) {
			System.out.println("ERROR en método read()");
			e.printStackTrace();

		}
		return proveedores;
	}

	@Override
	public void update(Proveedores p) {
		String sql = "update proveedores set nombre = '" + p.getNombre() + "', rut = '" + p.getRut()
				+ "', direccion = '" + p.getDireccion() + "', correo = '" + p.getCorreo() + "', telefono = '"
				+ p.getTelefono() + "', contacto = '" + p.getContacto() + "', telefono_contacto = '"
				+ p.getTelefonoContacto() + "' where id = " + p.getId();
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error en el método update()");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from proveedores where id = " + id;
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error en el método update()");
			e.printStackTrace();
		}
	}

}
