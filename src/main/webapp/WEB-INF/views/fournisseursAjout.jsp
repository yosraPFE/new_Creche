<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouveau Fournisseur</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminFou/index"/>"> <strong><i
				class=" glyphicon glyphicon-user"> </i> Liste Fournisseurs</strong></a> <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminF/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouveau Fournisseur</strong></a>



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
					
					<c:if test="${not empty fournisseurAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty fournisseurAjoute}">
					<div class="box-content row">
					</c:if>
						<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="fournisseur"
								action="ajouterFournisseur" method="post"
								enctype="multipart/form-data">

								<table>


									<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idPerson" /></td>
										<td><f:errors type="hidden" path="idPerson"
												cssClass="errors" /></td>
									</tr>

									<tr>


										<td><i class="glyphicon glyphicon-tag  blue"> </i> <font
											color="#585858"><strong>Nom : </strong></font></td>
										<td><f:input path="nom" class="form-control" /></td>
										<td><f:errors path="nom" cssClass="errors" /></td>
									</tr>


									<tr>
										<td><i class="glyphicon glyphicon-tags  blue"> </i> <font
											color="#585858"><strong> Prenom : </strong></font></td>
										<td><f:input path="prenom" class="form-control" /></td>
										<td><f:errors path="prenom" cssClass="errors" /></td>
									</tr>





									<tr>
										<td><i class="glyphicon glyphicon-camera blue"> </i> <font
											color="#585858"><strong> Photo :</strong></font></td>

										<td><input type="file" name="file" />
									</tr>
									
									
									

<tr>
														<td><i class="glyphicon glyphicon-road  blue"> </i><font
															color="#585858"> <strong>Cin:</strong></font></td>
														<td><f:input path="cin" class="form-control" /></td>
														<td><f:errors path="cin" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class=" glyphicon glyphicon-home  blue"> </i><font
															color="#585858"> <strong>Adresse Societé:</strong></font></td>
														<td><f:input path="adresseSociete" class="form-control"/></td>
														<td><f:errors path="adresseSociete"
																cssClass="errors" /></td>
													</tr>




													<tr>
														<td><i class="glyphicon glyphicon-star  blue"> </i>
															<font color="#585858"> <strong>Telephone Societé: </strong></font></td>
														<td><f:input path="telephoneSociete" class="form-control"/></td>
														<td><f:errors path="telephoneSociete" cssClass="errors" /></td>
													</tr>



													<tr>
														<td><i class="glyphicon glyphicon-ban-circle  blue"> </i>
															<font color="#585858"> <strong>Tel.portable: </strong></font></td>
														<td><f:input path="telephonePortable" class="form-control"/></td>
														<td><f:errors path="telephonePortable" cssClass="errors" /></td>
													</tr>
													
													
													<tr>
														<td><i class="glyphicon glyphicon-ban-circle  blue"> </i>
															<font color="#585858"> <strong>Email: </strong></font></td>
														<td><f:input path="email" class="form-control"/></td>
														<td><f:errors path="email" cssClass="errors" /></td>
													</tr>
													




									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
													<a class="btn btn-danger"
														title="Annuler et retourner à la liste des Fournisseurs"
														data-toggle="tooltip"
														href="<c:url value="/adminFou/index"/>">Annuler</a>
												</div>
											</div>
										</td>
									</tr>

								</table>

							</f:form>

						</div>
							
				</div>
				
				
				<c:if test="${not empty fournisseurAjoute}">
		
		
		<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du Fournisseur </font>
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
                   
                   

                    <p><b>  <img src="photoFour?idFournisseur=${fournisseurAjoute.idPerson}" class="images_petit" title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoFour?idFournisseur=${fournisseurAjoute.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')" />
                    
                            
                       </b>
                            
                     </p>
                     
                     
                      <p><b> C'est   ${fournisseurAjoute.nom} ${fournisseurAjoute.prenom} , 
                      
                      travail chez la societé d'adresse   ${fournisseurAjoute.adresseSociete} et de telephone ${fournisseurAjoute.telephoneSociete}  et qui a le cin:
 ${fournisseurAjoute.cin} , Telephone ${fournisseurAjoute.telephonePortable}  et email ${fournisseurAjoute.email} a bien eté ajouté !
                    
                   
                            
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