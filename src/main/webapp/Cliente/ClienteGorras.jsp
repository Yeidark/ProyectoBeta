<%-- 
    Document   : ClienteGorras
    Created on : 26/05/2022, 05:17:03 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

    <title>Gorras</title>


    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#"><i>OHANA</i></a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="./Controlador?accion=Nuevo"><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./controladorG?accion=home"><i class="fas fa-plus-circle"></i> Ofertas del Dia</a>
                </li>                   
                <li class="nav-item">
                    <a class="nav-link" href="./Controlador?accion=carrito"><i class="fas fa-cart-plus">(<label style="color: darkorange">${cont}</label>)</i> Carrito</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="./Controlador?accion=NuevoProducto">Productos</a>
                </li> 
            </ul>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <!--<form class="form-inline my-2 my-lg-0">-->
                <input style="width:400px" class="form-control mr-sm-2" id="txtBuscar">
                <button class="btn btn-outline-info my-2 my-sm-0" id="btnBuscar"><i class="fas fa-search"></i> Buscar</button>
                <!-- </form>       -->                 
            </ul>                                
            <ul class="navbar-nav btn-group my-2 my-lg-0" role="group">
                <a style="color: white; cursor: pointer" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fas fa-user-tie"></i> ${logueo}</a>
                <div class="dropdown-menu text-center dropdown-menu-right">
                    <a class="dropdown-item" href="#"><img src="img/user.png" alt="60" height="60"/></a>                        
                    <a class="dropdown-item" href="#">${user}</a>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal">${correo}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Controlador?accion=MisCompras">Mis Compras</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="./Controlador?accion=Salir"> <i class="fas fa-arrow-right"> Salir</i></a>                        
                </div>
            </ul>     
        </div>
    </nav>
    <br>
    <br>
    <div class="container mt2">
        <div class="row">
            <c:forEach var="p" items="${productos}">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header"><label>Nombre Producto</label></div>
                        <div class="card-body"><i>$56.000</i>
                            <img src="" width="200" height="180"></div>
                        <div class="card-footer text-center"><label>Descripcion del producto</label>
                            <div>
                                <a href="" class="btn btn-outline-info">Agregar al carrito</a>
                                <a href="" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>




    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="pv/js/funciones.js" type="text/javascript"></script>




</html>
