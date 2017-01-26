package ru.ilia.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by ILIA on 25.01.2017.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MonitorPrice {

    @WebMethod
    String getMonitorPrice();
}
