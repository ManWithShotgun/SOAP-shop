package ru.ilia.soap.impls;

import org.apache.log4j.Logger;
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

    private static final Logger log=Logger.getLogger("ServicePriceImpl");

    @Override
    public Price createPrice(int price) {
        Price priceResult=new Price();
        try {
            log.info("CREATE");
            priceResult= Factory.getInstance().getPriceDAO().createPrice(new Price(price));
            // if id null
            return priceResult;
        } catch (Exception e) {
            log.error("Create err",e);
            return  priceResult;// id: 0, price: 0
        }
    }

    @Override
    public boolean updatePrice(Price price) {
        try {
            log.info("UPDATE");
            Factory.getInstance().getPriceDAO().updatePrice(price);
            return true;
        } catch (Exception e) {
            log.error("Update err",e);
            return false;
        }
    }

    @Override
    public Price selectPrice(long id) {
        Price priceResult=null;
        try {
            log.info("SELECT");
            priceResult=Factory.getInstance().getPriceDAO().selectPriceById(id);
            return priceResult;
        } catch (Exception e) {
            log.error("Update err",e);
            return priceResult;
        }
    }

    @Override
    public boolean deletePrice(long id) {
        boolean result=false;
        try {
            log.info("DELETE");
            result=Factory.getInstance().getPriceDAO().deletePriceById(id);
            return result;
        } catch (Exception e) {
            log.error("Delete err",e);
            return result;
        }
    }

    @Override
    public PriceList selectList(PriceListRequest list) {
        PriceList result=null;
        try {
            log.info("SELECT LIST");
            result=Factory.getInstance().getPriceDAO().selectList(list);
            return result;
        } catch (Exception e) {
            log.error("Delete err",e);
            return result;
        }
    }

    @Override
    public CustomError testError() {
        return CustomError.DELETE;
    }
}
