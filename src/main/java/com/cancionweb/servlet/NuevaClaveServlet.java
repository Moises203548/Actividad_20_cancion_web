package com.cancionweb.servlet;

import com.cancionweb.dao.UsuarioDAO;
import com.cancionweb.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/nuevaClave")
public class NuevaClaveServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = request.getParameter("token");
        Usuario usuario = usuarioDAO.buscarPorToken(token);

        if (usuario == null || usuarioDAO.tokenExpirado(token)) {
            request.setAttribute("error", "El enlace no es válido o ha expirado. Solicita uno nuevo.");
            request.getRequestDispatcher("/views/recuperar.jsp").forward(request, response);
            return;
        }

        request.setAttribute("token", token);
        request.getRequestDispatcher("/views/nuevaClave.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String token = request.getParameter("token");
        String nuevaClave = request.getParameter("clave");

        Usuario usuario = usuarioDAO.buscarPorToken(token);

        if (usuario == null || usuarioDAO.tokenExpirado(token)) {
            request.setAttribute("error", "El enlace no es válido o ha expirado.");
            request.getRequestDispatcher("/views/recuperar.jsp").forward(request, response);
            return;
        }

        usuarioDAO.cambiarClave(usuario.getId(), nuevaClave);

        request.setAttribute("mensaje", "Clave actualizada correctamente. Ya puedes iniciar sesión.");
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }
}