package ru.ilia.soap.service;

import ru.ilia.soap.model.entity.CustomError;
import ru.ilia.soap.model.entity.Price;
import ru.ilia.soap.model.entity.PriceList;
import ru.ilia.soap.model.entity.PriceListRequest;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by ILIA on 26.01.2017.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServicePrice {

    @WebMethod
    Price createPrice(int price);

    @WebMethod
    boolean updatePrice(Price price);

    @WebMethod
    Price selectPrice(long id);

    @WebMethod
    boolean deletePrice(long id);

    @WebMethod
    PriceList selectList(PriceListRequest list);

    @WebMethod
    CustomError testError();
}
