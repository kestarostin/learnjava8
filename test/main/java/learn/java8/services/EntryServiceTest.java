package main.java.learn.java8.services;

import learn.java8.util.OopsException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;
import learn.java8.services.interfaces.EntryService;

/**
 * Class EntryServiceTest
 * <p>
 * Created by Starostin Konstantin
 * on 07.08.2016.
 */
public class EntryServiceTest {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/Spring-Datasource.xml");
    private static EntryService entryService = (EntryService) context.getBean("entryService");

    /**
     * The tested entry.
     */
    protected Entry entry;

    /**
     * Set up.
     */
    @Before
    public void before() throws OopsException {
        entry = new Entry(CalculationType.SORTER, 5000000L, 20);
        entryService.createEntry(entry);
    }

    /**
     * Checks service method createEntry.
     */
    @Test
    public void loadEntryTest() throws OopsException {
        Entry loadedEntry = entryService.loadEntry(entry.getId());
        Assert.assertEquals(entry.getType(), loadedEntry.getType());
        Assert.assertEquals(entry.getValue(), loadedEntry.getValue());
        Assert.assertEquals(entry.getIterations(), loadedEntry.getIterations());
    }

    /**
     * Clearing.
     */
    @After
    public void after() throws OopsException {
        entryService.deleteEntry(entry);
    }
}
