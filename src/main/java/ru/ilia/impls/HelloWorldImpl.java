package ru.ilia.impls;

import ru.ilia.soap.HelloWorld;

import javax.jws.WebService;

/**
 * Created by ILIA on 18.12.2016.
 */
@WebService(endpointInterface = "ru.ilia.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String getHelloWorld(String name) {
        System.out.println("getHelloWorld");
        return "Hello "+name;
    }
}
