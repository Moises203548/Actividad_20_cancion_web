<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reportes de Cancion</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Reportes de Cancion</h1>
<a href="${pageContext.request.contextPath}/cancion?accion=listar">Volver al listado</a>

<h2>Reporte 1: Canciones por Rango de Duración</h2>
<form action="${pageContext.request.contextPath}/reporteCancion" method="get">
    <input type="hidden" name="tipo" value="duracion">
    <label>Duración mínima (segundos):</label>
    <input type="number" name="min" value="0" required><br><br>
    <label>Duración máxima (segundos):</label>
    <input type="number" name="max" value="400" required><br><br>
    <button type="submit">Generar reporte</button>
</form>

<h2>Reporte 2: Canciones por Ritmo/Género</h2>
<form action="${pageContext.request.contextPath}/reporteCancion" method="get">
    <input type="hidden" name="tipo" value="ritmo">
    <label>Ritmo/género:</label>
    <input type="text" name="ritmo" placeholder="Rock, Pop, Reggaeton..." required>
    <button type="submit">Generar reporte</button>
</form>

<c:if test="${not empty criterio}">
    <hr>
    <h3>Resultado — Criterio: ${criterio}</h3>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Ritmo</th>
            <th>Duración (s)</th>
            <th>Álbum</th>
            <th>Intérprete</th>
        </tr>
        <c:forEach var="c" items="${resultado}">
            <tr>
                <td>${c.id}</td>
                <td>${c.nombre}</td>
                <td>${c.ritmo}</td>
                <td>${c.duracion}</td>
                <td>${c.album}</td>
                <td>${c.interprete}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty resultado}">
        <p>No se encontraron resultados para este criterio.</p>
    </c:if>
</c:if>
</body>
</html>