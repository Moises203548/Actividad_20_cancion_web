<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Usuario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>${usuario != null ? 'Editar Usuario' : 'Nuevo Usuario'}</h1>

<form action="${pageContext.request.contextPath}/usuario" method="post">
    <input type="hidden" name="id" value="${usuario.id}">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" value="${usuario.nombre}" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="${usuario.email}" required><br><br>

    <label>Clave:</label><br>
    <input type="password" name="clave" value="${usuario.clave}" required><br><br>

    <label>Rol:</label><br>
    <select name="rol">
        <option value="ADMIN" ${usuario.rol == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
        <option value="USER" ${usuario.rol == 'USER' ? 'selected' : ''}>USER</option>
    </select><br><br>

    <button type="submit">Guardar</button>
    <a href="${pageContext.request.contextPath}/usuario?accion=listar">Cancelar</a>
</form>
</body>
</html>