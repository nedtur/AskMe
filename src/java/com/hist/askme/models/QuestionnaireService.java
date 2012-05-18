package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class QuestionnaireService {

    private static final String pum = "AskmePU";
    private static EntityManagerFactory factory;

    public QuestionnaireService() {
    }

    public ArrayList<Questionnaire> getQuestionnaires() {
        factory = Persistence.createEntityManagerFactory(pum);
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createQuery("SELECT q FROM Questionnaire q");
        List ques = (List<Questionnaire>) q.getResultList();
        em.close();
        factory.close();
        if(ques.isEmpty()) return null;
        return new ArrayList(ques);
    }

    public void addQuestionnaire(Questionnaire questionnaire) {
        factory = Persistence.createEntityManagerFactory(pum);
        EntityManager em = factory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        userTransaction.begin();
        em.persist(questionnaire);
        userTransaction.commit();
        em.close();
        factory.close();
    }
    
    public void updateQuestionnaire(Long id) {
        factory = Persistence.createEntityManagerFactory(pum);
        EntityManager em = factory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
        
        Query q = em.createQuery("SELECT a FROM Answer a WHERE a.id = '" + id + "'");
        List<Answer> ans = q.getResultList();
        ans.get(0).setResult();
        
        userTransaction.begin();
        em.merge(ans.get(0));
        userTransaction.commit();
        em.close();
        factory.close();
    }

    public Questionnaire find(String name, ArrayList<Questionnaire> questionnaires) {
        /*
        factory = Persistence.createEntityManagerFactory(pum);
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createQuery("SELECT q FROM Questionnaire q WHERE q.name = '" + name + "'");
        Questionnaire ques = (Questionnaire)q.getSingleResult();
        em.close();
        factory.close();
        if(ques==null) return null;*/
        for(Questionnaire q : questionnaires) {
            if(q.getName().equals(name)) {
                return q;
            }
        }
        
        return null;
    }
}
