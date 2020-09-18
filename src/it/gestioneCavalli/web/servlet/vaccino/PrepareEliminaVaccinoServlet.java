package it.gestioneCavalli.web.servlet.vaccino;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.model.Vaccino;
import it.gestioneCavalli.service.VaccinoService;

/**
 * Servlet implementation class PrepareEliminaVaccinoServlet
 */
@WebServlet("/preEliminaVaccinoSer")
public class PrepareEliminaVaccinoServlet extends HttpServlet {
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
    public PrepareEliminaVaccinoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		Long idVaccino = Long.parseLong(request.getParameter("idVaccino"));

		Vaccino vaccino = vaccinoService.caricaConId(idVaccino);

		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("vaccinoAttr", vaccino);
		request.getRequestDispatcher("/vaccino/eliminaVaccino.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
