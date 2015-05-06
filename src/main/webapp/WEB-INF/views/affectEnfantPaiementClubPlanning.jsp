<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Affecter Clubs et Plannings Horraires</title>
</head>

<body>


	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	



			
<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">

			                        <a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnf/index"/>"> <strong><i
									class=" glyphicon glyphicon-user"> </i> Liste Enfants</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEF2/index"/>"> <strong><i
									class="glyphicon glyphicon-plus"> </i> Nouveau Enfant</strong></a>
									
									
									
									<a class="btn btn-info btn-round btn-lg" href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong> <i
									class=" glyphicon glyphicon-usd"> </i> Paiement Inscription</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong><i
									class=" glyphicon glyphicon-music"> </i> <i
									class=" glyphicon glyphicon-time"> </i> Clubs et Planning Horraires</strong></a>
									
									
								
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfEven/index"/>"> <strong><i
									class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
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
			<script type="text/javascript">
			
			total = 0.0;
			
	function init(valeurInit){
		total += valeurInit;
		//alert(total);

		document.formulaire.somme.value = Math.round(total*1000)/1000;
		calculRemise();
	}
	
			
	function checkTotal(valeur,id) { 
		if(document.getElementById("c"+id).checked){
			total += valeur;
		}else{
			total -= valeur;
		}
		document.formulaire.somme.value = Math.round(total*1000)/1000;
		calculRemise();
	}
	
	
	function checkTotalP(valeurp,idp) {
		if(document.getElementById("p"+idp).checked){
			total += valeurp;
		}else{
			total -= valeurp;
		}
		document.formulaire.somme.value = Math.round(total*1000)/1000;
		calculRemise();
	}
	
	function calculRemise(){
		remise = document.getElementById("remise").value;
		afterReduce = total - (total * remise / 100);
		document.formulaire.somme.value = Math.round(afterReduce*1000)/1000;
	}
</script>

			<div id="content" class="col-lg-10 col-sm-10">

				<!-- content starts -->
				<div class="content">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class=" glyphicon glyphicon-music"></i>  Affectation clubs & <i class="glyphicon glyphicon-time"></i> Plannings Horraires à
									<font color="#8C001A">  l'enfant	${enfant.nom} ${enfant.prenom} </font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form name="formulaire" action="affecterEnfantpaiemenAClub" method="GET">
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Tarif Inscription</font></strong>
									
									<input value="${crecheAnnee.tarifInscription}"   class="form-control" disabled="disabled" />
									<c:set var="tarifInscri" value="${crecheAnnee.tarifInscription}"/>
									
									</pre>
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Frais Assurance</font></strong>
									
									<input value="${crecheAnnee.tarifAssurance}"    class="form-control"  disabled="disabled" />
									<c:set var="prixAssur" value="${crecheAnnee.tarifAssurance}"/>
									</pre>
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Tarif Par mois</font></strong>
									
									<input value="${crecheAnnee.tarifParMois}"    class="form-control"  disabled="disabled" />
									<c:set var="prixTarifMoi" value="${crecheAnnee.tarifParMois}"/>
									</pre>
									
									
									
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Clubs</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nom Clubs</th>
													<th>Nombre Maximums</th>
													<th>Catégorie</th>
													<th>Prix</th>

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
<% double sumClubsPlannings = 0; %>
												<c:forEach items="${listClubEnfant}" var="clu" varStatus="status">
													<tr>
														<td>${clu.nom}</td>
														<td>${clu.nombreMaxPart}</td>

														<td>${clu.categorieClub.labelle}</td>
														<td>${clu.categorieClub.prix}</td>




														<td>
														<% int trouvee = 0; %>
														<c:forEach items="${listIdClubActifEnfantA}" var="idTemp">
														
														<c:if test="${idTemp  == clu.idClub}">
														<c:set var="prix" value="${clu.categorieClub.prix}"/>
														<% trouvee = 1;
														sumClubsPlannings += Double.parseDouble(pageContext.getAttribute("prix").toString());%>
														<input type="checkbox" id="c${status.index}"
															name="checkedClubs" value="${clu.idClub}" onchange="checkTotal(${clu.categorieClub.prix},${status.index})" CHECKED>
																															
														</c:if>
														</c:forEach>
														
														<%
														if(trouvee == 0){
														%>
															<input type="checkbox" id="c${status.index}"
															name="checkedClubs" value="${clu.idClub}" onchange="checkTotal(${clu.categorieClub.prix},${status.index})">
															
														<% 
														}
														trouvee = 0;
														%>
														
														
														
														
														
														
														</td>
														
														
														
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										
										
										
									<!-- ******************************* -->	
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Planning Horraires</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>TypePlanning</th>
													<th>Prix</th>
													

													<th>Actions</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listPlanningEnfant}" var="pl" varStatus="statusp">
													<tr>
														<td>${pl.typePlanning}</td>
														<td>${pl.prixPlanning}</td>

														




														<td>
														<% int trouveep = 0; %>
														<c:forEach items="${listIdPlanningActifEnfantA}" var="idTempP">
														
														<c:if test="${idTempP  == pl.idPlanningH}">
														<c:set var="prixPlanning" value="${pl.prixPlanning}"/>
														<% trouveep = 1;
														sumClubsPlannings += Double.parseDouble(pageContext.getAttribute("prixPlanning").toString());%>
														<input type="checkbox" id="p${statusp.index}"
															name="checkedPlanning" value="${pl.idPlanningH}" onchange = "checkTotalP(${pl.prixPlanning},${statusp.index})" CHECKED>
														
														</c:if>
														</c:forEach>
														
														<%
														if(trouveep == 0){
														%>
															<input type="checkbox" id="p${statusp.index}"
															name="checkedPlanning" value="${pl.idPlanningH}" onchange = "checkTotalP(${pl.prixPlanning},${statusp.index})">
															
														<% 
														}
														trouveep = 0;
														%>
														
														
														
														
														
														
														
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										<!-- **************************************** -->
										
										
										<input type="hidden" name="idEnf" value="${enfant.idPerson}" />
										
									<pre class="prettyprint linenums"><strong><font color="#8C001A">Remise</font></strong>
									
									<input value="0.0"  name="remise" id="remise" class="form-control" onkeyup ="calculRemise()"/>
									
									</pre>
										
											<pre class="prettyprint linenums"><strong><font color="#8C001A">Total :</font></strong>
									
									<input   name="somme" class="form-control" /></pre>
									
									<% sumClubsPlannings += Double.parseDouble(pageContext.getAttribute("tarifInscri").toString()) + Double.parseDouble(pageContext.getAttribute("prixAssur").toString())+ Double.parseDouble(pageContext.getAttribute("prixTarifMoi").toString());%>
									<script type="text/javascript">
										init(<%= sumClubsPlannings %>);
									</script>

<input type="submit" value="Valider et Afficher Facture"
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



	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
