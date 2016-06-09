package learn.java8.services.impl;

import learn.java8.dao.interfaces.ResultDAO;
import learn.java8.entities.Result;
import learn.java8.services.interfaces.ResultService;
import learn.java8.util.OopsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class ResultServiceImpl
 * <p>
 * Date: 09.06.2016
 * Time: 14:05
 *
 * @author Starostin Konstantin
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService {

	/**
	 * The result DAO.
	 */
	private ResultDAO resultDAO;

	/**
	 * The constructor.
	 *
	 * @param resultDAO The result DAO.
	 */
	@Autowired
	public ResultServiceImpl(ResultDAO resultDAO) {
		this.resultDAO = resultDAO;
	}

	/**
	 * Creates the result.
	 *
	 * @param result    The result.
	 * @return          The created result.
	 * @throws OopsException
	 */
	@Transactional
	public Result createResult(Result result) throws OopsException {
		Result createdResult = resultDAO.create(result);
		if (createdResult == null) {
			throw new OopsException("The result " + result + " can't be created.");
		}
		return createdResult;
	}

	/**
	 * Loads result by id.
	 *
	 * @param id    The id.
	 * @return      The found result.
	 * @throws OopsException
	 */
	@Transactional
	public Result loadResult(Long id) throws OopsException {
		Result loadedResult = resultDAO.read(id);
		if (loadedResult == null) {
			throw new OopsException("The result with id = " + id + " is not exist.");
		}
		return loadedResult;
	}

	/**
	 * Updates the result.
	 *
	 * @param result    The result.
	 * @return          The updated result.
	 * @throws OopsException
	 */
	@Transactional
	public Result updateResult(Result result) throws OopsException {
		Result updatedResult = resultDAO.update(result);
		if (updatedResult == null) {
			throw new OopsException("The result " + result + " can't be updated.");
		}
		return updatedResult;
	}

	/**
	 * Deletes the result.
	 *
	 * @param result    The result.
	 */
	@Transactional
	public void deleteResult(Result result) {
		resultDAO.delete(result);
	}
}
