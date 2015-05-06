<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Liste Materiels</title>
</head>



<body>



	<!-- Menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	
	
	<!-- table -->



	<div>


		<div id="content" class="col-lg-10 col-sm-10">
		<ul class="breadcrumb">


			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminMaterielLi/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i> Liste Materiels
					</strong></a> <a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminMater/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Materiel
					</strong></a>
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminFouurMater/index"/>"> <strong><i
					class="glyphicon glyphicon-user"> </i>  Affectation Fournisseurs</strong></a>


	</ul>
	
	
	
	
	
	<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">




						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-wrench"></i> <font color="#8C001A"></font><font
									color="#8C001A"></font>
							</h2>

							<div class="box-icon">

								<a href="#" class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i></a>

							</div>
						</div>
						<c:if test="${materiel.idMateriel!=0}">
							<div class="box-content" style="display: none;">
						</c:if>
						<c:if test="${materiel.idMateriel==0}">
							<div class="box-content">
						</c:if>
						
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<!--  <th >Id</th>-->
									
									<th>Actions</th>
									
									<th>Designation</th>
									<th>Description</th>
									<th>Prix</th>
									<th>Type</th>
									<th>Stock</th>


									

								</tr>
							</thead>
							
							
							
							<tbody>

								<c:forEach items="${materiels}" var="m">
									<tr>
									
									
									<td>
										
										<a  class="btn btn-primary btn-round btn-lg" title="Affectation Fournisseurs"
											data-toggle="tooltip" href="<c:url value="/FournMateriel/choisirFournisseurs?idMateriel=${m.idMateriel}"/>">
											
													<i class="glyphicon glyphicon-user"></i>
										
										</a> 
										
										
										
										</td>






										<!--  <td>${clu.idClub}</td>-->

										<td class="center">${m.designation} </td>
										<td class="center">${m.description} </td>
										<td class="center">${m.prix} </td>
										
										<td class="center">${m.typeMateriels.labelle} </td>
										<td class="center">${m.stock.quantite} </td>
										
										
										
										
							
						
	                                   </tr>
	                                   
	                                   </c:forEach>
							</tbody>


						</table>
						
						
							
					</div>
						
	
	
	          <c:if test="${materiel.idMateriel!=0}">
	
	
	  <div id="content" class="col-lg-12 col-sm-12">
							<!-- content starts -->
							<div></div>
							
							
							
							<div class="row">
								<div class="box col-md-12">
									<div class="box-inner">
										<div class="box-header well" data-original-title="">
											<h2>
												<i class="glyphicon glyphicon-pencil"></i> <font
													color="#8C001A">Modification du Materiel :</font>
											 <font
													color="#000099"> ${m.designation} </font>
											</h2>
											
											<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a>

											</div>
											
											</div>
										<div class="box-content">

											<f:form modelAttribute="materiel"
												action="validerModificationMateriel" method="post">
												
												<table>


													<f:input type="hidden" path="idMateriel" />
													<f:errors type="hidden" path="idMateriel" cssClass="errors" />





													<tr>
														<td><i class="glyphicon glyphicon-tag  blue"> </i><font
															color="#585858"><strong> Designation : * </strong></font></td>
														<td><f:textarea path="designation" class="form-control" /></td>
														<td><f:errors path="designation" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-pencil  blue"> </i><font
															color="#585858"><strong> Description : * </strong></font></td>
														<td><f:textarea path="description" class="form-control" /></td>
														<td><f:errors path="description" cssClass="errors" /></td>
													</tr>
													
													
													
													
													 <tr>
           <td><i class="glyphicon glyphicon-bookmark  blue"> </i> <font
															color="#585858"><strong> Type </strong></font></td>
           <td><f:select path="typeMateriels.idTypeMateriels" items="${typeMateriels}" itemValue="idTypeMateriels" itemLabel="labelle" class="form-control"></f:select></td>
           <td><f:errors path="typeMateriels.idTypeMateriels" items="${typeMateriels}" itemValue="idTypeMateriels" itemLabel="labelle" class="form-control" cssClass="errors"/></td>
           </tr>
           

											
	
	                                              <tr>
	                                              
	                                              
	                                              
	                                              
	                                               <tr>
           <td><i class="glyphicon glyphicon-shopping-cart  blue"> </i> <font
															color="#585858"><strong> Stock</strong></font></td>
           <td><f:select path="stock.idStock" items="${stocks}" itemValue="idStock" itemLabel="quantite" class="form-control"></f:select></td>
           <td><f:errors path="stock.idStock" items="${stocks}" itemValue="idStock" itemLabel="quantite" class="form-control" cssClass="errors"/></td>
           </tr>
           

											
	
	                                              <tr>
														<td>


															<div class="control-group" align="center">

																<div class="controls">
																	<button type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Materiels"
																		data-toggle="tooltip"
																		href="<c:url value="/adminMaterielLi/index"/>">Annuler</a>
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