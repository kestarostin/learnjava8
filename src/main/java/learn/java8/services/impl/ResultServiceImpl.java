package learn.java8.services.impl;

import learn.java8.dao.interfaces.ResultDAO;
import learn.java8.entities.Result;
import learn.java8.services.interfaces.ResultService;
import learn.java8.util.OopsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * The logger.
     */
    private Log LOG = LogFactory.getLog(ResultService.class);

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
            StringBuilder message = new StringBuilder("The result ").append(result).append(" can't be created.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
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
            StringBuilder message = new StringBuilder("The result with id = ").append(id).append(" is not exist.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
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
            StringBuilder message = new StringBuilder("The result ").append(result).append(" can't be updated.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
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

	/**
	 * Gets the list of all results.
	 *
	 * @return	The list of results.
	 */
	@Transactional
	public List<Result> getAllResults() throws OopsException {
		List<Result> resultList = resultDAO.getAllResults();
		if (resultList == null) {
            StringBuilder message = new StringBuilder("The result list is empty.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
		}
		return resultList;
	}

    /**
     * Deletes all results.
     */
    public void deleteAllResults() {
        resultDAO.deleteAllResults();
    }
}
