package learn.java8.dao.interfaces;

import learn.java8.entities.Result;

/**
 * Class ResultDAO
 * <p>
 * Date: 09.06.2016
 * Time: 13:19
 *
 * @author Starostin Konstantin
 */
public interface ResultDAO {

	/**
	 * Creates the result.
	 *
	 * @param result    The result.
	 * @return          The created result.
	 */
	Result create(Result result);

	/**
	 * Reads the result by id.
	 *
	 * @param id    The id.
	 * @return      The result.
	 */
	Result read(Long id);

	/**
	 * Updates the result.
	 *
	 * @param result    The result.
	 * @return          The result.
	 */
	Result update(Result result);

	/**
	 * Deletes the result.
	 *
	 * @param result    The result.
	 */
	void delete(Result result);
}
