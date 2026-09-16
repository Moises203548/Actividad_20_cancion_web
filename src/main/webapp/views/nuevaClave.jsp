<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nueva Clave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Establecer Nueva Clave</h1>

<form action="${pageContext.request.contextPath}/nuevaClave" method="post">
    <input type="hidden" name="token" value="${token}">

    <label>Nueva clave:</label><br>
    <input type="password" name="clave" required><br><br>

    <button type="submit">Guardar nueva clave</button>
</form>
</body>
</html>