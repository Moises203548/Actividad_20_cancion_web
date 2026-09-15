<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cancion Web</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Proyecto Cancion Web - Unidad 1</h1>

<c:choose>
    <c:when test="${not empty sessionScope.usuarioLogueado}">
        <p>Bienvenido, ${sessionScope.nombreUsuario} (${sessionScope.rolUsuario})</p>
        <a href="${pageContext.request.contextPath}/usuario?accion=listar">Ir a Usuarios</a><br><br>
        <a href="${pageContext.request.contextPath}/cancion?accion=listar">Ir a Canciones</a><br><br>
        <a href="${pageContext.request.contextPath}/logout">Cerrar sesión</a>
    </c:when>
    <c:otherwise>
        <p>Debes iniciar sesión para continuar.</p>
        <a href="${pageContext.request.contextPath}/login">Iniciar sesión</a>
    </c:otherwise>
</c:choose>
</body>
</html>