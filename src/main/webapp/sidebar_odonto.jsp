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
                    <span>Home</span>
                </a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Gestión
            </div>     
                      
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
            
             <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            
             <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <p class="text-center mb-2"><strong>Logged As: </strong>Odontólogo</p>
            </div>
            
        </ul>
        <!-- End of Sidebar -->