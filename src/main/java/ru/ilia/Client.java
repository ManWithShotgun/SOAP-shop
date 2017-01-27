package ru.ilia;



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

//        Price price1=null, price2=null, price3=null;
//        ArrayList<Price> result;
//        try {
//            AccountDAO accountDAO=new AccountDAO();
//            accountDAO.createAccount(new Account("dsadasd","tttdasda",true, Role.admin));
//
//        }
//        catch (ConstraintViolationException e){
//            System.out.println("Error: "+e.getConstraintViolations().iterator().next().getMessage());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println("Price: "+result);
//        System.out.println("getPrice: "+price1.getPrice()+" | "+price1.getId());
    }
}
