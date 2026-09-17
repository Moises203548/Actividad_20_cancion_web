<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reportes de Usuario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Reportes de Usuario</h1>
<a href="${pageContext.request.contextPath}/usuario?accion=listar">Volver al listado</a>

<h2>Reporte 1: Usuarios por Rol</h2>
<form action="${pageContext.request.contextPath}/reporteUsuario" method="get">
    <input type="hidden" name="tipo" value="rol">
    <label>Rol:</label>
    <select name="rol">
        <option value="ADMIN">ADMIN</option>
        <option value="USER">USER</option>
    </select>
    <button type="submit">Generar reporte</button>
</form>

<h2>Reporte 2: Usuarios por Dominio de Correo</h2>
<form action="${pageContext.request.contextPath}/reporteUsuario" method="get">
    <input type="hidden" name="tipo" value="dominio">
    <label>Dominio (ej: gmail.com):</label>
    <input type="text" name="dominio" placeholder="gmail.com" required>
    <button type="submit">Generar reporte</button>
</form>

<c:if test="${not empty criterio}">
    <hr>
    <h3>Resultado — Criterio: ${criterio}</h3>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Rol</th>
        </tr>
        <c:forEach var="u" items="${resultado}">
            <tr>
                <td>${u.id}</td>
                <td>${u.nombre}</td>
                <td>${u.email}</td>
                <td>${u.rol}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty resultado}">
        <p>No se encontraron resultados para este criterio.</p>
    </c:if>
</c:if>
</body>
</html>