package learn.java8.main;

import learn.java8.util.lambda.LambdaExplorer;

/**
 * Class Main
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Main {

    /*private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-Datasource.xml"});
    private static EntryService entryService = (EntryService) context.getBean("entryService");*/

    public static void main(String[] args) {

	    /**
	     * Printing
	     */
	    // Common printing
	    LambdaExplorer.printCollectionElements();
	    // Using lambda expression
	    LambdaExplorer.printCollectionElementsWithLambda();
	    // Using lambda expression without type declaration
	    LambdaExplorer.printCollectionElementsWithLambdaWithoutType();
	    // Using lambda expression with double colon operator
	    LambdaExplorer.printCollectionElementsWithLambdaShortest();

	    /**
	     * Sorting
	     */
	    // Common sorting with the class Comparator implementation
	    LambdaExplorer.sortCollectionElements();
	    // Common sorting with the anonymous class Comparator implementation
	    LambdaExplorer.sortCollectionElementsWithAnonymousClass();
	    // Sorting with the lambda expressions
	    LambdaExplorer.sortCollectionElementsWithLambda();
		// Sorting with the lambda expressions and complex expression inside
	    LambdaExplorer.sortCollectionElementsWithLambdaComplexExpression();

	    /**
	     * Runnable as functional interface
	     */
	    LambdaExplorer.implementRunnable();
    }
}
