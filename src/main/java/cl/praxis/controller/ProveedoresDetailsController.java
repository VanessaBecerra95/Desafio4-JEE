package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedoresDAOImpl;
import cl.praxis.model.dto.Proveedores;
import cl.praxis.model.dao.ProveedoresDAO;

@WebServlet("/edicion")
public class ProveedoresDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProveedoresDetailsController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		String StrId = request.getParameter("id");

		int id = 0;

		if (StrId != null) {
			try {
				id = Integer.parseInt(StrId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
				return;
			}
		}
		try {
			if (id > 0 && op == null) {
				ProveedoresDAOImpl pDAO = new ProveedoresDAOImpl();
				Proveedores p = pDAO.read(id);

				request.setAttribute("proveedores", p);

				getServletContext().getRequestDispatcher("/views/edicion.jsp").forward(request, response);
			} else if (id == 0) {
				getServletContext().getRequestDispatcher("/views/edicion.jsp").forward(request, response);
			} else if (op.equalsIgnoreCase("del")) {
				ProveedoresDAOImpl pDAO = new ProveedoresDAOImpl();
				pDAO.delete(id);

				response.sendRedirect(request.getContextPath() + "/index");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String rut = request.getParameter("rut");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		String telefonoContacto = request.getParameter("telefonoContacto");

		if (nombre == null || nombre.isEmpty() || rut == null || rut.isEmpty() || direccion == null
				|| direccion.isEmpty() || correo == null || correo.isEmpty() || telefono == null || telefono.isEmpty()
				|| contacto == null || contacto.isEmpty() || telefonoContacto == null || telefonoContacto.isEmpty()) {
			response.sendRedirect("views/error.jsp");
			return;
		}

		Proveedores p = null;
		ProveedoresDAO pDAO = new ProveedoresDAOImpl();

		try {
			if (!strId.isEmpty()) {
				int id = Integer.parseInt(strId);

				p = new Proveedores(id, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
				pDAO.update(p);
			} else {
				p = new Proveedores();
				p.setNombre(nombre);
				p.setRut(rut);
				p.setDireccion(direccion);
				p.setCorreo(correo);
				p.setTelefono(telefono);
				p.setContacto(contacto);
				p.setTelefonoContacto(telefonoContacto);

				pDAO.create(p);
			}
			response.sendRedirect(request.getContextPath() + "/index");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}

}
