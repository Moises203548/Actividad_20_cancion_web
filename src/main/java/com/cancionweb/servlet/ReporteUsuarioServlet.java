package com.cancionweb.servlet;

import com.cancionweb.dao.UsuarioDAO;
import com.cancionweb.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/reporteUsuario")
public class ReporteUsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo != null) {
            List<Usuario> resultado;

            if ("rol".equals(tipo)) {
                String rol = request.getParameter("rol");
                resultado = usuarioDAO.reportePorRol(rol);
                request.setAttribute("criterio", "Rol = " + rol);

            } else {
                String dominio = request.getParameter("dominio");
                resultado = usuarioDAO.reportePorDominioCorreo(dominio);
                request.setAttribute("criterio", "Dominio de correo = " + dominio);
            }

            request.setAttribute("resultado", resultado);
        }

        request.getRequestDispatcher("/views/usuario/reporte.jsp").forward(request, response);
    }
}