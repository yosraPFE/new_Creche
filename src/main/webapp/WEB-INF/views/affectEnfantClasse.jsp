<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
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


<title>Affecter a une classe</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>


	<c:if test="${InscriAjoute == 1}">

		<div id="p" title="Affectation Enfant à une Classe">
			<p>Succés! L'enfant est affecter a une classe,Voulez Vous lui affecter un Tarif d' Inscription ?</p>
		</div>

	</c:if>
	<div>



		<div id="content" class="col-lg-10 col-sm-10">
			<ul class="breadcrumb">

				<a class="btn btn-primary btn-round btn-lg"
					href="<c:url value="/adminEnf/index"/>"> <strong><i
						class=" glyphicon glyphicon-user"> </i> Liste Enfants</strong></a>


				<a class="btn btn-primary btn-round btn-lg"
					href="<c:url value="/adminEF2/index"/>"> <strong><i
						class="glyphicon glyphicon-plus"> </i> Nouveau Enfant</strong></a>


				<a class="btn btn-info btn-round btn-lg"
					href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong>
						<i class=" glyphicon glyphicon-briefcase"> </i> Affectation Classe
				</strong></a>


				<a class="btn btn-primary btn-round btn-lg"
					href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong><i
						class=" glyphicon glyphicon-music"> </i> <i
						class=" glyphicon glyphicon-time"> </i> Clubs et Planning
						Horraires</strong></a>




				<a class="btn btn-primary btn-round btn-lg"
					href="<c:url value="/adminEnfEven/index"/>"> <strong><i
						class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>


				<a class="btn btn-primary btn-round btn-lg"
					href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
						class="glyphicon glyphicon-filter"> </i> Consultations Medicales</strong></a>

			</ul>
		</div>






		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">


				<!--/span-->
				<!-- left menu ends -->

				<noscript>
					<div class="alert alert-block col-md-12">
						<h4 class="alert-heading">Warning!</h4>

						<p>
							You need to have <a
								href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
							enabled to use this site.
						</p>
					</div>
				</noscript>

				<div id="content" class="col-lg-10 col-sm-10">

					<!-- content starts -->
					<div class="content">
						<div class="row">
							<div class="box col-md-12">
								<div class="box-inner">
									<div class="box-header well" data-original-title="">
										<h2>
											<i class="glyphicon glyphicon-briefcase"></i> Affectation à
											une classe
										</h2>

										<div class="box-icon">
											<a href="#" class="btn btn-minimize btn-round btn-default"><i
												class="glyphicon glyphicon-chevron-up"></i></a>
										</div>
									</div>

									<f:form action="inscriptionEnfant" method="GET">
										<div class="box-content">
											<table class="table table-striped table-bordered responsive">
												<thead>
													<tr>
														<th>Nom</th>
														<th>Nombre Places</th>
														<!--  <th>Nombre Places Restantes</th>-->
														<th>Etat</th>
														<th>Actions</th>
													</tr>
												</thead>
												<tbody>

													<c:forEach items="${listClasses}" var="cla"
														varStatus="status">
														<tr>
															<td>${cla.nom}</td>

															<td>${cla.nombrePlaces}</td>


															<td>${listPlacesRestantes[status.index]}(places
																restantes) / ${cla.nombrePlaces} <c:if
																	test="${listPlacesRestantes[status.index] >= 3}">
																	<div class="progress">
																		<div
																			class="progress-bar progress-bar-success progress-bar-striped"
																			role="progressbar"
																			aria-valuenow="${listPlacesRestantes[status.index] * 100 /  cla.nombrePlaces}"
																			aria-valuemin="0" aria-valuemax="100"
																			style="width: ${listPlacesRestantes[status.index] * 100 /  cla.nombrePlaces}%">
																			<span class="sr-only">40% Complete (success)</span>
																		</div>
																	</div>
																</c:if> <c:if test="${listPlacesRestantes[status.index] < 3}">
																	<div class="progress">
																		<div
																			class="progress-bar progress-bar-danger progress-bar-striped"
																			role="progressbar"
																			aria-valuenow="${listPlacesRestantes[status.index] * 100 /  cla.nombrePlaces}"
																			aria-valuemin="0" aria-valuemax="100"
																			style="width: ${listPlacesRestantes[status.index] * 100 /  cla.nombrePlaces}%">
																			<span class="sr-only">100% Complete (danger)</span>
																		</div>
																	</div>
																</c:if>
															</td>

															<td><input type="radio" id="inlineCheckbox1"
																name="idCla" value="${cla.idClasse}"></td>

														</tr>


													</c:forEach>


												</tbody>

											</table>

											<table>


											</table>





											<input type="hidden" id="idEnf" name="idEnf"
												value="${enfant.idPerson}" /> <input type="submit"
												value="Valider" class="btn btn-primary btn-sm"> 

											<c:if test="${InscriAjoute == 1}">



												<a class="btn btn-success" title="Affecter Tarif"
													data-toggle="tooltip"
													href="<c:url value="/clubpai/choisirClubspaiem?idEnf=${enfant.idPerson}"/>">Suivant
													>></a>

											</c:if>


										</div>


									</f:form>
								</div>


							</div>




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
	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>

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
</body>
