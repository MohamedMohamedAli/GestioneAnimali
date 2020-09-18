package it.gestioneCavalli.web.servlet.vaccino;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;
import it.gestioneCavalli.service.VaccinoService;

/**
 * Servlet implementation class ExecuteCercaVaccinoServlet
 */
@WebServlet("/eseCercaVacciniSer")
public class ExecuteCercaVaccinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private VaccinoService vaccinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCercaVaccinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipoInput");
		String dataDa = request.getParameter("dataDaInput");
		String dataA = request.getParameter("dataAInput");
		
		VaccinoDTO vaccino = new VaccinoDTO(tipo, dataDa, dataA);
		
		List<Vaccino> vaccini = vaccinoService.cercaPerExample(vaccino);
		
		request.setAttribute("listaVacciniAttr", vaccini);
		request.getRequestDispatcher("/vaccino/resultCercaVaccini.jsp").forward(request, response);
	}

}
