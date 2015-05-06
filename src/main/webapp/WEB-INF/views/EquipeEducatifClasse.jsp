<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Equipes Educatifs</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



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
					
					
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminEduClass/index"/>"> <strong><i
					class=" glyphicon glyphicon-gift"> </i>Affectation Classes
					</strong></a>
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEduCategEq/index"/>"> <strong><i
					class="glyphicon glyphicon-bookmark"> </i>  Affectation Categories Clubs</strong></a>
					
					
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEduMateriel/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i>  Affectation Materiels</strong></a>
					</ul>
					




			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${equipeEducatif.idPerson!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${equipeEducatif.idPerson==null}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Actions</th>
									<th>Photo</th>
									<th>Nom & Prenom</th>
									<th>Fonction</th>
									<th>Sexe</th>


									

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${equipeEducatifs}" var="EqEdu">
									<tr>
									
									
										<td>
										
										<a class="btn btn-primary btn-round btn-lg"
											title="Affecter Classe" data-toggle="tooltip"
											href="<c:url value="/adminEqCla/choisirClasses?idEquiEducatif=${EqEdu.idPerson}"/>">

												<i class="glyphicon glyphicon-gift"></i>

										</a>
										
										</td>
										



										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoEqEdu?idEquipeEducatif=${EqEdu.idPerson}"
											class="images_petit" title="Cliquer pour voir la photo"
											data-toggle="tooltip"
											onclick="window.open('photoEqEdu?idEquipeEducatif=${EqEdu.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>





										<td class="center">${EqEdu.nom}  ${EqEdu.prenom}</td>


										<td class="center">${EqEdu.fonction.labelle}</td>
										<td class="center">${EqEdu.sexe}</td>






										
										
									</tr>







								</c:forEach>
							</tbody>


						</table>






					</div>



					<c:if test="${equipeEducatif.idPerson!=null}">



						<div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>

							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Membre : </font>
											 <font
													color="#000099">  ${equipeEducatif.nom} ${equipeEducatif.prenom} </font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="equipeEducatif"
												action="validerModificationEqEdu" method="post"
												enctype="multipart/form-data">


												<table>


													<f:input type="hidden" path="idPerson" />
													<f:errors type="hidden" path="idPerson" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Nom : * </strong></font></td>
														<td><f:input path="nom" class="form-control" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>

													<tr>
														<td><i class="glyphicon glyphicon-tags  blue"> </i> <font
															color="#585858"><strong> Prenom : *</strong></font></td>
														<td><f:input path="prenom" class="form-control"/></td>
														<td><f:errors path="prenom" cssClass="errors" /></td>
													</tr>


													<tr>
														<td><i class="glyphicon glyphicon-camera blue"> </i>
															<font color="#585858"><strong> Photo : *
															</strong></font></td>
														<td><c:if test="${equipeEducatif.idPerson!=null}">
																<img
																	src="photoEqEdu?idEquipeEducatif=${equipeEducatif.idPerson}"
																	class="images_petit" />

															</c:if>
															</td>
														<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
													</tr>






													<tr>
														<td><i class="glyphicon glyphicon-usd  blue"> </i><font
															color="#585858"><strong>Fonction</strong></font></td>
														<td><f:select path="fonction.idFonction"
																items="${fonctions}" itemValue="idFonction"
																itemLabel="labelle" class="form-control"></f:select></td>
														<td><f:errors path="fonction.idFonction"
																items="${fonctions}" itemValue="idFonction"
																itemLabel="labelle" cssClass="errors" /></td>
													</tr>







													<tr>
														<td><i class=" glyphicon glyphicon-user  blue"> </i>
															<font color="#585858"><strong> Sexe :</strong></font></td>
														<td><f:radiobutton path="sexe" value="Homme"
																checked="true" /> Homme <f:radiobutton path="sexe"
																value="Femme" /> Femme</td>


													</tr>


													<tr>
														<td><i class="glyphicon glyphicon-calendar  blue">
														</i> <font color="#585858"><strong>Date
																	Naissance : *</strong></font></td>
														<td><f:input type="date" path="dateNaissance" class="form-control" /></td>
														<td><f:errors path="dateNaissance" cssClass="errors" /></td>
													</tr>

													<tr>
														<td><i class="glyphicon glyphicon-road  blue"> </i><font
															color="#585858"> <strong>Lieu Naissance:</strong></font></td>
														<td><f:input path="lieuNaissance" class="form-control" /></td>
														<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class=" glyphicon glyphicon-home  blue"> </i><font
															color="#585858"> <strong>Adresse:</strong></font></td>
														<td><f:input path="adresseDomicile" class="form-control"/></td>
														<td><f:errors path="adresseDomicile"
																cssClass="errors" /></td>
													</tr>




													<tr>
														<td><i class="glyphicon glyphicon-star  blue"> </i>
															<font color="#585858"> <strong>Nom
																	Utilisateur: </strong></font></td>
														<td><f:input path="nomUtilisateur" class="form-control"/></td>
														<td><f:errors path="nomUtilisateur" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class="glyphicon glyphicon-ban-circle  blue"> </i>
															<font color="#585858"> <strong>Mot de
																	Passe: </strong></font></td>
														<td><f:input path="motPasse" class="form-control"/></td>
														<td><f:errors path="motPasse" cssClass="errors" /></td>
													</tr>




													<tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Membres d'Equipe Educatif"
																		data-toggle="tooltip"
																		href="<c:url value="/adminListEdu/index"/>">Annuler</a>
																</div>
															</div>
														</td>
													</tr>

												</table>


											</f:form>




										</div>
									</div>
								</div>

							</div>




						</div>
					</c:if>


				</div>
			</div>
		</div>
	</div>

	</div>




	</div>
	</div>

	<!-- footer -->

	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>