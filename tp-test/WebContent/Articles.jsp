<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <title>Article trouvé</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex
        }
    </style>
</head>
<body  style="padding-left: 100px; padding-top: 100px; padding-right: 100px">
<img src="logo.jpeg" >
<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link bg-light text-secondary" style=" font-size: 30px; text-decoration: none; " href="RechercheArticle.jsp">Accueil &nbsp;&nbsp;</a></li>
        <li class="nav-item"><a class="nav-link bg-light text-secondary" style=" font-size: 30px; text-decoration: none; "  href="#news">Présentation &nbsp;&nbsp;</a></li>
        <li class="nav-item"><a class="nav-link bg-light text-secondary" style=" font-size: 30px; text-decoration: none; "  href="ListerArticles">Nos Articles&nbsp;&nbsp;</a></li>
        <li class="nav-item"><a class="nav-link bg-light text-secondary" style=" font-size: 30px; text-decoration: none; "  href="#about">Contactez nous&nbsp;&nbsp;</a></li>
    </ul>
</nav>
<br><br>
<h3>Articles trouvé </h3>

<table class="table" border="1" width="80%">
    <tr>
        <th>Code</th> <th>Nom</th><th>Description</th><th>Prix</th> <th>Quantite</th> <th> </th>
    </tr>
    <c:forEach items="${articles}" var="p">
        <tr>
            <td>${p.code}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.price}</td>
            <td>${p.qte}</td>
            <td><a href="#panier">Ajouter au panier</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>