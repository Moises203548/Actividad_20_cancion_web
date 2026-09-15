<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Canciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Gestión de Canciones</h1>
<a href="${pageContext.request.contextPath}/cancion?accion=nuevo">+ Nueva Cancion</a>
<a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Ritmo</th>
        <th>Duración (s)</th>
        <th>Álbum</th>
        <th>Banda</th>
        <th>Intérprete</th>
        <th>Autor</th>
        <th>Fecha Lanzamiento</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="c" items="${listaCanciones}">
        <tr>
            <td>${c.id}</td>
            <td>${c.nombre}</td>
            <td>${c.ritmo}</td>
            <td>${c.duracion}</td>
            <td>${c.album}</td>
            <td>${c.banda}</td>
            <td>${c.interprete}</td>
            <td>${c.autor}</td>
            <td>${c.fechaLanzamiento}</td>
            <td>
                <a href="${pageContext.request.contextPath}/cancion?accion=editar&id=${c.id}">Editar</a>
                |
                <a href="${pageContext.request.contextPath}/cancion?accion=eliminar&id=${c.id}"
                   onclick="return confirm('¿Eliminar esta canción?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>