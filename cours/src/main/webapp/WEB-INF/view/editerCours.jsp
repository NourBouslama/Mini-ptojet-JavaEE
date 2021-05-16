<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

<title>Modifier un Cours</title>
</head>
<body>

<div class="container mt-5">
<div class="card-body">
<form action="updateCours" method="post">
 <div class="form-group">
 <label class="control-label">numero Cours :</label>
 <input type="text" name="numC" value="${produit.numC}" readonly class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">libelle cours :</label>
 <input type="text" name="libC" value="${produit.libC}"
class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">duree cours :</label>
 <input type="text" name="duree" value="${produit.duree}"
class="form-control"/>
 </div> 
 <div class="form-group">
 <label class="control-label"> Date Cours :</label>
 <fmt:formatDate pattern="yyyy-MM-dd" value="${produit.dateC}" var="formatDate" />
 <input type="date" name="date" value="${formatDate}" class="form-control"/>
  </div>
 <div>
 <button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
<br/>
<br/>
<a href="ListeCours">Liste Cours</a>
</div>
 
</body>
</html>