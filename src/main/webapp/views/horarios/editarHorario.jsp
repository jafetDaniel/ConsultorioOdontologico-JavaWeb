<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.Horarios"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Editar Horario</h1>
                    </div>
                    
                      <%  Horarios hora = (Horarios) request.getSession().getAttribute("horaEditar"); %>
                      
                    <form action="../../SvEditarHorarios" method="POST">
                        <div class="mb-3">
                            <label class="form-label">Hora inicio</label>
                            <input type="time" class="form-control" name="horario_inicio" value="<%=hora.getHorario_inicio()%>" required style="width: 150px">
                            
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Hora fin</label>
                            <input type="time" class="form-control" name="horario_fin" value="<%=hora.getHorario_fin()%>" required style="width: 150px">
                        </div>
                    
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Editar Horario</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>