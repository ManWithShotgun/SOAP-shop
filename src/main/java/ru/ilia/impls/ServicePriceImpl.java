package ru.ilia.impls;

import ru.ilia.model.dao.PriceDAO;
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
            PriceDAO priceDAO = new PriceDAO();
            priceResult=priceDAO.createPrice(new Price(price));
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
            PriceDAO priceDAO = new PriceDAO();
            priceDAO.updatePrice(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Price selectPrice(long id) {
        Price priceResult=null;
        try {
            PriceDAO priceDAO = new PriceDAO();
            priceResult=priceDAO.selectPriceById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return priceResult;
    }

    @Override
    public boolean deletePrice(long id) {
        boolean result=false;
        try {
            PriceDAO priceDAO = new PriceDAO();
            result=priceDAO.deletePriceById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
