<%@page import="logica.Pacientes"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Editar Odontólogo</h1>
                    </div>
                    
                    <%                        
                       Pacientes paciente = (Pacientes) request.getSession().getAttribute("pacienteEditar"); 
                        
                        List<Personas> listaPer = (List) request.getSession().getAttribute("selecPersonas");//obtener una variable de la session 
                        List<Responsables> listaResp = (List) request.getSession().getAttribute("selecResponsables");  
                    %>
                    
                    <form action="../../SvEditarPacientes" method="POST">
                        
                         <div class="mb-3">
                            <label class="form-label">Persona: <b><%=paciente.getPersona().getNombre() + " " + paciente.getPersona().getApellido()%></b></label>    
                            <select class="form-control" name="id_persona" style="width: 300px;">
                                <option value="0">cambiar persona</option>
                                <%   for (Personas per: listaPer) {   %>
                                   <option value="<%=per.getId()%>"><%=per.getNombre() +" "+per.getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Responsable: <b><%=paciente.getResponsable().getPersona().getNombre()+ " " + paciente.getResponsable().getPersona().getApellido()%></b></label>                           
                            <select class="form-control" name="id_responsable" style="width: 300px;">
                                <option value="0">cambiar responsable</option>
                                <%   for (Responsables resp: listaResp) {   %>
                                   <option value="<%=resp.getId_responsable()%>"><%=resp.getPersona().getNombre()+" - "+resp.getPersona().getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Tiene Seguro Médico: <b><%=paciente.isTiene_SM()%></b></label>                           
                            <select class="form-control" name="tiene_sm" style="width: 300px;">
                                <option value="0">cambiar</option>
                                <option value="true">SI</option>
                                <option value="false">NO</option>
                            </select>
                        </div>
                            
                        <div class="mb-3">
                            <label class="form-label">Tipo de sangre</label>
                              <input type="text" class="form-control" name="tipo_sangre" value="<%=paciente.getTipo_sangre()%>" required style="width: 300px">
                        </div>

                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Editar Paciente</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>