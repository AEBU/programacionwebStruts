/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author Alexis
 */
public class GrabarAction implements ServletRequestAware, ServletResponseAware{

    String user;
    HttpServletResponse response;
    
     public String execute() throws Exception{
        Cookie ck=new Cookie("user", user);
        ck.setMaxAge(2000);
        response.addCookie(ck);
        return "grabado";
    }

    public String getUser() {
        return user;
    }
     
     
    
    @Override
    public void setServletRequest(HttpServletRequest request) {
        user=request.getParameter("username");
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.response=hsr;
    }
    
}
