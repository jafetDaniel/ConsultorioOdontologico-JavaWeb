<%@page import="logica.Responsables"%>
<%@page import="logica.Personas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Controladora"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Alta Paciente</h1>
                    </div>
                    
                    <%                        
                        Controladora control = new Controladora();
                        
                        List<Personas> listaPer= new ArrayList();
                        listaPer = control.getPersonas();
                        
                        List<Responsables> listaResp = new ArrayList();
                        listaResp = control.getResponsables();
                    %>
                    
                    <form action="../../SvPacientes" method="POST">
                         
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
                            <label class="form-label">Responsable</label>
                            <select class="form-control" name="id_responsable" style="width: 300px">
                                <option value="0">seleccione responsable</option>
                                <%   for (Responsables resp: listaResp) {   %>
                                   <option value="<%=resp.getId_responsable()%>"><%=resp.getPersona().getNombre() +" "+resp.getPersona().getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label" style="width:100px;">Tiene Seguro Médico</label>
                            <input type="checkbox" class="form-control" name="tiene_sm" value="true" style="width:40px; display:inline;">
                        </div> 
                            
                        <div class="mb-3">
                            <label class="form-label">Tipo de sangre</label>
                              <input type="text" class="form-control" name="tipo_sangre" required style="width: 300px">
                        </div>
                            
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Crear Paciente</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>