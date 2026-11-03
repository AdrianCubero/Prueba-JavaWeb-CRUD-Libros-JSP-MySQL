<%-- 
    Document   : listar
    Created on : Oct 31, 2026, 3:39:13 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Libro"%>

<!DOCTYPE html>
<html>
<head>

<title>Libros</title> 

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>
<body>

<div class="container mt-4">

<h1 class="text-center">
Biblioteca
</h1>

<div class="row">

<%
List<Libro> lista =
(List<Libro>) request.getAttribute("listaLibros");

if(lista != null){

for(Libro libro : lista){
%>

<div class="col-md-4">

<div class="card mb-3">

<img src="<%= libro.getImagen() %>"
     class="card-img-top"
     height="250">

<div class="card-body">

<h5 class="card-title">
<%= libro.getTitulo() %>
</h5>

<p>
Autor:
<%= libro.getAutor() %>
</p>

<p>
<%= libro.getDescripcion() %>
</p>

<a href="LibroServlet?accion=editar&id=<%= libro.getId() %>"
   class="btn btn-warning">
   Editar
</a>

<a href="LibroServlet?accion=eliminar&id=<%= libro.getId() %>"
   class="btn btn-danger">
   Eliminar
</a>

</div>

</div>

</div>

<%
}
}
%>

</div>

</div>

</body>
</html>
