<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Plannings Horraires</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminPlanLi/index"/>"> <strong><i
					class="glyphicon glyphicon-time"> </i> Liste Plannings Horraires
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminPlan/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Planning Horraire
					</strong></a>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-time"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${planningHorraire.idPlanningH!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${planningHorraire.idPlanningH==null}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>type</th>
									
									<th>Prix</th>
									


									<th>Actions</th>

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${planningHorraires}" var="plHo">
									<tr>






										<!--  <td>${clu.idClub}</td>-->
										<td class="center">${plHo.typePlanning} </td>

										<td class="center">${plHo.prixPlanning} </td>
										
										
										
										
										<td><a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/planningEnfList/voirListEnfantParPlanning?idPlanning=${plHo.prixPlanning}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>
												

										</a> <a class="btn btn-info"
											title="Modifier planning horraire" data-toggle="tooltip"
											href="modifierListePlanningHorraires?idPlanningHo=${plHo.idPlanningH}"
											onclick="modifierListePlanningHorraires?idPlanningHo=${plHo.idPlanningH}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer planning horraire"
											data-toggle="tooltip"
											href="supprimerListePlanningHorraires?idPlanningHo=${plHo.idPlanningH}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${plHo.typePlanning} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
						
							
					</div>
						
	
	
	          <c:if test="${planningHorraire.idPlanningH!=null}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du planning horraire :</font>
											 <font
													color="#000099"> ${planningHorraire.typePlanning} </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="planningHorraire"
												action="validerModificationPlanHor" method="post">
												
												<table>


													<f:input type="hidden" path="idPlanningH" />
													<f:errors type="hidden" path="idPlanningH" cssClass="errors" />


                                                   <tr>
														<td><i class="glyphicon glyphicon-bookmark  blue"> </i><font
															color="#585858"><strong> Type : * </strong></font></td>
														<td><f:textarea path="typePlanning" class="form-control" /></td>
														<td><f:errors path="typePlanning" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class="glyphicon glyphicon-usd   blue"> </i><font
															color="#585858"><strong> Prix : * </strong></font></td>
														<td><f:input path="prixPlanning" class="form-control" /></td>
														<td><f:errors path="prixPlanning" cssClass="errors" /></td>
													</tr>
													
													
													
													
											
	
	                                              <tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des plannings horraires"
																		data-toggle="tooltip"
																		href="<c:url value="/adminPlanLi/index"/>">Annuler</a>
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