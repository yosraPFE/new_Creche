<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Categories Clubs</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	

<div>

		
		<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">

			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminListEdu/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Membres Equipe
					Educatif</strong></a> 
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEqEdu/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Membre Equipe
					Educatif</strong></a>
					
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEduClass/index"/>"> <strong><i
					class=" glyphicon glyphicon-gift"> </i>Affectation Classes
					</strong></a>
					
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminEduCategEq/index"/>"> <strong><i
					class="glyphicon glyphicon-bookmark"> </i>  Affectation Categories Clubs</strong></a>
					
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEduMateriel/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i>  Affectation Materiels</strong></a>
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
										<i class="glyphicon glyphicon-bookmark"></i>  Affectation Categorie Club à l'equipe educatif
									<font color="#8C001A">  ${equipeEducatif.nom}  ${equipeEducatif.prenom}</font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form action="affecterEquipeEducatifACategorie" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Categorie Clubs disponibles</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>labelle </th>
													<th>Prix</th>
													<th>Date</th>

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listCategorieClubEqEducatif}" var="categ">
													<tr>
														<td>${categ.labelle}</td>
														<td>${categ.prix}</td>
														<td>${categ.date}</td>

													
													<!-- listIdActif -->

														<td>
														<%! int trouvee = 0; %>
														<c:forEach items="${listIdCategorieActifEqEducatifA}" var="idTemp">
														
														<c:if test="${idTemp  == categ.idCategorie}">
														<% trouvee = 1;%>
														<input type="checkbox" id="inlineCheckbox1"
															name="checkedCategorie" value="${categ.idCategorie}" CHECKED>
														
														</c:if>
														</c:forEach>
														
														<%
														if(trouvee == 0){
														%>
															<input type="checkbox" id="inlineCheckbox1"
															name="checkedCategorie" value="${categ.idCategorie}" >
															
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
