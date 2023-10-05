<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession misession = request.getSession(); //obtener sesion
    String nombre_usuario = (String) misession.getAttribute("nombre_usuario"); //obtener el objeto usuario de la sesion
    if (nombre_usuario == null) {
            response.sendRedirect("login.jsp");
        }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Consultorio Odontológico</title>
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-regular fa-tooth"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Consultorio Odontológico</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-sharp fa-solid fa-teeth-open"></i>
                    <span>Home</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Gestión
            </div>
            
            
            <!-- Nav Item - USUARIOS -->
            <li class="nav-item">
                <a class="nav-link collapsed" data-toggle="collapse" data-target="#collapseUsuarios"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-user"></i>
                    <span>Usuarios</span>
                </a>
                <div id="collapseUsuarios" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvUsuarios">Ver usuarios</a>
                        <a class="collapse-item" href="views/usuarios/altaUsuario.jsp">Nuevo usuario</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - PERSONAS -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePersonas"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-users"></i>
                    <span>Personas</span>
                </a>
                <div id="collapsePersonas" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvPersonas">Ver personas</a>
                        <a class="collapse-item" href="views/personas/altaPersona.jsp">Nueva persona</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - RESPONSABLES -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseResponsables"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-user-secret"></i>
                    <span>Responsables</span>
                </a>
                <div id="collapseResponsables" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvResponsables">Ver responsables</a>
                        <a class="collapse-item" href="views/responsables/altaResponsable.jsp">Nuevo responsable</a>
                    </div>
                </div>
            </li>
            
            
            <!-- Nav Item - SECRETARIOS -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSecretarios"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-briefcase"></i>
                    <span>Secretarios</span>
                </a>
                <div id="collapseSecretarios" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvSecretarios">Ver secretarios</a>
                        <a class="collapse-item" href="views/secretarios/altaSecretario.jsp">Nuevo secretario</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Odontologos -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOdontologos"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-user-nurse"></i>
                    <span>Odontólogos</span>
                </a>
                <div id="collapseOdontologos" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvOdontologos">Ver odontólogos</a>
                        <a class="collapse-item" href="views/odontologos/altaOdontologo.jsp">Nuevo odontólogo</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Pacientes -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePacientes"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-tooth"></i>
                    <span>Pacientes</span>
                </a>
                <div id="collapsePacientes" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvPacientes">Ver pacientes</a>
                        <a class="collapse-item" href="views/pacientes/altaPaciente.jsp">Nuevo paciente</a>
                    </div>
                </div>
            </li>
            
            
            <!-- Divider -->
            <hr class="sidebar-divider">
            
             <!-- Nav Item - HORARIOS -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseHorarios"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-clock"></i>
                    <span>Horarios</span>
                </a>
                <div id="collapseHorarios" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvHorarios">Ver horarios</a>
                        <a class="collapse-item" href="views/horarios/altaHorario.jsp">Nuevo horario</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - TURNOS -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTurnos"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-calendar"></i>
                    <span>Turnos</span>
                </a>
                <div id="collapseTurnos" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="SvTurnos">Ver turnos</a>
                        <a class="collapse-item" href="views/turnos/altaTurno.jsp">Nuevo turno</a>
                    </div>
                </div>
            </li>

            


        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    
                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=nombre_usuario%></span>
                                <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">                            
                                <a class="dropdown-item" href="logout.jsp">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                     Cerrar Sesion
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->
