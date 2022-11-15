package br.com.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.DAOFactory;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioDAO dao;
		
    public LoginServelet() {
        dao = DAOFactory.getUsuarioDAO();        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(email, senha);
		
		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
					
		} else {
			request.setAttribute("erro", "Usuário e/ou senha inválido");
		}
		request.getRequestDispatcher("cadastroReceita.jsp").forward(request, response);
	}

}
