package ru.ilia.model.dao;

/**
 * Created by ILIA on 27.01.2017.
 */
public class Factory {
    private static PriceDAO priceDAO=null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public PriceDAO getPriceDAO(){
        if(priceDAO==null){
            priceDAO=new PriceDAO();
        }
        return priceDAO;
    }
}
