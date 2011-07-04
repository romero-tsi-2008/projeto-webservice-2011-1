package util;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Thiago
 */
@WebService
public class OperacoesService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "soma")
    public Integer soma(@WebParam(name = "a")
    int a, @WebParam(name = "b")
    int b) {
        int c = a+b;
        System.out.println("SOMA = "+c);
        return c;
    }
}