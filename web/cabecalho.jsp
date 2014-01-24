<%-- 
    Document   : index
    Created on : 26/10/2012, 23:58:36
    Author     : Saturno
--%>
<%@include file="autenticacao.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>   
    <head>
        <title>WebCar Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--Carrega JQuery e JS do menu de imagens-->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" charset="utf-8" src="js/menu.navega.js"></script>
        <%

            String mensagem = (String) request.getAttribute("mensagem");

            if ((mensagem != null) && (!mensagem.equals(""))) {
        %>
        <script type="text/javascript">alert("<%=mensagem%>")</script>
        <%
            }
        %>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>
    <body>
        <div id="tudo">
            <div id="topo">
                <img src="img/logotipo.png" alt="WebCar Store" border="0" />
                <div id="titulo">
                    <h1>WebCar Store</h1>
                    <h3>Sistema CMS</h3>
                </div>
                <div id="logado">
                    <div class="text"> 
                        Bem-vindo:<br/>
                        <span><%=usuario.getNome()%></span><br/>
                        <a href="index.jsp">Sair</a>
                    </div>
                </div>
            </div> 