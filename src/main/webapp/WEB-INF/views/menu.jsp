<div class="navbar navbar-default" role="navigation">

	<div class="navbar-inner">
	
<a class="navbar-brand" > <img alt="<%=request.getContextPath()%>/resources/Charisma Logo" src="<%=request.getContextPath()%>/resources/img/logo20.png" class="hidden-xs"/>
                <span>Administrateur</span></a>


		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<i class=" glyphicon glyphicon-off"></i><span
					class="hidden-sm hidden-xs"> <strong><font
						color="#8C001A">Admin</font></strong></span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">

				<li><a href="<c:url value="/j_spring_security_logout"/>"><strong><font
							color="#8C001A">Deconnexion</font></strong></a></li>
			</ul>
		</div>
		
		
		
		
		



	</div>
</div>
<!-- Menus -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    
                        
                        
                        
                        
                                 
                          <ul class="nav nav-pills nav-stacked main-menu">
                          
                        <li class="nav-header">Personnages</li>
                        
                        <li><a class="ajax-link" href="<c:url value="/adminEnf/index"/>"><span> Enfants</span></a>
                        </li>
                        
                        
                        <li><a class="ajax-link" href="<c:url value="/adminPa/index"/>"><span> Parents</span></a>
                        </li>
                        
                        
                        <li><a class="ajax-link" href="<c:url value="/admin/index"/>"><span> Accompagnateurs</span></a>
                        </li>
                        
                        
                        
                        
                        
                        <li class="accordion">
                            <a href="#"> <span>Equipes</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="<c:url value="/adminListEdu/index"/>">Equipe Educatif</a></li>
                                <li><a href="<c:url value="/adminListSan/index"/>">Equipe Sanitaire</a></li>
                                 
                                
                            </ul>
                        </li>
                        
                        
                        
                         <li><a class="ajax-link" href="<c:url value="/adminFou/index"/>"><span> Fournisseurs</span></a>
                        </li>
                        
                         <li class="nav-header hidden-md"><strong>Facteurs</strong></li>
                        
                        
                        <li class="accordion">
                            <a href="#"><span>Clubs & Categories</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="<c:url value="/adminClubLi/index"/>"> Clubs</a></li>
                                <li><a href="<c:url value="/adminCategC/index"/>"> Categories</a></li>
                                
                                
                            </ul>
                        </li>
                        
                        <li class="accordion">
                            <a href="#"><span>Creches & Classes</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="<c:url value="/adminCr/index"/>"> Creches</a></li>
                                <li><a href="<c:url value="/adminClasLi/index"/>"> Classes</a></li>
                                
                                
                            </ul>
                        </li>
                        
                        
                         
                        <li><a class="ajax-link" href="<c:url value="/adminPlanLi/index"/>"><span> Plannings Horraires</span></a>
                        </li>
                        
                        
                     
                        
                        <li>
                        
                        <ul class="nav nav-pills nav-stacked">
                                <li><a href="<c:url value="/adminFonc/index"/>"> Fonctions Equipes</a></li>
                                
                                
                                
                            </ul>
                        </li>
                        
                        
                        
                        
                        
                        
                        
                          <li>
                        
                        <ul class="nav nav-pills nav-stacked">
                                <li><a href="<c:url value="/adminEv/index"/>">Evennements</a></li>
                                
                                
                                
                            </ul>
                        </li>
                        
                        
                        
                        <li class="accordion">
                            <a href="#"><span>Paiements</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#"> Annuelles</a></li>
                                <li><a href="#"> Mensuelles</a></li>
                                
                                
                            </ul>
                        </li>
                        
                        
                        
                         <li class="nav-header hidden-md"><strong>Stocks</strong></li>
                        
                        
                        <li class="accordion">
                            <a href="#"><span>Stocks</span></a>
                            <ul class="nav nav-pills nav-stacked">
                            
                                <li><a href="<c:url value="/adminMaterielLi/index"/>"> Materiels</a></li>
                                <li><a href="<c:url value="/adminTypM/index"/>"> Types</a></li>
                                <li><a href="<c:url value="/adminStoc/index"/>"> Stocks</a></li>
                                
                                
                            </ul>
                        </li>
                        
                        
                        
                       
                        
                      
                       
                    
                    
                </div>
            </div>
        </div>
       