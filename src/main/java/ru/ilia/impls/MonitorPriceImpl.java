package ru.ilia.impls;

import ru.ilia.model.dao.PriceDAO;
import ru.ilia.model.entity.Price;
import ru.ilia.soap.MonitorPrice;

import javax.jws.WebService;

/**
 * Created by ILIA on 25.01.2017.
 */
@WebService(endpointInterface = "ru.ilia.soap.MonitorPrice")
public class MonitorPriceImpl implements MonitorPrice {
    public String getMonitorPrice() {
        Price price1=null, price2=null, price3=null;
        try {
            PriceDAO priceDAO=new PriceDAO();
            price1=priceDAO.createPrice(new Price(321));
            price2=priceDAO.createPrice(new Price(444));
            price3=priceDAO.selectPriceById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Price: "+price2.getId());
        System.out.println("getPrice: "+price3.getPrice()+" | "+price3.getId());
//        return price.getPrice();

        return "{\"product\":{\"id\":1,\"pricePer\":17,\"name\":\"Монитор1\",\"img\":\"/dist/public/monitor-1.jpg\",\"inch\":23,\"description\":\"This is the description #1\"}}";
    }
}
