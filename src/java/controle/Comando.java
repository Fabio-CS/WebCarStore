/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karen
 */
public abstract class Comando {
    
    private ServletContext context;  
  
    private HttpServletRequest request;  
  
    private HttpServletResponse response;  
  
  
    public abstract void execute() throws ServletException, IOException, SQLException, ClassNotFoundException ;  
  
    public void forward(String destino) throws ServletException, IOException{  
            RequestDispatcher rd = getRequest().getRequestDispatcher(destino);  
            rd.forward(getRequest(), getResponse());   
    }

    //gets and sets  
    public void setServletContext(ServletContext context){  
        this.context = context;  
    }  
    
    /**
     * @return the context
     */
    public ServletContext getServletContext() {
        return context;
    }
    
    /**
     * @return the request
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @return the response
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    
}
