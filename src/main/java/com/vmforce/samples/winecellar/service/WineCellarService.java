package com.vmforce.samples.winecellar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmforce.samples.winecellar.model.Producer;
import com.vmforce.samples.winecellar.model.Wine;

@Service
public class WineCellarService {
	

	private static final Logger logger = LoggerFactory.getLogger(WineCellarService.class);

	@PersistenceContext
	EntityManager em;

	@Transactional(readOnly=true)
	public Wine findById(String id) {
		try {
			return em.find(Wine.class, id);
		}
		catch(Exception e) {
			logger.info("find threw exception: "+e+": "+e.getMessage());
			logger.info("Will return null");
			return null;
		}
	}

	@Transactional
	public void createNewWineAndProducer(Wine wine) {
		em.persist(wine.getProducer());
		em.persist(wine);
	}
	
	@Transactional
	public void updateWine(Wine wine) {
		em.merge(wine);
	}

	@Transactional(readOnly=true)
	public Producer findProducerById(String id) {
		try {
			return em.find(Producer.class, id);
		}
		catch(Exception e) {
			logger.info("find threw exception: "+e+": "+e.getMessage());
			logger.info("Will return null");
			return null;
		}
	}

	@Transactional
	public Producer updateProducer(Producer producer) {
		return em.merge(producer);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Wine> getWineList() {
		return em.createQuery("SELECT w FROM Wine w").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Producer> getProducerList() {
		return em.createQuery("SELECT p FROM Producer p").getResultList();
	}

}
