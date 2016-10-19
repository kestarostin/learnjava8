package learn.java8.services.impl;

import learn.java8.dao.interfaces.EntryDAO;
import learn.java8.entities.Entry;
import learn.java8.services.interfaces.EntryService;
import learn.java8.util.OopsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * The logger.
     */
    private Log LOG = LogFactory.getLog(EntryService.class);

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
            StringBuilder message = new StringBuilder("The entry ").append(entry).append(" can't be created.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
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
            StringBuilder message = new StringBuilder("The entry with id = ").append(id).append(" is not exist.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
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
            StringBuilder message = new StringBuilder("The entry ").append(entry).append(" can't be updated.");
            LOG.error(message.toString());
			throw new OopsException(message.toString());
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

	/**
	 * Gets the list of all entries.
	 *
	 * @return	The list of entries.
	 */
	@Transactional
	public List<Entry> getAllEntries() throws OopsException {
		List<Entry> entryList = entryDAO.getAllEntries();
		if (entryList == null) {
            StringBuilder message = new StringBuilder("The entry list is empty.");
            LOG.error(message.toString());
            throw new OopsException(message.toString());
		}
		return entryList;
	}

    /**
     * Deletes all entries.
     */
    @Transactional
    public void deleteAllEntries() {
        entryDAO.deleteAllEntries();
    }
}
