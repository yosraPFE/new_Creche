<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste des Paiements Mensuels</title>
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
		document.formulaire.montantApresRemise.value = Math.round(total*1000)/1000;
		calculRemise();
	}
	
	function calculRemise(){
		remise = document.getElementById("remise").value;
		afterReduce = total - (total * remise / 100);
		document.formulaire.montantApresRemise.value = Math.round(afterReduce*1000)/1000;
		
		document.formulaire.montantApresRemiseHidden.value = document.formulaire.montantApresRemise.value;
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
										<i class="glyphicon glyphicon-usd"></i>  Paiements Mensuels de l'enfant :   
									<font color="#8C001A">  ${enfant.nom} ${enfant.prenom} </font>
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									</div>
								</div>
								<div class="box-content">

									<f:form name="formulaire" action="doPayments" method="GET">
									
									
									<pre class="prettyprint linenums"><strong><font color="#8C001A">liste Paiements</font></strong></pre>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nature</th>
													<th>Mois</th>
													<th>Date de Paiement</th>
													<th>Montant Avant Remise</th>
													<th>Remise</th>
													<th>Montant Après Remise</th>
													<th>Paiement</th>
												</tr>
												
												
											</thead>
											<tbody>

												<c:forEach items="${listPayments}" var="pay" varStatus="status">
													<tr>
														<td>${pay.naturePayement}</td>
														<td>${pay.id.moisPayment}</td>
														<td>${pay.datePayement}</td>
														<c:choose>
															<c:when test="${pay.datePayement  == null}">
															<input type="hidden" name="mois" value="${pay.id.moisPayment}" />
															<input type="hidden" id ="montantApresRemiseHidden" name="montantApresRemiseHidden" />
																<td>
																<input id = "montantAvantRemise" type="text" value="${pay.montantAvantRemise}" name ="montantAvantRemise" disabled="disabled">
																<c:set var="montantAvantRemise" value="${pay.montantAvantRemise}"/>
																</td>
																<td>															
																<input id="remise" type="text" name="remise" value="${pay.remise}" onkeyup ="calculRemise()"/>
																</td>
																<td><input type="text" value="${pay.montantApresRemise}" name ="montantApresRemise" disabled="disabled"></td>
																<script type="text/javascript">
																	init(<%= Double.parseDouble(pageContext.getAttribute("montantAvantRemise").toString()) %>);
																</script>
																<td><input type="submit" value="Paiement"	class="btn btn-primary btn-sm"></td>
															</c:when>
															<c:otherwise>
																<td>${pay.montantAvantRemise}</td>
																<td>${pay.remise}</td>
																<td>${pay.montantApresRemise}</td>
																<td>Payé</td>
															</c:otherwise>															
															</c:choose>
														
														
														
	
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										
										
									
										<!-- **************************************** -->
										
										
										<input type="hidden" name="idEnf" value="${enfant.idPerson}" />
										
									
										
											
									
									

				
										
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
