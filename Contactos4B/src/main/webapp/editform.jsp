<%--
  Created by IntelliJ IDEA.
  User: carolinacorcino
  Date: 07/11/22
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Editar</title>
</head>
<body style="background-image:url('fondo.png'); background-repeat: no-repeat;overflow-y:hidden">
<%@page import="mx.edu.utez.contactos4b.model.BeanContacto"%>
<%@ page import="mx.edu.utez.contactos4b.model.DaoContacto" %>
<%
    String id = request.getParameter("id");
   BeanContacto contact = DaoContacto.getRecordById(Integer.parseInt(id));
%>

<div class="signupFrm">
<form action="edituser.jsp" method="post" class="form">
    <h1 class="title">Editar contacto</h1>
    <input type="hidden" name="id" value="<%=contact.getId() %>"/>
    <div class="inputContainer">
        <input type="text" name="name" value="<%=  contact.getName()%>"/>
        <label class="label">Nombre</label>
    </div>
    <div class="inputContainer">
        <input type="text" name="lastName" value="<%= contact.getLastName()%>"/>
        <label class="label">Apellido/s</label>
    </div>
    <div class="inputContainer">
        <input type="number" name="phoneNumber" value="<%= contact.getPhoneNumber()%>"/>
        <label class="label">Número de teléfono</label>
    </div>
    <div class="inputContainer">
        <input type="text" name="direction" value="<%= contact.getDirection()%>"/>
        <label class="label">Dirección</label>
    </div>
    <div class="inputContainer">
        <input type="email" name="email" value="<%= contact.getEmail()%>"/>
        <label class="label">Email</label>
    </div>
    <div class="inputContainer">
        <select name="type" value="<%= contact.getType()%>">
            <option>Personal</option>
            <option>Empresa</option>
            <option>Escolar</option>
            <option>Otro</option>
        </select>
        <label class="label">Tipo</label>
    </div>

       <input class="submitBtn" type="submit" value="Guardar cambios"/> <a href="list-contacts">Cancelar</a>

</form>
</div>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
    body {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        background-color: white;
        font-family: "lato", sans-serif;
    }
    .signupFrm {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form {
        background-color: white;
        width: 400px;
        border-radius: 8px;
        padding: 20px 40px;
        box-shadow: 0 10px 25px rgba(92, 99, 105, .2);
    }

    .title {
        font-size: 50px;
        margin-bottom: 50px;
    }
    .inputContainer {
        position: relative;
        height: 45px;
        width: 90%;
        margin-bottom: 17px;
    }
    .input {
        position: absolute;
        top: 0px;
        left: 0px;
        height: 100%;
        width: 100%;
        border: 1px solid #DADCE0;
        border-radius: 7px;
        font-size: 16px;
        padding: 0 20px;
        outline: none;
        background: none;
        z-index: 1;
    }

    /* Hide the placeholder texts (a) */

    ::placeholder {
        color: transparent;
    }
    .label {
        position: absolute;
        top: 15px;
        left: 15px;
        padding: 0 4px;
        background-color: white;
        color: #DADCE0;
        font-size: 16px;
        transition: 0.5s;
        z-index: 0;
    }
    .submitBtn {
        display: block;
        margin-left: auto;
        padding: 15px 30px;
        border: none;
        background-color: purple;
        color: white;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 30px;
    }

    .submitBtn:hover {
        background-color: #9867C5;
        transform: translateY(-2px);
    }
    .input:focus + .label {
        top: -7px;
        left: 3px;
        z-index: 10;
        font-size: 14px;
        font-weight: 600;
        color: purple;
    }
    .input:focus {
        border: 2px solid purple;
    }
    .input:not(:placeholder-shown)+ .label {
        top: -7px;
        left: 3px;
        z-index: 10;
        font-size: 14px;
        font-weight: 600;
    }
</style>
</body>
</html>

