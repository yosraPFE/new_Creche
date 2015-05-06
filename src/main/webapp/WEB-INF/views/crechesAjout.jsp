<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouvelle Creche</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminCr/index"/>"> <strong><i
				class="glyphicon glyphicon-home"> </i> Liste Creches</strong></a> <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminCrech/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouvelle Creche</strong></a>



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
					
					<c:if test="${not empty crecheAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty crecheAjoute}">
					<div class="box-content row">
					</c:if>
						<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="creche"
								action="ajouterCreche" method="post"
								enctype="multipart/form-data">

								<table>


									<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idCreche" /></td>
										<td><f:errors type="hidden" path="idCreche"
												cssClass="errors" /></td>
									</tr>

									<tr>


										<td><i class="glyphicon glyphicon-tag  blue"> </i> <font
											color="#585858"><strong>Nom : </strong></font></td>
										<td><f:input path="nom" class="form-control" /></td>
										<td><f:errors path="nom" cssClass="errors" /></td>
									</tr>






									<tr>
										<td><i class="glyphicon glyphicon-camera blue"> </i> <font
											color="#585858"><strong> Photo :</strong></font></td>

										<td><input type="file" name="file" />
									</tr>




									
									

									


									<tr>
										<td><i class="glyphicon glyphicon-road   blue"> </i> <font
											color="#585858"><strong> Adresse: </strong></font></td>
										<td><f:input path="adresse" class="form-control"/></td>
										<td><f:errors path="adresse" cssClass="errors" /></td>
									</tr>
									
									
									<tr>
										<td><i class="glyphicon glyphicon-globe   blue"> </i> <font
											color="#585858"><strong> Site Web: </strong></font></td>
										<td><f:input path="siteWeb" class="form-control"/></td>
										<td><f:errors path="siteWeb" cssClass="errors" /></td>
									</tr>
									
									
									
									<tr>
										<td><i class="glyphicon glyphicon-flag  blue"> </i> <font
											color="#585858"><strong>Ville: </strong></font></td>
										<td><f:input path="ville" class="form-control"/></td>
										<td><f:errors path="ville" cssClass="errors" /></td>
									</tr>
									
									
									<tr>
										<td><i class="glyphicon glyphicon-phone-alt  blue"> </i> <font
											color="#585858"><strong>Telephone: </strong></font></td>
										<td><f:input path="telephone" class="form-control"/></td>
										<td><f:errors path="telephone" cssClass="errors" /></td>
									</tr>





									




									



									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
													<a class="btn btn-danger"
														title="Annuler et retourner à la liste des Creches"
														data-toggle="tooltip"
														href="<c:url value="/adminCr/index"/>">Annuler</a>
												</div>
											</div>
										</td>
									</tr>

								</table>

							</f:form>

						</div>
							
				</div>
				
				
				<c:if test="${not empty crecheAjoute}">
		
		
		<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du Creche </font>
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
                   
                   

                    <p><b>  <img src="photoCrech?idCreche=${crecheAjoute.idCreche}" class="images_petit" title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoCrech?idCreche=${crecheAjoute.idCreche}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')" />
                    
                            
                       </b>
                            
                     </p>
                     
                     
                      <p><b> C'est La ${crecheAjoute.nom}  ,
                     
                      située à  ${crecheAjoute.adresse} dans ${crecheAjoute.ville} et a comme site web ${crecheAjoute.siteWeb}
                      possede le numero de telephone suivant ${crecheAjoute.telephone}  !
                    
                   
                            
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