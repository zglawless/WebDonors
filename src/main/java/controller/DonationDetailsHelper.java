package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DonationDetails;

public class DonationDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Donors");
	
	public void insertNewDonationDetails(DonationDetails d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<DonationDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<DonationDetails> allDetails = em.createQuery("SELECT f FROM DonationDetails f").getResultList();
		return allDetails;
	}
	
	public DonationDetails searchForDonationDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		DonationDetails found = em.find(DonationDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(DonationDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DonationDetails> typedQuery = em.createQuery("SELECT detail from DonationDetails detail where detail.id= :selectedId", DonationDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		DonationDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(DonationDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
