<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Consultation Medicale</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>

<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">

			<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnf/index"/>"> <strong><i
									class=" glyphicon glyphicon-user"> </i> Liste Enfants</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEF2/index"/>"> <strong><i
									class="glyphicon glyphicon-plus"> </i> Nouveau Enfant</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong><i
									class=" glyphicon glyphicon-music"> </i> <i
									class=" glyphicon glyphicon-time"> </i> Clubs et Planning Horraires</strong></a>
									
									
								
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfEven/index"/>"> <strong><i
									class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>
									
									
									<a class="btn btn-info btn-round btn-lg" href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
									class="glyphicon glyphicon-filter"> </i> Consultations Medicales</strong></a>
									
							</ul>	</div>	



	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">


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

				<!-- content starts -->
				<div class="content">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-filter"></i> Affectation Consultation à
									<font color="#8C001A">  l'enfant	${enfant.nom} ${enfant.prenom} </font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<f:form action="consultationEnfant" method="GET">
									<div class="box-content">
										<table class="table table-striped table-bordered responsive"">
											<thead>
												<tr>
													<th>Photo</th>
													<th>Nom</th>
													<th>Prenom</th>
													<th>Fonction</th>
													<th>Sexe</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listEquipeSanitaires}" var="eqSan">
													<tr>

														<td width=100px><img
															src="photoEqSan?idEquipeSanitaire=${eqSan.idPerson}"
															class="images_petit" title="Cliquer pour voir la photo"
															data-toggle="tooltip"
															onclick="window.open('photoEqSan?idEquipeSanitaire=${eqSan.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
															class="images_petit" /></td>
														<td>${eqSan.nom}</td>
														<td>${eqSan.prenom}</td>


														<td>${eqSan.fonction.labelle}</td>
														<td>${eqSan.sexe}</td>

														<td><input type="radio" id="inlineCheckbox1"
															name="idEqSani" value="${eqSan.idPerson}" ></td>


													</tr>


												</c:forEach>
											</tbody>
										</table>
										
										<table>
										
										
										
										<tr>
										
										<td>Description Enfant</td>
										
										<td><textarea type="text" id="description" value=" "
												name="description" ></textarea></td>
										<td></td>
										
										
										</tr>
										
										
										</table>
										
										<input type="hidden" id="idEnf" name="idEnf" value="${enfant.idPerson}" />
									<input type="submit" value="Valider"
										class="btn btn-primary btn-sm">


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


	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
