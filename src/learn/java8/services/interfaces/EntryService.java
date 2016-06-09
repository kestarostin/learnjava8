package learn.java8.services.interfaces;

import learn.java8.entities.Entry;
import learn.java8.util.OopsException;

/**
 * Class EntryService
 * <p>
 * Date: 09.06.2016
 * Time: 14:05
 *
 * @author Starostin Konstantin
 */
public interface EntryService {

	/**
	 * Creates the entry.
	 *
	 * @param entry The entry.
	 * @return      The created entry.
	 * @throws OopsException
	 */
	Entry createEntry(Entry entry) throws OopsException;

	/**
	 * Loads entry by id.
	 *
	 * @param id    The id.
	 * @return      The found entry.
	 * @throws OopsException
	 */
	Entry loadEntry(Long id) throws OopsException;

	/**
	 * Updates the entry.
	 *
	 * @param entry The entry.
	 * @return      The updated entry.
	 * @throws OopsException
	 */
	Entry updateEntry(Entry entry) throws OopsException;

	/**
	 * Deletes the entry.
	 *
	 * @param entry The entry.
	 */
	void deleteEntry(Entry entry);
}
