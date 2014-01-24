<%@ include file="cabecalho.jsp" %>

<% int teste = usuario.getPermissao();
if (teste==1){%>
<%@ include file="admin.jsp" %>
<%}else if (teste==2){%>
<%@ include file="revenda.jsp"%>
<%}else if(teste==3){%>
<%@ include file="vendedor.jsp"%>
<%}%>

<%@ include file="rodape.jsp" %>