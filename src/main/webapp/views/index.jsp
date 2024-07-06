<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Proveedores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css"
	rel="stylesheet">
</head>
<jsp:include page="./header.jsp"></jsp:include>
<body class="d-flex flex-column min-vh-100">
	<div class="ms-auto">
		<a href="${pageContext.request.contextPath}/edicion"
			class="btn btn-primary"><i class="fa-solid fa-plus"></i> Nuevo
			proveedor</a>
	</div>
	<main class="flex-fill">
		<div class="container">
			<h1 class="py-5 text-center">Listado de proveedores</h1>

			<table class="table border" id="tblProveedores">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Rut</th>
						<th>Direccion</th>
						<th>Correo</th>
						<th>Telefono</th>
						<th>Contacto</th>
						<th>Telefono contacto</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${proveedores}">
						<tr>
							<th><c:out value="${p.getId()}"></c:out></th>
							<td><c:out value="${p.getNombre()}"></c:out></td>
							<td><c:out value="${p.getRut()}"></c:out></td>
							<th><c:out value="${p.getDireccion()}"></c:out></th>
							<td><c:out value="${p.getCorreo()}"></c:out></td>
							<td><c:out value="${p.getTelefono()}"></c:out></td>
							<td><c:out value="${p.getContacto()}"></c:out></td>
							<td><c:out value="${p.getTelefonoContacto()}"></c:out></td>
							<td><a
								href="${pageContext.request.contextPath}/edicion?id=${p.getId()}"
								class="btn btn-secondary"><i
									class="fa-solid fa-pen-to-square"></i></a> <a
								href="${pageContext.request.contextPath}/edicion?id=${p.getId()}&op=del"
								class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<jsp:include page="./footer.jsp"></jsp:include>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>

	<script>$(document).ready(()=>{
			$('#tblProveedores').DataTable();})
	</script>

	<script src="https://kit.fontawesome.com/b5bbcbce64.js"
		crossorigin="anonymous"></script>

</body>
</html>