<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Fournisseurs</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	<div>


		<div id="content" class="col-lg-10 col-sm-10">
	
		<ul class="breadcrumb">


			


			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminMaterielLi/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i> Liste Materiels
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminMater/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Materiel
					</strong></a>
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminFouurMater/index"/>"> <strong><i
					class="glyphicon glyphicon-user"> </i>  Affectation Fournisseurs</strong></a>


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
										<i class="glyphicon glyphicon-user"></i>  Affectation Fournisseurs aux Materiels de designation 
									<font color="#8C001A"> ${materiel.designation}  </font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form action="affecterFournisseurAMateriel" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Fournisseurs Disponibles</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nom </th>
													<th>Prenom</th>
													<th>Photo</th>
													<th>Cin</th>
													

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listFournisseursMateriels}" var="four">
													<tr>
														<td>${four.nom}</td>
														<td>${four.prenom}</td>
														<td></td>
														<td>${four.cin}</td>

													

														<td>
														
													

														
														<input type="checkbox" id="inlineCheckbox1"
															name="checkedFournisseur" value="${four.idPerson}" >
														

														
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
							
										


										<input type="hidden" name="idMateriel" value="${materiel.idMateriel}" />
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
