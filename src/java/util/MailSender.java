/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author http://www.guj.com.br/java/87637-api-java-mail---usando-o-gmaill
 */
public class MailSender {

    private String username;
    private String password;
    private String host;
    private String porta;

    public MailSender(String username, String password, String host, String porta) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.porta = porta;
    }

    /**
     * Send an Email via Gmail SMTP server using SSL connection.
     *
     * @param assunto
     * @param mensagem
     * @throws MessagingException
     */
    public void sendMail(String assunto, String mensagem) throws MessagingException, IOException {
        
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP  
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host); //server SMTP do GMAIL  
        props.put("mail.smtp.auth", "true"); //ativa autenticacao  

        String from = "winget.cs@gmail.com";
        props.put("mail.smtp.user", from); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)  
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", porta); //porta  
        props.put("mail.smtp.socketFactory.port", porta); //mesma porta para o socket  
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        //Cria um autenticador que sera usado a seguir  
        SimpleAuth auth = new SimpleAuth(username, password);
    
        //Session - objeto que ira realizar a conexão com o servidor  
        /*Como há necessidade de autenticação é criada uma autenticacao que 
         * é responsavel por solicitar e retornar o usuário e senha para  
         * autenticação */  
        Session session = Session.getDefaultInstance(props, auth);  
        session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email  
  
        //Objeto que contém a mensagem  
        Message msg = new MimeMessage(session);  
  
        try {  
            //Setando o destinatário  
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(username));  
            //Setando a origem do email  
            msg.setFrom(new InternetAddress(from));  
            //Setando o assunto  
            msg.setSubject(assunto);  
            //Setando o conteúdo/corpo do email  
            msg.setContent(mensagem,"text/plain");  
  
        } catch (Exception e) {  
            System.out.println(">> Erro: Completar Mensagem");  
            e.printStackTrace();  
        }  
          
        //Objeto encarregado de enviar os dados para o email  
        Transport tr;  
        try {  
            tr = session.getTransport("smtp"); //define smtp para transporte  
            /* 
             *  1 - define o servidor smtp 
             *  2 - seu nome de usuario do gmail 
             *  3 - sua senha do gmail 
             */  
            tr.connect(host, username, password);  
            msg.saveChanges(); // don't forget this  
            //envio da mensagem  
            tr.sendMessage(msg, msg.getAllRecipients());  
            tr.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            System.out.println(">> Erro: Envio Mensagem");  
            e.printStackTrace();  
        }  
  

    }

    //clase que retorna uma autenticacao para ser enviada e verificada pelo servidor smtp  
    class SimpleAuth extends Authenticator {

        private String usuario;
        private String senha;

        public SimpleAuth(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(usuario, senha);
        }
    }
    
//        public static void main(String[] args) {
//            try {
//                HashMap dados = new PropertiesManager("email.properties").readPropertiesFile();
//                String username = (String) dados.get("username");
//                String password = (String) dados.get("password");
//                String porta = (String) dados.get("porta");
//                String host = (String) dados.get("host");
//
//                MailSender sender = new MailSender(username, password, host, porta);
//                sender.sendMail("mensagem de teste2", "o assunto é teste de novo");
//
//                System.out.println("email enviado com sucesso !");
//
//                // A MENSAGEM NÃO ESTÁ CHEGANDO !
//
//            } catch (MessagingException ex) {
//                System.out.println(ex);
//            } catch (IOException ex) {
//                Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
