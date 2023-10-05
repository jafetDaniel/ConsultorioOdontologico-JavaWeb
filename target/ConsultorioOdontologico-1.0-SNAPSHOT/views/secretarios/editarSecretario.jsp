<%@page import="logica.Secretarios"%>
<%@page import="logica.Usuarios"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Editar Secretario</h1>
                    </div>
                    
                    <%                        
                       Secretarios secre = (Secretarios) request.getSession().getAttribute("secreEditar"); 
                        
                        List<Personas> listaPer = (List) request.getSession().getAttribute("selecPersonas");//obtener una variable de la session 
                        List<Usuarios> listaUsu = (List) request.getSession().getAttribute("selecUsuarios");  
                    %>
                    
                    <form action="../../SvEditarSecretarios" method="POST">
                        
                         <div class="mb-3">
                            <label class="form-label">Usuario: <b><%=secre.getUsuario().getNombre_usuario()%></b></label>                           
                            <select class="form-control" name="id_usuario" style="width: 300px;">
                                <option value="0">cambiar usuario</option>
                                <%   for (Usuarios usu: listaUsu) {   %>
                                   <option value="<%=usu.getId_usuario()%>"><%=usu.getNombre_usuario()%></option>
                                <% } %>
                            </select>
                        </div>
                            
                         <div class="mb-3">
                            <label class="form-label">Persona: <b><%=secre.getPersona().getNombre() + " " + secre.getPersona().getApellido()%></b></label>    
                            <select class="form-control" name="id_persona" style="width: 300px;">
                                <option value="0">cambiar persona</option>
                                <%   for (Personas per: listaPer) {   %>
                                   <option value="<%=per.getId()%>"><%=per.getNombre() +" "+per.getApellido()%></option>
                                <% } %>
                            </select>
                        </div>
                           
                        <div class="mb-3">
                            <label class="form-label">Sector</label>
                              <input type="text" class="form-control" name="sector" value="<%=secre.getSector()%>" required style="width: 300px">
                        </div>

                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Editar Secretario</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>