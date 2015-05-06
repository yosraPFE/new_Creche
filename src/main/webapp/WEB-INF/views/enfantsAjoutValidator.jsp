<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">
<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>


<!--  -->

<link href='<%=request.getContextPath()%>/resources/css/jquery.ui.css'
	rel='stylesheet'>
<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>
	
	
	<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap-cerulean.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/charisma-app.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/fullcalendar/dist/fullcalendar.print.css"
	rel="stylesheet" media="print">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/chosen/chosen.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/bower_components/colorbox/example3/colorbox.css"
	rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">

<link
	href="<%=request.getContextPath()%>/resources/bower_components/responsive-tables/responsive-tables.css"
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/jquery.noty.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/noty_theme_default.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/elfinder.min.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/elfinder.theme.css'
	rel='stylesheet'>
<link
	href='<%=request.getContextPath()%>/resources/css/jquery.iphone.toggle.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/uploadify.css'
	rel='stylesheet'>
<link href='<%=request.getContextPath()%>/resources/css/animate.min.css'
	rel='stylesheet'>

<link href='<%=request.getContextPath()%>/resources/css/jquery.ui.css'
	rel='stylesheet'>
<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/resources/bower_components/jquery/jquery.min.js"></script>

<title>Ajouter Nouveau Enfant</title>



</head>

<body>

	<!-- menus -->

	<%@ include file="/WEB-INF/views/menu.jsp"%>





<div id="content" class="col-lg-10 col-sm-10">
<ul class="breadcrumb">

			<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnf/index"/>"> <strong><i
									class=" glyphicon glyphicon-user"> </i> Liste Enfants</strong></a>
									
									
									<a class="btn btn-info btn-round btn-lg" href="<c:url value="/adminEF2/index"/>"> <strong><i
									class="glyphicon glyphicon-plus"> </i> Nouveau Enfant</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfClubPlanning/index"/>"> <strong><i
									class=" glyphicon glyphicon-music"> </i> <i
									class=" glyphicon glyphicon-time"> </i> Clubs et Planning Horraires</strong></a>
									
									
								
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfEven/index"/>"> <strong><i
									class="glyphicon glyphicon-screenshot"> </i> Evennements</strong></a>
									
									
									<a class="btn btn-primary btn-round btn-lg" href="<c:url value="/adminEnfConsulta/index"/>"> <strong><i
									class="glyphicon glyphicon-filter"> </i> Consultations Medicales</strong></a>
									
							</ul>		
									





		<div class="row">
			<div class="box col-md-12">
				

					




