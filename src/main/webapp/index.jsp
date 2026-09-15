<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cancion Web</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Proyecto Cancion Web</h1>
<a href="${pageContext.request.contextPath}/usuario?accion=listar">Ir a Usuarios</a><br><br>
<a href="${pageContext.request.contextPath}/cancion?accion=listar">Ir a Canciones</a>
</body>
</html>