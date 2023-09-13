<%@page import="java.util.List"%>
<%@page import="logica.Pacientes"%>
<%@page import="logica.Odontologos"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Turnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Editar Persona</h1>
                    </div>
                    <%  Turnos turno = (Turnos) request.getSession().getAttribute("turnoEditar"); 
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //dar formato a fecha
                        
                        List<Odontologos> listOdonto = (List) request.getSession().getAttribute("selecOdontolos"); 
                        List <Pacientes> listPac = (List) request.getSession().getAttribute("selecPacientes");
                    %>
                    
                    <form action="../../SvEditarTurnos" method="POST">
                        
                        <div class="mb-3">
                            <label class="form-label">Fecha de Turno</label>
                            <div>
                                <% if (turno.getFecha_turno() != null) { %>
                                   <label class="form-label"><%=formato.format(turno.getFecha_turno())%></label>
                                <% } %>
                                <input type="date" class="form-control" name="fecha_turno" style="width: 150px; display:inline;">
                            </div>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Hora Turno</label>
                            <input type="time" class="form-control" name="hora_turno" value="<%=turno.getHora_turno()%>" required style="width: 150px">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Tratamiento</label>
                            <input type="text" class="form-control" name="tratamiento" value="<%=turno.getTratamiento()%>" required style="width: 500px">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Odontólogo</label>
                            <div>
                                <label class="form-label"><%=turno.getOdonto().getPersona().getNombre()+ " " + turno.getOdonto().getPersona().getApellido()%></label>
                            
                                <select class="form-control" name="id_odonto" style="width: 500px; display:inline;">
                                <option value="0">cambiar odontólogo</option>
                                <%   for (Odontologos odonto: listOdonto) { %>
                                   <option value="<%=odonto.getId_odontologo()%>"><%=odonto.getPersona().getNombre()+" "+odonto.getPersona().getApellido()%></option>
                                <% } %>
                                </select>
                            </div>
                        </div>
                            
                            <div class="mb-3">
                            <label class="form-label">Paciente</label>      
                            <div>
                                <label class="form-label"><%=turno.getPacient().getPersona().getNombre()+ " " + turno.getPacient().getPersona().getApellido()%></label>
     
                            <select class="form-control" name="id_persona" style="width: 300px; display: inline;">
                                <option value="0">cambiar paciente</option>
                                <%   for (Pacientes pacient : listPac) { %>
                                   <option value="<%=pacient.getId_paciente()%>"><%=pacient.getPersona().getNombre() +" "+pacient.getPersona().getApellido()%></option>
                                <% } %>
                            </select>
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