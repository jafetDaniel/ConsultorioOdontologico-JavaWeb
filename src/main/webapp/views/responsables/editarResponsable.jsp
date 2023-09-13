<%@page import="logica.Responsables"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Controladora"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Personas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../header_views.jsp"%>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Editar Responsable</h1>
                    </div>

                    <%                         
                        Responsables resp = (Responsables) request.getSession().getAttribute("respEditar"); 
                        List<Personas> listaPer = (List) request.getSession().getAttribute("selecPersonas");//obtener una variable de la session 
                    %>

                    <form action="../../SvEditarResponsables" method="POST">
                        <div class="mb-3">
                            <label class="form-label">Persona: <b><%=resp.getPersona().getNombre() + " " + resp.getPersona().getApellido()%></b></label>
                                <select class="form-control" name="id_persona" style="width: 300px;">
                                    <option value="0">cambiar persona</option>
                                    <%   for (Personas per : listaPer) {%>
                                    <option value="<%=per.getId()%>"><%=per.getNombre() +" "+per.getApellido()%></option>
                                    <% }%>
                                </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Tipo de Responsable</label>
                            <input type="text" class="form-control" name="tipo_resp" value="<%=resp.getTipo_resp()%>" required style="width: 300px">
                        </div>
                        
                        <div class="mb-3">
                            <br>
                            <button type="submit" class="btn btn-primary mb-3">Editar Responsable</button>
                        </div>
                    </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="../footer_views.jsp"%>