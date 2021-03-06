<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Equipe Sanitaire</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">
		<ul class="breadcrumb">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminListSan/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Membres Equipe
					Sanitaire</strong></a> 
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEqSan/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Membre Equipe
					Sanitaire</strong></a>
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminSaMater/index"/>"> <strong><i
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
						<c:if test="${equipeSanitaire.idPerson!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${equipeSanitaire.idPerson==null}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Photo</th>
									<th>Nom & Prenom</th>
									<th>Fonction</th>
									<th>Sexe</th>


									<th>Actions</th>

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${equipeSanitaires}" var="EqSan">
									<tr>






										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoEqSan?idEquipeSanitaire=${EqSan.idPerson}"
											class="images_petit" title="Cliquer pour voir la photo"
											data-toggle="tooltip"
											onclick="window.open('photoEqSan?idEquipeSanitaire=${EqSan.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>





										<td class="center">${EqSan.nom}  ${EqSan.prenom}</td>


										<td class="center">${EqSan.fonction.labelle}</td>
										<td class="center">${EqSan.sexe}</td>














										<td><a class="btn btn-success" title="Afficher Details"
											data-toggle="tooltip" href="" onclick=""> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i>

										</a> <a class="btn btn-info"
											title="Modifier Membre Equipe Sanitaire" data-toggle="tooltip"
											href="modifierListeEquipeSanitaire?idEquipeSanitaire=${EqSan.idPerson}"
											onclick="modifierListeEquipeSanitaire?idEquipeSanitaire=${EqSan.idPerson}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer Membre Equipe Sanitaire"
											data-toggle="tooltip"
											href="supprimerListeEquipeSanitaire?idEquipeSanitaire=${EqSan.idPerson}"
											onclick="return confirm('�tes-vous s�r de vouloir supprimer ${EqSan.nom} ${EqSan.prenom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a>
										
										
										<a  class="btn btn-success" title="Affecter materiels"
											data-toggle="tooltip" href="<c:url value="/adminEqSanMater/choisirMateriles?idEquiSanitaire=${EqSan.idPerson}"/>">
											
													<i class="glyphicon glyphicon-briefcase"></i>
										
										</a>
										
										
										
										
										
										
										</td>
									</tr>







								</c:forEach>
							</tbody>


						</table>

			

					</div>



					<c:if test="${equipeSanitaire.idPerson!=null}">



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
													color="#000099"> ${equipeSanitaire.nom} ${equipeSanitaire.prenom} </font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="equipeSanitaire"
												action="validerModificationEqSan" method="post"
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
														<td><c:if test="${equipeSanitaire.idPerson!=null}">
																<img
																	src="photoEqSan?idEquipeSanitaire=${equipeSanitaire.idPerson}"
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
																		title="Annuler et retourner � la liste des Membres d'Equipe Sanitaire"
																		data-toggle="tooltip"
																		href="<c:url value="/adminListSan/index"/>">Annuler</a>
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