<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.Inacap.Odiseo.DTO.Libro"%>
<%@page import="java.util.List"%>
<%
	List<Libro> arrLibro=new ArrayList<Libro>();

%>

<!DOCTYPE html>
<html lang="es">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Odiseo - Compra de libros online</title>
      <meta name="description" content="Source code generated using layoutit.com">
      <meta name="author" content="LayoutIt!">
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
      <link href="css/style.css" rel="stylesheet">
   </head>
   <body>
      <div class="container">
      <div class="row">
      <div class="col-md-12">
      <h1 class="title-site font-weight-bold text-center">
         Odiseo
      </h1>
      <hr>
      <ul class="nav">
         <li class="nav-item">
            <a class="nav-link active" href="./index.jsp">Home</a>
         </li>
         <li class="nav-item">
            <a class="nav-link" href="./categorias.html">Categorías</a>
         </li>
         <li class="nav-item dropdown ml-md-auto">
            <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown">Admin</a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
               <a class="dropdown-item" href="./login.jsp">Ingresar</a>
            </div>
         </li>
      </ul>
      <div class="row">
         <div class="col-md-12">
            <h3 class="text-center">
               Destacados
            </h3>
            <div class="carousel slide" id="carousel-618102">
               <ol class="carousel-indicators">
                  <li data-slide-to="0" data-target="#carousel-618102" class="active">
                  </li>
                  <li data-slide-to="1" data-target="#carousel-618102">
                  </li>
                  <li data-slide-to="2" data-target="#carousel-618102">
                  </li>
               </ol>
               <div class="carousel-inner">
                  <div class="carousel-item active">
                     <img class="d-block w-100" alt="Carousel Bootstrap First" src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg">
                     <div class="carousel-caption">
                        <h4>
                           First Thumbnail label
                        </h4>
                        <p>
                           Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                        </p>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <img class="d-block w-100" alt="Carousel Bootstrap Second" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg">
                     <div class="carousel-caption">
                        <h4>
                           Second Thumbnail label
                        </h4>
                        <p>
                           Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                        </p>
                     </div>
                  </div>
                  <div class="carousel-item">
                     <img class="d-block w-100" alt="Carousel Bootstrap Third" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg">
                     <div class="carousel-caption">
                        <h4>
                           Third Thumbnail label
                        </h4>
                        <p>
                           Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                        </p>
                     </div>
                  </div>
               </div>
               <a class="carousel-control-prev" href="#carousel-618102" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-618102" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
            </div>
            
            
            
            
            
            
            
            
            
                        <c:forEach items="${ListaLibros}" var="l" varStatus="ciclo">

              <div class="row text-center">
               <div class="col-md-3">
                  <div class="card">
                     <img src="${l.portada } class="card-img-top m-4" alt="Portada">
                     <div class="card-body">
                        <h5 class="card-title mb-4">${l.nombre }</h5>
                        <p class="card-text ml-4 mr-4 mb-4">${l.autor }</p>
                        <hr>
                        <p><i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="far fa-star"></i> 4/5
                        </p>
                     </div>
                  </div>
               </div>
                        </c:forEach>
            
            
            
            
            
            
            <div class="row">
               <div class="col-md-12">
                  <h3>
                     Clásicos
                  </h3>
               </div>
            </div>
            <div class="row text-center">
               <div class="col-md-3">
                  <div class="card">
                     <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                     <div class="card-body">
                        <h5 class="card-title mb-4">Special title treatment</h5>
                        <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <hr>
                        <p><i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="far fa-star"></i> 4/5
                        </p>
                     </div>
                  </div>
               </div>
               <div class="col-md-3">
                  <div class="card">
                     <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                     <div class="card-body">
                        <h5 class="card-title mb-4">Special title treatment</h5>
                        <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <hr>
                        <p><i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="far fa-star"></i> 4/5
                        </p>
                     </div>
                  </div>
               </div>
               <div class="col-md-3">
                  <div class="card">
                     <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                     <div class="card-body">
                        <h5 class="card-title mb-4">Special title treatment</h5>
                        <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <hr>
                        <p><i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="far fa-star"></i> 4/5
                        </p>
                     </div>
                  </div>
               </div>
               <div class="col-md-3">
                  <div class="card">
                     <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                     <div class="card-body">
                        <h5 class="card-title mb-4">Special title treatment</h5>
                        <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <hr>
                        <p><i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="fas fa-star"></i>
                           <i class="far fa-star"></i> 4/5
                        </p>
                     </div>
                  </div>
               </div>
               <br>
               <div class="row">
                  <div class="col-md-12">
                     <h3 class="text-center">
                        Horror
                     </h3>
                  </div>
               </div>
               <div class="row text-center">
                  <div class="col-md-3">
                     <div class="card">
                        <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                        <div class="card-body">
                           <h5 class="card-title mb-4">Special title treatment</h5>
                           <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                           <hr>
                           <p><i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="far fa-star"></i> 4/5
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3">
                     <div class="card">
                        <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                        <div class="card-body">
                           <h5 class="card-title mb-4">Special title treatment</h5>
                           <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                           <hr>
                           <p><i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="far fa-star"></i> 4/5
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3">
                     <div class="card">
                        <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                        <div class="card-body">
                           <h5 class="card-title mb-4">Special title treatment</h5>
                           <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                           <hr>
                           <p><i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="far fa-star"></i> 4/5
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-3">
                     <div class="card">
                        <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                        <div class="card-body">
                           <h5 class="card-title mb-4">Special title treatment</h5>
                           <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                           <hr>
                           <p><i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="fas fa-star"></i>
                              <i class="far fa-star"></i> 4/5
                           </p>
                        </div>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-md-12">
                        <h3 class="text-center">
                           Ficción
                        </h3>
                     </div>
                  </div>
                  <div class="row text-center">
                     <div class="col-md-3">
                        <div class="card">
                           <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                           <div class="card-body">
                              <h5 class="card-title mb-4">Special title treatment</h5>
                              <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <hr>
                              <p><i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="far fa-star"></i> 4/5
                              </p>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-3">
                        <div class="card">
                           <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                           <div class="card-body">
                              <h5 class="card-title mb-4">Special title treatment</h5>
                              <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <hr>
                              <p><i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="far fa-star"></i> 4/5
                              </p>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-3">
                        <div class="card">
                           <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                           <div class="card-body">
                              <h5 class="card-title mb-4">Special title treatment</h5>
                              <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <hr>
                              <p><i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="far fa-star"></i> 4/5
                              </p>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-3">
                        <div class="card">
                           <img src="https://imagessl9.casadellibro.com/a/l/t5/29/9788416628629.jpg" class="card-img-top m-4" alt="Portada">
                           <div class="card-body">
                              <h5 class="card-title mb-4">Special title treatment</h5>
                              <p class="card-text ml-4 mr-4 mb-4">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <hr>
                              <p><i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="fas fa-star"></i>
                                 <i class="far fa-star"></i> 4/5
                              </p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/scripts.js"></script>
   </body>
</html>


