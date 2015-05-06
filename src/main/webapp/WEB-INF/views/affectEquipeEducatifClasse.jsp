<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Classes</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
		<ul class="breadcrumb">


			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminListEdu/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Membres Equipe
					Educatif</strong></a> 
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEqEdu/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Membre Equipe
					Educatif</strong></a>
					
					
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminEduClass/index"/>"> <strong><i
					class=" glyphicon glyphicon-gift"> </i>Affectation Classes
					</strong></a>
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEqEdu/index"/>"> <strong><i
					class="glyphicon glyphicon-bookmark"> </i>  Affectation Categories</strong></a>
					
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEduCategEq/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i>  Affectation Materiels</strong></a>
					
					</ul>
					
					</ul>	
									
									
									
									
									



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
										<i class="glyphicon glyphicon-screenshot"></i>  Affectation Classe  à l'equipe educatif 
									<font color="#8C001A"> ${equipeEducatif.nom}  ${equipeEducatif.prenom}</font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form action="affecterEquipeEducatifAClass" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Classes disponibles</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nom </th>
													<th>Nombre de Places</th>
													

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listClasseEqEducatif}" var="clas">
													<tr>
														<td>${clas.nom}</td>
														<td>${clas.nombrePlaces}</td>

													
													<!-- ajoutereee -->
                                                        <td>
														<%! int trouvee = 0; %>
														<c:forEach items="${listIdClasseActifEqEducatifA}" var="idTemp">
														
														<c:if test="${idTemp  == clas.idClasse}">
														<% trouvee = 1;%>
														<input type="checkbox" id="inlineCheckbox1"
															name="checkedClass" value="${clas.idClasse}" CHECKED>
														
														</c:if>
														</c:forEach>
														
														<%
														if(trouvee == 0){
														%>
															<input type="checkbox" id="inlineCheckbox1"
															name="checkedClass" value="${clas.idClasse}" >
															
														<% 
														}
														trouvee = 0;
														%>
														
														
														
														
														
														
														
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
							
										


										<input type="hidden" name="idEquiEducatif" value="${equipeEducatif.idPerson}" />
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
