<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Details Enfants</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>





	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">




			<pre class="prettyprint linenums">
				<strong><font color="#8C001A">Informations Generale sur l'enfant " ${enfant.nom} ${enfant.prenom} "</font></strong>
			</pre>


			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font>Inscription<font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>




						<div class="box-content" style="display: none;">


							<blockquote>
								<p>Date Inscription : ${inscritAnnee.dateInscription}</p>



								<p>Annee : ${inscritAnnee.annee}</p>





							</blockquote>





						</div>





					</div>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font>Liste
								des Clubs<font color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>




						<div class="box-content" style="display: none;">


							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Nom Clubs</th>

										<th>Catégorie</th>
										<th>Prix</th>


									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listClubActifsEnfant}" var="clu">
										<tr>
											<td>${clu.id.club.nom}</td>


											<td>${clu.id.club.categorieClub.labelle}</td>
											<td>${clu.id.club.categorieClub.prix}</td>


										</tr>
									</c:forEach>
								</tbody>
							</table>





						</div>





					</div>
				</div>
			</div>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font>Liste
								des Plannings Horraires<font color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>




						<div class="box-content" style="display: none;">


							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Type Planning</th>
										<th>Prix Planning</th>


									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listPlanningActifsEnfant}" var="pl">
										<tr>
											<td>${pl.id.planningHorraires.typePlanning}</td>
											<td>${pl.id.planningHorraires.prixPlanning}</td>



										</tr>
									</c:forEach>
								</tbody>
							</table>





						</div>





					</div>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font>Liste
								des Evennements<font color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>




						<div class="box-content" style="display: none;">


							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Nom</th>
										<th>Type</th>
										<th>Fraix</th>
										<th>Lieu</th>


									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listEvenementActifsEnfant}" var="even">
										<tr>
											<td>${even.id.evenement.nom}</td>
											<td>${even.id.evenement.type}</td>
											<td>${even.id.evenement.fraix}</td>
											<td>${even.id.evenement.lieu}</td>





										</tr>
									</c:forEach>
								</tbody>
							</table>



						</div>




					</div>
				</div>
			</div>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<!--  <div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font>Liste
								des Consultations<font color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>




						<div class="box-content" style="display: none;">

							<blockquote>
							
								<p>Date Consultation : ${consjour.date}</p>



								<p>Description : ${consjour.description}</p>





							</blockquote>


						</div>




					</div>
				</div>
			</div>-->






		</div>

	</div>






	<!-- footer -->

	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>