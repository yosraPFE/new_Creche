<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>


<!-- The styles -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css1/styl.css">
	
	
	<script>

    function print_cmd(){
    window.print();
}

</script>
<style type="text/css">
    @media print
{    
    .no-print, .no-print *
    {
        display: none !important;
    }
}
</style>

<!-- header -->
<%@ include file="/WEB-INF/views/templates/header.jsp"%>


</head>

<body>


	
	
	

							



	
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
                                <table width="100%">
                                    <tr>
                                        
                                        <td>
                                            <h2 style="color:#ec6a97">Facture Menuselle </h2>
                                            
                                            
                                            <h3 style="color:#ec6a97"> ${payementMensuel.moisPayment}</h3>
                                            
                                            <h4><label> ${enfant.nom} ${enfant.prenom}</label> </h4>
                                            
                                            
                                        </td>
                                        
                                        <td width="60%"> <h2> Crèche L' ${crecheAnnee.nom}</h2>  </td>
                                    </tr>
                                </table>
                                
                                            
                                        

									<div class="box-icon">
										
									</div>
								</div>
								<div class="box-content">

								
                      
                           
                              
                                <blockquote>
                                    <p>L'Enfant ${enfant.nom} ${enfant.prenom} est inscri à la date " ${inscritAnnee.dateInscription} " dans la classe " ${classeAnnee.nom} " </p>
                                   
                                </blockquote>
                           
									
									
									
									
									
									
									
									 <blockquote>
									<p>Liste des choix clubs</p>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Nom Clubs</th>
													
													<th>Catégorie</th>
													<th>Prix</th>

													
												</tr> 
											</thead>
											<tbody>

												<c:forEach items="${listClubActifsEnfant}" var="clu" >
													<tr>
														<td>${clu.id.club.nom}</td>
														

														<td>${clu.id.club.categorieClub.labelle}</td>
														<td>${clu.id.club.categorieClub.prix}</td>
	
														
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
										  </blockquote>
										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
										
										
										 <blockquote> 
										 
										 
										 <p>Liste des choix plannings horraires</p>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Type Planning</th>
													<th>Prix Planning</th>
													

													
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listPlanningActifsEnfant}" var="pl" >
													<tr>
														<td>${pl.id.planningHorraires.typePlanning}</td>
														<td>${pl.id.planningHorraires.prixPlanning}</td>

	
														
													</tr>
												</c:forEach>
											</tbody>
										</table>
										 </blockquote>
										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
										
										<blockquote>
                                    <p>${enfant.nom} ${enfant.prenom} a pour  Tarif Mensuel d'inscription ${crecheAnnee.tarifParMois} (DT) et
                                    suivant ces integrations dans dans les clubs et les plannings horraires choisis , il a pour montant sans remise ${payementMensuel.montantAvantRemise} (DT) et en affectant un  remise de ${payementMensuel.remise} % il a comme montant total ${payementMensuel.montantApresRemise} (Dt) pour le mois
                                    ${payementMensuel.moisPayment} et il l'a payé en ${payementAnnuelle.typePayement}. </p>
                                   
                                     </blockquote>
										
										
									
							
									
                                      
										
								
								</div>
							</div>
						</div>
						<!--/span-->

					</div>


				</div>
			</div>
		</div>
	<div class="row">
                        <div class="col-lg-13">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                <div style="
            width: 700px;
            text-align: center;
            margin: auto;
        "><label>Adresse :</label>
         ${crecheAnnee.adresse}<br>

                             
                                

        <label>Tél:</label>  ${crecheAnnee.telephone}  	
        <label>&nbsp; Ville: </label> ${crecheAnnee.ville}<label> &nbsp;E-Mail:</label>${crecheAnnee.email}
        
        
        </div>


</div></div></div></div> <button  class="btn btn-success no-print" onclick="print_cmd()">Imprimer</button>
	
</body>
