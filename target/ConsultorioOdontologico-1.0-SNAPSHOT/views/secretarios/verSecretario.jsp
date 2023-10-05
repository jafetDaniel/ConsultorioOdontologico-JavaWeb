<%@page import="logica.Secretarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
  <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center mb-4">
                        <img src="../../img/dentist.png" alt="dentist" width="50px" height="50px" style="margin-right: 10px">    
                        <h1 class="h3 mb-2 text-gray-800">Ver Secretarios</h1>
                    </div>
                  
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Secretarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Sector</th>
                                            <th>Usuario</th>  
                                            <th>Persona</th>             
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <% 
                                      List<Secretarios> listaSecre = (List) request.getSession().getAttribute("listaSecre");//obtener una variable de la session
                                    %>
                                    <tbody>
                                        <% 
                                        for (Secretarios secre: listaSecre) { %>
                                        <tr>
                                            <td><%=secre.getId_secretario()%></td>
                                            <td><%=secre.getSector()%></td>   
                                            <td><%=secre.getUsuario().getNombre_usuario()%></td>
                                            <td><%=secre.getPersona().getNombre()+" "+secre.getPersona().getApellido()%></td>
                                            <td style="display:flex; width:230px;">
                                                <div style="margin-left: 5px;">
                                                    <form name="editar" action="../../SvEditarSecretarios" method="get">
                                                        <button type="submit" class="btn btn-success">
                                                             <i class="fas fa-pencil-alt"></i>
                                                            Editar
                                                        </button>
                                                        <input type="hidden" name="id_edit" value="<%=secre.getId_secretario()%>">
                                                    </form>
                                                </div>
                                                <div style="margin-left: 5px;">
                                                    <form name="eliminar" action="../../SvEliminarSecretarios" method="POST">
                                                        <button type="submit" class="btn btn-danger">
                                                            Eliminar
                                                            <i class="fas fa-trash-alt"></i>
                                                        </button>
                                                        <input type="hidden" name="id_delete" value="<%=secre.getId_secretario()%>">
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