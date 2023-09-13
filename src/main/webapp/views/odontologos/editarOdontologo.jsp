<%@page import="logica.Odontologos"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Editar Odontólogo</h1>
                    </div>
                    
                    <%                        
                       Odontologos odonto = (Odontologos) request.getSession().getAttribute("odontoEditar"); 
                        
                        List<Personas> listaPer = (List) request.getSession().getAttribute("selecPersonas");//obtener una variable de la session 
                        List<Usuarios> listaUsu = (List) request.getSession().getAttribute("selecUsu");  
                        List<Horarios> listaHora = (List) request.getSession().getAttribute("selecHora");
                    %>
                    
                    <form action="../../SvEditarOdontologos" method="POST">
                         <div class="mb-3">
                            <label class="form-label">Usuario: <b><%=odonto.getUsuario().getNombre_usuario()%></b></label>
                            <select class="form-control" name="id_usuario" style="width: 300px;">
                                <option value="0">cambiar usuario</option>
                                <%   for (Usuarios usu: listaUsu) {   %>
                                   <option value="<%=usu.getId_usuario()%>"><%=usu.getNombre_usuario()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                         <div class="mb-3">
                            <label class="form-label">Persona: <b><%=odonto.getPersona().getNombre() + " " + odonto.getPersona().getApellido()%></b></label>    
                            <select class="form-control" name="id_persona" style="width: 300px;">
                                <option value="0">cambiar persona</option>
                                <%   for (Personas per: listaPer) {   %>
                                   <option value="<%=per.getId()%>"><%=per.getNombre() +" "+per.getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Especialidad</label>
                            <input type="text" class="form-control" name="especialidad" value="<%=odonto.getEspecialidad()%>" required style="width: 300px">
                        </div> 
                            
                        <div class="mb-3">
                            <label class="form-label">Horario: <b><%=odonto.getHorario().getHorario_inicio()+ " - " + odonto.getHorario().getHorario_fin()%></b></label>                           
                            <select class="form-control" name="id_horario" style="width: 300px;">
                                <option value="0">cambiar horario</option>
                                <%   for (Horarios hora: listaHora) {   %>
                                   <option value="<%=hora.getId_horario()%>"><%=hora.getHorario_inicio()+" - "+hora.getHorario_fin()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Editar Odontólogo</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>