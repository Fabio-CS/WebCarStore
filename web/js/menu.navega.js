function index(){
	$('div.divs').stop().slideUp();
	$('#home').stop().slideDown();
}

function usuarios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#usuarios').stop().slideDown();
}

function cadastrarUsuarios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarUsuarios').stop().slideDown();                        
        var arr = new Array();  
        arr = document.getElementsByTagName("input");            
        for (var i = 0; i < arr.length; i++) {
            if ((arr[i].type != "submit")&&(arr[i].type != "hidden")&&(arr[i].type != "button")&&(arr[i].type != "image")){
                arr[i].value = "";
            }
        }
        document.getElementById("user_permissao_cad").options[0].selected = true;
        document.getElementById("cad_usuario_cmd").value = "trataCadastroUsuario";
        document.getElementById("cad_usuario_title").innerHTML = "Cadastro de Usuário:";       
}

function editarUsuario(id,nome,login,senha,celular,telefone,revenda,permissao){
        cadastrarUsuarios();
        document.getElementById("id_user").value = id;
        document.getElementById("user_nome_cad").value = nome;
        document.getElementById("user_login_cad").value = login;
        document.getElementById("user_senha_cad").value = senha;
        document.getElementById("user_celular_cad").value = celular;
        document.getElementById("user_telefone_cad").value = telefone;
        document.getElementById("user_revenda_cad").value = revenda;
        document.getElementById("user_permissao_cad").options[permissao].selected = true;
        document.getElementById("cad_usuario_cmd").value = "trataEditarUsuario";
        document.getElementById("cad_usuario_title").innerHTML = "Edição de Usuário:";
}

function cadastrarVeiculos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarVeiculos').stop().slideDown();
        var arr = new Array();  
        arr = document.getElementsByTagName("input");            
        for (var i = 0; i < arr.length; i++) {
            if ((arr[i].type != "submit")&&(arr[i].type != "hidden")&&(arr[i].type != "button")&&(arr[i].type != "image")){
                arr[i].value = "";
            }
        }
        document.getElementById("cad_veiculo_cmd").value = "trataCadastroVeiculo";
        document.getElementById("cad_veiculo_title").innerHTML = "Cadastro de Veículo:";       

}

function editarVeiculo(id,modelo,combustivel,categoria,cor,ano,motor,valor,km,opcionais){
        cadastrarVeiculos();
        var veic_select;
        document.getElementById("id_veiculo").value = id;
        
        veic_select = document.getElementById("veiculo_modelo_select");        
        for(i=0;i<veic_select.length;i++){
            if(veic_select.options[i].value == modelo){
                veic_select.options[i].selected = true;
            }
        }
        veic_select = document.getElementById("veiculo_combustivel_select");        
        for(i=0;i<veic_select.length;i++){
            if(veic_select.options[i].value == combustivel){
                veic_select.options[i].selected = true;
            }
        }
        veic_select = document.getElementById("veiculo_categoria_select");
        for(i=0;i<veic_select.length;i++){
            if(veic_select.options[i].value == categoria){
                veic_select.options[i].selected = true;
            }
        }
        veic_select = document.getElementById("veiculo_cor_select");        
        for(i=0;i<veic_select.length;i++){
            if(veic_select.options[i].value == cor){
                veic_select.options[i].selected = true;
            }
        }
        veic_select = document.getElementById("veiculo_ano_select");        
        for(i=0;i<veic_select.length;i++){
            if(veic_select.options[i].value == ano){
                veic_select.options[i].selected = true;
            }
        }       
        document.getElementById("veiculo_motor_cad").value = motor;
        document.getElementById("veiculo_valor_cad").value = valor;
        document.getElementById("veiculo_quilometragem_cad").value = km;
        document.getElementById("cad_veiculo_cmd").value = "trataEditarVeiculo";
        document.getElementById("cad_veiculo_title").innerHTML = "Edição de Veículo";
}


function cadastrarModelos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarModelos').stop().slideDown();
}

function cadastrarMarcas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarMarcas').stop().slideDown();
}

function cadastrarItens(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarItens').stop().slideDown();
}

function cadastrarRevendas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarRevendas').stop().slideDown();
        
        document.getElementById("cad_revenda_cmd").value = "trataCadastroRevenda";
        document.getElementById("cad_revenda_title").innerHTML = "Cadastro de Revenda:";
}

function editarRevenda(id,cnpj,nome,telefone,email,endereco,numero,bairro,cidade,estado, ativo){
        cadastrarRevendas();
        document.getElementById("id_revenda").value = id;
        document.getElementById("revenda_cnpj_cad").value = cnpj;
        document.getElementById("revenda_nome_cad").value = nome;
        document.getElementById("revenda_end").value = endereco;
        document.getElementById("revenda_nro").value = numero;
        document.getElementById("revenda_bairro").value = bairro;
        document.getElementById("revenda_cidade").value = cidade;        
        document.getElementById("revenda_uf").value = estado;      
        document.getElementById("revenda_telefone_cad").value = telefone;
        document.getElementById("revenda_mail_cad").value = email;
        if (ativo == 1) {
        $("#revenda_inativo_cad").attr('checked', true);
        } else {
        $("#revenda_ativo_cad").attr('checked', true);
        }
        document.getElementById("cad_revenda_cmd").value = "trataEditarRevenda";
        document.getElementById("cad_revenda_title").innerHTML = "Edição de Revenda:";        
}

function revendas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#revendas').stop().slideDown();
}

function veiculos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#veiculos').stop().slideDown();
}
				
function layouts(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#layouts').stop().slideDown();
}
			
function planos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#planos').stop().slideDown();
}

function anuncios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#anuncios').stop().slideDown();
}

function cadastrarAnuncios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarAnuncios').stop().slideDown();
        
        document.getElementById("cad_anuncio_cmd").value = "trataCadastroAnuncio";
        document.getElementById("cad_anuncio_title").innerHTML = "Cadastro de Anúncio:";
}

function editarAnuncio(id, veiculo, getStatus, valor, destaque){
        cadastrarAnuncios();       
        var anun_select;
        document.getElementById("id_anuncio").value = id;
        
        anun_select = document.getElementById("veiculo_select_cad");
        for(i=0;i<anun_select.length;i++){
            if(anun_select.options[i].value == veiculo){
                anun_select.options[i].selected = true;
            }
        }        
        document.getElementById("valor_anuncio_cad").value = valor;
        
        anun_select = document.getElementById("status_anuncio_cad");
        if(anun_select.options[0].value == 'Sim')
            anun_select.options[0].selected = true
        else
            anun_select.options[1].selected = true;
        document.getElementById("cad_anuncio_cmd").value = "trataEditarAnuncio";
        document.getElementById("cad_anuncio_title").innerHTML = "Edição de Anúncio:"; 
}


function visitas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#visitas').stop().slideDown();
}

function cadastrarVisitas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarVisitas').stop().slideDown();
}

