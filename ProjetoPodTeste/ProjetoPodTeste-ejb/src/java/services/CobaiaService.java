/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.*;
import sessionBeans.CobaiaBeanLocal;

/**
 *
 * @author Romero
 */
@WebService(serviceName = "CobaiaService")
@Stateless()
public class CobaiaService {
    @EJB
    private CobaiaBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    
        /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