<c:if test="${not empty enfant}">


						<div class="row">
							<div class="box col-md-12">
								<div class="box-inner">
									<div class="box-header well" data-original-title="">
										<h2><i class=" glyphicon glyphicon-briefcase  blue"> </i> Coordinations Enfant :</h2>

										<div class="box-icon">

											<a href="#" class="btn btn-minimize btn-round btn-default"><i
												class="glyphicon glyphicon-chevron-up"></i></a>

										</div>
									</div>

									<c:if test="${cas == 0}">

										<div class="box-content">
									</c:if>
									<c:if test="${(cas == 1) || (cas == 2)|| (cas == 3)}">

										<div class="box-content" style="display: none;">
									</c:if>

									<div class="row">


										<f:form modelAttribute="enfant" action="verifierEnfant"
											method="post" enctype="multipart/form-data"
											class="form-horizontal">

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
													<td><f:input path="nom" class="form-control" placeholder="Tapez  nom" /></td>
													<td><f:errors path="nom" cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i class="glyphicon glyphicon-tags  blue"> </i> <font
														color="#585858"><strong> Prenom : </strong></font></td>
													<td><f:input path="prenom" class="form-control" placeholder="Tapez prenom"/></td>
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
														<td><i class="glyphicon glyphicon-calendar  blue">
														</i> <font color="#585858"><strong>Date
																	Naissance : *</strong></font></td>
														<td><f:input id="datepicker" path="dateNaissance"  class="form-control" /></td>
														<td><f:errors path="dateNaissance" cssClass="errors" /></td>
													</tr>


												<tr>
													<td><i class=" glyphicon glyphicon-home  blue"> </i> <font
														color="#585858"><strong> Lieu Naissance: </strong></font></td>
													<td><f:input path="lieuNaissance" class="form-control" placeholder="Tapez  Lieu de niassance"/></td>
													<td><f:errors path="lieuNaissance" cssClass="errors" /></td>
												</tr>

												<tr>
													<td><i class="glyphicon glyphicon-flag  blue"> </i> <font
														color="#585858"><strong>Langue : *</strong></font></td>
													<td><f:select path="langue" id="selectError"
															data-rel="chosen">
															<f:option value="Arabe" />
															<f:option value="Français" />
															<f:option value="Anglais" />
														</f:select></td>
													<td><f:errors path="langue" cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i class=" glyphicon glyphicon-list-alt  blue">
													</i> <font color="#585858"><strong> Antecedants
																Medicaux : </strong></font></td>
													<td><f:textarea path="antecedantsMedicaux" class="form-control" placeholder="Tapez les antecedants medicaux" /></td>
													<td><f:errors path="antecedantsMedicaux"
															cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i class="glyphicon glyphicon-cog  blue"> </i> <font
														color="#585858"><strong> Situation
																Parentale : </strong></font></td>
													<td><f:radiobutton path="situationParentale"
															value="Marie" checked="true" /> Mariés <f:radiobutton
															path="situationParentale" value="Divorce" /> Divorcés <f:radiobutton
															path="situationParentale" value="Pereveuf" /> Père Veuve
														<f:radiobutton path="situationParentale" value="Mereveuve" />
														Mère Veuve</td>
												</tr>


												<tr>
													<td><i class="glyphicon glyphicon-thumbs-up  blue">
													</i> <font color="#585858"><strong> Certifié? </strong></font></td>
													<td><f:checkbox path="certificatMedicale" /></td>
													<td><f:errors path="certificatMedicale"
															cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i
														class=" glyphicon glyphicon-facetime-video  blue"> </i> <font
														color="#585858"><strong>Autorisé pour la
																prise Photo? </strong></font></td>
													<td><f:checkbox path="autorisationPrisePhoto" /></td>
													<td><f:errors path="autorisationPrisePhoto"
															cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i class="glyphicon glyphicon-briefcase  blue">
													</i> <font color="#585858"><strong>Nom & prenom
																Pediatre : </strong></font></td>
													<td><f:input path="nomPrenomPediatre" class="form-control" placeholder="Tapez nom et prenom pediatre"/></td>
													<td><f:errors path="nomPrenomPediatre"
															cssClass="errors" /></td>
												</tr>


												<tr>
													<td><i class="glyphicon glyphicon-phone blue"> </i> <font
														color="#585858"><strong>Tel.Portable
																Pediatre : </strong></font></td>
													<td><f:input path="telephonePortablePediatre" class="form-control" placeholder="Tapez numero telephone pediatre"/></td>
													<td><f:errors path="telephonePortablePediatre"
															cssClass="errors" /></td>
												</tr>
												
												
												<tr>
													<td><i class="glyphicon glyphicon-phone blue"> </i> <font
														color="#585858"><strong> Date Pre Inscription
																 : </strong></font></td>
													<td><f:input path="datePreInscription" class="form-control" placeholder="Tapez numero telephone pediatre"/></td>
													<td><f:errors path="datePreInscription"
															cssClass="errors" /></td>
												</tr>




												<tr>


													<td>
													
													<input type="submit" name="btnEnfant" value="Valider" />
													
													</td>
												</tr>




											</table>


										</f:form>




									</div>
								</div>

							</div>







						</div>
					
					
					</c:if>
