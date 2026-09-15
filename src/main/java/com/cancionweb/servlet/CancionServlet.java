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

@WebServlet("/cancion")
public class CancionServlet extends HttpServlet {

    private final CancionDAO cancionDAO = new CancionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "nuevo":
                request.getRequestDispatcher("/views/cancion/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Cancion cancion = cancionDAO.buscarPorId(idEditar);
                request.setAttribute("cancion", cancion);
                request.getRequestDispatcher("/views/cancion/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                cancionDAO.eliminar(idEliminar);
                response.sendRedirect("cancion?accion=listar");
                break;

            case "listar":
            default:
                List<Cancion> lista = cancionDAO.listarTodos();
                request.setAttribute("listaCanciones", lista);
                request.getRequestDispatcher("/views/cancion/listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");

        Cancion cancion = new Cancion();
        cancion.setNombre(request.getParameter("nombre"));
        cancion.setRitmo(request.getParameter("ritmo"));
        cancion.setDuracion(parseIntSeguro(request.getParameter("duracion")));
        cancion.setAlbum(request.getParameter("album"));
        cancion.setPosicionEnAlbum(parseIntSeguro(request.getParameter("posicionEnAlbum")));
        cancion.setBanda(request.getParameter("banda"));
        cancion.setInterprete(request.getParameter("interprete"));
        cancion.setAutor(request.getParameter("autor"));
        cancion.setFechaLanzamiento(request.getParameter("fechaLanzamiento"));

        if (idParam == null || idParam.isEmpty()) {
            cancionDAO.crear(cancion);
        } else {
            cancion.setId(Integer.parseInt(idParam));
            cancionDAO.actualizar(cancion);
        }

        response.sendRedirect("cancion?accion=listar");
    }

    private int parseIntSeguro(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            return 0;
        }
    }
}