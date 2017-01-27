package ru.ilia;

import ru.ilia.model.dao.PriceDAO;
import ru.ilia.model.entity.Price;
import ru.ilia.soap.HelloWorld;

import javax.validation.ConstraintViolationException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

        Price price1=null, price2=null, price3=null;
        ArrayList<Price> result;
        try {
            PriceDAO priceDAO=new PriceDAO();
            result=(ArrayList<Price>) priceDAO.selectListWithOffset(4);
            for (Price p : result){
                System.out.println("Price: "+p.getPrice()+" | "+p.getId());
            }
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
