package it.gestioneCavalli.web.servlet.alimentazione;

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

import it.gestioneCavalli.model.Alimentazione;
import it.gestioneCavalli.service.AlimentazioneService;

/**
 * Servlet implementation class ListaVisiteServlet
 */
@WebServlet("/listaAlimentazioneSer")
public class ListaAlimentazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AlimentazioneService alimentazioneService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaAlimentazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idAnimale = Long.parseLong(request.getParameter("idCavallo"));
		String nomeAnimale = request.getParameter("nomeCavallo"); 
		List<Alimentazione> alimentazione= alimentazioneService.listaConIdAnimale(idAnimale);
		
		request.setAttribute("listaAlimentazioneAttr", alimentazione);
		request.setAttribute("idAnimale", idAnimale);
		request.setAttribute("nomeAnimale", nomeAnimale);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/alimentazione/listaAlimentazione.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
