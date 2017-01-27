package ru.ilia.impls;

import ru.ilia.model.dao.Factory;
import ru.ilia.model.dao.PriceDAO;
import ru.ilia.model.entity.CustomError;
import ru.ilia.model.entity.Price;
import ru.ilia.soap.ServicePrice;

import javax.jws.WebService;

/**
 * Created by ILIA on 26.01.2017.
 */
@WebService(endpointInterface = "ru.ilia.soap.ServicePrice")
public class ServicePriceImpl implements ServicePrice {
    @Override
    public Price createPrice(int price) {
        Price priceResult=new Price(price);
        try {
            priceResult= Factory.getInstance().getPriceDAO().createPrice(new Price(price));
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
    public CustomError testError() {
        return CustomError.DELETE;
    }
}
