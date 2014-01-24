<%@page import="model.Revenda"%>
<%@page import="dao.RevendaDAO"%>
<%@page import="model.Veiculo"%>
<%@page import="controle.TrataListaMarcas"%>
<%@page import="dao.VeiculoDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsuarioDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div id="menu_admin">
    <ul>
        <li><a href="#" onclick="usuarios()">Usuarios</a></li>
        <li><a href="#" onclick="revendas()">Revendas</a></li>
        <li><a href="#" onclick="veiculos()">Veiculos</a></li>
        <li><a href="#" onclick="layouts()">Layouts</a></li>
        <li><a href="#" onclick="planos()">Planos</a></li>
    </ul>                
</div>

<div id="conteudo">
    <div class="divs listagem" id="usuarios">
        <h3>Gerenciamento de Usuarios:</h3>
        <br/>

        <a href="#" onclick="cadastrarUsuarios()" class="btn_cadastrar">
            <span>Cadastar novo usuario</span>
        </a>

        <br/>
        <br/>

        <table>
            <tr class="gray2">
                <th>Nome</th>
                <th>Revenda</th>
                <th>Login</th>
                <th>Permissão</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <%
                int line = 0;
                Usuario usuarioLogado = (Usuario) usuario;
                UsuarioDAO admin = new UsuarioDAO();
                ArrayList users = admin.pesquisarTudo();
                Iterator it = users.iterator();
                while (it.hasNext()) {
                    Usuario user = (Usuario) it.next();
                    if (line % 2 == 0) {
            %>

            <tr class="white">
                <% } else {%>
            <tr class="gray">
                <% }%>
                <td><%=user.getNome()%></td>
                <td><%=user.getRevenda().getNome()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=admin.pesquisarPermissaoId(user.getPermissao())%></td>
                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarUsuario("<%=user.getId()%>","<%=user.getNome()%>","<%=user.getLogin()%>","<%=user.getSenha()%>","<%=user.getCelular()%>","<%=user.getTelefone()%>","<%=user.getRevenda().getId()%>","<%=user.getPermissao()%>")'/>
                </td>

                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirUsuario">
                        <input type="hidden" name="user_id_excluir" value="<%=user.getId()%>">                   
                    </form>
                </td>
            </tr>
            <% line++;
                }

            %>
        </table>
    </div>

    <div class="divs listagem" id="revendas">

        <h3>Gerenciamento de Revendas</h3>
        <br/>
        <a href="#" onclick="cadastrarRevendas()" class="btn_cadastrar">
            <span>Cadastar Revendas</span>
        </a>

        <table>
            <tr class="gray2">
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado(UF)</th>
                <th>Data Cadastro</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>


            <%
                line = 0;
                RevendaDAO comando = new RevendaDAO();
                ArrayList revendas = comando.pesquisarTudo();
                Iterator itr = revendas.iterator();
                while (itr.hasNext()) {
                    Revenda revenda = (Revenda) itr.next();
                    if (line % 2 == 0) {
            %>

            <tr class="white">
                <%  } else {%>
            <tr class="gray">
                <% }%>
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
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarRevenda("<%=revenda.getId()%>","<%=revenda.getCNPJ()%>","<%=revenda.getNome()%>","<%=revenda.getFone()%>","<%=revenda.getEmail()%>","<%=revenda.getEndereco()%>","<%=revenda.getNumero()%>","<%=revenda.getBairro()%>","<%=revenda.getCidade()%>","<%=revenda.getEstado()%>", "<%=revenda.getAtivo()%>")'/>
                </td>
                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirRevenda">
                        <input type="hidden" name="id_revenda_excluir" value="<%=revenda.getId()%>">
                    </form>
                </td>
            </tr>
            <% line++;
                }

            %>

            <%--
            /* Ainda n?o rolou com foreach!
        <!--forEach, implementa um la?o  para fazer a intera??o ArrayList contido no objeto de requisi??o -->
        
        
        <c:forEach items="${listaRevendas}" var="revenda">

                <tr>

                    <!--A tag out ? respons?vel por gerar uma String de sa?da na tela -->

                    <td><c:out value="${revenda.cnpj}"/></td>
                    
                    <td><c:out value="${revenda.nome}"/></td>
                    
                    <td><c:out value="${revenda.telefone}"/></td>
                    
                    <td><c:out value="${revenda.email}"/></td>
                    
                    <td><c:out value="${revenda.endereco}"/></td>
                    
                    <td><c:out value="${revenda.numero}"/></td>
                    
                    <td><c:out value="${revenda.bairro}"/></td>
                    
                    <td><c:out value="${revenda.cidade}"/></td>
                    
                    <td><c:out value="${revenda.estado}"/></td>
                    
                    <td><c:out value="${revenda.data_cadastro}"/></td>
                    

                </tr>
            </c:forEach> --%>

        </table>
    </div>

    <div class="divs listagem" id="veiculos">


        <a href="#" onclick="cadastrarVeiculos()" class="btn_cadastrar">
            <span>Cadastar veículos</span>
        </a>
        <a href="#" onclick="cadastrarModelos()" class="btn_cadastrar">
            <span>Cadastar modelos</span>
        </a>
        <a href="#" onclick="cadastrarMarcas()" class="btn_cadastrar">
            <span>Cadastar marcas</span>
        </a>
        <a href="#" onclick="cadastrarItens()" class="btn_cadastrar">
            <span>Cadastar Itens Opcionais</span>
        </a>
        <br>
        <br>
        <table>
            <tr class="gray2">
                <th>ID Veículo</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Combustível</th>
                <th>Categoria</th>
                <th>Cor</th>
                <th>Ano</th>
                <th>Motor</th>
                <th>Valor</th>
                <th>KM</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <%
                int lineVeiculo = 0;
                VeiculoDAO comandVeiculos = new VeiculoDAO();
                ArrayList veiculos = comandVeiculos.pesquisarTudo();
                Iterator itv = veiculos.iterator();
                while (itv.hasNext()) {
                    Veiculo v = (Veiculo) itv.next();
                    if (lineVeiculo % 2 == 0) {
            %>

            <tr class="white">
                <% } else {%>
            <tr class="gray">
                <% }%>
                <td><%=v.getId()%></td>
                <td><%=comandVeiculos.pesquisarMarcaId(comandVeiculos.pesquisarMarcaByModelo(v.getIdModelo()))%></td>
                <td><%=comandVeiculos.pesquisarModeloId(v.getIdModelo())%></td>
                <td><%=comandVeiculos.pesquisarCombustivelId(v.getIdCombustivel())%></td>
                <td><%=comandVeiculos.pesquisarCategoriaId(v.getCategoria().getIdCategoria())%></td>
                <td><%=comandVeiculos.pesquisarCorId(v.getIdCor())%></td>
                <td><%=v.getAno()%></td>
                <td><%=v.getMotor()%></td>
                <td><%=v.getValor()%></td>
                <td><%=v.getKm()%></td>
                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarVeiculo("<%=v.getId()%>","<%=v.getIdModelo()%>","<%=v.getIdCombustivel()%>","<%=v.getCategoria()%>","<%=v.getIdCor()%>","<%=v.getAno()%>","<%=v.getMotor()%>","<%=v.getValor()%>","<%=v.getKm()%>")'/>
                </td>

                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirVeiculo">
                        <input type="hidden" name="veiculo_id_excluir" value="<%=v.getId()%>">                   
                    </form>
                </td>
            </tr>
            <% lineVeiculo++;
                }
            %>
        </table>

    </div>

    <div class="divs listagem" id="layouts">
        <h3 id="cad_usuario_title">Layouts</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
                <label for="template_nome_cad">Nome:</label>
                <input name="template_nome_cad" id="user_nome_cad" type="text" size="50" required autofocus/><br/>

                <label for="template_descricao_cad">Descrição:</label>
                <input name="template_descricao_cad" id="user_login_cad" type="text" size="50" required/><br/>
                
                <label for="template_path_cad">Path:</label>
                <input name="template_path_cad" id="user_login_cad" type="text" size="50" required/><br/>
                
            </fieldset>
        </form>
    </div>

    <div class="divs listagem" id="planos">
        Planos
    </div>

    <div class="divs formulario" id="cadastrarUsuarios">
        <h3 id="cad_usuario_title">Cadastro de Usuario:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
                <label for="user_nome_cad">Nome completo:</label>
                <input name="user_nome_cad" id="user_nome_cad" type="text" size="50" required autofocus/><br/>

                <label for="user_login_cad">Login:</label>
                <input name="user_login_cad" id="user_login_cad" type="email" size="50" required/><br/>

                <label for="user_senha_cad">Senha:</label>
                <input name="user_senha_cad" id="user_senha_cad" type="password" size="50" required/><br/>           

                <label for="user_celular_cad">Celular:</label>
                <input name="user_celular_cad" id="user_celular_cad" type="tel" size="20" required/><br/>

                <label for="user_telefone_cad">Telefone:</label>
                <input name="user_telefone_cad" id="user_telefone_cad" type="tel" size="20" required/><br/>

                <label for="user_revenda_cad">Revenda:</label>
                <select name="user_revenda_cad"  id="user_revenda_cad">
                    <%
                        comando = new RevendaDAO();
                        revendas = comando.pesquisarTudo();
                        itr = revendas.iterator();
                        while (itr.hasNext()) {
                        Revenda revenda = (Revenda) itr.next();
                    %>

                    <option value="<%=revenda.getId()%>"><%=revenda.getNome()%></option>

                    <% }%>
                </select> <br/>


                <label for="user_permissao_cad">Permissão:</label>
                <label class="usuario_label"> 
                    <select class="usuario_select" name="user_permissao_cad" id="user_permissao_cad">
                        <option value=""></option>
                        <option value="1">Administrador</option>
                        <option value="2">Revenda</option>
                        <option value="3">Vendedor</option>                    
                    </select>
                </label>
                <br/>
                <input name="id_user" type="hidden" id="id_user" value="">
                <input id="cad_usuario_cmd" type="hidden" name="cmd" value='trataCadastroUsuario'>
                <input name="Salvar" type="submit" value="Salvar"/>
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="usuarios()" />
            </fieldset>                  
        </form>
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

                <label for="revenda_end">Endereço:</label>
                <input name="revenda_end" id="revenda_end" placeholder="Rua, Logradouro, Avenida" type="text" size="50" required/><br/>

                <label for="revenda_nro">Número:</label>
                <input name="revenda_nro" id="revenda_nro" required/><br/>

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
                <input name="revenda_ativo_cad" id="revenda_inativo_cad" type="radio" value="2"> Não<br/>

                <input name="id_revenda" type="hidden" id="id_revenda" value="">       
                <input id="cad_revenda_cmd" type="hidden" name="cmd" value='trataCadastroRevenda'>
                <input name="Salvar" type="submit" value="Salvar"/>   
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="revendas()" />
            </fieldset>                  
        </form>
    </div>

    <div class="divs formulario" id="cadastrarVeiculos">
        <h3 id="cad_veiculo_title">Cadastro de Veículo:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>                                 
                <label>Modelo:</label>
                <%
                    ArrayList listaModelos = new VeiculoDAO().pesquisarModelos();
                    session.setAttribute("listaModelos", listaModelos);
                %>  

                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_modelo_select" name="veiculo_modelo_select">
                        <c:forEach items="${listaModelos}" var="veiculo">
                            <option value='<c:out value="${veiculo.idModelo}"/>'><c:out value="${veiculo.modelo}"/></option>
                        </c:forEach>                  
                    </select>
                </label>
                <br/>

                <label>Combustível:</label>
                <%
                    ArrayList listaCombustiveis = new VeiculoDAO().pesquisarCombustiveis();
                    session.setAttribute("listaCombustiveis", listaCombustiveis);
                %> 
                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_combustivel_select" name="veiculo_combustivel_select">
                        <c:forEach items="${listaCombustiveis}" var="combustivel">
                            <option value='<c:out value="${combustivel.idCombustivel}"/>'><c:out value="${combustivel.nome}"/></option>
                        </c:forEach> 
                    </select>
                </label>            
                <br/>

                <label>Categoria:</label>
                <%
                    ArrayList listaCategorias = new VeiculoDAO().pesquisarCategorias();
                    session.setAttribute("listaCategorias", listaCategorias);
                %> 
                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_categoria_select" name="veiculo_categoria_select">
                        <c:forEach items="${listaCategorias}" var="categoria">
                            <option value='<c:out value="${categoria.idCategoria}"/>'><c:out value="${categoria.nome}"/></option>
                        </c:forEach>                   
                    </select>
                </label>            
                <br/>

                <label>Cor:</label>
                <%
                    ArrayList listaCores = new VeiculoDAO().pesquisarCores();
                    session.setAttribute("listaCores", listaCores);
                %> 
                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_cor_select" name="veiculo_cor_select">
                        <c:forEach items="${listaCores}" var="cor">
                            <option value='<c:out value="${cor.idCor}"/>'><c:out value="${cor.nome}"/></option>
                        </c:forEach>               
                    </select>
                </label>
                <br/>

                <label>Ano:</label>
                <label class="veiculo_label"> 
                    <select class="veiculo_select" id="veiculo_ano_select" name="veiculo_ano_select">
                        <option value=""></option>
                        <% for (int i = 1950; i <= 2013; i++) {%>
                        <option value="<%=i%>"> <%=i%></option>
                        <% }%>  
                    </select>
                </label>
                <br/>

                <label for="veiculo_motor_cad">Motor</label>
                <input name="veiculo_motor_cad" id="veiculo_motor_cad" type="text" size="50" required/><br/>

                <label for="veiculo_valor_cad">Valor</label>
                <input name="veiculo_valor_cad" id="veiculo_valor_cad" type="text" size="50" required/><br/>

                <label for="veiculo_quilometragem_cad">Quilometragem</label>
                <input name="veiculo_quilometragem_cad" id="veiculo_quilometragem_cad" type="text" size="50" required/><br/>          
                
                <label for="veiculo_itens_op">Itens Opcionais</label>
                <%
                    ArrayList listaItensOp = new VeiculoDAO().pesquisarItems();
                    session.setAttribute("listaItensOp", listaItensOp);
                %> 
                <select name="veiculo_itens_op" multiple>
                    <c:forEach items="${listaItensOp}" var="item">
                            <option value='<c:out value="${item.idItem}"/>'><c:out value="${item.nome}"/></option>
                        </c:forEach> 
                </select><br/>
                
                <input name="id_veiculo" type="hidden" id="id_veiculo" value="">       
                <input id="cad_veiculo_cmd" type="hidden" name="cmd" value='trataCadastroVeiculo'>
                <input name="Salvar" type="submit" value="Salvar"/>  
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="veiculos()" />
            </fieldset>                  
        </form>
    </div>

    <div class="divs formulario" id="cadastrarModelos">                
        <h3>Cadastro de Modelo:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>

                <label for="veiculo_modelo_cad">Modelo</label>
                <input name="veiculo_modelo_cad" type="text" size="50" required autofocus/><br/>
                <%
                    ArrayList listaMarcas = new VeiculoDAO().pesquisarMarcas();
                    session.setAttribute("listaMarcas", listaMarcas);
                %>                


                <label>Marca:</label>
                <label class="veiculo_label"> 
                    <select class="veiculo_select" name="veiculo_marca_select">
                        <%-- uso com iterator
                         <%
                         Iterator itM = listaMarcas.iterator();
                         while (itM.hasNext()) 
                         {
                             Veiculo veiculo = (Veiculo) itM.next();
                             String marca = veiculo.getMarca();
                         %>

                        <option value=""><%=marca%></option>
                    <%
                    }
                    %>
                        --%>
                        <c:forEach items="${listaMarcas}" var="veiculo">
                            <option value='<c:out value="${veiculo.idMarca}"/>'><c:out value="${veiculo.marca}"/></option>
                        </c:forEach>     
                    </select>
                </label>            
                <br/>

                <input type="hidden" name="cmd" value='trataCadastroModelo'>
                <input name="Salvar" type="submit" value="Salvar"/>
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="veiculos()" />
            </fieldset>                  
        </form>   
    </div>


    <div class="divs formulario" id="cadastrarMarcas">                
        <h3>Cadastro de Marca:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>

                <label for="veiculo_marca_cad">Marca:</label>
                <input name="veiculo_marca_cad" type="text" size="50" required autofocus/><br/>

                <input type="hidden" name="cmd" value='trataCadastroMarca'>
                <input name="Salvar" type="submit" value="Salvar"/>    
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="veiculos()" />
            </fieldset>                  
        </form>   
    </div>

    <div class="divs formulario" id="cadastrarItens">                
        <h3>Cadastro de itens opcionais</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
                <label for="veiculo_itens_cad">Item:</label>
                <input name="veiculo_itens_cad" type="text" size="50" required autofocus/><br/>

                <input type="hidden" name="cmd" value='trataCadastroItem'>
                <input name="Salvar" type="submit" value="Salvar"/>     
                <input name="Cancelar" class="cancel" type="button" value="Cancelar" onclick="veiculos()" />
            </fieldset>                  
        </form>   
    </div>
</div>
