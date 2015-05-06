<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Accompagnateurs</title>
</head>

<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/admin/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Accompagnateurs</strong></a>







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
						<c:if test="${accompagnateur.idPerson!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${accompagnateur.idPerson==null}">
							<div class="box-content">
						</c:if>



						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									<th>Photo</th>
									<th>Nom & Prenom</th>
									<th>Active?</th>

									<th>Cin</th>
									<th>Description</th>


									<th>Actions</th>

								</tr>
							</thead>

							<tbody>

								<c:forEach items="${accompagnateurs}" var="acc">
									<tr>






										<!--  <td>${en.idPerson}</td>-->

										<td width=100px><img
											src="photoAccomp?idAccompagnateur=${acc.idPerson}"
											class="images_petit" title="Cliquer pour voir la photo"
											data-toggle="tooltip"
											onclick="window.open('photoAccomp?idAccompagnateur=${acc.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>


										<td class="center">${acc.nom}  ${acc.prenom}</td>

										
													<c:if test="${acc.active==true}">
														<td class="center"><button
																class="btn btn-round btn-default btn-lg">
																<i class="glyphicon glyphicon-thumbs-up"></i>
															</button></td>
													</c:if>

													<c:if test="${acc.active==false}">
														<td class="center"><button
																class="btn btn-round btn-default btn-lg">
																<i class="glyphicon glyphicon-thumbs-down"></i>
															</button></td>
													</c:if>


										<td class="center">${acc.cin}</td>

										<td class="center">${acc.description}</td>















										<td>
										
										<a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/AccompEnfList/voirListEnfantParAccomp?idAccomp=${acc.idPerson}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>
										
										
										
										
										
										
										 <a class="btn btn-info" title="Modifier Accompagnateur"
											data-toggle="tooltip"
											href="modifierListeAccompagnateur?idAccompagnateur=${acc.idPerson}"
											onclick="modifierListeAccompagnateur?idAccompagnateur=${acc.idPerson}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger" title="Supprimer Accompagnateur"
											data-toggle="tooltip"
											href="supprimerListeAccompagnateur?idAccompagnateur=${acc.idPerson}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${acc.nom} ${acc.prenom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
									</tr>







								</c:forEach>
							</tbody>


						</table>



				
					</div>



					<c:if test="${accompagnateur.idPerson!=null}">



						<div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>

							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification de l'Accompagnateur:
													${accompagnateur.nom} ${accompagnateur.prenom}</font>
											</h2>


											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>


										</div>
										<div class="box-content">

											<f:form modelAttribute="accompagnateur"
												action="validerModificationAccomp" method="post"
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
														<td><f:input path="prenom" class="form-control" /></td>
														<td><f:errors path="prenom" cssClass="errors" /></td>
													</tr>

													
													
													
													
													


													<tr>
														<td><i class="glyphicon glyphicon-camera blue"> </i>
															<font color="#585858"><strong> Photo : *
															</strong></font></td>
														<td><c:if test="${accompagnateur.idPerson!=null}">
																<img
																	src="photoAccomp?idAccompagnateur=${accompagnateur.idPerson}"
																	class="images_petit" />

															</c:if></td>
														<td><input type="file" name="file" /><br> <!--<f:textarea
								path="nomPhoto" readonly="true" />--></td>
													</tr>
													
													
													
													<tr>
														<td><i class="glyphicon glyphicon-thumbs-up  blue">
														</i> <font color="#585858"> <strong>Active?
															</strong></font></td>
														<td><f:checkbox path="active" /></td>
														<td><f:errors path="active"
																cssClass="errors" /></td>
													</tr>






													<tr>
														<td><i class="glyphicon glyphicon-edit  blue"> </i><font
															color="#585858"> <strong>Cin:</strong></font></td>
														<td><f:input path="Cin" class="form-control" /></td>
														<td><f:errors path="Cin" cssClass="errors" /></td>
													</tr>





													<tr>
														<td><i class="glyphicon glyphicon-pencil  blue">
														</i> <font color="#585858"> <strong>Description
															</strong></font></td>
														<td><f:textarea path="description"
																class="form-control" /></td>
														<td><f:errors path="description" cssClass="errors" /></td>
													</tr>







													<tr>
														<td><i class="glyphicon glyphicon-phone  blue"> </i><font
															color="#585858"> <strong>Tel.portable : </strong></font></td>
														<td><f:input path="telephonePortable"
																class="form-control" /></td>
														<td><f:errors path="telephonePortable"
																cssClass="errors" /></td>
													</tr>






													<tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Accompagnateurs"
																		data-toggle="tooltip"
																		href="<c:url value="/admin/index"/>">Annuler</a>
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