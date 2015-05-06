<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">
	
	
	
<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>


</head>

<body>

<%@ include file="/WEB-INF/views/menu.jsp"%>
	
	
	

							



	
	<div class="ch-container">
		<div class="row">


			<!--/span-->
			<!-- left menu ends -->

			
			
			 <div id="page-wrapper">
                    <div class="row">
                      
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-13">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                
                                            
                                        

									<div class="box-icon">
										
									</div>
								</div>
								<div class="box-content">

								
                      
                           
                              
                               
									
									
									
									
									
									
									
									 <blockquote>
									<p>Liste des Enfants Inscris</p>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
										<table class="table table-bordered">
											<thead>
												<tr>
												   <!--   <th>Photos</th>-->
													<th>Nom </th>
													
													<th>Prenom</th>
													

													
												</tr> 
											</thead>
											<tbody>

												<c:forEach items="${listPlanningActifsEnfant}" var="pl" >
													<tr>
														<td>${pl.id.enfant.nom}</td>
														
														
														<!--  <td width=100px><img
											src="photoEnf?idEnfant=${clu.id.enfant.idPerson}" class="images_petit"
											title="Cliquer pour voir la photo" data-toggle="tooltip"
											onclick="window.open('photoEnf?idEnfant=${clu.id.enfant.idPerson}','nom_de_ma_popup','menubar=no, scrollbars=no, top=100, left=100, width=400, height=500')"
											class="images_petit" /></td>-->
										
														
														<td>${pl.id.enfant.nom}</td>
														

														<td>${pl.id.enfant.prenom}</td>
														
	
														
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										  </blockquote>
										
									
										
										 
										
									
							
									
                                      
										
								
								</div>
							</div>
						</div>
						<!--/span-->

					</div>


				</div>
			</div>
		</div>
	<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
