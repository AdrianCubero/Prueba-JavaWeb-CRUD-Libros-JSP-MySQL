<%-- 
    Document   : editar
    Created on : Nov 1, 2026, 11:47:07 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Libro"%>

<%
Libro libro = (Libro) request.getAttribute("libro");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Libro</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container mt-4">

<h1>Editar Libro</h1>

<form action="LibroServlet" method="post">

    <input type="hidden"
           name="id"
           value="<%= libro.getId() %>">

    <input type="hidden"
           name="accion"
           value="actualizar">

    <div class="mb-3">
        <label>Titulo</label>
        <input type="text"
               name="titulo"
               class="form-control"
               value="<%= libro.getTitulo() %>">
    </div>

    <div class="mb-3">
        <label>Autor</label>
        <input type="text"
               name="autor"
               class="form-control"
               value="<%= libro.getAutor() %>">
    </div>

    <div class="mb-3">
        <label>Descripcion</label>
        <textarea name="descripcion"
                  class="form-control"><%= libro.getDescripcion() %></textarea>
    </div>

    <div class="mb-3">
        <label>Imagen</label>
        <input type="text"
               name="imagen"
               class="form-control"
               value="<%= libro.getImagen() %>">
    </div>

    <button type="submit"
            class="btn btn-success">
        Actualizar
    </button>

</form>

</div>

</body>
</html>
