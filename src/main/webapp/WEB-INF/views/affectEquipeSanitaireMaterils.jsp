<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Materiels</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
				
<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">
		


			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminListSan/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Membres Equipe
					Sanitaire</strong></a> 
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEqSan/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Membre Equipe
					Sanitaire</strong></a>
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminSaMater/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i>  Affectation Materiels</strong></a>
					
					
					</ul></div>	
					
					
									
									
									
									
									



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
										<i class="glyphicon glyphicon-wrench"></i>  Affectation Materiel à l'equipe sanitaire
									<font color="#8C001A">  ${equipeSanitaire.nom}  ${equipeSanitaire.prenom}</font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form action="affecterEquipeSanitaireAMateriel" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Materiels disponibles</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Designation </th>
													<th>Description</th>
													<th>Quantite Stock</th>
													<th>Type</th>
													<th>Prix</th>
													

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listMaterielEqSanitaire}" var="mat">
													<tr>
														<td>${mat.designation}</td>
														<td>${mat.description}</td>
														<td>${mat.stock.quantite}</td>
														<td>${mat.typeMateriels.labelle}</td>
														<td>${mat.prix}</td>
														

													

														<td>
														<%! int trouvee = 0; %>
														<c:forEach items="${listIdMaterielActifEqSanitaireA}" var="idTemp">
														
														<c:if test="${idTemp  == mat.idMateriel}">
														<% trouvee = 1;%>
														<input type="checkbox" id="inlineCheckbox1"
															name="checkedMateriel" value="${mat.idMateriel}" CHECKED>
														
														</c:if>
														</c:forEach>
														
														<%
														if(trouvee == 0){
														%>
															<input type="checkbox" id="inlineCheckbox1"
															name="checkedMateriel" value="${mat.idMateriel}" >
															
														<% 
														}
														trouvee = 0;
														%>
														
														
														
														
														
														
														
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
							
										


										<input type="hidden" name="idEquiSanitaire" value="${equipeSanitaire.idPerson}" />
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
