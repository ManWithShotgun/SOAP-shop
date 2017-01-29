package ru.ilia.soap.model.dao;

import org.apache.log4j.Logger;
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

    private static final Logger log=Logger.getLogger("PriceDAO");

    public Price createPrice(Price price) throws Exception {
        Session session=begin();
        try {
            session.save(price);
            commit(session);
            log.info(price);
            return price;
        } catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("create price error: "+e);
        }
    }

    public Price selectPriceById(long id) throws Exception {
        Session session=begin();
        try {
            log.info("id: "+id);
            Query q = session.createQuery("from Price where id_price = :id");
            q.setLong("id", id);
            Price price = (Price) q.uniqueResult();
            commit(session);
            log.info(price);
            return price;
        } catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("select price error: " + e);
        }
    }

    public void updatePrice(Price price) throws Exception {
        Session session=begin();
        try {
            log.info(price);
            session.update(price);
            commit(session);
        }catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("update price error: " + e);
        }
    }

    public void deletePrice(Price price) throws Exception {
        Session session=begin();
        try {
            log.info(price);
            session.delete(price);
            commit(session);
        }catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("delete price error: " + e);
        }
    }

    public boolean deletePriceById(long id) throws Exception {
        int result;
        Session session=begin();
        try {
            log.info("id: "+id);
            Query q = session.createQuery("delete from Price where id_price = :id");
            q.setLong("id", id);
            result = q.executeUpdate();
            commit(session);
            return result == 1;
        }catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("delete price error: " + e);
        }
    }

    public PriceList selectList(PriceListRequest list) throws Exception {
        PriceList priceList=new PriceList();
        Session session=begin();
        try {
            Query q = session.createQuery("from Price where id_price = :id");
            for (Long id : list.getIdList()) {
                q.setLong("id", id);
                priceList.getPriceList().add((Price) q.uniqueResult());
                log.info("select id: "+id);
            }
            commit(session);
            return priceList;
        }catch (HibernateException e) {
            log.error(e.getMessage());
            rollback(session);
            throw new Exception("select list error: " + e);
        }
    }


}
