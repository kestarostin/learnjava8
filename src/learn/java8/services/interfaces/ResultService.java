package learn.java8.services.interfaces;

import learn.java8.entities.Result;
import learn.java8.util.OopsException;

/**
 * Class ResultService
 * <p>
 * Date: 09.06.2016
 * Time: 14:05
 *
 * @author Starostin Konstantin
 */
public interface ResultService {

	/**
	 * Creates the result.
	 *
	 * @param result    The result.
	 * @return          The created result.
	 * @throws OopsException
	 */
	Result createResult(Result result) throws OopsException;

	/**
	 * Loads the result by id.
	 *
	 * @param id    The id.
	 * @return      The found result.
	 * @throws OopsException
	 */
	Result loadResult(Long id) throws OopsException;

	/**
	 * Updates the result.
	 *
	 * @param result    The result.
	 * @return          The updated result.
	 * @throws OopsException
	 */
	Result updateResult(Result result) throws OopsException;

	/**
	 * Deletes the result.
	 *
	 * @param result    The result.
	 */
	void deleteResult(Result result);
}
