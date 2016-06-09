package learn.java8.dao.impl;

import learn.java8.dao.interfaces.ResultDAO;
import learn.java8.entities.Result;
import org.springframework.stereotype.Repository;

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
}
