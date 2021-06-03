<%@page import="java.util.ArrayList"%>
<%@page import="cl.Inacap.Odiseo.DTO.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<Libro> arrLibro=new ArrayList<Libro>();


%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de libros</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<style>
    .border{
       border: 1px solid #000 !important;   
       min-height:20px;
       margin-bottom: 20px;
    }
  
    .col-centered{
        float: none;
        margin: 0 auto;
    }

</style> 
<body>


    <div class="container" style="margin-top: 20px;">

        <div class="row">
            <div class="col-12 text-center">
                <h1>Lista de libros</h1>
            </div>
        </div>


        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-striped" id="myTable">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Autor</th>
                            <th>Páginas</th>
                            <th>Destacado</th>
                            <th>Portada</th>
                            <th>Estrellas</th>
                            <th>Categoría</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                    	<c:forEach items="${ListaLibros}" var="o" varStatus="ciclo">
                        <tr>
                            <td>${o.nombre }</td>
                            <td>${o.autor }</td>
                            <td>${o.paginas }</td>
                            <td>${o.destacado}</td>
                            <td>${o.portada }</td>
                            <td>${o.estrellas}</td>
                            <td>${o.categoria}</td>
                            <td class="text-center"><a class="btn btn-sm btn-success" href="EditLibro.do?Iden=${ciclo.index}">Editar libro</a></td>
                            <td class="text-center"><button class="btn btn-sm btn-danger" onclick="deleteLibro(${ciclo.index},'Nombre de libro fila')">Elminar libro</button></td>
                        </tr>
                        </c:forEach>
                    </tbody>

                   


                </table>
            </div>


        </div>

        
    </div>



    
</body>

<script src="https://code.jquery.com/jquery-3.0.0.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script> 
<script src="site/js/scripts.js"></script>
<script src="site/js/jquery.Rut.js"></script>
<script>
    $(document).ready(function (){
       
        $('#myTable').DataTable();

    });

    

    function deleteLibro(Index,NombrePersona){
        $.confirm({
            title: "Consulta",
            content: "Seguro de eliminar a "+NombrePersona,
            icon: 'fa fa-question-circle-o',
            theme: 'supervan',
            closeIcon: false,
            animation: 'scale',
            type: 'orange',
            buttons: {
                heyThere: {
                    text: 'Si', // text for button
                    btnClass: 'btn-blue', // class for the button
                    action: function(heyThereButton){
                      	
                    	var jsonSend={
                    		'Id':Index
                    	}
                    	
                    	
                    	$.ajax({
                    		type: "POST",
                    		url : "ListartPersonas.do",
                        	data: {"Id":Index,"Opc":1},
                        	success:function (obj){
                        		console.log(obj)		
                        		alert("Se elimino el libro")
                        		setTimeout("location.reload()",4000);
                        		
                        	}
                    			
                    		
                    	})
                    	
                    	
                    }
                },

                cancel: {
                    text: 'No', // text for button
                    btnClass: 'btn-blue', // class for the button
                    action: function(heyThereButton){
                        
                    }
                },
            }   
        });


    }

   

</script>

