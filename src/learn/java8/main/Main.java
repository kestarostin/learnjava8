package learn.java8.main;

import learn.java8.business.FactorialCalculator;
import learn.java8.entities.Entry;
import learn.java8.entities.Result;
import learn.java8.entities.util.CalculationType;

import java.util.Date;

/**
 * Class Main
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Main {

    /*private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-Datasource.xml"});
    private static EntryService entryService = (EntryService) context.getBean("entryService");*/

    public static void main(String[] args) throws Exception{

        Entry entry = new Entry(CalculationType.FACTORIAL, 40000L, 25);
	    System.out.println(entry);

	    FactorialCalculator calc = new FactorialCalculator(entry);
	    calc.calculate();

	    Result result = new Result(entry, calc.getResult(), calc.getTime(), new Date());
	    System.out.println(result);
    }
}
