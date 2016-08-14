package learn.java8.main;

import learn.java8.entities.Entry;
import learn.java8.entities.util.CalculationType;
import learn.java8.services.interfaces.EntryService;
import learn.java8.util.OopsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Main {

    private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-datasource.xml"});
    private static EntryService entryService = (EntryService) context.getBean("entryService");

    public static void main(String[] args) {

        doJob();

	    /**
	     *
	     * LAMBDA EXPRESSIONS:
	     *
	     */

	    /**
	     * Printing
	     */
	    // Common printing
	    //LambdaExplorer.printCollectionElements();
	    // Using lambda expression
	    //LambdaExplorer.printCollectionElementsWithLambda();
	    // Using lambda expression without type declaration
	    //LambdaExplorer.printCollectionElementsWithLambdaWithoutType();
	    // Using lambda expression with method reference (double colon operator)
	    //LambdaExplorer.printCollectionElementsWithLambdaMethodReference();

	    /**
	     * Sorting
	     */
	    // Common sorting with the class Comparator implementation
	    //LambdaExplorer.sortCollectionElements();
	    // Common sorting with the anonymous class Comparator implementation
	    //LambdaExplorer.sortCollectionElementsWithAnonymousClass();
	    // Sorting with the lambda expressions
	    //LambdaExplorer.sortCollectionElementsWithLambda();
	    // Sorts a list of integers using method reference
	    //LambdaExplorer.sortCollectionElementsWithLambdaMethodReference();
		// Sorting with the lambda expressions and complex expression inside
	    //LambdaExplorer.sortCollectionElementsWithLambdaComplexExpression();

	    /**
	     * Runnable as functional interface
	     */
	    //LambdaExplorer.implementRunnable();

	    /**
	     * Method reference
	     */
	    // Using lambda expression with method reference to another method of this class
	    //LambdaExplorer.printCollectionElementsWithLambdaThis();
	    // Using lambda expression with method reference to the superclass method
	    //LambdaExplorer.printCollectionElementsWithLambdaSuper();

	    /**
	     * Lambda expression with final external variables
	     */
	    //LambdaExplorer.printCollectionElementsWithLambdaExternalVariables();


	    /**
	     *
	     * STREAM API:
	     *
	     */

	    /**
	     * Printing
	     */
	    // Common printing
	    //StreamExplorer.printFirstElement();
	    // Using stream API
	    //StreamExplorer.printFirstElementWithStreams();
	    // Printing the elements of the array with streams except the first one
	    //StreamExplorer.printElementsExceptTheFirstOne();
	    // Printing the elements of the array with streams except the last one
	    //StreamExplorer.printElementsExceptTheLastOne();
	    // Printing the array length
	    //StreamExplorer.printLength();
	    // Filtered printing
	    //StreamExplorer.printFirstElementFiltered();
	    // Filtered printing with optimized order
	    //StreamExplorer.printFirstElementFilteredOptimized();
	    // Print all elements filtered and  collected as one string
	    //StreamExplorer.printAllElementsFiltered();
	    // Print the average using collector
	    //StreamExplorer.printAllElementsWithCollector();
	    // Print all elements filtered in parallel
	    //StreamExplorer.printAllElementsFilteredParallel();
	    // Create stream of streams
	    //StreamExplorer.createStreamOfStreams();
    }

    private static void doJob() {
        Entry entry = new Entry(CalculationType.SORTER, 1234L, 20);
        try {
            entryService.createEntry(entry);
        } catch (OopsException e) {
            e.printStackTrace();
        }
    }
}
