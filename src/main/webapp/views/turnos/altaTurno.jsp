<%@page import="logica.Personas"%>
<%@page import="logica.Pacientes"%>
<%@page import="logica.Odontologos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Alta Turno</h1>
                    </div>
                    
                    <%                        
                        Controladora control = new Controladora();
                        
                        List<Odontologos> listaOdonto = new ArrayList<Odontologos>();
                        listaOdonto = control.getOdontologos();
                        
                        List<Pacientes> listaPacient = new ArrayList<Pacientes>();
                        listaPacient = control.getPacientes();
                    %>

                    <form action="../../SvTurnos" method="POST">
                        
                        <div class="mb-3">
                            <label class="form-label">Fecha de Turno</label>
                            <input type="date" class="form-control" name="fecha_turno" required style="width: 150px">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Hora Turno</label>
                            <input type="time" class="form-control" name="hora_turno" required style="width: 150px">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Tratamiento</label>
                            <input type="text" class="form-control" name="tratamiento" required style="width: 500px">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Odontólogo</label>
                            
                            <select class="form-control" name="id_odonto" style="width: 500px">
                                <option value="0">seleccione odontólogo</option>
                                <%   for (Odontologos odonto: listaOdonto) { %>
                                   <option value="<%=odonto.getId_odontologo()%>"><%=odonto.getPersona().getNombre()+" "+odonto.getPersona().getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                            <div class="mb-3">
                            <label class="form-label">Paciente</label>
                            
                            <select class="form-control" name="id_persona" style="width: 300px">
                                <option value="0">seleccione paciente</option>
                                <%   for (Pacientes pacient : listaPacient) { %>
                                   <option value="<%=pacient.getId_paciente()%>"><%=pacient.getPersona().getNombre() +" "+pacient.getPersona().getApellido()%></option>
                                <% } %>
                            </select>
                        </div>


                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Crear Turno</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>