<c:if test="${not empty parentUn}">

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2><i class="glyphicon glyphicon-user  blue"> </i> Coordinations Premier Parent :</h2>

									<div class="box-icon">

										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>

									</div>
								</div>

								<c:if test="${cas == 1}">

									<div class="box-content">
								</c:if>
								<c:if test="${(cas == 2) || (cas == 0) || (cas == 3)}">

									<div class="box-content" style="display: none;">
								</c:if>

								<div class="row">
								<!-- formulaire parentUn -->
								
								<f:form modelAttribute="parentUn" action="verifierParentUn"
											method="post" enctype="multipart/form-data"
											class="form-horizontal">
								
								
							<table>



								<tr>
									<!--  <td>ID</td>-->
									<td><f:input type="hidden" path="idPerson" /></td>
									<td><f:errors type="hidden" path="idPerson"
											cssClass="errors" /></td>
								</tr>

								<tr>
								
                                   <td><i class=" glyphicon glyphicon-user  green"> </i>
															<font color="#585858"><strong>Genre</strong></font></td>
                                   <td>
                                    <f:radiobutton path="genre" value="Papa" checked="true"/> Papa
                                    <f:radiobutton path="genre" value="Maman"/>Maman 
                                    </td>
                                    </tr>

								<tr>
									<td><i class="glyphicon glyphicon-tag  green"> </i> <font
										color="#585858"><strong>Nom : *</strong></font></td>
									<td><f:input path="nom" class="form-control" placeholder="Tapez nom"/></td>
									<td><f:errors path="nom" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-tags  green"> </i> <font
										color="#585858"><strong>Prenom : *</strong></font></td>
									<td><f:input path="prenom" class="form-control" placeholder="Tapez prenom"/></td>
									<td><f:errors path="prenom" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-camera green"> </i> <font
										color="#585858"><strong>Photo : </strong></font></td>



									<td><input type="file" name="filep" />
								</tr>



								<tr>
									<td><i class="glyphicon glyphicon-edit green"> </i> <font
										color="#585858"><strong>Cin :</strong></font></td>
									<td><f:input path="cin" class="form-control" placeholder="Tapez numero carte d'identité nationale" /></td>
									<td><f:errors path="cin" cssClass="errors" /></td>
								</tr>
								<tr>
									<td><i class="glyphicon glyphicon-usd green"> </i> <font
										color="#585858"><strong>Profession :</strong></font></td>
									<td><f:input path="profession" class="form-control" placeholder="Tapez profession"/></td>
									<td><f:errors path="profession" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-home  green"> </i> <font
										color="#585858"><strong>Adresse :</strong></font></td>
									<td><f:input path="adresseDomicile" class="form-control" placeholder="Tapez l'adresse"/></td>
									<td><f:errors path="adresseDomicile" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-phone-alt  green"> </i>
										<font color="#585858"><strong>Tel.fixe:</strong></font></td>
									<td><f:input path="telephoneDomicile" class="form-control" placeholder="Tapez numero de telephone fixe"/></td>
									<td><f:errors path="telephoneDomicile"
											cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-phone  green"> </i> <font
										color="#585858"><strong>Portable :</strong></font></td>
									<td><f:input path="telephonePortable" class="form-control" placeholder="Tapez numero telephone portable"/></td>
									<td><f:errors path="telephonePortable"
											cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-envelope  green"> </i> <font
										color="#585858"><strong>Email :</strong></font></td>
									<td><f:input path="email" class="form-control" placeholder="Tapez Email"/></td>
									<td><f:errors path="email" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-road  green"> </i> <font
										color="#585858"><strong>Lieu Travail:</strong></font></td>
									<td><f:input path="lieuTravail" class="form-control" placeholder="Tapez lieu de travail" /></td>
									<td><f:errors path="lieuTravail" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-earphone  green"> </i> <font
										color="#585858"><strong>Tel.Travail :</strong></font></td>
									<td><f:input path="telephoneTravail" class="form-control" placeholder="Tapez numero de telephone" /></td>
									<td><f:errors path="telephoneTravail"
											cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class=" glyphicon glyphicon-star  green"> </i> <font
										color="#585858"><strong>Nom d'Utilisateur :</strong></font></td>
									<td><f:input path="nomUtilisateur" class="form-control" placeholder="Tapez Nom d'utilisateur" /></td>
									<td><f:errors path="nomUtilisateur" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class=" glyphicon glyphicon-ban-circle  green">
									</i> <font color="#585858"><strong>Mot de Passe :</strong></font></td>
									<td><f:input path="motPasse" class="form-control" placeholder="Tapez Mot de Passe" /></td>
									<td><f:errors path="motPasse" cssClass="errors" /></td>
								</tr>




												<tr>


													<td><input type="submit" name="btnChoisi" value="Valider" /></td>
														<td><input type="submit" name="btnChoisi" value="Ajouter_Autre_Parent" /></td>
															<td><input type="submit" name="btnChoisi" value="Ajouter_Accompagnateur" /></td>
												</tr>

							</table>
							
							
										</f:form>

                               </div>
							</div>
							
						</div>
					</div>
					</div>
         </c:if>
