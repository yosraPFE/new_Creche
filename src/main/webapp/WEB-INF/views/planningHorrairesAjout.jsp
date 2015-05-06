<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">



<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<title>Nouveau Planning Horraire</title>
</head>

<body>

	<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	
	<div id="content" class="col-lg-10 col-sm-10">



		<a class="btn btn-primary btn-round btn-lg"
			href="<c:url value="/adminPlanLi/index"/>"> <strong><i
				class="glyphicon glyphicon-time"> </i> Liste Planning Horraires</strong></a> <a
			class="btn btn-info btn-round btn-lg"
			href="<c:url value="/adminPlan/index"/>"> <strong><i
				class="glyphicon glyphicon-plus"> </i> Nouveau Planning Horraire</strong></a>
	
	
	
	
	
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
					
					
					<c:if test="${not empty planningHorraireAjoute}">
							<div class="box-content row" style="display: none;">
						</c:if>
					
					
						<c:if test="${empty planningHorraireAjoute}">
					<div class="box-content row">
					</c:if>
					
					<div class="col-lg-7 col-md-12">




							<f:form modelAttribute="planningHorraire"
								action="ajouterPlanningHorraire" method="post">

								<table>
								
								
								<tr>
										<!--  <td>ID</td>-->
										<td><f:input type="hidden" disabled="true"
												path="idPlanningH" /></td>
										<td><f:errors type="hidden" path="idPlanningH"
												cssClass="errors" /></td>
									</tr>
									
									<tr>


										<td><i class="glyphicon glyphicon-bookmark  blue"> </i> <font
											color="#585858"><strong>Type : </strong></font></td>
										<td><f:textarea path="typePlanning" class="form-control" /></td>
										<td><f:errors path="typePlanning" cssClass="errors" /></td>
									</tr>
									
									
									
									<tr>


										<td><i class="glyphicon glyphicon-usd  blue"> </i> <font
											color="#585858"><strong>Prix : </strong></font></td>
										<td><f:input path="prixPlanning" class="form-control" /></td>
										<td><f:errors path="prixPlanning" cssClass="errors" /></td>
									</tr>
									
									
									
	                                              <tr>
									
									
									
									
									
									
									
									
									
									
									
									
									<tr>
										<td>


											<div class="control-group" align="center">

												<div class="controls">
													<button type="submit" class="btn btn-success"
														title="Valider et afficher details" data-toggle="tooltip">Valider</button>
													<a class="btn btn-danger"
														title="Annuler et retourner à la liste des Planning Horraire"
														data-toggle="tooltip"
														href="<c:url value="/adminPlanLi/index"/>">Annuler</a>
												</div>
											</div>
										</td>
									</tr>
									
									</table>

							</f:form>

						</div>
							
				</div>
					<c:if test="${not empty planningHorraireAjoute}">
					
	
	
	<div id="content" class="col-lg-12 col-sm-12">
							
			<div></div>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
								<i class="glyphicon glyphicon-align-justify"></i> <font
													color="#8C001A">Details d'ajout du Planning Horraire</font>
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
	
	
	
	   <p><b> C'est Le planning Horraire  qui a de type ${planningHorraireAjoute.typePlanning} et qui a de prix ${planningHorraireAjoute.prixPlanning} a eté ajoutée !
                    
                   
                            
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