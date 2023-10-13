<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../../index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-regular fa-tooth"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Consultorio Odontológico</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="../../index.jsp">
                    <i class="fas fa-sharp fa-solid fa-teeth-open"></i>
                    <span>Home</span>
                </a>
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
                        <a class="collapse-item" href="../../SvUsuarios">Ver usuarios</a>
                        <a class="collapse-item" href="../usuarios/altaUsuario.jsp">Nuevo usuario</a>
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
                        <a class="collapse-item" href="../../SvPersonas">Ver personas</a>
                        <a class="collapse-item" href="../personas/altaPersona.jsp">Nueva persona</a>
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
                        <a class="collapse-item" href="../../SvResponsables">Ver responsables</a>
                        <a class="collapse-item" href="../responsables/altaResponsable.jsp">Nuevo responsable</a>
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
                        <a class="collapse-item" href="../../SvSecretarios">Ver secretarios</a>
                        <a class="collapse-item" href="../secretarios/altaSecretario.jsp">Nuevo secretario</a>
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
                        <a class="collapse-item" href="../../SvOdontologos">Ver odontólogos</a>
                        <a class="collapse-item" href="../odontologos/altaOdontologo.jsp">Nuevo odontólogo</a>
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
                        <a class="collapse-item" href="../../SvPacientes">Ver pacientes</a>
                        <a class="collapse-item" href="../pacientes/altaPaciente.jsp">Nuevo paciente</a>
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
                        <a class="collapse-item" href="../../SvHorarios">Ver horarios</a>
                        <a class="collapse-item" href="../horarios/altaHorario.jsp">Nuevo horario</a>
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
                        <a class="collapse-item" href="../../SvTurnos">Ver turnos</a>
                        <a class="collapse-item" href="../turnos/altaTurno.jsp">Nuevo turno</a>
                    </div>
                </div>
            </li>
            
             <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            
             <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <p class="text-center mb-2"><strong>Logged As: </strong>Admin</p>
            </div>
        </ul>
        <!-- End of Sidebar -->