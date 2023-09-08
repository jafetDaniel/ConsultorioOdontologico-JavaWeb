<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Personas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Editar Persona</h1>
                    </div>
                    <%  Personas per = (Personas) request.getSession().getAttribute("perEditar"); 
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //dar formato a fecha
                    %>
                    
                    <form action="../../SvEditarPersonas" method="POST">
                        <div class="mb-3">
                            <label class="form-label">DNI</label>
                            <input type="text" class="form-control" name="dni" value="<%=per.getDni()%>" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="<%=per.getNombre()%>" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Apellido</label>
                            <input type="text" class="form-control" name="apellido" value="<%=per.getApellido()%>" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Teléfono</label>
                            <input type="number" class="form-control" name="telefono" value="<%=per.getTelefono()%>" required style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Dirección</label>
                            <input type="text" class="form-control" name="direccion" value="<%=per.getDireccion()%>" required  style="width: 500px">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Fecha de nacimiento</label>
                            <div>
                                <% if (per.getFecha_nac() != null) { %>
                                   <label class="form-label"><%=formato.format(per.getFecha_nac())%></label>
                                <% } %>
                                <input type="date" class="form-control" name="fecha_nac" style="width: 160px; display:inline;">
                            </div>
                        </div>
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">guardar</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>