<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html >
<head>
   <title>Page Authentification</title>
    
    <!-- links -->
    <link id="<%=request.getContextPath()%>/resources/bs-css" href="<%=request.getContextPath()%>/resources/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/css/charisma-app.css" rel="stylesheet">
    <link href='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/uploadify.css' rel='stylesheet'>
    <link href='<%=request.getContextPath()%>/resources/css/animate.min.css' rel='stylesheet'>

    
    <script src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

   
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
</head>

<body>



<div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>Bienvenue à notre Crèche l'Excellence</h2>
        </div>
       
    </div>

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Merci de vous connecter avec votre Nom d'utilisateur et Mot de passe.
            </div>
            
            
            <form class="form-horizontal" action="j_spring_security_check" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" name="j_username" class="form-control" placeholder="Nom d'utilisateur">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" name="j_password" onkeypress="majuscule(event);" class="form-control" placeholder="Mot de passe">
                    </div>
                    <div class="clearfix"></div>

                    
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary"><i
											class=" glyphicon glyphicon-ok"></i>  Se Connecter</button>
                    </p>
                </fieldset>
            </form>
        </div>
       
    </div>
</div>

</div>



<script src="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.cookie.js"></script>
<script src='<%=request.getContextPath()%>/resources/bower_components/moment/min/moment.min.js'></script>
<script src='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<script src='<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js'></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.noty.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.js"></script>
<script src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.raty.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.iphone.toggle.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.autogrow-textarea.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.uploadify-3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.history.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/charisma.js"></script>

<script>

function majuscule(e)
{
var key = e.keyCode? e.keyCode : e.charCode;
 
    if(key > 64 && key < 95)
    {
      alert("Majuscules Activé");
    }
 
}
</script>

</body>
</html>
