<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Alta Usuario</h1>
                    </div>
                    
                    <form action="../../SvUsuarios" method="POST">
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre_usuario" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Contraseña</label>
                            <input type="password" class="form-control" name="contrasenia" required style="width: 500px">
                        </div>
                         <div class="mb-3">
                            <label class="form-label">Rol</label>
                            <input type="text" class="form-control" name="rol" required style="width: 500px">
                        </div>
                    
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Crear Usuario</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>