<c:if test="${not empty parentDeux}">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2><i class="glyphicon glyphicon-user  blue"> </i> Coordinations deuxieme Parent :</h2>

									<div class="box-icon">

										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>

									</div>
								</div>

								<c:if test="${cas == 2}">

									<div class="box-content">
								</c:if>
								<c:if test="${(cas == 1) || (cas == 0) || (cas == 3)}">

									<div class="box-content" style="display: none;">
								</c:if>

								<div class="row">
								<!-- formulaire parentDeux -->
								
								<f:form modelAttribute="parentDeux" action="verifierParentDeux"
											method="post" enctype="multipart/form-data"
											class="form-horizontal">
								
								
							<table>



								<tr>
									<!--  <td>ID</td>-->
									<td><f:input type="hidden" path="idPerson" /></td>
									<td><f:errors type="hidden" path="idPerson"
											cssClass="errors" /></td>
								</tr>

								<tr>
								
                                   <td><i class=" glyphicon glyphicon-user  red"> </i>
															<font color="#585858"><strong>Genre</strong></font></td>
                                   <td>
                                    
                                    <c:if test="${ parentUn.genre == 'Maman'}">
                                     <f:radiobutton path="genre" value="Papa" checked="true" /> Papa
                                     <f:radiobutton path="genre" value="Maman"/>Maman
                                    </c:if>
                                    
                                   <c:if test="${ parentUn.genre == 'Papa'}">
                                   <f:radiobutton path="genre" value="Papa"/> Papa
                                    <f:radiobutton path="genre" value="Maman" checked="true"/>Maman
                                    
                                    
                                    </c:if>
                                     
                                    </td>
                                    </tr>

								<tr>
									<td><i class="glyphicon glyphicon-tag  red"> </i> <font
										color="#585858"><strong>Nom : *</strong></font></td>
									<td><f:input path="nom" class="form-control" placeholder="Tapez  nom"/></td>
									<td><f:errors path="nom" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-tags  red"> </i> <font
										color="#585858"><strong>Prenom : *</strong></font></td>
									<td><f:input path="prenom" class="form-control" placeholder="Tapez prenom" /></td>
									<td><f:errors path="prenom" cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-camera red"> </i> <font
										color="#585858"><strong>Photo : </strong></font></td>



									<td><input type="file" name="filep2" />
								</tr>



								<tr>
									<td><i class="glyphicon glyphicon-edit red"> </i> <font
										color="#585858"><strong>Cin :</strong></font></td>
									<td><f:input path="cin" class="form-control" placeholder="Tapez numero carte d'identité nationale"/></td>
									<td><f:errors path="cin" cssClass="errors" /></td>
								</tr>
								<tr>
									<td><i class="glyphicon glyphicon-usd red"> </i> <font
										color="#585858"><strong>Profession :</strong></font></td>
									<td><f:input path="profession" class="form-control" placeholder="Tapez profession"/></td>
									<td><f:errors path="profession" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-home  red"> </i> <font
										color="#585858"><strong>Adresse :</strong></font></td>
									<td><f:input path="adresseDomicile" class="form-control" placeholder="Tapez l'adresse" /></td>
									<td><f:errors path="adresseDomicile" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-phone-alt  red"> </i>
										<font color="#585858"><strong>Tel.fixe:</strong></font></td>
									<td><f:input path="telephoneDomicile" class="form-control" placeholder="Tapez numero de telephone fixe" /></td>
									<td><f:errors path="telephoneDomicile"
											cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-phone  red"> </i> <font
										color="#585858"><strong>Portable :</strong></font></td>
									<td><f:input path="telephonePortable" class="form-control" placeholder="Tapez numero telephone portable"/></td>
									<td><f:errors path="telephonePortable"
											cssClass="errors" /></td>
								</tr>


								<tr>
									<td><i class="glyphicon glyphicon-envelope  red"> </i> <font
										color="#585858"><strong>Email :</strong></font></td>
									<td><f:input path="email" class="form-control" placeholder="Tapez Email"/></td>
									<td><f:errors path="email" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-road  red"> </i> <font
										color="#585858"><strong>Lieu Travail:</strong></font></td>
									<td><f:input path="lieuTravail" class="form-control" placeholder="Tapez lieu de travail"/></td>
									<td><f:errors path="lieuTravail" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-earphone  red"> </i> <font
										color="#585858"><strong>Tel.Travail :</strong></font></td>
									<td><f:input path="telephoneTravail" class="form-control" placeholder="Tapez numero de telephone" /></td>
									<td><f:errors path="telephoneTravail"
											cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class=" glyphicon glyphicon-star  red"> </i> <font
										color="#585858"><strong>Nom d'Utilisateur :</strong></font></td>
									<td><f:input path="nomUtilisateur" class="form-control" placeholder="Tapez Nom d'utilisateur"/></td>
									<td><f:errors path="nomUtilisateur" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class=" glyphicon glyphicon-ban-circle  red">
									</i> <font color="#585858"><strong>Mot de Passe :</strong></font></td>
									<td><f:input path="motPasse" class="form-control"  placeholder="Tapez Mot de Passe"/></td>
									<td><f:errors path="motPasse" cssClass="errors" /></td>
								</tr>




												<tr>


													<td><input type="submit" name="btnChoisi" value="Valider" /></td>
															<td><input type="submit" name="btnChoisi" value="Ajouter Accompagnateur" /></td>
												</tr>

							             </table>
							
							
							   </f:form>

                            </div>
							</div>
							
						</div>
					</div>
					</div>
					
