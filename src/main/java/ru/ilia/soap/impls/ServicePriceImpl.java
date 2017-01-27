package ru.ilia.soap.impls;

import ru.ilia.soap.model.dao.Factory;
import ru.ilia.soap.model.entity.CustomError;
import ru.ilia.soap.model.entity.Price;
import ru.ilia.soap.model.entity.PriceList;
import ru.ilia.soap.model.entity.PriceListRequest;
import ru.ilia.soap.service.ServicePrice;

import javax.jws.WebService;

/**
 * Created by ILIA on 26.01.2017.
 */
@WebService(endpointInterface = "ru.ilia.soap.service.ServicePrice")
public class ServicePriceImpl implements ServicePrice {
    @Override
    public Price createPrice(int price) {
        Price priceResult=new Price();
        try {
            priceResult= Factory.getInstance().getPriceDAO().createPrice(new Price());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // if id null
        return priceResult;
    }

    @Override
    public boolean updatePrice(Price price) {
//        boolean result=false;
        try {
            Factory.getInstance().getPriceDAO().updatePrice(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Price selectPrice(long id) {
        Price priceResult=null;
        try {
            priceResult=Factory.getInstance().getPriceDAO().selectPriceById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return priceResult;
    }

    @Override
    public boolean deletePrice(long id) {
        boolean result=false;
        try {
            result=Factory.getInstance().getPriceDAO().deletePriceById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PriceList selectList(PriceListRequest list) {
        PriceList result=null;
        try {

            result=Factory.getInstance().getPriceDAO().selectList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CustomError testError() {
        return CustomError.DELETE;
    }
}
