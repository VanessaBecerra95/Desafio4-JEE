<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalles usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Proveedor</h1>
		<form
			class ="form"
			action="${pageContext.request.contextPath}/edicion"
			method="post">
			<input type="hidden" id="id" name="id" value="${proveedores.getId()}">
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre" value="${proveedores.getNombre()}">
			</div>
			<div class="mb-3">
				<label for="rut" class="form-label">RUT</label> <input type="text"
					class="form-control" id="rut" name="rut" value="${proveedores.getRut()}">
			</div>
			<div class="mb-3">
				<label for="direccion" class="form-label">Dirección</label> <input
					type="text" class="form-control" id="direccion" name="direccion"
					value="${proveedores.getDireccion()}">
			</div>
			<div class="mb-3">
				<label for="correo" class="form-label">Correo</label> <input
					type="email" class="form-control" id="correo" name="correo"
					value="${proveedores.getCorreo()}">
			</div>
			<div class="mb-3">
				<label for="telefono" class="form-label">Teléfono</label> <input
					type="text" class="form-control" id="telefono" name="telefono"
					value="${proveedores.getTelefono()}">
			</div>
			<div class="mb-3">
				<label for="contacto" class="form-label">Contacto</label> <input
					type="text" class="form-control" id="contacto" name="contacto"
					value="${proveedores.getContacto()}">
			</div>
			<div class="mb-3">
				<label for="telefono_contacto" class="form-label">Teléfono
					de Contacto</label> <input type="text" class="form-control"
					id="telefonoContacto" name="telefonoContacto" value="${proveedores.getTelefonoContacto()}">
			</div>
			<button type="submit" class="btn btn-primary"><i class="fa-solid fa-floppy-disk"></i>Guardar</button>
		</form>
	</div>
</body>
</html>
