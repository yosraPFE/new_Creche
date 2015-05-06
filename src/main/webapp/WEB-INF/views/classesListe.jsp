<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Classe</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminClasLi/index"/>"> <strong><i
					class="glyphicon glyphicon-gift"> </i> Liste Classes
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminClas/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouvelle Classe
					</strong></a>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-gift"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${classe.idClasse!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${classe.idClasse==null}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Nom</th>
									
									<th>Nombre de places</th>
									
									


									<th>Actions</th>

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${classes}" var="clas">
									<tr>






										<!--  <td>${clu.idClub}</td>-->

										<td class="center">${clas.nom} </td>
										
										
										<td class="center">${clas.nombrePlaces} </td>
										
										
										
										
										
										
										<td><td><a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/ClassEnfList/voirListEnfantParClass?idClass=${clas.idClasse}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>

										</a> <a class="btn btn-info"
											title="Modifier classe" data-toggle="tooltip"
											href="modifierListeClasse?idClasse=${clas.idClasse}"
											onclick="modifierListeClasse?idClasse=${clas.idClasse}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer club"
											data-toggle="tooltip"
											href="supprimerListeClasse?idClasse=${clas.idClasse}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${clas.nom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
				
						
						
					</div>
						
	
	
	          <c:if test="${classe.idClasse!=null}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Classe :</font>
												 <font
													color="#000099"> ${classe.nom} </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="classe"
												action="validerModificationClas" method="post">
												
												<table>


													<f:input type="hidden" path="idClasse" />
													<f:errors type="hidden" path="idClasse" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Nom : * </strong></font></td>
														<td><f:input path="nom" class="form-control" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>
													
													
													
													
													
														<td><i class="glyphicon glyphicon-exclamation-sign  blue"> </i><font
															color="#585858"><strong> Nombre de places : * </strong></font></td>
														<td><f:input path="nombrePlaces" class="form-control" /></td>
														<td><f:errors path="nombrePlaces" cssClass="errors" /></td>
													</tr>
           

											
	
	                                              <tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Classe"
																		data-toggle="tooltip"
																		href="<c:url value="/adminClasLi/index"/>">Annuler</a>
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