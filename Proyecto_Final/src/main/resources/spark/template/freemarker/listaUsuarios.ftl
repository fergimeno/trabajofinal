<#include "plantilla.ftl">

<#macro content>

<table class="table table-hover">
	<thead>
		<tr>

			<th>Nombre</th>  <th>Autor</th> <th>Album</th> <th>Duración</th> <th>Acciones</th>

		</tr>
	</thead>
	<tbody>
		<#list tracks as track>
		<tr>
			<td>${track.nombre}</td> <td>${track.autor}</td> <td>${track.album}</td> <td>${track.duracion}</td>    <td>Accion</td>
		</tr>
		</#list>
	</tbody>
</table>

</#macro>



<@display_page/>