<%@page import="mx.edu.utez.contactos4b.model.DaoContacto "%>
<jsp:useBean id="contact" class="mx.edu.utez.contactos4b.model.BeanContacto"></jsp:useBean>
<jsp:setProperty property="*" name="contact"/>
<%
    int i=DaoContacto.update(contact);
    response.sendRedirect("list-contacts");
%>
