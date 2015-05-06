<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Fournisseurs</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">
		<ul class="breadcrumb">

		


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminFou/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Fournisseurs
					</strong></a> 
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminF/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Fournisseur
					</strong></a></ul>
					

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
						<c:if test="${fournisseur.idPerson!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${fournisseur.idPerson==null}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Photo</th>
									<th>Nom & Prenom</th>
									<th>Adresse</th>
									


									<th>Actions</th>

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${fournisseurs}" var="four">
									<tr>






										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoFourn?idFournisseur=${four.idPerson}"
											class="images_petit" title="Cliquer pour voir la photo"
											data-toggle="tooltip"
											onclick="window.open('photoFourn?idFournisseur=${four.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>





										<td class="center">${four.nom}  ${four.prenom}</td>


										
										<td class="center">${EqEdu.adresseSociete}</td>














										<td><a class="btn btn-success" title="Afficher Details"
											data-toggle="tooltip" href="" onclick=""> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i>

										</a> <a class="btn btn-info"
											title="Modifier Fournisseur" data-toggle="tooltip"
											href="modifierListeFournisseur?idFournisseur=${four.idPerson}"
											onclick="modifierListeFournisseur?idFournisseur=${four.idPerson}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer Fournisseur"
											data-toggle="tooltip"
											href="supprimerListeFournisseur?idFournisseur=${four.idPerson}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${four.nom} ${four.prenom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a>
										
										
										
										
										
										
										
										
										
										</td>
										
										
										
									</tr>







								</c:forEach>
							</tbody>


						</table>







					</div>



					<c:if test="${fournisseur.idPerson!=null}">



						<div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>

							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Fournisseur : </font>
											 <font
													color="#000099"> ${fournisseur.nom} ${fournisseur.prenom} </font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="fournisseur"
												action="validerModificationFourn" method="post"
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
														<td><c:if test="${fournisseur.idPerson!=null}">
																<img
																	src="photoFourn?idFournisseur=${fournisseur.idPerson}"
																	class="images_petit" />

															</c:if>
															</td>
														<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
													</tr>














													

													<tr>
														<td><i class="glyphicon glyphicon-road  blue"> </i><font
															color="#585858"> <strong>Cin:</strong></font></td>
														<td><f:input path="cin" class="form-control" /></td>
														<td><f:errors path="cin" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class=" glyphicon glyphicon-home  blue"> </i><font
															color="#585858"> <strong>Adresse Societé:</strong></font></td>
														<td><f:input path="adresseSociete" class="form-control"/></td>
														<td><f:errors path="adresseSociete"
																cssClass="errors" /></td>
													</tr>




													<tr>
														<td><i class="glyphicon glyphicon-star  blue"> </i>
															<font color="#585858"> <strong>Telephone Societé: </strong></font></td>
														<td><f:input path="telephoneSociete" class="form-control"/></td>
														<td><f:errors path="telephoneSociete" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class="glyphicon glyphicon-ban-circle  blue"> </i>
															<font color="#585858"> <strong>Tel.portable: </strong></font></td>
														<td><f:input path="telephonePortable" class="form-control"/></td>
														<td><f:errors path="telephonePortable" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-ban-circle  blue"> </i>
															<font color="#585858"> <strong>Email: </strong></font></td>
														<td><f:input path="email" class="form-control"/></td>
														<td><f:errors path="email" cssClass="errors" /></td>
													</tr>
													




													<tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
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