package com.cancionweb.servlet;

import com.cancionweb.dao.CancionDAO;
import com.cancionweb.model.Cancion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/reporteCancion")
public class ReporteCancionServlet extends HttpServlet {

    private final CancionDAO cancionDAO = new CancionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo != null) {
            List<Cancion> resultado;

            if ("duracion".equals(tipo)) {
                int min = parseIntSeguro(request.getParameter("min"));
                int max = parseIntSeguro(request.getParameter("max"));
                resultado = cancionDAO.reportePorDuracion(min, max);
                request.setAttribute("criterio", "Duración entre " + min + "s y " + max + "s");

            } else {
                String ritmo = request.getParameter("ritmo");
                resultado = cancionDAO.reportePorRitmo(ritmo);
                request.setAttribute("criterio", "Ritmo/género contiene: " + ritmo);
            }

            request.setAttribute("resultado", resultado);
        }

        request.getRequestDispatcher("/views/cancion/reporte.jsp").forward(request, response);
    }

    private int parseIntSeguro(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            return 0;
        }
    }
}