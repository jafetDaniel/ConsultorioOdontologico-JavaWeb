<%@page import="logica.Horarios"%>
<%@page import="logica.Personas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Usuarios"%>
<%@page import="logica.Controladora"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Alta Odontólogo</h1>
                    </div>
                    
                    <%                        
                        Controladora control = new Controladora();
                        List<Usuarios> listaUsu = new ArrayList<Usuarios>();
                        listaUsu = control.getUsuarios();
                        List<Personas> listaPer= new ArrayList<Personas>();
                        listaPer = control.getPersonas();
                        List<Horarios> listaHora= new ArrayList<Horarios>();
                        listaHora = control.getHorarios();
                    %>
                    
                    <form action="../../SvOdontologos" method="POST">
                         <div class="mb-3">
                            <label class="form-label">Usuario</label>
                            <select class="form-control" name="id_usuario" style="width: 300px">
                                <option value="0">seleccione usuario</option>
                                <%   for (Usuarios usu: listaUsu) {   %>
                                   <option value="<%=usu.getId_usuario()%>"><%=usu.getNombre_usuario()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                         <div class="mb-3">
                            <label class="form-label">Persona</label>                           
                            <select class="form-control" name="id_persona" style="width: 300px">
                                <option value="0">seleccione persona</option>
                                <%   for (Personas per: listaPer) {   %>
                                   <option value="<%=per.getId()%>"><%=per.getNombre() +" "+per.getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Especialidad</label>
                            <input type="text" class="form-control" name="especialidad" style="width: 300px">
                        </div> 
                            
                        <div class="mb-3">
                            <label class="form-label">Horario</label>                            
                            <select class="form-control" name="id_horario" style="width: 300px">
                                <option value="0">seleccione horario</option>
                                <%   for (Horarios hora: listaHora) {   %>
                                   <option value="<%=hora.getId_horario()%>"><%=hora.getHorario_inicio()+" - "+hora.getHorario_fin()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Crear Odontólogo</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>