</c:if>
<c:if test="${not empty Accompagnateur}">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2><i class="glyphicon glyphicon-eye-open  blue"> </i> Coordinations Accompagnateurs :</h2>

									<div class="box-icon">

										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>

									</div>
								</div>

								<c:if test="${cas == 3}">

									<div class="box-content">
								</c:if>
								<c:if test="${(cas == 2) || (cas == 0) || (cas == 1)}">

									<div class="box-content" style="display: none;">
								</c:if>

								<div class="row">
								<!-- formulaire Accompagnateur -->
								
								<f:form modelAttribute="Accompagnateur" action="verifierAccompagnateur"
											method="post" enctype="multipart/form-data"
											class="form-horizontal">
								 <table>
								<tr>
									<!--  <td>ID</td> -->
									<td><f:input type="hidden" path="idPerson" /></td>
									<td><f:errors type="hidden" path="idPerson"
											cssClass="errors" /></td>
								</tr>




								<tr>
									<td><i class="glyphicon glyphicon-tag  yellow"> </i> <font
										color="#585858"><strong>Nom :</strong></font></td>
									<td><f:input path="nom" class="form-control" placeholder="Tapez nom"/></td>
									<td><f:errors path="nom" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-tags  yellow"> </i> <font
										color="#585858"><strong>Prenom :</strong></font></td>
									<td><f:input path="prenom"  class="form-control" placeholder="Tapez prenom"/></td>
									<td><f:errors path="prenom"
											cssClass="errors" /></td>
								</tr>




								<tr>
									<td><i class="glyphicon glyphicon-camera yellow"> </i> <font
										color="#585858"><strong> Photo :</strong></font></td>



									<td><input type="file" name="fileaccomp" />
								</tr>
								
								<tr>
														<td><i class="glyphicon glyphicon-thumbs-up  yellow">
														</i> <font color="#585858"> <strong>Active?
															</strong></font></td>
														<td><f:checkbox path="active" /></td>
														<td><f:errors path="active"
																cssClass="errors" /></td>
													</tr>



								<tr>
									<td><i class="glyphicon glyphicon-edit  yellow"> </i> <font
										color="#585858"><strong>Cin :</strong></font></td>
									<td><f:input path="cin" class="form-control" placeholder="Tapez numero crate d'dentité nationale"/></td>
									<td><f:errors path="cin" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-pencil  yellow"> </i> <font
										color="#585858"><strong>Description :</strong></font></td>
									<td><f:textarea path="description" class="form-control" placeholder="Tapez desciption" /></td>
									<td><f:errors path="description" cssClass="errors" /></td>
								</tr>

								<tr>
									<td><i class="glyphicon glyphicon-phone  yellow"> </i> <font
										color="#585858"><strong>Tel.portable :</strong></font></td>
									<td><f:input path="telephonePortable" class="form-control" placeholder="Tapez numero telephone" /></td>
									<td><f:errors path="telephonePortable"
											cssClass="errors" /></td>
								</tr>

								 
          
           
								
							
												<tr>


													<td><input type="submit" name="btnChoisi" value="Valider" /></td>
														<td><input type="submit" name="btnChoisi" value="Valider et Ajouter Autre Accompagnateur" /></td>
															
												</tr>

							</table>
							
							
										</f:form>

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

	<!-- footer -->

<script
		src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
	<!-- multiple file upload plugin -->
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/1.10.2.js"></script>
	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
	
	<script>
$(function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  });
  </script>
</body>
</html>

