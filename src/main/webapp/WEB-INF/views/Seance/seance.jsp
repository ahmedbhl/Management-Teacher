<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Enseignants</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">
<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>
			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Seances</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<!-- /.row -->
				
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<c:url value="/seances/nouveau" var="enseignant"></c:url>
  							<li><a href="${enseignant}"><i class="fa fa-plus">&nbsp;Ajouter</i></a></li>
  							<li><a href="#"><i class="fa fa-upload ">&nbsp;Importer</i></a></li>
  							<li><a href="#"><i class="fa fa-download ">&nbsp;Exporter</i></a></li>
						</ol>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Liste des Seances</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<table width="100%" style="text-align:center"
									class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th style="text-align:center">Enseignant</th>
											<th style="text-align:center">Nom Seance</th>
											<th style="text-align:center">Type Seance</th>
											<th style="text-align:center">Nombre Seance / Jour</th>
											<th style="text-align:center">Date</th>
											<th style="text-align:center">Heures</th>
											<th style="text-align:center">Absence</th>
											<th style="text-align:center">Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listeseances}" var="listeseances">

											<tr class="odd gradeX">
												<td>${listeseances.getChargeEnseignant().getEnseignant().getNom() } ${listeseances.getChargeEnseignant().getEnseignant().getPrenom() }</td>
												<td>${listeseances.getNomSeance() }</td>
												<td>${listeseances.getType() }</td>
												<td>${listeseances.getNbreSeance()}</td>
												<fmt:formatDate var="date" value="${listeseances.getDate()}" pattern="dd-MM-yyyy" />
												<td>${date}</td>
												<td>
												<c:forEach items="${listeseances.getHeureSeances()}" var="Heure">
												${Heure}
												</c:forEach>
												</td>												
											<td>
											<c:url	value="/seances/modifierEtat/${listeseances.getIdSeance()}" var="modifierEtat"></c:url>
											<c:choose>
   											<c:when test="${listeseances.getAbsence()}">
   												<button class="btn btn-outline btn-success btn-sm" type="button" onclick="location.href='${modifierEtat}'">Prèsent</button>
											</c:when>   
				 							<c:otherwise>
												<button class="btn btn-outline btn-danger btn-sm" type="button" onclick="location.href='${modifierEtat}'">Absent</button>
											 </c:otherwise>	</c:choose>									
												
												</td>
												<td><c:url
														value="/seances/modifier/${listeseances.getIdSeance()}"
														var="updateSeance"></c:url> <a href="${updateSeance}"><i
														class="fa fa-edit"></i></a> 
													  &nbsp;|&nbsp; <a href="javascript:void(0);" data-toggle="modal" data-target="#modal${listeseances.getIdSeance()}">	<i class="fa fa-trash-o"></i></a>
														<div style="text-align:left" class="modal fade" id="modal${listeseances.getIdSeance()}"  role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal"
																			aria-hidden="true">&times;</button>
																		<h4 class="modal-title" id="myModalLabel">Confirmation </h4>
																	</div>
																	<div class="modal-body">Êtes-vous sûr de vouloir
																		supprimer cette session !</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-default"
																			data-dismiss="modal">Annuler</button>
																		<c:url	value="/seances/supprimer/${listeseances.getIdSeance()}" var="deleteSeance"></c:url>
																		<a href="${deleteSeance}" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;Supprimer</a>
																	</div>
																</div>
																<!-- /.modal-content -->
															</div>
															<!-- /.modal-dialog -->
														</div>
													</td>
											</tr>
										</c:forEach>


									</tbody>
								</table>

							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>

</html>
