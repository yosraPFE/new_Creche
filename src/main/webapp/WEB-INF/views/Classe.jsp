<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap-cerulean.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/charisma-app.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.print.css"
	rel="stylesheet" media="print">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/colorbox/example3/colorbox.css"
	rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">

<link
	href="<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.css"
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/jquery.noty.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/noty_theme_default.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/elfinder.min.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/elfinder.theme.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/jquery.iphone.toggle.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/uploadify.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/animate.min.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/jquery.ui.css'
	rel='stylesheet'>
<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/img/favicon.ico">

</head>

<body>
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">
			<button type="button" class="navbar-toggle pull-left animated flip">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html"> <img
				alt="Charisma Logo"
				src="<%=request.getContextPath()%>/resources/img/logo20.png"
				class="hidden-xs" /> <span>Admin</span></a>

			<!-- user dropdown starts -->
			<div class="btn-group pull-right">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs"> admin</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">Profile</a></li>
					<li class="divider"></li>
					<li><a href="login.html">Logout</a></li>
				</ul>
			</div>
			<!-- user dropdown ends -->

			<!-- theme selector starts -->
			<div class="btn-group pull-right theme-container animated tada">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-tint"></i><span
						class="hidden-sm hidden-xs"> Change Theme / Skin</span> <span
						class="caret"></span>
				</button>
				<ul class="dropdown-menu" id="themes">
					<li><a data-value="classic" href="#"><i class="whitespace"></i>
							Classic</a></li>
					<li><a data-value="cerulean" href="#"><i
							class="whitespace"></i> Cerulean</a></li>
					<li><a data-value="cyborg" href="#"><i class="whitespace"></i>
							Cyborg</a></li>
					<li><a data-value="simplex" href="#"><i class="whitespace"></i>
							Simplex</a></li>
					<li><a data-value="darkly" href="#"><i class="whitespace"></i>
							Darkly</a></li>
					<li><a data-value="lumen" href="#"><i class="whitespace"></i>
							Lumen</a></li>
					<li><a data-value="slate" href="#"><i class="whitespace"></i>
							Slate</a></li>
					<li><a data-value="spacelab" href="#"><i
							class="whitespace"></i> Spacelab</a></li>
					<li><a data-value="united" href="#"><i class="whitespace"></i>
							United</a></li>
				</ul>
			</div>
			<!-- theme selector ends -->

			

		</div>
	</div>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">

			<!-- left menu starts -->
			<div class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu">
							<li class="nav-header">Main</li>
							<li class="accordion"><a href="#"><i
									class=" glyphicon glyphicon-user"></i><span> Enfant </span></a>
								<ul class="nav nav-pills nav-stacked">
									<li><a href="enfant"> <i
											class=" glyphicon glyphicon-search"></i> Lister
									</a></li>
									<li><a href="ajouter-enfant">
									 <i class=" glyphicon glyphicon-plus-sign"></i> Ajouter
									</a></li>
									<li><a href="modif">
							<i class="glyphicon glyphicon-edit"></i> Modifier
									</a></li>
									
								</ul></li>


							<li><a class="ajax-link" href="evenements"><i
									class=" glyphicon glyphicon-calendar
"></i><span>Evennement
								</span></a></li>
							<li><a class="ajax-link" href="club"><i
									class=" glyphicon glyphicon-music
"></i><span> Club</span></a></li>
							<li class="accordion"><a href="#"><i
									class=" glyphicon glyphicon-user
"></i><span> Equipe
										Educative </span></a>
								<ul class="nav nav-pills nav-stacked">
									<li><a href=animateur><i
											class=" glyphicon glyphicon-user
