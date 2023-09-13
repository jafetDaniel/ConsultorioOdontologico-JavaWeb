<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Turnos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
  <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center mb-4">
                        <img src="../../img/dentist.png" alt="dentist" width="50px" height="50px" style="margin-right: 10px">    
                        <h1 class="h3 mb-2 text-gray-800">Ver Turnos</h1>
                    </div>
                  
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Fecha de Turno</th>
                                            <th>Hora Turno</th>
                                            <th>Tratamiento</th>
                                            <th>Odontólogo</th>
                                            <th>Paciente</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <% 
                                      List<Turnos> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");//obtener una variable de la session
                                      SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //dar formato a fecha
                                    %>
                                    <tbody>
                                        <% 
                                        for (Turnos turno: listaTurnos) {  
                                        %>
                                        <tr>
                                            <td><%=turno.getId_turno()%></td>
                                            <td>
                                                <% if (turno.getFecha_turno() != null) { %>
                                                <%=formato.format(turno.getFecha_turno())%>
                                                <% } %>
                                            </td>
                                            <td><%=turno.getHora_turno()%></td>
                                            <td><%=turno.getTratamiento()%></td>
                                            <td><%=turno.getOdonto().getPersona().getNombre()+ "" + turno.getOdonto().getPersona().getApellido()%></td>
                                            <td><%=turno.getPacient().getPersona().getNombre()+ "" + turno.getPacient().getPersona().getApellido()%></td>
                                            
                                            <td style="display:flex; width:230px;">
                                                <div style="margin-left: 5px;">
                                                    <form name="editar" action="../../SvEditarTurnos" method="get">
                                                        <button type="submit" class="btn btn-success">
                                                             <i class="fas fa-pencil-alt"></i>
                                                            Editar
                                                        </button>
                                                        <input type="hidden" name="id_edit" value="<%=turno.getId_turno()%>">
                                                    </form>
                                                </div>
                                                <div style="margin-left: 5px;">
                                                    <form name="eliminar" action="../../SvEliminarTurnos" method="POST">
                                                        <button type="submit" class="btn btn-danger">
                                                            Eliminar
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                        <input type="hidden" name="id_delete" value="<%=turno.getId_turno()%>">
                                                    </form>
                                                </div>

                                            </td>
                                            
                                        </tr>
                                        <%  } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>