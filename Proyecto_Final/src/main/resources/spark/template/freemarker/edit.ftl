<#include "plantilla.ftl">

<#macro content>

<form class="form-horizontal" name="track" action="track/edit/${track.id}" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="nombre" value="${track.nombre}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Autor</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="autor" value="${track.autor}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Album</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="album" value="${track.album}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Duración</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="duracion" value="${track.duracion}">
		</div>

		<div class="form-group">

		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Actualizar</button>
			</div>
		</div>
	</form>


	</#macro>



	<@display_page/>