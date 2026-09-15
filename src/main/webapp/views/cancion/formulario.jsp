<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Cancion</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>${cancion != null ? 'Editar Cancion' : 'Nueva Cancion'}</h1>

<form action="${pageContext.request.contextPath}/cancion" method="post">
    <input type="hidden" name="id" value="${cancion.id}">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" value="${cancion.nombre}" required><br><br>

    <label>Ritmo/Género:</label><br>
    <input type="text" name="ritmo" value="${cancion.ritmo}"><br><br>

    <label>Duración (segundos):</label><br>
    <input type="number" name="duracion" value="${cancion.duracion}"><br><br>

    <label>Álbum:</label><br>
    <input type="text" name="album" value="${cancion.album}"><br><br>

    <label>Posición en el álbum:</label><br>
    <input type="number" name="posicionEnAlbum" value="${cancion.posicionEnAlbum}"><br><br>

    <label>Banda:</label><br>
    <input type="text" name="banda" value="${cancion.banda}"><br><br>

    <label>Intérprete:</label><br>
    <input type="text" name="interprete" value="${cancion.interprete}"><br><br>

    <label>Autor:</label><br>
    <input type="text" name="autor" value="${cancion.autor}"><br><br>

    <label>Fecha de lanzamiento:</label><br>
    <input type="date" name="fechaLanzamiento" value="${cancion.fechaLanzamiento}"><br><br>

    <button type="submit">Guardar</button>
    <a href="${pageContext.request.contextPath}/cancion?accion=listar">Cancelar</a>
</form>
</body>
</html>