<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Categories Clubs</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">


			<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminCategC/index"/>"> <strong><i
					class="glyphicon glyphicon-folder-open"> </i> Liste Categories Clubs
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminCateg/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouvelle Categorie Clubs
					</strong></a>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-folder-open"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${categorieClub.idCategorie!=null}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${categorieClub.idCategorie==null}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Labelle</th>
									<th>Prix</th>
									<th>Date</th>


									<th>Actions</th>

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${CategorieClubs}" var="cat">
									<tr>






										<!--  <td>${fonc.idFonction}</td>-->

										<td class="center">${cat.labelle} </td>
										<td class="center">${cat.prix} </td>
										<td class="center">${cat.date} </td>
										
										
										
										<td><a class="btn btn-success" title="Afficher Details"
											data-toggle="tooltip" href="" onclick=""> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i>

										</a> <a class="btn btn-info"
											title="Modifier Categorie Club" data-toggle="tooltip"
											href="modifierListeCategorieClub?idCategorieClub=${cat.idCategorie}"
											onclick="modifierListeCategorieClub?idCategorieClub=${cat.idCategorie}">
												<i class="glyphicon glyphicon-edit icon-white"></i>

										</a> <a class="btn btn-danger"
											title="Supprimer categorie Club"
											data-toggle="tooltip"
											href="supprimerListeCategorieClub?idCategorieClub=${cat.idCategorie}"
											onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${cat.labelle} ?');">
												<i class="glyphicon glyphicon-trash icon-white"></i>
										</a></td>
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
						

					</div>
						
	
	
	          <c:if test="${categorieClub.idCategorie!=null}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Categorie :</font>
												 <font
													color="#000099">  ${categorieClub.labelle}  </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="categorieClub"
												action="validerModificationCateg" method="post">
												
												<table>


													<f:input type="hidden" path="idCategorie" />
													<f:errors type="hidden" path="idCategorie" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Labelle : * </strong></font></td>
														<td><f:input path="labelle" class="form-control" /></td>
														<td><f:errors path="labelle" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-usd  blue"> </i><font
															color="#585858"><strong> Prix : * </strong></font></td>
														<td><f:input path="prix" class="form-control" /></td>
														<td><f:errors path="prix" cssClass="errors" /></td>
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
																		title="Annuler et retourner à la liste des Categories"
																		data-toggle="tooltip"
																		href="<c:url value="/adminCategC/index"/>">Annuler</a>
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