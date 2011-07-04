/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.xml.ws.WebServiceRef;
import sessionbeans.OraculoService_Service;

/**
 *
 * @author Romero
 */
@Named(value = "oraculoMBean")
@Dependent
public class OraculoMBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/OraculoService/OraculoService.wsdl")
    private OraculoService_Service service;
    
    private String teste = "Pegou porra nenhuma";

    /** Creates a new instance of OraculoMBean */
    public OraculoMBean() {
    }

    private String hello(java.lang.String name) {
        sessionbeans.OraculoService port = service.getOraculoServicePort();
        teste = port.hello(name);
        System.out.println(this.teste);
        return port.hello(name);
    }        
}
