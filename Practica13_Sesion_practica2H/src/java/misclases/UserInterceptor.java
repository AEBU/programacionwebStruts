/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.StrutsStatics;

/**
 *
 * @author Alexis
 */
public class UserInterceptor extends AbstractInterceptor implements StrutsStatics{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ComprobarAction action=(ComprobarAction) invocation.getAction();
        
        ActionContext context=invocation.getInvocationContext();
        HttpServletRequest request=(HttpServletRequest)context.get(HTTP_REQUEST);
        
        Cookie [] cookies= request.getCookies();
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("user")) {
                    action.setExiste(true);
                    action.setUser(cookies[i].getValue());
                    
                }
            }
        }
        return invocation.invoke();
    }
    
}
