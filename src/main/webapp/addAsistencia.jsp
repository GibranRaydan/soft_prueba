<%@page import="Model.Profesor"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lista de Asistencia</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>
    <body>

        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Lista Asistencia</h1>
                    <p></p>
                    <hr>
                    <div class="container">   
                        <form class="form-inline" action="addAsistencia" method="POST">
                            <div class="form-group">
                                <label for="idAsistencia">ID :</label>
                                <input  class="form-control" name="idAsistencia">
                            </div>
                            <div class="form-group">
                                <label for="idCurso">Curso:</label>
                                <input  class="form-control" name="idCurso">
                            </div>
                            <div class="form-group">
                                <label for="idEstudiante">Estudiante:</label>
                                <input  class="form-control" name="idEstudiante">
                            </div>
                            <div class="span12">&nbsp;</div>
                            <div class="form-group">
                                <label for="fechaC">Fecha Compra:</label>
                                <input  class="form-control" name="fechaC">
                            </div>
                            <div class="form-group">
                                <label for="prestaso">Ultimo Mant.:</label>
                                <input  class="form-control" name="mantenimiento">
                            </div>
                            <div class="form-group">
                                <label for="tipo">Estado</label>
                                <select class="form-control" name="estado">
                                    <option>Excelente</option>
                                    <option>Bueno</option>
                                    <option>Regula</option>
                                    <option>Malo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="tipo">Prestado</label>
                                <select class="form-control" name="prestado">
                                    <option>True</option>
                                    <option>False</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="tipo">Categoria</label>
                                <select class="form-control" name="categoria">
                                     <%
                                        if (request.getAttribute("categoria") != null) {
                                            ArrayList<Categoria> array = (ArrayList<Categoria>) request.getAttribute("categoria");
                                            for (Categoria a : array) {
                                    %> 
                                    <option value="<%=a.getNombre()%>"><%=a.getNombre()%></option> 
                                    <%      }
                                        }
                                    %> 
                                </select>
                            </div>
                                <br>
                                <br>
                                
                            <div class="form-group">
                                <label for="tipo">Calificación</label>
                                <select class="form-control" name="calificacion">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>


                            <br>
                            <div class="span12">&nbsp;</div>
                            <button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>

    

    </body>
</html>