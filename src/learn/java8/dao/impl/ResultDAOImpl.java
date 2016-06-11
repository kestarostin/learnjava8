package learn.java8.dao.impl;

import learn.java8.dao.interfaces.ResultDAO;
import learn.java8.entities.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class ResultDAOImpl
 * <p>
 * Date: 09.06.2016
 * Time: 13:38
 *
 * @author Starostin Konstantin
 */
@Repository("ResultDao")
public class ResultDAOImpl extends AbstractDAO<Result> implements ResultDAO {

    /**
     * Gets all results.
     *
     * @return	The list of results.
     */
    public List<Result> getAllResults() {
        return em.createNamedQuery("Result.getAllResults").getResultList();
    }

    /**
     * Deletes all results.
     */
    public void deleteAllResults() {
        em.createNamedQuery("Result.deleteAllResults");
    }
}
