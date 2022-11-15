package br.com.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.Receita;
import br.com.fintech.dao.ReceitaDAO;
import br.com.fintech.factory.DAOFactory;

/**
 * Servlet implementation class ReceitaServelet
 */
@WebServlet("/receita")
public class ReceitaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReceitaDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getReceitaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int tipo = Integer.parseInt(request.getParameter("tipo"));
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataReceita = Calendar.getInstance();
			dataReceita.setTime(format.parse(request.getParameter("data")));
			
			int qtdRepeticao = Integer.parseInt(request.getParameter("repeticao"));
			String tipoRepeticao = request.getParameter("tipoRepeticao");
			
			Receita receita = new Receita(0, "", tipo, descricao, valor, dataReceita, tipoRepeticao, qtdRepeticao);
			dao.Cadastrar(receita);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}