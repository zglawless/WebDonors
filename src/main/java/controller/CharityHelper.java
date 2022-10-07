package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Charities;

public class CharityHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Donors");
	
	public void insertCharity(Charities c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Charities> showAllCharities(){
		EntityManager em = emfactory.createEntityManager();
		List<Charities> allCharities = em.createQuery("SELECT c FROM Charities c").getResultList();
		return allCharities;
	}
	
	public Charities findCharity(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Charities> typedQuery = em.createQuery("select ch from Charities ch where ch.charityName = :selectedName", Charities.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Charities foundCharity;
		
		try {
			foundCharity = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCharity = new Charities(nameToLookUp);
		}
		em.close();
		
		return foundCharity;
	}
}
