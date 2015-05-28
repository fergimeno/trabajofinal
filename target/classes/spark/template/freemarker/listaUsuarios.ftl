<#include "plantilla.ftl">

<#macro content>

<table class="table table-hover">
	<thead>
		<tr>

			<th>Nombre</th>  <th>Autor</th> <th>Album</th> <th>Link</th> <th>Acciones</th>

		</tr>
	</thead>
	<tbody>
		<#list tracks as track>
		<tr>
			<td>${track.nombre}</td> <td>${track.autor}</td> <td>${track.album}</td> <td><a href="${track.link}" target="_blank">Escuchar</a></td>    
			<td>
			  <a href="track/delete/${track.id}" class="btn btn-default btn-xs">Borrar</a>  
			  <a href="edit/${track.id}" class="btn btn-default btn-xs">Editar</a>
			</td>
		</tr>
		</#list>
	</tbody>
</table>

</#macro>



<@display_page/>