<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Alta Persona</h1>
                    </div>

                    <form action="../../SvPersonas" method="POST">
                        <div class="mb-3">
                            <label class="form-label">DNI</label>
                            <input type="text" class="form-control" name="dni" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Apellido</label>
                            <input type="text" class="form-control" name="apellido" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Teléfono</label>
                            <input type="number" class="form-control" name="telefono" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Dirección</label>
                            <input type="text" class="form-control" name="direccion" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="fecha_nac" required style="width: 160px">
                        </div>
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Crear Persona</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>