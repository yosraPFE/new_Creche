<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouveau Materiel</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	<div>


		<div id="content" class="col-lg-10 col-sm-10">
		<ul class="breadcrumb">
	
	



		<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminMaterielLi/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i> Liste Materiels
					</strong></a> <a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminMater/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Materiel
					</strong></a>
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminFouurMater/index"/>"> <strong><i
					class="glyphicon glyphicon-user"> </i>  Affectation Fournisseurs</strong></a>

	
	
	</ul>
	
	
		<div class="row">
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-plus"> </i> 
						</h2>

						<div class="box-icon">

							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a>

						</div>
						
						
							<div class="box-content row">
						
						
						</div>
						
					</div>
					
					
					<c:if test="${not empty materielAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty materielAjoute}">
					<div class="box-content row">
					</c:if>
					
					<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="materiel"
								action="ajouterMateriel" method="post">

								<table>
								
								
								<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idMateriel" /></td>
										<td><f:errors type="hidden" path="idMateriel"
												cssClass="errors" /></td>
									</tr>
									
									
									
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
														<td><i class="glyphicon glyphicon-pencil  blue"> </i><font
															color="#585858"><strong> Prix : * </strong></font></td>
														<td><f:input path="prix" class="form-control" /></td>
														<td><f:errors path="prix" cssClass="errors" /></td>
													</tr>
	                                              
	                                              
	                                              
	                                              
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
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
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
					<c:if test="${not empty materielAjoute}">
					
	
	
	<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du Materiel</font>
								</h2>


								<div class="box-icon">

												<a href="#" class="btn btn-minimize btn-round btn-default"><i
													class="glyphicon glyphicon-chevron-up"></i></a></div>

							</div>
								<div class="box-content"></div>
								
								<div class="box-content row">
                <div class="col-lg-7 col-md-12">
                
	
	
	             <h1>
                   Ajout avec succès!
                   </h1>
                   
                   </br>
	
	
	
	   <p><b> C'est Le Materiel ${materielAjoute.designation} ,de description ${materielAjoute.description}  , du prix ${materielAjoute.prix} 
	   
	   de type ${materielAjoute.typeMateriels.labelle} et de stock ${materielAjoute.stock.quantite}  a eté ajoutée !
	   
	  
                    
                   
                            
                       </b>
                            
                     </p>
	
	
	
	
	
	
	
	
	
	 </div>
								

								<div class="box-content">

									
									
							
								</div>		
								
								
							  
								</div>
								</div>
								
										
										
							
							</div>
							
							
							
							
						
						  
							

						</div>
						
						
						
					
						
						
				
           </c:if>
				
				
	
			</div>
		</div>
	</div>
	
	
	
	
	






	
	
	
	
	
	
	
	
	

	
	
	
	
	
	


	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>	