package learn.java8.dao.interfaces;

/**
 * Class CommonDAO
 * <p>
 * Created by Starostin Konstantin
 * on 09.08.2016.
 */
public interface CommonDAO<T> {
    /**
     * Creates the entity.
     *
     * @param t The entity.
     * @return  The created entity.
     */
    T create(T t);

    /**
     * Reads the entity by id.
     *
     * @param id    The id.
     * @return      The entity.
     */
    T read(Long id);

    /**
     * Updates the entity.
     *
     * @param t The entity.
     * @return  The entity.
     */
    T update(T t);

    /**
     * Deletes the entity.
     *
     * @param t The entity.
     */
    void delete(T t);
}
