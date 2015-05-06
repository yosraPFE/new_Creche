<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouveau Club</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminClubLi/index"/>"> <strong><i
				class="glyphicon glyphicon-inbox"> </i> Liste Clubs</strong></a> <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminClub/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouveau Club</strong></a>
	
	
	
	
	
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
					
					
					<c:if test="${not empty clubAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty clubAjoute}">
					<div class="box-content row">
					</c:if>
					
					<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="club"
								action="ajouterClub" method="post">

								<table>
								
								
								<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idClub" /></td>
										<td><f:errors type="hidden" path="idClub"
												cssClass="errors" /></td>
									</tr>
									
									
									
									<tr>


										<td><i class="glyphicon glyphicon-tag  blue"> </i> <font
											color="#585858"><strong>Nom : </strong></font></td>
										<td><f:input path="nom" class="form-control" /></td>
										<td><f:errors path="nom" cssClass="errors" /></td>
									</tr>
									
									
									
									
									
													 <tr>
           <td><i class="glyphicon glyphicon-folder-open  blue"> </i> <font
															color="#585858"><strong> Categorie </strong></font></td>
           <td><f:select path="categorieClub.idCategorie" items="${CategorieClubs}" itemValue="idCategorie" itemLabel="labelle" class="form-control"></f:select></td>
           <td><f:errors path="categorieClub.idCategorie" items="${CategorieClubs}" itemValue="idCategorie" itemLabel="labelle" class="form-control" cssClass="errors"/></td>
           </tr>
           
           <td><i class="glyphicon glyphicon-exclamation-sign  blue"> </i><font
															color="#585858"><strong> Nombre Maximum d'integration: * </strong></font></td>
														<td><f:input path="nombreMaxPart" class="form-control" /></td>
														<td><f:errors path="nombreMaxPart" cssClass="errors" /></td>
													</tr>
           

											
	
	                                              <tr>
									
									
									
									
									
									
									
									
									
									
									
									
									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
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
					<c:if test="${not empty clubAjoute}">
					
	
	
	<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du Clubs</font>
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
	
	
	
	   <p><b> C'est Le Club ${clubAjoute.nom}  qui a de categorie ${clubAjoute.categorieClub.labelle} a eté ajoutée !
                    
                   
                            
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