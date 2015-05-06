<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouvelle Evennement</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminEv/index"/>"> <strong><i
				class="glyphicon glyphicon-bell"> </i> Liste Evennements</strong></a> <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminEvenAj/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouveau Evennement </strong></a>





		<div class="row">
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-plus"> </i>
						</h2>

						<div class="box-icon">

							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a>

						</div>


						<div class="box-content row"></div>

					</div>


					<c:if test="${not empty evennementAjoute}">
						<div class="box-content row" style="display: none;">
					</c:if>


					<c:if test="${empty evennementAjoute}">
						<div class="box-content row">
					</c:if>

					<div class="col-lg-7 col-md-12">




						<f:form modelAttribute="evennement" action="ajouterEvennement"
							method="post">

							<table>


								<tr>
									<!--  <td>ID</td>-->
									<td><f:input type="hidden" disabled="true"
											path="idEvenement" /></td>
									<td><f:errors type="hidden" path="idEvenement"
											cssClass="errors" /></td>
								</tr>



								<tr>
									<td><i class="glyphicon glyphicon-tag  blue"> </i><font
										color="#585858"><strong> Nom : * </strong></font></td>
									<td><f:input path="nom" class="form-control" /></td>
									<td><f:errors path="nom" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-tag  blue"> </i><font
										color="#585858"><strong> Type : * </strong></font></td>
									<td><f:input path="type" class="form-control" /></td>
									<td><f:errors path="type" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class=" glyphicon glyphicon-home  blue"> </i><font
										color="#585858"><strong> Lieu : * </strong></font></td>
									<td><f:input path="lieu" class="form-control" /></td>
									<td><f:errors path="lieu" cssClass="errors" /></td>
								</tr>




								<tr>
									<td><i class="glyphicon glyphicon-usd   blue"> </i><font
										color="#585858"><strong> Fraix : * </strong></font></td>
									<td><f:input path="fraix" class="form-control" /></td>
									<td><f:errors path="fraix" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-time  blue"> </i><font
										color="#585858"><strong> Date : * </strong></font></td>
									<td><f:input path="date" type="datetime-local"
											class="form-control" /></td>
									<td><f:errors path="date" type="datetime-local"
											cssClass="errors" /></td>
								</tr>


								<tr>
									<td>


										<div class="control-group" align="center">

											<div class="controls">
												<button type="submit" class="btn btn-success"
													title="Valider et afficher details" data-toggle="tooltip">Valider</button>
												<a class="btn btn-danger"
													title="Annuler et retourner à la liste des Fournisseurs"
													data-toggle="tooltip"
													href="<c:url value="/adminFou/index"/>">Annuler</a>
											</div>
										</div>
									</td>
								</tr>

							</table>

						</f:form>

					</div>

				</div>
				<c:if test="${not empty evennementAjoute}">



					<div id="content" class="col-lg-12 col-sm-12">

						<div></div>

						<div class="row">
							<div class="box col-md-12">
								<div class="box-inner">
									<div class="box-header well" data-original-title="">
										<h2>
											<i class="glyphicon glyphicon-align-justify"></i> <font
												color="#8C001A">Details d'ajout dE L'evennement</font>
										</h2>


										<div class="box-icon">

											<a href="#" class="btn btn-minimize btn-round btn-default"><i
												class="glyphicon glyphicon-chevron-up"></i></a>
										</div>

									</div>
									<div class="box-content"></div>

									<div class="box-content row">
										<div class="col-lg-7 col-md-12">



											<h1>Ajout avec succès!</h1>

											</br>



											<p>
												<b> C'est L'evennement ${evennementAjoute.nom} , du type
													${evennementAjoute.type} , du fraix
													${evennementAjoute.fraix} traité pour la date
													${evennementAjoute.date} a eté ajoutée ! </b>

											</p>









										</div>


										<div class="box-content"></div>



									</div>
								</div>




							</div>








						</div>
				</c:if>



			</div>
		</div>
	</div>





























	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>
