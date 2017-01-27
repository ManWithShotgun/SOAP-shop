package ru.ilia.soap;

import ru.ilia.model.entity.CustomError;
import ru.ilia.model.entity.Price;
import ru.ilia.model.entity.PriceList;
import ru.ilia.model.entity.PriceListRequest;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

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
