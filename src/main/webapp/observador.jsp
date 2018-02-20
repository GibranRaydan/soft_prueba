<%@page import="Model.Observador"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Observador</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>
    <body>

        <%--  <%@include file="header.jsp" %> --%>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">
                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Observador</h1>
                    <p></p>
                    <div class="container">                  
                            <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
                                <label for="nombre_estudiante">Estudiante:</label>
                                <%
                                    if (request.getAttribute("nombre") != null) {
                                        String nombre = request.getAttribute("nombre");
                                            
                                %>
                                <input  class="form-control" name="nombre_estudiante" readonly="readonly" value="<%=nombre%>">
                                <%      
                                    }
                                %>
                                <table class="table table-inverse">
                                    <thead>
                                        <tr>
                                            <th>Calificacion</th>
                                            <th>Descripcion</th>
                                        </tr>
                                    </thead>
                                    <%
                                      if (request.getAttribute("notas") != null) {
                                                ArrayList<Observador> array = (ArrayList<Observador>) request.getAttribute("notas");
                                                for (Observador r : array) {
                                    %>
                                    <thead>
                                        <tr>
                                            <th><%=r.getCalificaciones()%></th>
                                            <th><%=r.getDetalles()%></th>
                                        </tr>
                                    </thead>
                                    <%      }
                                        }
                                    %>
                                </table>  
                                <br>
                                <a class="btn tm-bordered-btn pull-xs-center" href="Observador" role="button">Buscar Otro</a>
                            </div>                         
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>