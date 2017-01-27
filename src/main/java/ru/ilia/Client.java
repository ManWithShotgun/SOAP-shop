package ru.ilia;



import ru.ilia.model.dao.Factory;
import ru.ilia.model.entity.Price;
import ru.ilia.model.entity.PriceList;

import javax.validation.ConstraintViolationException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by ILIA on 18.12.2016.
 */
public class Client {
    public static void main(String[] args) throws MalformedURLException {
//        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
//        QName qname = new QName("http://impls.ilia.ru/", "HelloWorldImplService");
//
//        Service service = Service.create(url, qname);
//
//        HelloWorld hello = service.getPort(HelloWorld.class);
//
//        System.out.println(hello.getHelloWorld("GGG"));

        Price price1=null;
        Price price2=null;
        Price price3=null;
        ArrayList<Price> result;
        try {
//            ArrayList<Long> list=new ArrayList<>();
//            list.add(3L);
//            list.add(4L);
//            list.add(5L);
//            list.add(6L);
//            PriceList prices = Factory.getInstance().getPriceDAO().selectList(list);
//
//            for (Price p : prices.getPriceList()){
//                System.out.println(p.getId()+" | "+p.getPrice());
//            }


//            price1=Factory.getInstance().getPriceDAO().selectPriceById(3);
//            System.out.println(price1.getId()+" : "+price1.getPrice());
//            Factory.getInstance().getPriceDAO().createPrice(new Price(43));

        }
        catch (ConstraintViolationException e){
            System.out.println("Error: "+e.getConstraintViolations().iterator().next().getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Price: "+result);
//        System.out.println("getPrice: "+price1.getPrice()+" | "+price1.getId());
    }
}
