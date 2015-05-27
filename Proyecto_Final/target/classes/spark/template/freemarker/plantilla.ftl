<#macro page_head>
<title>Base Template</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="/css/styles.css">
</#macro>

<#macro content>
<p>Contenido base</p>
</#macro>

<#macro barra_nav>
<div class="navbar-inner">
  <ul class="nav">

    <li class="active"><a href="/"><i class="icon-th icon-black"></i>Lista</a></li>
    <li ><a href="/form"><i class="icon-plus-sign icon-black"></i>Crear</a></li>

  </ul>
</div>
</#macro>


<#macro display_page>
<!DOCTYPE html>
<html>
<head>
  <@page_head/>
</head>

<body>


    <div class="navbar">
      <@barra_nav/>
    </div>

    <div class="content">     
     <@content/>
   </div>        


   <div class="footer">
    <p>Página creada por Fer</p>
  </div>

</body>

</html>
</#macro>