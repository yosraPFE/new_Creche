	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
	<html>
	<head>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/resources/css1/styl.css">

	<!-- header -->
	<%@ include file="/WEB-INF/views/templates/header.jsp"%>

	<title>Liste Parent</title>
	</head>

	<body>
		<!-- Menus -->
		<%@ include file="/WEB-INF/views/menu.jsp"%>
		<!-- table -->
		<div>
			<div id="content" class="col-lg-10 col-sm-10">
				<a class="btn btn-info btn-round btn-lg"
					href="<c:url value="/adminPa/index"/>"> <strong><i
						class=" glyphicon glyphicon-user"> </i> Liste Parent</strong></a>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> <font color="#8C001A"></font><font
										color="#8C001A"></font>
								</h2>
								<div class="box-icon">
									<a href="#" class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a>
								</div>
							</div>
							<c:if test="${parent.idPerson!=null}">
								<div class="box-content" style="display: none;">
							</c:if>
							<c:if test="${parent.idPerson==null}">
								<div class="box-content">
							</c:if>
							<table
								class="table table-striped table-bordered bootstrap-datatable datatable responsive">
								<thead>
									<tr>
										<!--  <th >Id</th>-->
										<th>Photo</th>
										<th>Nom et Prénom</th>
										<th>genre</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${parents}" var="par">
										<tr>
											
											<td width=100px><img
												src="photoPar?idParent=${par.idPerson}"
												class="images_petit" title="Cliquer pour voir la photo"
												data-toggle="tooltip"
												onclick="window.open('photoPar?idParent=${par.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
												class="images_petit" /></td>
											<td class="center">${par.nom}  ${par.prenom}</td>
											<td class="center">${par.genre}</td>
											
											<td>
											
											
											<a class="btn btn-success" title="Afficher  Details"
											data-toggle="tooltip"
											href="<c:url value="/ParenEnfList/voirListEnfantParParents?idPar=${par.idPerson}"/>"
											>
												<i class="glyphicon glyphicon-zoom-in icon-white"></i>
										</a>
											
											
											<a class="btn btn-info" title="Modifier Parent"
												data-toggle="tooltip"
												href="modifierListeParent?idParent=${par.idPerson}"
												onclick="modifierListeParent?idParent=${par.idPerson}">
													<i class="glyphicon glyphicon-edit icon-white"></i>
											</a> <a class="btn btn-danger" title="Supprimer Parent"
												data-toggle="tooltip"
												href="supprimerListeParent?idParent=${par.idPerson}"
												onclick="return confirm('Êtes-vous sûr de vouloir supprimer ${par.nom} ${par.prenom} ?');">
													<i class="glyphicon glyphicon-trash icon-white"></i>
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							
							
							
							
							
					
						</div>
						
						
						
						
						
						
						
						<c:if test="${parent.idPerson!=null}">
							<div id="content" class="col-lg-12 col-sm-12">
								<!-- content starts -->
								<div></div>
								<div class="row">
									<div class="box col-md-12">
										<div class="box-inner">
											<div class="box-header well" data-original-title="">
												<h2>
													<i class="glyphicon glyphicon-pencil"></i> <font
														color="#8C001A">Modification du parent :
														${parent.nom} ${parent.prenom}</font>
												</h2>
												<div class="box-icon">
													<a href="#" class="btn btn-minimize btn-round btn-default"><i
														class="glyphicon glyphicon-chevron-up"></i></a>
												</div>
											</div>
											<div class="box-content">
												<f:form modelAttribute="parent"
													action="validerModificationParent" method="post"
													enctype="multipart/form-data">
													<table>
														<f:input type="hidden" path="idPerson" />
														<f:errors type="hidden" path="idPerson" cssClass="errors" />
														<tr>
															<td><i class="glyphicon glyphicon-tag  blue"> </i><font
																color="#585858"><strong> Nom : * </strong></font></td>
															<td><f:input path="nom" class="form-control"/></td>
															<td><f:errors path="nom" cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-tags  blue">
															</i> <font color="#585858"><strong> Prenom : *</strong></font></td>
															<td><f:input path="prenom" class="form-control"/></td>
															<td><f:errors path="prenom" cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-camera blue"> </i>
																<font color="#585858"><strong> Photo : *
																</strong></font></td>
															<td><c:if test="${parent.idPerson!=null}">
																	<img src="photoPar?idParent=${parent.idPerson}"
																		class="images_petit" />
																</c:if></td>
															<td><input type="file" name="file" /><br> <!--<f:textarea
									path="nomPhoto" readonly="true" />--></td>
														</tr>
														<tr>
															<td><i class=" glyphicon glyphicon-user  blue"> </i>
																<font color="#585858"><strong> Genre :</strong></font></td>
															<td><f:radiobutton path="genre" value="Papa"  checked="true"/>
																Papa <f:radiobutton path="genre" value="Maman" /> Maman
																</td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-edit  blue">
															</i> <font color="#585858"> <strong>Cin
																		</strong></font></td>
															<td><f:input path="cin" class="form-control"/></td>
															<td><f:errors path="cin"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-usd  blue">
															</i> <font color="#585858"> <strong>Profession
																		</strong></font></td>
															<td><f:input path="profession" class="form-control"/></td>
															<td><f:errors path="profession"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-home  blue">
															</i> <font color="#585858"> <strong>Adresse Domicile
																		</strong></font></td>
															<td><f:input path="adresseDomicile" class="form-control"/></td>
															<td><f:errors path="adresseDomicile"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-phone-alt  blue">
															</i> <font color="#585858"> <strong>Telephone Domicile
																		</strong></font></td>
															<td><f:input path="telephoneDomicile" class="form-control"/></td>
															<td><f:errors path="telephoneDomicile"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-phone  blue">
															</i> <font color="#585858"> <strong>Telephone Portable
																		</strong></font></td>
															<td><f:input path="telephonePortable" class="form-control"/></td>
															<td><f:errors path="telephonePortable"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-envelope  blue">
															</i> <font color="#585858"> <strong>Email
																		</strong></font></td>
															<td><f:input path="email" class="form-control"/></td>
															<td><f:errors path="email"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-road  blue">
															</i> <font color="#585858"> <strong>Lieu de Travail
																		</strong></font></td>
															<td><f:input path="lieuTravail" class="form-control"/></td>
															<td><f:errors path="lieuTravail"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-earphone  blue">
															</i> <font color="#585858"> <strong>Telephone de Travail
																		</strong></font></td>
															<td><f:input path="telephoneTravail" class="form-control"/></td>
															<td><f:errors path="telephoneTravail"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class="glyphicon glyphicon-star  blue">
															</i> <font color="#585858"> <strong>Nom Utilisateur
																		</strong></font></td>
															<td><f:input path="nomUtilisateur" class="form-control"/></td>
															<td><f:errors path="nomUtilisateur"
																	cssClass="errors" /></td>
														</tr>
														<tr>
															<td><i class=" glyphicon glyphicon-ban-circle  blue">
															</i> <font color="#585858"> <strong>Mot de Passe
																		</strong></font></td>
															<td><f:input path="motPasse" class="form-control"/></td>
															<td><f:errors path="motPasse"
																	cssClass="errors" /></td>
														</tr>
														<tr>
														<td>
															<div class="control-group" align="center" >
																<div class="controls" >
																	<button  type="submit" class="btn btn-success"
																		title="Modifier et Enregistrer" data-toggle="tooltip">Valider</button>
																	<a class="btn btn-danger"
																		title="Annuler et retourner à la liste des Parents"
																		data-toggle="tooltip"
																		href="<c:url value="/adminPa/index"/>">Annuler</a>
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
		<!-- footer -->

		<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
	</body>
	</html>