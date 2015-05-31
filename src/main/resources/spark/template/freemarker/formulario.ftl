<#include "plantilla.ftl">

<#macro content>

<form class="form-horizontal" name="track" action="track/create" method="post">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Nombre</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="nombre" placeholder="Nombre">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Autor</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="autor" placeholder="Autor">
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Album</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="album" placeholder="Album">
		</div>
	</div>
		<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Link</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="link" placeholder="Link">
		</div>

	<div class="form-group">

	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Crear</button>
		</div>
	</div>
</form>


</#macro>



<@display_page/>