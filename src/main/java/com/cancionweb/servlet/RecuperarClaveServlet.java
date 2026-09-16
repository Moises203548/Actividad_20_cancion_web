package com.cancionweb.servlet;

import com.cancionweb.dao.UsuarioDAO;
import com.cancionweb.model.Usuario;
import com.cancionweb.util.EnviarCorreo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

@WebServlet("/recuperar")
public class RecuperarClaveServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/recuperar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");

        Usuario usuario = usuarioDAO.buscarPorEmail(email);

        if (usuario != null) {
            String token = UUID.randomUUID().toString();
            long ahora = System.currentTimeMillis();
            Timestamp expiracion = new Timestamp(ahora + (30 * 60 * 1000)); // 30 minutos

            usuarioDAO.guardarTokenRecuperacion(email, token, expiracion);

            String enlace = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/nuevaClave?token=" + token;

            EnviarCorreo.enviarCorreoRecuperacion(email, enlace);

            request.setAttribute("mensaje", "Si el correo existe, se envió un enlace de recuperación.");
        } else {
            request.setAttribute("mensaje", "Si el correo existe, se envió un enlace de recuperación.");
        }

        request.getRequestDispatcher("/views/recuperar.jsp").forward(request, response);
    }
}