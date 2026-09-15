<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Gestión de Usuarios</h1>
<a href="${pageContext.request.contextPath}/usuario?accion=nuevo">+ Nuevo Usuario</a>
<a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Rol</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="u" items="${listaUsuarios}">
        <tr>
            <td>${u.id}</td>
            <td>${u.nombre}</td>
            <td>${u.email}</td>
            <td>${u.rol}</td>
            <td>
                <a href="${pageContext.request.contextPath}/usuario?accion=editar&id=${u.id}">Editar</a>
                |
                <a href="${pageContext.request.contextPath}/usuario?accion=eliminar&id=${u.id}"
                   onclick="return confirm('¿Eliminar este usuario?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>