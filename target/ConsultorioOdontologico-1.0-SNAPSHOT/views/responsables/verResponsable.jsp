<%@page import="logica.Personas"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Responsables"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
  <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center mb-4">
                        <img src="../../img/dentist.png" alt="dentist" width="50px" height="50px" style="margin-right: 10px">    
                        <h1 class="h3 mb-2 text-gray-800">Ver Responsables</h1>
                    </div>
                  
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Responsables</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>DNI</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Teléfono</th>
                                            <th>Dirección</th>
                                            <th>Fecha de Nacimiento</th>
                                            <th>Tipo de Responsable</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <% 
                                      List<Responsables> listaResponsables = (List) request.getSession().getAttribute("listaResponsables");//obtener una variable de la session
                                      SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //dar formato a fecha
                                    %>
                                    <tbody>
                                        <% 
                                        for (Responsables resp: listaResponsables) {
                                        %>
                                        <tr>
                                            <td><%=resp.getId_responsable()%></td>
                                            <td><%=resp.getPersona().getDni()%></td>
                                            <td><%=resp.getPersona().getNombre() %></td>
                                            <td><%=resp.getPersona().getApellido()%></td>
                                            <td><%=resp.getPersona().getTelefono()%></td>
                                            <td><%=resp.getPersona().getDireccion()%></td>
                                            <td>
                                                <% if (resp.getPersona().getFecha_nac() != null) { %>
                                                <%=formato.format(resp.getPersona().getFecha_nac())%>
                                                <% } %>
                                            </td>
                                            <td><%=resp.getTipo_resp()%></td>
                                            
                                            <td style="display:flex; width:230px;">
                                                <div style="margin-left: 5px;">
                                                    <form name="editar" action="../../SvEditarResponsables" method="get">
                                                        <button type="submit" class="btn btn-success">
                                                             <i class="fas fa-pencil-alt"></i>
                                                            Editar
                                                        </button>
                                                        <input type="hidden" name="id_edit" value="<%=resp.getId_responsable()%>">
                                                    </form>
                                                </div>
                                                <div style="margin-left: 5px;">
                                                    <form name="eliminar" action="../../SvEliminarResponsables" method="POST">
                                                        <button type="submit" class="btn btn-danger">
                                                            Eliminar
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                        <input type="hidden" name="id_delete" value="<%=resp.getId_responsable()%>">
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