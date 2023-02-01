package mx.edu.utez.contactos4b.controller;

import mx.edu.utez.contactos4b.listas.ListaCircular;
import mx.edu.utez.contactos4b.model.BeanContacto;
import mx.edu.utez.contactos4b.model.DaoContacto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(
        name = "Servlet",
        urlPatterns = {
                "/list-contacts",
                "/register",
                "/delete",
                "/search"
        })
public class Servlet extends HttpServlet {
    private DaoContacto daoUser = new DaoContacto();
    private BeanContacto beanContacto = new BeanContacto();
    private static String LIST_USER = "/list-contactos.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getServletPath();
        String forward="";
        switch (option) {
            case "/list-contacts":
               Service service = new Service();
                List<BeanContacto> listContactos = service.getContactos();
                request.setAttribute("list", listContactos);
                request.getRequestDispatcher("/WEB-INF/view/list-contacts.jsp").forward(request,response);
                break;
            case "/delete":
                int userId =
                        Integer.parseInt(request.getParameter("id"));
                //daoUser.deleteUser(userId);
                forward = LIST_USER;
                request.setAttribute("contacto", daoUser.getContactos());
                break;

    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getServletPath();
        switch (option) {
            case "/register":
                String nombre = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                String phoneNumber = request.getParameter("phoneNumber");
                String direction = request.getParameter("direction");
                String email = request.getParameter("email");
                String type = request.getParameter("type");
                BeanContacto beanUser = new BeanContacto();

                beanUser.setName(nombre);
                beanUser.setLastName(lastName);
                beanUser.setPhoneNumber(phoneNumber);
                beanUser.setDirection(direction);
                beanUser.setEmail(email);
                beanUser.setType(type);
                try{
                    daoUser.registerUser(beanUser);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("list-contacts");
                break;
            case "/search":
                String dato= request.getParameter("txtBuscar");
                List<BeanContacto>lista = daoUser.buscar(dato);
                request.setAttribute("list", lista);
                request.getRequestDispatcher("/WEB-INF/view/list-contacts.jsp").forward(request,response);
                break;

        }
    }
}
