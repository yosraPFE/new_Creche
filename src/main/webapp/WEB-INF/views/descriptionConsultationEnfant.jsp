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
                                            <h2 style="color:#ec6a97"> Consultation </h2>
                                            
                                            
                                            <h4><label> ${enfant.nom} ${enfant.prenom}</label> </h4>
                                            
                                            
                                        </td>
                                        
                                        <td width="60%"> <h2> </h2>  </td>
                                    </tr>
                                </table>
                                
                                            
                                        

									<div class="box-icon">
										
									</div>
								</div>
								<div class="box-content">

								
                      
                           
                              
                                <blockquote>
                                    <p>L'Enfant ${enfant.nom} ${enfant.prenom} est consulté à la date " ${derniereConsultation.date} " de la part de Mr/Madame " ${eqSanConsultation.nom} " qui est
                                    une/un  ${eqSanConsultation.fonction.labelle} ! </p>
                                   
                                </blockquote>
                                
                                  <blockquote>
                                    <p>Description Medicale :  ${derniereConsultation.description}  </p>
                                   
                                </blockquote>
                           
									
										
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
										
											
								
								</div>
							</div>
						</div>
						<!--/span-->

					</div>


				</div>
			</div>
		</div>
	


 <button  class="btn btn-success no-print" onclick="print_cmd()">Imprimer</button>
	
</body>
