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
			<c:url value="/admin/" var="home"></c:url>
			<a href="${home}"><i class="fa fa-dashboard fa-fw"></i>
			Accueil</a></li>
			<li>
			<a href="#"><i class="glyphicon glyphicon-user  "></i> Enseignants<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/enseignants/" var="enseignant"></c:url>
					<li><a href="${enseignant}">Liste des enseignants</a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="glyphicon glyphicon-stats"></i> Charges Enseignants <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/chargeEnseignants/" var="chargeEnseignant"></c:url>
					<li><a href="${chargeEnseignant}">Liste des charges enseignants</a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Grades<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/grades/" var="listgrade"></c:url>
					<li><a href="${listgrade}">Liste des Grades</a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-suitcase"></i> Seances<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/seances/" var="Seance"></c:url>
					<li><a href="${Seance}">Liste des Seances</a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-clock-o "></i> Semestres<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/semestres/" var="Semestre" ></c:url>				
					<li><a href="${Semestre}">Liste des Semestres</a></li>
				</ul>
			</li>
			<li>
			<a href="#"><i class="fa fa-users "></i> Utilisateurs<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/Users/" var="utilisateur"></c:url>
					<li><a href="${utilisateur}">Liste des Utilisateurs</a></li>
				</ul>
			</li>
			
			
			<li><a href="#"><i class="fa fa-exclamation-circle"></i> A Propos</a></li>
					
					
			
			
			
			
		</ul>
	</div>
	
</div>