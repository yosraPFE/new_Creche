<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<link href='<%=request.getContextPath()%>/resources/css/animate.min.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/jquery.ui.css'
	rel='stylesheet'>
<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>


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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">

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



<title>Evennement</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>


















	<c:if test="${InscriAjoute == 0}">									

<<div id="p" title="Affectation Enfant à une Classe">
			<p>Echec! L'enfant est deja affecter à une classe</p>
		</div>
	</c:if>

	<c:if test="${InscriAjoute == 1}">

		<div id="p" title="Affectation Enfant à une Classe">
			<p>Succés! L'enfant est affecter a une classe</p>
		</div>

	</c:if>






	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">

			<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnf/index"/>"> <strong><i
									class=" glyphicon glyphicon-user"> </i> Liste Enfants</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEF2/index"/>"> <strong><i
									class="glyphicon glyphicon-plus"> </i> Nouveau Enfant</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong><i
									class=" glyphicon glyphicon-music"> </i> <i
									class=" glyphicon glyphicon-time"> </i> Clubs et Planning Horraires</strong></a>
									
									
								
									
									<a class="btn btn-info btn-round btn-lg" href="<c:url value="/adminEnfEven/index"/>"> <strong><i
									class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
									class="glyphicon glyphicon-filter"> </i> Consultations Medicales</strong></a>
									
							</ul>		
									

       	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">



						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> <font color="#8C001A">
									Enfants deja inscris</font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${enfant.idPerson!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${enfant.idPerson==null}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Actions</th>
									<th>Photo</th>
									<th>Nom & Prenom</th>
									<th>Classe & Date Inscription</th>
									<th>Date de Naissance</th>
									<th>Certifié?</th>
									<th>Autorisé photos?</th>


									

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${enfants}" var="en">
									<tr>
									
									
									<td><a class="btn btn-info btn-round btn-lg"
											title="Affecter Evennement" data-toggle="tooltip"
											href="<c:url value="/adminEf/choisirEvennements?idEnf=${en.idPerson}"/>">

												<i class="glyphicon glyphicon-screenshot"></i>

										</a></td>


										<td width=100px><img
											src="photoEnf?idEnfant=${en.idPerson}" class="images_petit"
											title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoEnf?idEnfant=${en.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>
										<td class="center">${en.nom}${en.prenom}</td>

										<td class="center"></td>
										<td class="center">${en.dateNaissance}</td>


										<c:if test="${en.certificatMedicale==true}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-ok"></i>
												</button></td>
										</c:if>

										<c:if test="${en.certificatMedicale==false}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-remove"></i>
												</button></td>
										</c:if>



										<c:if test="${en.autorisationPrisePhoto==true}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-ok"></i>
												</button></td>
										</c:if>

										<c:if test="${en.autorisationPrisePhoto==false}">
											<td class="center"><button
													class="btn btn-round btn-default btn-lg">
													<i class="glyphicon glyphicon-remove"></i>
												</button></td>
										</c:if>


										
									</tr>

								</c:forEach>
							</tbody>


						</table>


					</div>

				</div>
			</div>
		</div>
	</div>

	</div>




	</div>
	</div>



	<!-- footer -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
	<!-- multiple file upload plugin -->

	<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/1.10.2.js"></script>
	<script>
		$(function() {
			// définition de la boîte de dialogue
			// la méthode jQuery dialog() permet de transformer un div en boîte de dialogue et de définir ses boutons
			$("#p").dialog({
				autoOpen : true,
				width : 700,
				buttons : [ {

					text : "fermer",
					click : function() {
						$(this).dialog("close");
					}
				} ]
			});
		});
	</script>

	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>




</body>
</html>