<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Recherche...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> 
			</li>
			<li>
			<c:url value="/user/" var="home"></c:url>
			<a href="${home}"><i class="fa fa-dashboard fa-fw"></i>ACCUEIL</a></li>
			
			<li>
			<a href="#"><i class="glyphicon glyphicon-stats"></i> Charges Enseignants <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/user/charges" var="chargeEnseignant"></c:url>
					<li><a href="${chargeEnseignant}">Liste des charges enseignants</a></li>
				</ul>
			</li>
			<li>
			<a href="#"><i class="fa fa-suitcase"></i> Seances<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/user/seances/" var="Seance"></c:url>
					<li><a href="${Seance}">Liste des Seances</a></li>
				</ul>
			</li>
			
			<li><a href="#"><i class="fa fa-exclamation-circle"></i> A Propos</a></li>
					
					
			
			
			
			
		</ul>
	</div>
	
</div>