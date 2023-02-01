<%--
  Created by IntelliJ IDEA.
  User: carolinacorcino
  Date: 07/11/22
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@page import="mx.edu.utez.contactos4b.model.DaoContacto"%>
<jsp:useBean id ="contact" class="mx.edu.utez.contactos4b.model.BeanContacto"></jsp:useBean>
<jsp:setProperty name="contact" property="*"></jsp:setProperty>
<%
    DaoContacto.delete(contact);
    response.sendRedirect("list-contacts");
%>
