<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Iniciar Sesión</h1>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Correo:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Clave:</label><br>
    <input type="password" name="clave" required><br><br>

    <button type="submit">Ingresar</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/recuperar">¿Olvidaste tu clave?</a>
</body>
</html>