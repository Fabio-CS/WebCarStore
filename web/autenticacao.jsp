<%-- 
    Document   : autenticacao
    Created on : 10/12/2012, 19:49:47
    Author     : Fábio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if( usuario == null ) {
%>
        <jsp:forward page="/index.jsp"/>
<%
    }
%>