package beans.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import beans.model.RelacionPlatosIngredientes;

/**
 * Home object for domain model class RelacionPlatosIngredientes.
 * @see beans.model.RelacionPlatosIngredientes
 * @author Hibernate Tools
 */
public class RelacionPlatosIngredientesHome {

	private static final Log log = LogFactory.getLog(RelacionPlatosIngredientesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(RelacionPlatosIngredientes transientInstance) {
		log.debug("persisting RelacionPlatosIngredientes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RelacionPlatosIngredientes instance) {
		log.debug("attaching dirty RelacionPlatosIngredientes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RelacionPlatosIngredientes instance) {
		log.debug("attaching clean RelacionPlatosIngredientes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RelacionPlatosIngredientes persistentInstance) {
		log.debug("deleting RelacionPlatosIngredientes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RelacionPlatosIngredientes merge(RelacionPlatosIngredientes detachedInstance) {
		log.debug("merging RelacionPlatosIngredientes instance");
		try {
			RelacionPlatosIngredientes result = (RelacionPlatosIngredientes) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RelacionPlatosIngredientes findById(java.lang.Integer id) {
		log.debug("getting RelacionPlatosIngredientes instance with id: " + id);
		try {
			RelacionPlatosIngredientes instance = (RelacionPlatosIngredientes) sessionFactory.getCurrentSession()
					.get("beans.model.RelacionPlatosIngredientes", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RelacionPlatosIngredientes instance) {
		log.debug("finding RelacionPlatosIngredientes instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("beans.model.RelacionPlatosIngredientes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
