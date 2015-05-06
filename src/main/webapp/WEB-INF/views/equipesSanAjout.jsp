<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouveau Membre  Sanitaire</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>



	<div id="content" class="col-lg-10 col-sm-10">

<ul class="breadcrumb">

		
			<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminListSan/index"/>"> <strong><i
					class=" glyphicon glyphicon-user"> </i> Liste Membres Equipe
					Sanitaire</strong></a> 
					
					<a class="btn btn-info btn-round btn-lg"
				href="<c:url value="/adminEqSan/index"/>"> <strong><i
					class="glyphicon glyphicon-plus"> </i> Nouveau Membre Equipe
					Sanitaire</strong></a>
					
					<a class="btn btn-primary btn-round btn-lg"
				href="<c:url value="/adminSaMater/index"/>"> <strong><i
					class="glyphicon glyphicon-wrench"> </i>  Affectation Materiels</strong></a>
					
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
					
					<c:if test="${not empty equipeSanitaireAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty equipeSanitaireAjoute}">
					<div class="box-content row">
					</c:if>
						<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="equipeSanitaire"
								action="ajouterEquipeSanitaire" method="post"
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
										<td><i class=" glyphicon glyphicon-user  blue"> </i> <font
											color="#585858"><strong> Sexe : </strong></font></td>
										<td><f:radiobutton path="sexe" value="Homme"
												checked="true" /> Homme <f:radiobutton path="sexe"
												value="Femme" /> Femme</td>
									</tr>
									
									<tr>
										<td><i class="glyphicon glyphicon-usd  blue"> </i><font
											color="#585858"><strong>Fonction</strong></font></td>
										<td><f:select path="fonction.idFonction"
												items="${fonctions}" itemValue="idFonction"
												itemLabel="labelle" class="form-control"></f:select></td>
										<td><f:errors path="fonction.idFonction"
												items="${fonctions}" itemValue="idFonction"
												itemLabel="labelle" cssClass="errors" /></td>
									</tr>

									<tr>
										<td><i class="glyphicon glyphicon-calendar  blue"> </i><font
											color="#585858"><strong> Date Naissance: </strong></font></td>
										<td><f:input type="date" path="dateNaissance" /></td>
										<td><f:errors path="dateNaissance" cssClass="errors" /></td>
									</tr>


									<tr>
										<td><i class="glyphicon glyphicon-road  blue"> </i> <font
											color="#585858"><strong> Lieu Naissance: </strong></font></td>
										<td><f:input path="lieuNaissance" class="form-control"/></td>
										<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
									</tr>





									<tr>
										<td><i class=" glyphicon glyphicon-home  blue"> </i><font
											color="#585858"> <strong>Adresse:</strong></font></td>
										<td><f:input path="adresseDomicile" class="form-control" /></td>
										<td><f:errors path="adresseDomicile" cssClass="errors" /></td>
									</tr>




									<tr>
										<td><i class="glyphicon glyphicon-star  blue"> </i> <font
											color="#585858"> <strong>Nom Utilisateur: </strong></font></td>
										<td><f:input path="nomUtilisateur" class="form-control" /></td>
										<td><f:errors path="nomUtilisateur" cssClass="errors" /></td>
									</tr>



									<tr>
										<td><i class="glyphicon glyphicon-ban-circle  blue">
										</i> <font color="#585858"> <strong>Mot de Passe:
											</strong></font></td>
										<td><f:input path="motPasse" class="form-control" /></td>
										<td><f:errors path="motPasse" cssClass="errors" /></td>
									</tr>



									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
													<a class="btn btn-danger"
														title="Annuler et retourner à la liste des Membres d'Equipe Sanitaire"
														data-toggle="tooltip"
														href="<c:url value="/adminListSan/index"/>">Annuler</a>
												</div>
											</div>
										</td>
									</tr>

								</table>

							</f:form>

						</div>
							
				</div>
				
				
				<c:if test="${not empty equipeSanitaireAjoute}">
		
		
		<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du membre Sanitaire </font>
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
                   
                   

                    <p><b>  <img src="photoEqSan?idEquipeSanitaire=${equipeSanitaireAjoute .idPerson}" class="images_petit" title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoEqSan?idEquipeSanitaire=${equipeSanitaireAjoute .idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')" />
                    
                            
                       </b>
                            
                     </p>
                     
                     
                      <p><b> C'est L'(e) ${equipeSanitaireAjoute.fonction.labelle}  appelé  ${equipeSanitaireAjoute .nom} ${equipeEducatifAjoute .prenom} ,C'est un (e)  ${equipeSanitaireAjoute.sexe}  , né le ${equipeSanitaireAjoute.dateNaissance} à ${equipeSanitaireAjoute .lieuNaissance} ,
                     
                      habite à   ${equipeSanitaireAjoute.adresseDomicile}  et qu'on a attribué comme Nom d'utilisateur ${equipeSanitaireAjoute.nomUtilisateur} et Mot de Passe ${equipeSanitaireAjoute.motPasse} !
                    
                   
                            
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