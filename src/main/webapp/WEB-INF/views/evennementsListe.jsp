<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Evennements</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminEv/index"/>"> <strong><i
					class="glyphicon glyphicon-bell"> </i> Liste Evennements
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminEvenAj/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouvelle Evennement
					</strong></a>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-bell"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${evennement.idEvenement!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${evennement.idEvenement==null}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Nom</th>
									<th>Type</th>
									<th>Lieu</th>
									<th>Fraix</th>
									<th>Date</th>


									<th>Actions</th>

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${evennements}" var="even">
									<tr>






										<!--  <td>${fonc.idFonction}</td>-->

										<td class="center">${even.nom} </td>
										<td class="center">${even.type} </td>
										<td class="center">${even.lieu} </td>
										<td class="center">${even.fraix} </td>
										<td class="center">${even.date} </td>
										
										
										
										<td><a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/EvennEnfList/voirListEnfantParEvenn?idEvenn=${even.idEvenement}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>
												
												

										</a> <a class="btn btn-info"
											title="Modifier Evennement" data-toggle="tooltip"
											href="modifierListeEvennement?idEvennement=${even.idEvenement}"
											onclick="modifierListeEvennement?idEvennement=${even.idEvenement}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer Evennement"
											data-toggle="tooltip"
											href="supprimerListeEvennement?idEvennement=${even.idEvenement}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${even.nom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
						
							

					</div>
						
	
	
	          <c:if test="${evennement.idEvenement!=null}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification de l'evennement :</font>
										 <font
													color="#000099"> ${evennement.nom} </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="evennement"
												action="validerModificationEven" method="post">
												
												<table>


													<f:input type="hidden" path="idEvenement" />
													<f:errors type="hidden" path="idEvenement" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Nom : * </strong></font></td>
														<td><f:input path="nom" class="form-control" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-bookmark  blue"> </i><font
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
														<td><f:input path="date" type="datetime-local" class="form-control" /></td>
														<td><f:errors path="date" type="datetime-local" cssClass="errors" /></td>
													</tr>
													

											
	
	<tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Evennements"
																		data-toggle="tooltip"
																		href="<c:url value="/adminEv/index"/>">Annuler</a>
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