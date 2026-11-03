/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.LibroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Libro;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        LibroDAO dao = new LibroDAO();
        
        if ("eliminar".equals(accion)) {

    int id = Integer.parseInt(
        request.getParameter("id")
    );

    dao.eliminar(id);

    response.sendRedirect("LibroServlet");
    return;
}

if ("editar".equals(accion)) {

    int id = Integer.parseInt(
        request.getParameter("id")
    );

    Libro libro = dao.buscarPorId(id);

    request.setAttribute("libro", libro);

    request.getRequestDispatcher(
        "editar.jsp"
    ).forward(request, response);

    return;
}

request.setAttribute(
        "listaLibros",
        dao.listar()
);

request.getRequestDispatcher(
        "listar.jsp"
).forward(request, response);
}

           @Override
           protected void doPost(HttpServletRequest request,
                                 HttpServletResponse response)
                    throws ServletException, IOException {

               Libro libro = new Libro();

               libro.setTitulo(request.getParameter("titulo"));
               libro.setAutor(request.getParameter("autor"));
               libro.setDescripcion(request.getParameter("descripcion"));
               libro.setImagen(request.getParameter("imagen"));

               String accion = request.getParameter("accion");

LibroDAO dao = new LibroDAO();

if ("actualizar".equals(accion)) {

    libro.setId(
        Integer.parseInt(
            request.getParameter("id")
        )
    );

    dao.actualizar(libro);

} else {

    dao.insertar(libro);
}

response.sendRedirect("LibroServlet");

           }
}