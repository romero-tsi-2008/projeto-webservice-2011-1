/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import services.CobaiaServiceNovo_Service;

/**
 *
 * @author Romero
 */
@ManagedBean
@SessionScoped
public class CobaiaMBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CobaiaServiceNovo/CobaiaServiceNovo.wsdl")
    private CobaiaServiceNovo_Service service;

    /** Creates a new instance of CobaiaMBean */
    public CobaiaMBean() {
    }

    public String hello(java.lang.String name) {
        services.CobaiaServiceNovo port = service.getCobaiaServiceNovoPort();
        return port.hello(name);
    }
    
    
}
