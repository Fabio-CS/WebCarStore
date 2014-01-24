<%-- 
    Document   : anuncios.jsp
    Created on : 17/01/2013, 03:57:41
    Author     : Cícero
--%>

<%@page import="model.Usuario"%>
<%@page import="model.Anuncio"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.AnuncioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <head>
        <title>WebCar Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--Carrega JQuery e JS do menu de imagens-->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" charset="utf-8" src="js/menu.navega.js"></script>

        <link rel="stylesheet" type="text/css" href="css/layout1.css" />
    </head>
    <body>
        <div id="tudo">
            <div id="topo">
                <div class="img_topo"><img src="img/logo.png" alt="WebCar Store" border="0" /></div>
                <p class="titulo"><span>Webcar Revenda</span> <br/>The world's most powerful resale</p>
            </div>                                                

            <div id="anunciosh">
                <%
                    ArrayList listaAnuncios = new AnuncioDAO().pesquisarTudo();
                    ArrayList anunciosRevenda=new ArrayList();
                    
                    Iterator itr = listaAnuncios.iterator();
                    Usuario usuario=(Usuario) session.getAttribute("usuario");
                    while (itr.hasNext()) {
                        Anuncio anuncio = (Anuncio) itr.next();
                        if(anuncio.getRevenda().getId() == usuario.getRevenda().getId()) 
                        {
                            anunciosRevenda.add(anuncio);
                        }
                        session.setAttribute("listaAnuncios", anunciosRevenda);
                        

                    }
                %>  
                 <c:forEach items="${listaAnuncios}" var="anuncio">

                    <div class="anunciosh_box">
                        <div class="anunciosh_box_in">
                            <p class="anunciosh_marca"><c:out value="${anuncio.veiculo.marca}"/></p>
                            <p class="anunciosh_modelo"><c:out value="${anuncio.veiculo.modelo}"/></p>
                            <p class="anunciosh_ano"><c:out value="${anuncio.data_inicio}"/></p>                    
                            <p class="anunciosh_valor"><c:out value="${anuncio.valor_anuncio}"/></p>
                            <a href="" class="anunciosh_interesse">Informar Interesse</a>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div id="rodape"> 
                Webcar Store - 2012
            </div>

        </div>

    </body>
</html>


