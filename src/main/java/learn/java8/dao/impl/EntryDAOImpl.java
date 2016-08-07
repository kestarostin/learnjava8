package learn.java8.dao.impl;

import learn.java8.dao.interfaces.EntryDAO;
import learn.java8.entities.Entry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class EntryDAOImpl
 * <p>
 * Date: 09.06.2016
 * Time: 13:37
 *
 * @author Starostin Konstantin
 */
@Repository("entryDao")
public class EntryDAOImpl extends AbstractDAO<Entry> implements EntryDAO {

    /**
     * Gets all entries.
     *
     * @return	The list ef entries.
     */
    public List<Entry> getAllEntries() {
        return em.createNamedQuery("Entry.getAllEntries").getResultList();
    }

    /**
     * Deletes all entries.
     */
    public void deleteAllEntries() {
        em.createNamedQuery("Entry.deleteAllEntries");
    }
}
