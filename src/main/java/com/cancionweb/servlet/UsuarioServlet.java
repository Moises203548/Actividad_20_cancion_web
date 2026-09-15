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

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "nuevo":
                request.getRequestDispatcher("/views/usuario/formulario.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = usuarioDAO.buscarPorId(idEditar);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/views/usuario/formulario.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                usuarioDAO.eliminar(idEliminar);
                response.sendRedirect("usuario?accion=listar");
                break;

            case "listar":
            default:
                List<Usuario> lista = usuarioDAO.listarTodos();
                request.setAttribute("listaUsuarios", lista);
                request.getRequestDispatcher("/views/usuario/listar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String clave = request.getParameter("clave");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setClave(clave);
        usuario.setRol(rol);

        if (idParam == null || idParam.isEmpty()) {
            usuarioDAO.crear(usuario);
        } else {
            usuario.setId(Integer.parseInt(idParam));
            usuarioDAO.actualizar(usuario);
        }

        response.sendRedirect("usuario?accion=listar");
    }
}