"></i>   Animateur</a></li>
									<li><a href="maitresse"><i
											class=" glyphicon glyphicon-user"></i>    Maitresse</a></li>
								</ul></li>
							<li><a class="ajax-link" href="PlaningHoraire"><i
									class=" glyphicon glyphicon-time"></i><span> Planing
										Horaires</span></a></li>

							<li><a class="ajax-link" href="materiel"><i
									class="glyphicon glyphicon-shopping-cart"></i><span> Materiel</span></a></li>
							<li><a class="ajax-link" href="chart.html"><i
									class="glyphicon glyphicon-leaf"></i><span> Medecin</span></a></li>
							<li><a class="ajax-link" href="classe"><i
									class="glyphicon glyphicon-briefcase"></i><span> Classe</span></a></li>
					<li class="accordion"><a href="#"><i
									class=" glyphicon glyphicon-tasks"></i><span> Catégorie</span></a>
					<ul class="nav nav-pills nav-stacked">
					<li><a href="categorieclub"><i class=" glyphicon glyphicon-music"></i> Club</a></li>
					<li><a href="categoriemateriel"><i class=" glyphicon glyphicon-shopping-cart"></i>Materiel</a></li>
								</ul></li>
					
					</ul>
					</div>
				</div>
			</div>
			<!--/span-->
			<!-- left menu ends -->

			<noscript>
				<div class="alert alert-block col-md-12">
					<h4 class="alert-heading">Warning!</h4>

					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

<div id="content" class="col-lg-10 col-sm-10">
				<div>
					<ul class="breadcrumb">
						<li><a href="#" data-toggle="modal" data-target="#myModal"
							class="btn btn-primary" id="boutoninformation">Ajouter Classe</a></li>
						<li><a href="#" class="btn btn-primary" id="boutonclasse">Liste des Enfants</a></li>
						

					</ul>
				</div>
			
			<div class="content">
			
				<div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> Liste des Classes</h2>

        <div class="box-icon">
             <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
           </div>
    </div>
    <div class="box-content">
     <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Capacité</th>
        <th>Nom maitresse</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${classes}" var="cla">
				<tr>
				<td>${cla.nom}</td>
					<td>${cla.cpacite}</td>
					<td>${cla.maitresse.nom}</td>
					<td><a href="modifierclasse?idClas=${cla.idClasse}"class= "btn btn-info popupmodifier">
					<i class="glyphicon glyphicon-edit icon-white"></i></a>
					</td>
				</tr>
				
			</c:forEach>
    </tbody>
    </table>
    </div>
    </div>
    </div>
    <!--/span-->

    </div>
			
			<f:form modelAttribute="classe" action="ajouterclasse" method="post"
							name="form1">
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">

								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">x</button>
											<h3>Ajouter</h3>
										</div>
										<div class="modal-body">

											<table>
												<tr>
													<td>
														<div class="hide">
															<f:input type="text" class="form-control"
																aria-describedby="sizing-addon5" path="idClasse" />
														</div>
													</td>

													<td><f:errors path="idClasse"></f:errors></td>
												</tr>
												<tr>
													<td>Nom:</td>
													<td>
														<div class="input-group input-group-lg">
															<f:input type="text" class="span" name="nom"
																aria-describedby="sizing-addon5" path="nom"  required="true"/>
														</div>
													</td>

													<td><f:errors path="nom"></f:errors></td>
												</tr>
												<tr>
													<td>Capacité:</td>
													<td><f:input type="number" min="10" max="25" path="cpacite" required="true"
															class="span" rows="8" /></td>
													<td> <f:errors path="cpacite"></f:errors></td>
												</tr>
<tr>												
<td>Maitresse:</td>

<td>

<div class="control-group">
 
                    <div class="controls">
<f:select path= "maitresse.id" items= "${maitresses}" itemLabel= "nom" itemValue="id" id="selectError"/>

                    </div>
                    
                </div>
</td> 
<td><f:errors path= "maitresse.id"></f:errors></td>
</tr>
												
											</table>

										</div>
										<div class="modal-footer">
											<input type="submit" value="Valider" class="btn btn-default"> <a href="#"
												class="btn btn-default" data-dismiss="modal">Annuler</a>

										</div>
									</div>
								</div>
							</div>
						</f:form>
			
			
			<div class="hide">
			
		<div  id="popupmodifier" title="Modifier">
				<f:form modelAttribute="classe" action="ajouterclasse" method="post"
							name="form2" id="form2">
							

											<table>
												<tr>
													<td>
														<div class="hide">
															<f:input type="text" class="form-control"
																aria-describedby="sizing-addon5" path="idClasse" />
														</div>
													</td>

													<td><f:errors path="idClasse"></f:errors></td>
												</tr>
												<tr>
													<td>Nom:</td>
													<td>
														<div class="input-group input-group-lg">
															<f:input type="text" class="span" name="nom"
																aria-describedby="sizing-addon5" path="nom"  required="true"/>
														</div>
													</td>

													<td><f:errors path="nom"></f:errors></td>
												</tr>
												<tr>
													<td>Nombre places:</td>
													<td><f:input type="number" min="10" max="25" path="nombrePlaces" required="true"
															class="span" rows="8" /></td>
													<td> <f:errors path="nombrePlaces"></f:errors></td>
												</tr>

												
											</table>

										
									
								
							
						</f:form>
			</div>
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		//////////////////
		
		
		<div class="hide">
			
		<div  id="popupclasse" title="Classes">
				
					
				<f:form modelAttribute="classe" action="Liste-Classes" method="post"
							name="form3" id="form3">
							
			

