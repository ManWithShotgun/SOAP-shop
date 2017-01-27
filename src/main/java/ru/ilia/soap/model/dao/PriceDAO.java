package ru.ilia.soap.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import ru.ilia.soap.model.entity.Price;
import ru.ilia.soap.model.entity.PriceList;
import ru.ilia.soap.model.entity.PriceListRequest;

/**
 * Created by ILIA on 26.01.2017.
 */
public class PriceDAO extends DAO {

    public Price createPrice(Price price) throws Exception {
        try {
//            int result=-1
            begin();
            getSession().save(price);
            commit();
            return price;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("DAO error: "+e);
        }
    }

    public Price selectPriceById(long id) throws Exception {
        try {
            begin();
//            Price price=getSession().get(Price.class,id);
            Query q = getSession().createQuery("from Price where id_price = :id");
            q.setLong("id", id);
            Price price = (Price) q.uniqueResult();
            commit();
            return price;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("DAO error: " + e);
        }
    }

    public void updatePrice(Price price){
        begin();
        getSession().update(price);
        commit();
    }

    public void deletePrice(Price price){
        begin();
        getSession().delete(price);
        commit();
    }

    public boolean deletePriceById(long id){
        int result;
        begin();
        Query q = getSession().createQuery("delete from Price where id_price = :id");
        q.setLong("id", id);
        result=q.executeUpdate();
        commit();
        return result==1;
    }

    public PriceList selectList(PriceListRequest list){
        PriceList priceList=new PriceList();
//        List<Price> result=new ArrayList<>(list.size());
        begin();
        Query q = getSession().createQuery("from Price where id_price = :id");
        for (Long id : list.getIdList()){
            q.setLong("id", id);
            priceList.getPriceList().add((Price) q.uniqueResult());
        }
        commit();
        return priceList;
    }


}
