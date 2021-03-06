<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Utilisateurs</title>

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
<link
	href="<%=request.getContextPath()%>/resources/dist/css/checkbox.css"
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
						<h1 class="page-header">Utilisateurs</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">Nouvel Utilisateur</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<c:url value="/Users/enregistrer" var="enregistrer"></c:url>
								<f:form modelAttribute="user" action="${enregistrer}"
									method="Post" role="form">
									<f:hidden path="idutilisateur" />

									<div class="form-group">
										<label>Nom</label>
										<f:input path="nom" class="form-control" placeholder="Nom" />
										<f:errors path="nom" class="text-danger" />
									</div>

									<div class="form-group">
										<label>Prenom</label>
										<f:input path="prenom" class="form-control"
											placeholder="Prenom" />
										<f:errors path="prenom" class="text-danger" />
									</div>
									<div class="form-group">
										<label>Mot de Passe</label>
									<div class="form-group input-group">
									    <f:input path="password" class="form-control" placeholder="Mot de Passe" id="password" readonly="true" />
										<span class="input-group-btn">
										<button class="btn btn-outline btn-primary" type="button" onclick="javascript:generatePassword();"><i class="fa fa-lock"></i></button> </span>
										<f:errors path="password" class="text-danger" />
									</div></div>

									<div class="form-group">
										<label>Mail</label>
										<f:input path="mail" type="email" class="form-control"
											placeholder="Mail" />
										<f:errors path="mail" class="text-danger" />
									</div>
									
									<div class="form-group">
									<label>Activer le Compte</label>
									<div class="slideTwo">
										<f:checkbox path="Actived"  id="slideTwo" name="check" label="" for="slideTwo" />
										<f:errors path="Actived" class="text-danger" />
									</div></div>

									<div class="panel-footer">
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-save">&nbsp;Enregistrer</i>
										</button>
										<a href="<c:url value="/Users/" />" class="btn btn-danger"
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
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/checkbsox.js"></script>
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
	<script type="text/javascript">
	function generatePassword() {
	var text = "";
	  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdef@ghijklmnopqrstuvwxyz0123456789@-*/&";

	  for (var i = 0; i < 5; i++){
	    text += possible.charAt(Math.floor(Math.random() * possible.length));}
	$('#password').val(text);
	}
</script> 
</body>

</html>
