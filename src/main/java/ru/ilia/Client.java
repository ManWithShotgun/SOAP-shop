package ru.ilia;



import ru.ilia.model.dao.Factory;
import ru.ilia.model.entity.Price;

import javax.management.relation.Role;
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

        Price price1=null;
        Price price2=null;
        Price price3=null;
        ArrayList<Price> result;
        try {
            ArrayList<Long> list=new ArrayList<>();
            list.add(3L);
            list.add(4L);
            list.add(5L);
            list.add(6L);
            ArrayList<Price> prices= (ArrayList<Price>) Factory.getInstance().getPriceDAO().selectList(list);

            for (Price p : prices){
                System.out.println(p.getId()+" | "+p.getPrice());
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
