package learn.java8.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Class AbstractDAO
 * <p>
 * Date: 09.06.2016
 * Time: 13:21
 *
 * @author Starostin Konstantin
 */
public abstract class AbstractDAO<T> {

	/**
	 * The type.
	 */
	private final Class<T> type;

	/**
	 * The persistence context.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * The constructor.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Creates the object.
	 *
	 * @param t The object.
	 */
	public T create(T t) {
		em.persist(t);
		return t;
	}

	/**
	 * Reads the object by its id.
	 *
	 * @param id    The id of the object.
	 * @return      The object.
	 */
	public T read(Long id) {
		return em.find(type, id);
	}

	/**
	 * Updates the object.
	 *
	 * @param t The object.
	 * @return  The updated object.
	 */
	public T update(T t) {
		return em.merge(t);
	}

	/**
	 * Deletes the object.
	 *
	 * @param t The object.
	 */
	public void delete(T t) {
		em.remove(t);
	}
}
