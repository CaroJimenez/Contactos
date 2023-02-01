<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
String letters =request.getParameter("letters");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Contactos 4B</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body style="background-image:url('fondo.png'); background-repeat: no-repeat; overflow-y:hidden">
<h1 style="text-align: center"><%=" Lista de contactos "%>
</h1>
<br/>
<br>
<br>

<section class="ftco-section">

    <div class="container">

        <div class="row justify-content-center" style="margin-top: -100px;">
            <div class="col-md-6 text-center mb-5">

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-wrap">
                    <div class="">
                        <a href="register.jsp" class="btn btn-success" id="abrir"
                           style="margin-left: 900px;">Agregar nuevo contacto</a>

                        </td>

                        <div class="navbar">
                            <form action="search" method="post" class="form-inline">
                                <input type="search" name="txtBuscar" class="form-control">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-success">
                            </form>
                        </div>

                    </div>

                    <td>

                        <br>
                        <br>
                        <table class="table table-bordered" style="background: white">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Apellido(s)</th>
                                <th>Número</th>
                                <th>Email</th>
                                <th style="text-align: center">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${list}" var="contacto" varStatus="index">
                                <tr>
                                    <td><c:out value="${index.count}"/></td>
                                    <td><c:out value="${contacto.name}"/></td>
                                    <td><c:out value="${contacto.lastName}"/> </td>
                                    <td><c:out value="${contacto.phoneNumber}"/> </td>
                                    <td><c:out value="${contacto.email}"/> </td>
                                    <td style="text-align: center"><a href="editform.jsp?id=${contacto.getId()}" class="btn btn-warning">Editar</a>
                                        <a href="deleteuser.jsp?id=${contacto.getId()}" class="btn btn-danger" style="margin-left: 20px;">Eliminar</a></td>
                                </tr>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                </div>
            </div>
        </div>
    </div>
</section>

</table>
<a href="list-contacts" style="color: white; text-align: center">Todos los contactos</a>
</body>
</html>
<script src="fun.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/d35d510498.js" crossorigin="anonymous"></script>