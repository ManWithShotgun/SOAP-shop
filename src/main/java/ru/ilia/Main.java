package ru.ilia;

import ru.ilia.impls.HelloWorldImpl;
import ru.ilia.impls.MonitorPriceImpl;
import ru.ilia.impls.ServicePriceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ILIA on 18.12.2016.
 */
public class Main {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
        Endpoint.publish("http://localhost:9999/ws/price", new ServicePriceImpl());
        System.out.println("deploy");
    }
}
