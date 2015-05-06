<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Evennement</title>
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
									
									
								
									
									<a class="btn btn-info btn-round btn-lg" href="<c:url value="/adminEnfEven/index"/>"> <strong><i
									class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
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
										<i class="glyphicon glyphicon-screenshot"></i>  Affectation Evennement à
									<font color="#8C001A">  l'enfant	${enfant.nom} ${enfant.prenom} </font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form action="affecterEnfantAEvennem" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Evennements disponibles</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nom </th>
													<th>Type</th>
													<th>Fraix</th>
													<th>Lieu</th>
													<th>Date</th>

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listEvenementEnfant}" var="even">
													<tr>
														<td>${even.nom}</td>
														<td>${even.type}</td>

														<td>${even.fraix}</td>
														<td>${even.lieu}</td>
														<td>${even.date}</td>


<!-- ajouter list Clubs actif -->	
														
														
														<td>
														<%! int trouvee = 0; %>
														<c:forEach items="${listIdEvenementActifEnfantA}" var="idTempP">
														
														<c:if test="${idTempP  == even.idEvenement}">
														<% trouvee = 1;%>
														<input type="checkbox" id="inlineCheckbox2"
															name="checkedEvennement" value="${even.idEvenement}" CHECKED>
														
														</c:if>
														</c:forEach>
														
														<%
														if(trouvee == 0){
														%>
															<input type="checkbox" id="inlineCheckbox2"
															name="checkedEvennement" value="${even.idEvenement}" >
															
														<% 
														}
														trouvee = 0;
														%>
														
														
														
														
														
														
														
														</td>
														
														
														
														
														
														
														
														
														
														
													</tr>
												</c:forEach>
											</tbody>
										</table>
							
										


										<input type="hidden" name="idEnf" value="${enfant.idPerson}" />
										<input type="submit" value="Valider"
											class="btn btn-primary btn-sm">
									</f:form>
								</div>
							</div>
						</div>
						<!--/span-->

					</div>


				</div>
			</div>
		</div>
	</div>
	</div>




	</script>
	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
