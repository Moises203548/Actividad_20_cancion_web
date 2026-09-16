<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recuperar Clave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Recuperar Clave</h1>

<c:if test="${not empty mensaje}">
    <p style="color:green;">${mensaje}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/recuperar" method="post">
    <label>Ingresa tu correo registrado:</label><br>
    <input type="email" name="email" required><br><br>
    <button type="submit">Enviar enlace de recuperación</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/login">Volver al login</a>
</body>
</html>