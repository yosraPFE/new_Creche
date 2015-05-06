<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Clubs</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminClubLi/index"/>"> <strong><i
					class=" glyphicon glyphicon-inbox"> </i> Liste Clubs
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminClub/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Club
					</strong></a>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-inbox"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${club.idClub!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${club.idClub==null}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Nom</th>
									<th>Categorie Club</th>
									<th>Nombre Participants Maximum</th>
									<th>Date</th>


									<th>Actions</th>

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${clubs}" var="clu">
									<tr>






										<!--  <td>${clu.idClub}</td>-->

										<td class="center">${clu.nom} </td>
										<td class="center">${clu.categorieClub.labelle} </td>
										<td class="center">${clu.nombreMaxPart} </td>
										<td class="center">${clu.categorieClub.date} </td>
										
										
										
										<td><a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/ClubEnfList/voirListEnfantParClubs?idClub=${clu.idClub}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>
												
											
												
												

										 <a class="btn btn-info"
											title="Modifier club" data-toggle="tooltip"
											href="modifierListeClubs?idClubs=${clu.idClub}"
											onclick="modifierListeClubs?idClubs=${clu.idClub}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer club"
											data-toggle="tooltip"
											href="supprimerListeClubs?idClubs=${clu.idClub}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${clu.nom} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
						
							

					</div>
						
	
	
	          <c:if test="${club.idClub!=null}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Club :</font>
												 <font
													color="#000099">  ${club.nom} </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="club"
												action="validerModificationClub" method="post">
												
												<table>


													<f:input type="hidden" path="idClub" />
													<f:errors type="hidden" path="idClub" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Nom : * </strong></font></td>
														<td><f:input path="nom" class="form-control" /></td>
														<td><f:errors path="nom" cssClass="errors" /></td>
													</tr>
													
													
													
													
													 <tr>
           <td><i class="glyphicon glyphicon-folder-open  blue"> </i> <font
															color="#585858"><strong> Categorie Clubs</strong></font></td>
           <td><f:select path="categorieClub.idCategorie" items="${CategorieClubs}" itemValue="idCategorie" itemLabel="labelle" class="form-control"></f:select></td>
           <td><f:errors path="categorieClub.idCategorie" items="${CategorieClubs}" itemValue="idCategorie" itemLabel="labelle" class="form-control" cssClass="errors"/></td>
           </tr>
           
                                                      <tr>
														<td><i class="glyphicon glyphicon-exclamation-sign  blue"> </i><font
															color="#585858"><strong> Nombre Maximum d'integration: * </strong></font></td>
														<td><f:input path="nombreMaxPart" class="form-control" /></td>
														<td><f:errors path="nombreMaxPart" cssClass="errors" /></td>
													</tr>
											
	
	                                              <tr>
	                                              
	                                              
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Clubs"
																		data-toggle="tooltip"
																		href="<c:url value="/adminClubLi/index"/>">Annuler</a>
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