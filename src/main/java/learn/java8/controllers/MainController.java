package learn.java8.controllers;

import learn.java8.business.performance.AbstractExecutor;
import learn.java8.business.performance.ArraySorter;
import learn.java8.entities.Entry;
import learn.java8.entities.Result;
import learn.java8.entities.util.CalculationType;
import learn.java8.services.interfaces.EntryService;
import learn.java8.services.interfaces.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Class MainController
 * <p>
 * Created by Starostin Konstantin
 * on 14.08.2016.
 */
@Controller
public class MainController {

	@Autowired
	private EntryService entryService;

	@Autowired
	private ResultService resultService;

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/start";
	}

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String showCalcPage(Model model) {
        Entry entry = new Entry();
        model.addAttribute("startPage", entry);
        return "startPage";
    }

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String calculate(@ModelAttribute("startPage") Entry entry, Model model) {
		entry.setType(CalculationType.SORTER);

		try {
			entry = entryService.createEntry(entry);

			AbstractExecutor executor = new ArraySorter(entry);
			executor.execute();

			Result result = new Result(entry, executor.getResult(), executor.getTime(), new Date());
			result = resultService.createResult(result);

			return "redirect:/start";
		} catch (Exception e) {
			return "redirect:/start";
		}
	}

	/**
	 * Handle a calculation type.
	 *
	 * @param type  The Calculation Type in short value.
	 * @return      The Calculation Type as enum.
	 */
	private CalculationType handleCalcType(short type) {
		if (CalculationType.values().length < type) {
			return null;
		}
		switch(type) {
			case 1:
				return CalculationType.SORTER;
			case 2:
				return CalculationType.SORTER_STREAM;
			case 3:
				return CalculationType.SORTER_PARALLEL_STREAM;
			case 4:
				return CalculationType.FACTORIAL;
			case 5:
				return CalculationType.FACTORIAL_STREAM;
			case 6:
				return CalculationType.FACTORIAL_PARALLEL_STREAM;
			default:
				return null;
		}
	}
}