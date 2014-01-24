<%-- 
    Document   : index
    Created on : 26/10/2012, 23:58:36
    Author     : Saturno
--%>
<%
/*Cookie mCookies[] = request.getCookies();
 if(!(mCookies == null)){
        Cookie getCookieLogin = null;
        Cookie getCookieSenha = null;

        for(int i = 0; i < mCookies.length; i++){
        if(mCookies[i].getName().equals("usuario")){
        getCookieLogin = mCookies[i];
        }
        
        if(mCookies[i].getName().equals("senha")){
        getCookieSenha = mCookies[i];
        }
        
        }
        
        String login = getCookieLogin.getValue();
        String senha = getCookieSenha.getValue();
        
        if(login != null && senha != null){
            request.setAttribute("usuario", login);
            request.setAttribute("senha", senha);
            request.setAttribute("cmd", "trataLogin");
            request.setAttribute("lembrar", "true");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("FrontController"); 
            dispatcher.forward(request,response); 
        }
 }*/

%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>   
    <head>
        <title>WebCar Store - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />

    </head>
    <body>
        <div id="login">
            <h2>WebCar Store</h2>
            <h6>Acesso ao sistema:</h6>

            <form method="post" action="FrontController"> 
                <fieldset>   
            
                    <input name="login" type="text" size="40" placeholder="E-mail ou usuário" required autofocus/><br/>
                    <input name="senha" type="password" size="40" placeholder="Senha" required/><br/>
                    <a href="#">Esqueceu sua senha?</a> <br/><br/>
                    <input type="checkbox" name="lembrar" />Lembrar-me neste computador <br/><br/>
                    <input type="hidden" name="cmd" value='trataLogin'>
                    <input name="Login" type="submit" value="Login"/>

                </fieldset>                  
            </form>

        </div>
    </body>
</html>

