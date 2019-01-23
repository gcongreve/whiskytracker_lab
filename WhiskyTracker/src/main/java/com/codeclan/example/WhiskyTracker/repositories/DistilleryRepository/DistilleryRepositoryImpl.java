package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;



public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> getDistilleryByRegion(String region) {
        List<Distillery> result = null;



        Session session = entityManager.unwrap(Session.class);


        Criteria cr = session.createCriteria(Distillery.class);
        cr.add(Restrictions.eq("region", region));

        try {
            result = cr.list();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Distillery> getDistilleryByAgeOfWhisky(int age) {
        List<Distillery> result = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);
        cr.createAlias("whiskies", "whiskiesAlias");
        cr.add(Restrictions.eq("whiskiesAlias.age", age));
        result = cr.list();

        return result;
    }

}
