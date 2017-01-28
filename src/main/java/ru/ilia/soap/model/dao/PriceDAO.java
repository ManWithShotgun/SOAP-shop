package ru.ilia.soap.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import ru.ilia.soap.model.entity.Price;
import ru.ilia.soap.model.entity.PriceList;
import ru.ilia.soap.model.entity.PriceListRequest;

/**
 * Created by ILIA on 26.01.2017.
 */
public class PriceDAO extends DAO {

    public Price createPrice(Price price) throws Exception {
        Session session=begin();
        try {
//            int result=-1
            session.save(price);
            commit(session);
            return price;
        } catch (HibernateException e) {
            rollback(session);
            throw new Exception("DAO error: "+e);
        }
    }

    public Price selectPriceById(long id) throws Exception {
        Session session=begin();
        try {
//            Price price=getSession().get(Price.class,id);
            Query q = session.createQuery("from Price where id_price = :id");
            q.setLong("id", id);
            Price price = (Price) q.uniqueResult();
            commit(session);
            return price;
        } catch (HibernateException e) {
            rollback(session);
            throw new Exception("DAO error: " + e);
        }
    }

    public void updatePrice(Price price){
        Session session=begin();
        session.update(price);
        commit(session);
    }

    public void deletePrice(Price price){
        Session session=begin();
        session.delete(price);
        commit(session);
    }

    public boolean deletePriceById(long id){
        int result;
        Session session=begin();
        Query q = session.createQuery("delete from Price where id_price = :id");
        q.setLong("id", id);
        result=q.executeUpdate();
        commit(session);
        return result==1;
    }

    public PriceList selectList(PriceListRequest list){
        PriceList priceList=new PriceList();
//        List<Price> result=new ArrayList<>(list.size());
        Session session=begin();
        Query q = session.createQuery("from Price where id_price = :id");
        for (Long id : list.getIdList()){
            q.setLong("id", id);
            priceList.getPriceList().add((Price) q.uniqueResult());
        }
        commit(session);
        return priceList;
    }


}
