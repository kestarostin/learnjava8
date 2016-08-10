package learn.java8.dao.interfaces;

import learn.java8.entities.Entry;

import java.util.List;

/**
 * Class EntryDAO
 * <p>
 * Date: 09.06.2016
 * Time: 13:18
 *
 * @author Starostin Konstantin
 */
public interface EntryDAO {

	/**
	 * Gets all entries.
	 *
	 * @return	The list ef entries.
	 */
	List<Entry> getAllEntries();

    /**
     * Deletes all entries.
     */
    void deleteAllEntries();
}
