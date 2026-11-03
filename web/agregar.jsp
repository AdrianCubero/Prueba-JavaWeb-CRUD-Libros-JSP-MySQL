<%-- 
    Document   : agregar
    Created on : Nov 1, 2026, 10:45:50 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Libro</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container mt-4">

    <h1>Agregar Libro</h1>

    <form action="LibroServlet" method="post">

        <div class="mb-3">
            <label>Titulo</label>
            <input type="text" name="titulo"
                   class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Autor</label>
            <input type="text" name="autor"
                   class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Descripcion</label>
            <textarea name="descripcion"
                      class="form-control"></textarea>
        </div>

        <div class="mb-3">
            <label>Imagen (URL o ruta)</label>
            <input type="text" name="imagen"
                   class="form-control" required>
        </div>

        <button type="submit"
                class="btn btn-success">
            Guardar
        </button>

        <a href="LibroServlet"
           class="btn btn-secondary">
           Volver
        </a>

    </form>

</div>

</body>
</html>