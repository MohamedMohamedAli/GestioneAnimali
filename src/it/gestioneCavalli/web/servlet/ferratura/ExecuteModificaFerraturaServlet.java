package it.gestioneCavalli.web.servlet.ferratura;

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

import it.gestioneCavalli.model.Ferratura;
import it.gestioneCavalli.service.FerraturaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteModificaFerraturaServlet
 */
@WebServlet("/eseModificaFerraturaSer")
public class ExecuteModificaFerraturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FerraturaService ferraturaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteModificaFerraturaServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		Long idFerratura = Long.parseLong(request.getParameter("idFerratura"));
		String maniscalco = request.getParameter("maniscalcoInput");
		String data = request.getParameter("dataInput");
		String tipo = request.getParameter("tipoInput");
		String prezzo = request.getParameter("prezzoInput");
		String note = request.getParameter("noteInput");

		Ferratura fer = new Ferratura();
		fer.setId(idFerratura);
		fer.setManiscalco(maniscalco);
		fer.setData(Utils.parseDate(data));
		fer.setTipo(tipo);
		fer.setPrezzo(Utils.parsePrezzo(prezzo));
		fer.setNote(note);

		ferraturaService.aggiorna(fer);
		List<Ferratura> ferrature = ferraturaService.listaConIdCavallo(idCavallo);

		request.setAttribute("listaFerratureAttr", ferrature);
		request.setAttribute("messaggioConferma", "Modifica avvenuto con successo");
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/ferratura/listaFerrature.jsp").forward(request, response);

	}

}
