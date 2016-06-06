package learn.java8.entities;

import learn.java8.entities.util.CalculationType;

import java.math.BigInteger;

/**
 * Class Result
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Result {

    /**
     * The id.
     */
    private Long id;

    /**
     * The used entry.
     */
    private Entry entry;

	/**
	 * The used calculation type.
	 */
	private CalculationType type;

    /**
     * The result of calculation.
     */
    private BigInteger result;

    /**
     * The average spent time value.
     */
    private Integer spentTime;

    /**
     * The default constructor.
     */
    public Result() {
    }

    /**
     * The full constructor.
     *
     * @param entry     The used entry.
     * @param result    The result of calculation.
     * @param spentTime The average spent time value.
     */
    public Result(Entry entry, BigInteger result, Integer spentTime) {
        this.entry = entry;
        this.result = result;
        this.spentTime = spentTime;
    }

    /**
     * Gets the id.
     *
     * @return  The id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the new id.
     *
     * @param id    the new id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the entry.
     *
     * @return  The entry.
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     * Sets the new entry.
     *
     * @param entry The new entry.
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

	/**
	 * Gets the calculation type.
	 *
	 * @return  The calculation type.
	 */
	public CalculationType getType() {
		return type;
	}

	/**
	 * Sets the new calculation type.
	 *
	 * @param type  The new type.
	 */
	public void setType(CalculationType type) {
		this.type = type;
	}

	/**
     * Gets the result.
     *
     * @return  The result.
     */
    public BigInteger getResult() {
        return result;
    }

    /**
     * Sets the new result.
     *
     * @param result    The new result.
     */
    public void setResult(BigInteger result) {
        this.result = result;
    }

    /**
     * Gets the spent time.
     *
     * @return  The spent time.
     */
    public Integer getSpentTime() {
        return spentTime;
    }

    /**
     * Sets the new spent time.
     *
     * @param spentTime The new spent time.
     */
    public void setSpentTime(Integer spentTime) {
        this.spentTime = spentTime;
    }

    /**
     * To string
     *
     * @return  The string.
     */
    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", entry=" + entry +
		        ", type=" + type +
                ", result=" + result +
                ", spentTime=" + spentTime +
                '}';
    }

    /**
     * The equals realization.
     *
     * @param o The object.
     * @return  The boolean result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result1 = (Result) o;

        if (!id.equals(result1.id)) return false;
        if (!entry.equals(result1.entry)) return false;
	    if (!type.equals(result1.type)) return false;
        if (!result.equals(result1.result)) return false;
        return spentTime.equals(result1.spentTime);

    }

    /**
     * The hash code realization.
     *
     * @return  The result.
     */
    @Override
    public int hashCode() {
        int result1 = id.hashCode();
        result1 = 31 * result1 + entry.hashCode();
	    result1 = 31 * result1 + type.hashCode();
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + spentTime.hashCode();
        return result1;
    }
}
