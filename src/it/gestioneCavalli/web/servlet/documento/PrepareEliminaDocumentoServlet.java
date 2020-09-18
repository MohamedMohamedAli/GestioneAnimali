package it.gestioneCavalli.web.servlet.documento;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.model.Documento;
import it.gestioneCavalli.service.DocumentoService;

/**
 * Servlet implementation class PrepareEliminaDocumentoServlet
 */
@WebServlet("/preEliminaDocumentoSer")
public class PrepareEliminaDocumentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
	private DocumentoService documentoService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareEliminaDocumentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		Long idDocumento = Long.parseLong(request.getParameter("idDocumento"));

		Documento documento = documentoService.caricaConId(idDocumento);

		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("documentoAttr", documento);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.getRequestDispatcher("/documento/eliminaDocumento.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
