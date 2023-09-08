<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Personas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
  <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center mb-4">
                        <img src="../../img/dentist.png" alt="dentist" width="50px" height="50px" style="margin-right: 10px">    
                        <h1 class="h3 mb-2 text-gray-800">Ver Personas</h1>
                    </div>
                  
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Personas</h6>
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
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <% 
                                      List<Personas> listaPersonas = (List) request.getSession().getAttribute("listaPersonas");//obtener una variable de la session
                                      SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); //dar formato a fecha
                                    %>
                                    <tbody>
                                        <% 
                                        for (Personas per: listaPersonas) {  
                                        %>
                                        <tr>
                                            <td><%=per.getId()%></td>
                                            <td><%=per.getDni() %></td>
                                            <td><%=per.getNombre() %></td>
                                            <td><%=per.getApellido()%></td>
                                            <td><%=per.getTelefono()%></td>
                                            <td><%=per.getDireccion()%></td>
                                            <td>
                                                <% if (per.getFecha_nac() != null) { %>
                                                <%=formato.format(per.getFecha_nac())%>
                                                <% } %>
                                            </td>
                                            
                                            <td style="display:flex; width:230px;">
                                                <div style="margin-left: 5px;">
                                                    <form name="editar" action="../../SvEditarPersonas" method="get">
                                                        <button type="submit" class="btn btn-success">
                                                             <i class="fas fa-pencil-alt"></i>
                                                            Editar
                                                        </button>
                                                        <input type="hidden" name="id_edit" value="<%=per.getId()%>">
                                                    </form>
                                                </div>
                                                <div style="margin-left: 5px;">
                                                    <form name="eliminar" action="../../SvEliminarPersonas" method="POST">
                                                        <button type="submit" class="btn btn-danger">
                                                            Eliminar
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                        <input type="hidden" name="id_delete" value="<%=per.getId()%>">
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