<div class="control-group">
                    <div class="controls">
                    <br>
                    
&nbsp &nbsp &nbsp &nbsp &nbsp  Classes:<f:select path="idClasse"  items= "${classes}" itemLabel= "nom" itemValue="idClasse" id="selectErr"/>
                  
                    	<input type="submit" value="Ok" class="btn btn-primary btn-xs"> 
							</div>					
						</f:form>
			</div>
			</div>
			
			
			
			
			
		


										
									
								
							
						
			</div>
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			</div>
			</div>	
		</div>	


	<!--/.fluid-container-->

	<!-- external javascript -->

	<script
		src="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script
		src='<%=request.getContextPath()%>/resources/bower_components/moment/min/moment.min.js'></script>
	<script
		src='<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script
		src='<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
	<!-- multiple file upload plugin -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=request.getContextPath()%>/resources/js/charisma.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/js/1.10.2.js"></script>
	<script>
		$(function() {
			// définition de la boîte de dialogue
			// la méthode jQuery dialog() permet de transformer un div en boîte de dialogue et de définir ses boutons
			

		});

		$(document).ready(function() {
			$('#example').dataTable({
			//"bPaginate":false,
			// "bSort":false,
			//"bInfo":false,
			//"bFilter": true

			}

			);
		});
		$(function() {
			// définition de la boîte de dialogue
			// la méthode jQuery dialog() permet de transformer un div en boîte de dialogue et de définir ses boutons
			$("#popupconfirmation").dialog({
				autoOpen : false,
				width : 400
			});

			// comportement du bouton devant ouvrir la boîte de dialogue
			$(".boutonsupprimer").click(function(event) {
				event.preventDefault();
				var targetUrl = $(this).attr("href"); // retrouve l'attribut href du lien sur lequel on a cliqué
				// on définit les boutons ici plutôt que plus haut puisqu'on a besoin de connaître l'URL de la page, qui n'était pas encore disponible sur le document.ready.
				$("#popupconfirmation").dialog({
					buttons : [ {
						text : "Oui",
						click : function() {
							window.location.href = targetUrl;
						}
					}, {
						text : "Non",
						click : function() {
							$(this).dialog("close");
						}
					} ]
				});

				$("#popupconfirmation").dialog("open");
			});
		});
		$(function() {
			// définition de la boîte de dialogue
			// la méthode jQuery dialog() permet de transformer un div en boîte de dialogue et de définir ses boutons
			if ($("input[name$='nom']").val() != '') {
				$("#popupmodifier").dialog({ 
					autoOpen : true,
					show: {
				        effect: "explode",
				        duration: 1000
				      },
				      hide: {
				        effect: "explode",
				        duration: 1000
				      },
					width : 500,
					buttons : [ {
						text : "Valider",
						click : function() {
							$("#form2").submit();
						}
					},

					{
						text : "Annuler",
						click : function() {
							$(this).dialog("close");
						}
					} ]
				});

			}
			$("#popupclasse").dialog({
				autoOpen : false,
				width : 400
			});

			$("#boutonclasse").click(function(event) {
				event.preventDefault();
				
			
		
			$("#popupclasse").dialog({
				
			});
			$("#popupclasse").dialog("open");
			// comportement du bouton devant ouvrir la boîte de dialogue
			});
		});
	</script>
<script type="text/javascript">

function aller()
{
var valeur = document.forms['form2'].elements['selectErr'].value; // Contient la valeur de l'<input />
document.location.href = 'Liste-Classes?idCla='+valeur;
}
</script>
</body>
