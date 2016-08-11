package learn.java8.dao.interfaces;

import learn.java8.entities.Result;

import java.util.List;

/**
 * Class ResultDAO
 * <p>
 * Date: 09.06.2016
 * Time: 13:19
 *
 * @author Starostin Konstantin
 */
public interface ResultDAO extends CommonDAO<Result> {

	/**
	 * Gets all results.
	 *
	 * @return	The list of results.
	 */
	List<Result> getAllResults();

    /**
     * Deletes all results.
     */
    void deleteAllResults();
}
