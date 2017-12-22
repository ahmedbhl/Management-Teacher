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

<link
	href="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap-datetimepicker.min.css"
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
						<h1 class="page-header">Semestres</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">Nouveau Semestre</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<c:url value="/semestres/enregistrer" var="enregistrer"></c:url>
								<f:form modelAttribute="semestre" action="${enregistrer}" method="Post" role="form" id="formId">
									<f:hidden path="idSemestre" />
									
									<div class="form-group">
										<label>Description</label>
										<f:input path="description" class="form-control"
											placeholder="Description" />
										<f:errors path="description" class="text-danger" />
									</div>
	
									<div class="form-group">
										<label>Date de Début</label>
										<div class='input-group date' id='datetimepicker10'>
										<f:input  path="date_deb" size="16" type="text" class="form-control" placeholder="Date de Début" readonly="true" id="date_deb" />
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<f:errors path="date_deb" class="text-danger" />
									</div>
									
									<div class="form-group">
										<label>Date de Fin</label>
										<div class='input-group date' id='datetimepicker10'>
										<f:input  path="date_fin" size="16" type="text" class="form-control" placeholder="Date de Fin" readonly="true" id="date_fin" />
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
										</div>
										<f:errors path="date_fin" class="text-danger" />
									</div>
									
									<div class="panel-footer">
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-save">&nbsp;Enregistrer</i>
										</button>
										<a href="<c:url value="/semestres/" />" class="btn btn-danger"
											type="submit"><i class="fa  fa-arrow-left ">&nbsp;Annuler</i></a>

									</div>
								</f:form>
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
	</script>

	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/jquery-1.8.3.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap-datetimepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/locales/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript">
		$("#date_deb").datetimepicker({
			language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0,
			format: 'yyyy-mm-dd'
		});
		$("#date_fin").datetimepicker({
			language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0,
			format: 'yyyy-mm-dd'
		});
	</script>
	<script type="text/javascript">
    $(document).ready(function() {
        $.validator.addMethod("endDate", function(value, element) {
            var date_deb = $('#date_deb').val();
            var date_fin = $('#date_fin').val();
            return Date.parse(date_deb) < Date.parse(date_fin) || value == "";
        }, "* End date must be after start date");
        $('#formId').validate();
    });
</script>
</body>

</html>
