<%@page import="logica.Usuarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
  <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center mb-4">
                        <img src="../../img/dentist.png" alt="dentist" width="50px" height="50px" style="margin-right: 10px">    
                         <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
                    </div>
                   
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Rol</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <% 
                                      List<Usuarios> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                      //obtener una variable de la session
                                    %>
                                    <tbody>
                                        <% 
                                        for (Usuarios usu: listaUsuarios) {  
                                        %>
                                        <tr>
                                            <td><%=usu.getId_usuario()%></td>
                                            <td><%=usu.getNombre_usuario()%></td>
                                            <td><%=usu.getRol()%></td>
                                            <td style="display:flex; width:230px;">
                                                <div style="margin-left: 5px;">
                                                    <form name="editar" action="../../SvEditarUsuarios" method="get">
                                                        <button type="submit" class="btn btn-success">
                                                             <i class="fas fa-pencil-alt"></i>
                                                            Editar
                                                        </button>
                                                        <input type="hidden" name="id_edit" value="<%=usu.getId_usuario()%>">
                                                    </form>
                                                </div>
                                                <div style="margin-left: 5px;">
                                                    <form name="eliminar" action="../../SvEliminarUsuarios" method="POST">
                                                        <button type="submit" class="btn btn-danger">
                                                            Eliminar
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                        <input type="hidden" name="id_delete" value="<%=usu.getId_usuario()%>">
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