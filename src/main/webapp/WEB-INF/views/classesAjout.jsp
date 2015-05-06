<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouvelle Classe</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminClasLi/index"/>"> <strong><i
				class="glyphicon glyphicon-gift"> </i> Liste Classes</strong></a> 
				
				 <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminClas/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouvelle Classe</strong></a>
	
	
	
	
	
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
					
					
					<c:if test="${not empty classeAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty classeAjoute}">
					<div class="box-content row">
					</c:if>
					
					<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="classe"
								action="ajouterClasse" method="post">

								<table>
								
								
								<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idClasse" /></td>
										<td><f:errors type="hidden" path="idClasse"
												cssClass="errors" /></td>
									</tr>
									
									
									
									<tr>


										<td><i class="glyphicon glyphicon-tag  blue"> </i> <font
											color="#585858"><strong>Nom : </strong></font></td>
										<td><f:input path="nom" class="form-control" /></td>
										<td><f:errors path="nom" cssClass="errors" /></td>
									</tr>
									
									
									
									
									
											
	
	                                          <tr>


										<td><i class="glyphicon glyphicon-exclamation-sign  blue"> </i> <font
											color="#585858"><strong>Nombre de Places : </strong></font></td>
										<td><f:input path="nombrePlaces" class="form-control" /></td>
										<td><f:errors path="nombrePlaces" cssClass="errors" /></td>
									</tr>
									
									
									
									
									
									
									
									
									
									
									
									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
													<a class="btn btn-danger"
														title="Annuler et retourner à la liste des Classes"
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
					<c:if test="${not empty classeAjoute}">
					
	
	
	<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout de la classe</font>
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
	
	
	
	   <p><b> C'est La ${classeAjoute.nom}  qui appartient a la creche 
	   
	   
	   et qui pour capacité ${classeAjoute.nombrePlaces} a eté ajoutée !
                    
                   
                            
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