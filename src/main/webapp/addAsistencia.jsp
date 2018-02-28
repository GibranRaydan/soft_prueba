<%@page import="Model.Estudiante"%>
<%@page import="Model.Asistencia"%>
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

        
        
    <script>
        function sendData(){
        var http =  new XMLHttpRequest();
        var url = "ListaAsistencia";
        
       var params = "fecha="+document.getElementById('fecha')+"id_estudiante="+document.getElementById('id_estudiante')+
          "nombre_estudiante="+document.getElementById('nombre_estudiante')+"vino="+document.getElementById("opciones");
       
        http.open("POST", url, true);
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        http.send(params);
    }
        
    </script>
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

                    <form class="form-inline" method="POST">
                        <text id="fecha">
                        <script>
                            var f = new Date();
                            document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
                        </script>
                        </text>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID Estudiante</th>
                                    <th>Nombre Estudiante</th>

                                </tr>
                            </thead>

                            <tbody>
                                <% if (request.getAttribute("listaCurso") != null) {
                                        ArrayList<Estudiante> list = (ArrayList<Estudiante>) request.getAttribute("listaCurso");
                                        if (list != null)
                                            for (Estudiante estudiante : list) {
                                %>
                                <tr>

                                    <td id="id_estudiante" ><%=estudiante.getId_estudiante()%></td>
                                    <td id="nombre_estudiante"><%=estudiante.getNombre_estudiante()%></td>


                                    <td>
                                        <SELECT id="opciones">
                                            <OPTION value="1">Presente</OPTION>
                                            <OPTION value="2">Ausente</OPTION>
                                        </SELECT>
                                    </td>
                                </tr>
                                <% }
                                    }
                                %>

                            </tbody>
                        </table>
                                <button type="button" onClick="sendData()">Guardar</button> 

                       
                    </form>
                                
                    


                </div>

            </div>
        </div>



    </body>
</html>
