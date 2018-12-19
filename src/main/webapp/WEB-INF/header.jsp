<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
	
<div class= "row">
<!-- Navbar -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">

      <!-- Brand -->
      <a class="navbar-brand waves-effect" href="https://mdbootstrap.com/material-design-for-bootstrap/" target="_blank">
        <strong class="blue-text">Auto Portaria</strong>
      </a>

      <!-- Collapse -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <!-- Left -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link waves-effect" href="${path }/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLinkCondominio" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="true">Condomínio</a>
            
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLinkCondominio">   
     		   <a class="dropdown-item" href="#">Apartamentos</a>
     		   <a class="dropdown-item" href="#">Moradores</a>
     		   <a class="dropdown-item" href="#">Veículos</a>
    	    </div>
            
          </li>
          
           <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLinkFinanceiro" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="true">Financeiro</a>
                  
            	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLinkFinanceiro">
            		<a class="dropdown-item" href="#">Taxa do Condomino</a>
            		<a class="dropdown-item" href="#">Contas a Pagar</a>
            	</div>
           </li>
          
        </ul>

        <!-- Right -->
        <ul class="navbar-nav nav-flex-icons">
          
          <li class="nav-item">
            <a href="https://github.com/mdbootstrap/bootstrap-material-design" class="nav-link border border-light rounded waves-effect"
              target="_blank">
              <i class="fa fa-github mr-2"></i>MDB GitHub
            </a>
          </li>
        </ul>

      </div>

    </div>
  </nav>
  <!-- Navbar -->
  <!-- SideBar -->
  <div class="sidebar-fixed position-fixed">
  	<a class="logo-wrapper waves-effect">
  		<img class="img-fluid" alt src="#"/>
  	</a>
  	
  	<div class="list-group list-group-flush">
  		<a class="list-group-item active waves-effect" href="#">Home</a>
  		<a class="list-group-item list-group-item-action waves-effect" href="#">Condominio</a>
  	</div>
  </div>
  <!-- SideBar -->
</div>