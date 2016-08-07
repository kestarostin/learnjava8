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
	 * Creates the entry.
	 *
	 * @param entry     The entry.
	 * @return          The created entry.
	 */
	Entry create(Entry entry);

	/**
	 * Reads the entry by id.
	 *
	 * @param id    The id.
	 * @return      The entry.
	 */
	Entry read(Long id);

	/**
	 * Updates the entry.
	 *
	 * @param entry     The entry.
	 * @return          The entry.
	 */
	Entry update(Entry entry);

	/**
	 * Deletes the entry.
	 *
	 * @param entry    The entry.
	 */
	void delete(Entry entry);

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
