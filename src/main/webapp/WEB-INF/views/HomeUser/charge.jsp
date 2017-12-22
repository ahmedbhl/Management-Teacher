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
			<%@ include file="/WEB-INF/views/menu_left/leftMenuEnseignant.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Charge Enseignants</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				
				
				<div class="row">
					
				</div>
				
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Liste des Charges Enseignants</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<table width="100%" style="text-align:center"
									class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th style="text-align:center"><font size="2">Enseignant</font></th>
											<th style="text-align:center"><font size="2">Nombre TD Totale</font></th>
											<th style="text-align:center"><font size="2">Nombre TP Totale</font></th>
											<th style="text-align:center"><font size="2">Nombre Cours Totale</font></th>
											<th style="text-align:center"><font size="2">Salaire Net</font></th>
											<th style="text-align:center"><font size="2">Salaire Brut</font></th>
											<th style="text-align:center"><font size="2">Semestre</font></th>
											<th style="text-align:center"><font size="2">Année Scolaire</font></th>
											<th style="text-align:center"><font size="2">Action</font></th>
											

										</tr>
									</thead>
									<tbody>
									<c:forEach items="${listechargeens}" var="listechargeens">
									
										<tr class="odd gradeX">
											<td>${listechargeens.getEnseignant().getNom() } ${listechargeens.getEnseignant().getPrenom()}</td>
											<td>${listechargeens.getNbreTdTot()}</td>
											<td>${listechargeens.getNbreTpTot()}</td>
											<td>${listechargeens.getNbreCoursTot()}</td>
											<td>${listechargeens.getSalaireNet()}</td>
											<td>${listechargeens.getSalaireBrut()}</td>
											<fmt:formatDate var="year" value="${listechargeens.getSemestre().getDate_deb()}" pattern="yyyy" />
											<fmt:formatDate var="month" value="${listechargeens.getSemestre().getDate_deb()}" pattern="MM" />
											<td>${listechargeens.getSemestre().getDescription()}</td>
											<c:choose>
   											<c:when test="${month<9}">
											<td>${year-1}-${year}</td>
											</c:when><c:otherwise>
											<td>${year}-${year+1}</td>
											</c:otherwise>	</c:choose>	
											<td>
											 <c:url	value="/user/details/${listechargeens.getIdChargeEnseignant()}" var="Details"></c:url>
											 &nbsp; <a	href="${Details}"><i class="fa fa-info-circle " data-toggle="tooltip" title="Gérer la liste des séances de ${listechargeens.getSemestre().getDescription()} de l'année ${year}-${year+1} "></i></a>
											 <c:url	value="/user/print/${listechargeens.getIdChargeEnseignant()}" var="print"></c:url>
											&nbsp;|&nbsp; <a	href="${print}"><i class="fa fa-print "></i></a>
											
														
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
			 $('[data-toggle="tooltip"]').tooltip();  
		});
	</script>

</body>

</html>
