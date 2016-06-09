package learn.java8.services.impl;

import learn.java8.dao.interfaces.EntryDAO;
import learn.java8.entities.Entry;
import learn.java8.services.interfaces.EntryService;
import learn.java8.util.OopsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class EntryServiceImpl
 * <p>
 * Date: 09.06.2016
 * Time: 14:05
 *
 * @author Starostin Konstantin
 */
@Service("entryService")
public class EntryServiceImpl implements EntryService {

	/**
	 * The entry DAO.
	 */
	private EntryDAO entryDAO;

	/**
	 * The constructor.
	 *
	 * @param entryDAO  The entry DAO.
	 */
	@Autowired
	public EntryServiceImpl(EntryDAO entryDAO) {
		this.entryDAO = entryDAO;
	}

	/**
	 * Creates the entry.
	 *
	 * @param entry The entry.
	 * @return      The created entry.
	 * @throws OopsException
	 */
	@Transactional
	public Entry createEntry(Entry entry) throws OopsException {
		Entry createdEntry = entryDAO.create(entry);
		if (createdEntry == null) {
			throw new OopsException("The entry " + entry + " can't be created.");
		}
		return createdEntry;
	}

	/**
	 * Loads entry by id.
	 *
	 * @param id    The id.
	 * @return      The found entry.
	 * @throws OopsException
	 */
	@Transactional
	public Entry loadEntry(Long id) throws OopsException {
		Entry loadedEntry = entryDAO.read(id);
		if (loadedEntry == null) {
			throw new OopsException("The entry with id = " + id + " is not exist.");
		}
		return loadedEntry;
	}

	/**
	 * Updates the entry.
	 *
	 * @param entry The entry.
	 * @return      The updated entry.
	 * @throws OopsException
	 */
	@Transactional
	public Entry updateEntry(Entry entry) throws OopsException {
		Entry updatedEntry = entryDAO.update(entry);
		if (updatedEntry == null) {
			throw new OopsException("The entry " + entry + " can't be updated.");
		}
		return updatedEntry;
	}

	/**
	 * Deletes the entry.
	 *
	 * @param entry The entry.
	 */
	@Transactional
	public void deleteEntry(Entry entry) {
		entryDAO.delete(entry);
	}
}
