<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Creches</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminCr/index"/>"> <strong><i
					class=" glyphicon glyphicon-home"> </i> Liste Creche
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminCrech/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouvelle Creche
					</strong></a>




			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-home"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${creche.idCreche!=0}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${creche.idCreche==0}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Photo</th>
									<th>Nom</th>
									<th>Adresse</th>
									<th>Site Web</th>
									<th>Ville</th>
									<th>Telephone</th>
									<th>Tarif Inscription</th>
									<th>Tarif Assurance</th>
									<th>Tarif paiement par mois</th>


									<th>Actions</th>

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${creches}" var="cre">
									<tr>






										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoCrech?idCreche=${cre.idCreche}"
											class="images_petit" title="Cliquer pour voir la photo"
											data-toggle="tooltip"
											onclick="window.open('photoCrech?idCreche=${cre.idCreche}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>





										<td class="center">${cre.nom}</td>


										<td class="center">${cre.adresse}</td>
										<td class="center">${cre.siteWeb}</td>
										<td class="center">${cre.ville}</td>
										<td class="center">${cre.telephone}</td>
										<td class="center">${cre.tarifInscription}</td>
										<td class="center">${cre.tarifAssurance}</td>
										<td class="center">${cre.tarifParMois}</td>














										<td><a class="btn btn-success" title="Afficher Details"
											data-toggle="tooltip" href="" onclick=""> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i>

										</a> <a class="btn btn-info"
											title="Modifier Creche" data-toggle="tooltip"
											href="modifierListeCreche?idCreche=${cre.idCreche}"
											onclick="modifierListeCreche?idCreche=${cre.idCreche}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer Creche"
											data-toggle="tooltip"
											href="supprimerListeCreche?idCreche=${cre.idCreche}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${cre.nom}  ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
										
										
										
									</tr>







								</c:forEach>
							</tbody>


						</table>






						
					</div>



					<c:if test="${creche.idCreche!=0}">



						<div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>

							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Creche :</font>
												 <font
													color="#000099">  ${creche.nom} </font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="creche"
												action="validerModificationCrech" method="post"
												enctype="multipart/form-data">


												<table>


													<f:input type="hidden" path="idCreche" />
													<f:errors type="hidden" path="idCreche" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Nom : * </strong></font></td>
														<td><f:input path="nom" class="form-control" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>

													<tr>
														<td><i class="glyphicon glyphicon-road  blue"> </i> <font
															color="#585858"><strong> Adresse : *</strong></font></td>
														<td><f:input path="adresse" class="form-control"/></td>
														<td><f:errors path="adresse" cssClass="errors" /></td>
													</tr>


													<tr>
														<td><i class="glyphicon glyphicon-camera blue"> </i>
															<font color="#585858"><strong> Photo : *
															</strong></font></td>
														<td><c:if test="${creche.idCreche!=null}">
																<img
																	src="photoCrech?idCreche=${creche.idCreche}"
																	class="images_petit" />

															</c:if>
															</td>
														<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
													</tr>








													<tr>
														<td><i class="glyphicon glyphicon-globe blue"> </i><font
															color="#585858"> <strong>Site Web:</strong></font></td>
														<td><f:input path="siteWeb" class="form-control" /></td>
														<td><f:errors path="siteWeb" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-flag  blue"> </i><font
															color="#585858"> <strong>Ville:</strong></font></td>
														<td><f:input path="ville" class="form-control" /></td>
														<td><f:errors path="ville" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-phone-alt  blue"> </i><font
															color="#585858"> <strong>Telephone:</strong></font></td>
														<td><f:input path="telephone" class="form-control" /></td>
														<td><f:errors path="telephone" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-phone-alt  blue"> </i><font
															color="#585858"> <strong>Tarif Inscription:</strong></font></td>
														<td><f:input path="tarifInscription" class="form-control" /></td>
														<td><f:errors path="tarifInscription" cssClass="errors" /></td>
													</tr>
													
													<tr>
														<td><i class="glyphicon glyphicon-phone-alt  blue"> </i><font
															color="#585858"> <strong>Tarif Assurance:</strong></font></td>
														<td><f:input path="tarifAssurance" class="form-control" /></td>
														<td><f:errors path="tarifAssurance" cssClass="errors" /></td>
													</tr>
													
													<tr>
														<td><i class="glyphicon glyphicon-phone-alt  blue"> </i><font
															color="#585858"> <strong>Tarif paiement par mois:</strong></font></td>
														<td><f:input path="tarifParMois" class="form-control" /></td>
														<td><f:errors path="tarifParMois" cssClass="errors" /></td>
													</tr>
													






													




													<tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Creches"
																		data-toggle="tooltip"
																		href="<c:url value="/adminCr/index"/>">Annuler</a>
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