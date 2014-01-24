<%-- 
    Document   : revenda
    Created on : 26/10/2012, 23:58:36
    Author     : Saturno

    Comments   : Esta pagina servira para os seguintes casos de uso:

    2 - Editar Revenda
    3 - Desativar Revenda
    
    7 - Gerenciar Anuncios:
    14 - Cadastrar anuncios
    15 - Remover anuncios
    16 - Publicar anuncios
    17 - Encerrar anuncios
    20 - Consultar anuncios
    26 - Alterar anuncios
--%>

<%@page import="dao.TemplateDAO"%>
<%@page import="javax.mail.Session"%>
<%@page import="model.Usuario"%>
<%@page import="model.Revenda"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.RevendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div id="menu_admin">
    <ul>
        <li><a href="#" onclick="revendas()">Revenda</a></li>
        <li><a href="#" onclick="layouts()">Site Layout</a></li>
        <!-- <li><a href="#" onclick="veiculos()">Veiculos</a></li>
        <li><a href="#" onclick="layouts()">Layouts</a></li>
        <li><a href="#" onclick="planos()">Planos</a></li> -->
    </ul>                
</div>

<div id="conteudo">

    <div class="divs listagem" id="revendas">
        <h3>Gerenciamento de Revendas</h3>
        <br/>

        <table>
            <tr class="gray2">
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>EndereÃ§o</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado(UF)</th>
                <th>Data Cadastro</th>
                <th>Editar</th>
            </tr>


            <%
                Usuario usuarioLogado = (Usuario) usuario;
                RevendaDAO comando = new RevendaDAO();
                int id_revenda = (int) usuarioLogado.getRevenda().getId();
                Revenda revenda =  (Revenda) comando.pesquisarChave(id_revenda);
            %>

            <tr class="white">
                <td><%=revenda.getCNPJ()%></td>
                <td><%=revenda.getNome()%></td>
                <td><%=revenda.getFone()%></td>
                <td><%=revenda.getEmail()%></td>
                <td><%=revenda.getEndereco()%></td>
                <td><%=revenda.getNumero()%></td>
                <td><%=revenda.getBairro()%></td>
                <td><%=revenda.getCidade()%></td>
                <td><%=revenda.getEstado()%></td>
                <td><%=revenda.getData_cadastro()%></td>

                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarRevenda("<%=revenda.getId()%>","<%=revenda.getCNPJ()%>","<%=revenda.getNome()%>","<%=revenda.getFone()%>","<%=revenda.getEmail()%>","<%=revenda.getEndereco()%>","<%=revenda.getNumero()%>","<%=revenda.getBairro()%>","<%=revenda.getCidade()%>","<%=revenda.getEstado()%>")'/>
                </td>
            </tr>

    </table>
    </div>
                
    <div class="divs formulario" id="cadastrarRevendas">                
        <h3 id="cad_revenda_title">Cadastro de Revenda:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
                <label for="revenda_cnpj_cad">CNPJ:</label>
                <input name="revenda_cnpj_cad" id="revenda_cnpj_cad" placeholder="Informe o CNPJ (14) digitos" size="50" required autofocus/><br/>

                <label for="revenda_nome_cad">Nome da revenda:</label>
                <input name="revenda_nome_cad" id="revenda_nome_cad" type="text" size="50" required/><br/>

                <label for="revenda_end">EndereÃ§o:</label>
                <input name="revenda_end" id="revenda_end" placeholder="Rua, Logradouro, Avenida" type="text" size="50" required/><br/>

                <label for="revenda_nro">Numero:</label>
                <input name="revenda_nro" id="revenda_nro" type="number" required/><br/>

                <label for="revenda_bairro">Bairro:</label>
                <input name="revenda_bairro" id="revenda_bairro" type="text" size="50" required/><br/>

                <label for="revenda_cidade">Cidade:</label>
                <input name="revenda_cidade" id="revenda_cidade" type="text" size="50" required/><br/>

                <label for="revenda_uf">Estado:</label>
                <select name="revenda_uf" id="revenda_uf">
                    <option value="AC">AC</option>
                    <option value="AL">AL</option>
                    <option value="AM">AM</option>
                    <option value="AP">AP</option>
                    <option value="BA">BA</option>
                    <option value="CE">CE</option>
                    <option value="DF">DF</option>
                    <option value="ES">ES</option>
                    <option value="GO">GO</option>
                    <option value="MA">MA</option>
                    <option value="MG">MG</option>
                    <option value="MS">MS</option>
                    <option value="MT">MT</option>
                    <option value="PA">PA</option>
                    <option value="PB">PB</option>
                    <option value="PE">PE</option>
                    <option value="PI">PI</option>
                    <option value="PR">PR</option>
                    <option value="RJ">RJ</option>
                    <option value="RN">RN</option>
                    <option value="RO">RO</option>
                    <option value="RR">RR</option>
                    <option value="RS">RS</option>
                    <option value="SC">SC</option>
                    <option value="SE">SE</option>
                    <option value="SP">SP</option>
                    <option value="TO">TO</option>
                </select><br/>

                <label for="revenda_telefone_cad">Telefone:</label>
                <input name="revenda_telefone_cad" id="revenda_telefone_cad" type="text" size="50" required/><br/>

                <label for="revenda_mail_cad">E-mail:</label>
                <input name="revenda_mail_cad" id="revenda_mail_cad" type="text" size="50" required/><br/>

                <label for="revenda_ativo_cad">Ativo?</label><br/>         
                <input name="revenda_ativo_cad" id="revenda_ativo_cad" type="radio" value="1"> Sim<br/>
                <input name="revenda_ativo_cad" id="revenda_inativo_cad" type="radio" value="2"> NÃ£o<br/>

                <input name="id_revenda" type="hidden" id="id_revenda" value="">       
                <input id="cad_revenda_cmd" type="hidden" name="cmd" value='trataCadastroRevenda'>
                <input name="Salvar" type="submit" value="Salvar"/>   
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="revendas()" />
            </fieldset>                  
        </form>
        
    </div>
                


    <div class="divs formulario" id="layouts">
        <h3 id="cad_revenda_title">Selecionar Layout:</h3>
        <label>Modelo:</label>
                <%
                    ArrayList listaTemplates = new TemplateDAO().pesquisarTudo();
                    session.setAttribute("listaTemplates", listaTemplates);
                %>  

                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_modelo_select" name="veiculo_modelo_select">
                        <c:forEach items="${listaTemplates}" var="template">
                            <option value='<c:out value="${template.id}"/>'><c:out value="${template.nome}"/></option>
                        </c:forEach>                  
                    </select>
                </label>
                <br/>
    </div>   
</div>
