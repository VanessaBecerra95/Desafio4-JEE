package cl.praxis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedoresDAOImpl;
import cl.praxis.model.dto.Proveedores;
import cl.praxis.model.dao.ProveedoresDAO;

@WebServlet("/index")
public class ProveedoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProveedoresController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProveedoresDAO pDAO = new ProveedoresDAOImpl();
		List<Proveedores> proveedores = pDAO.read();
		request.setAttribute("proveedores", proveedores);
		getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
