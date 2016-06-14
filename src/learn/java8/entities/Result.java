package learn.java8.entities;

import learn.java8.entities.util.CalculationType;
import learn.java8.util.StringUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Class Result
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
@Entity
@Table(name = "RESULT")
@NamedQueries(
        {
                @NamedQuery(name = "Result.getAllResults", query = "SELECT result FROM Result result"),
                @NamedQuery(name = "Result.deleteAllResults", query = "DELETE FROM Result")
        })
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
    private BigInteger resultValue;

    /**
     * The average spent time value.
     */
    private Integer spentTime;

	/**
	 * The date of calculation
	 */
	private Date date;

    /**
     * The default constructor.
     */
    public Result() {
    }

	/**
	 * The full constructor.
	 *
	 * @param entry         The used entry.
	 * @param result        The result of calculation.
	 * @param spentTime     The average spent time value.
	 * @param date          The date of calculation.
	 */
    public Result(Entry entry, BigInteger result, Integer spentTime, Date date) {
        this.entry = entry;
	    this.type = entry.getType();
        this.resultValue = result;
        this.spentTime = spentTime;
	    this.date = date;
    }

    /**
     * Gets the id.
     *
     * @return  The id.
     */
    @Id
    @Column(name = "RES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ENTR_ID", nullable = false)
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
	@Column(name = "RES_CALC_TYPE")
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
	@Column(name = "RES_VALUE")
    public BigInteger getResultValue() {
        return resultValue;
    }

    /**
     * Sets the new result.
     *
     * @param resultValue    The new result.
     */
    public void setResultValue(BigInteger resultValue) {
        this.resultValue = resultValue;
    }

    /**
     * Gets the spent time.
     *
     * @return  The spent time.
     */
    @Column(name = "RES_DATE")
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
	 * Gets the date of calculation
	 *
	 * @return  The date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the new date.
	 *
	 * @param date  The new date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
     * To string
     *
     * @return  The string.
     */
    @Override
    public String toString() {
	    return new StringBuffer(StringUtils.BIG_DELIMITER_ABOVE)
			    .append("ID: ").append("\t\t\t\t\t\t").append(id).append("\n")
			    .append("The type: ").append("\t\t\t\t\t").append(type).append("\n")
			    .append("The result value: ").append("\t\t\t").append(resultValue).append("\n")
			    .append("The average spent time: ").append("\t").append(spentTime).append(" seconds").append("\n")
			    .append("The date of calculation: ").append("\t").append(date)
			    .append(StringUtils.BIG_DELIMITER_BELOW).toString();
    }

    /**
     * The equals realization.
     *
     * @param o The object.
     * @return  The boolean resultValue.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result1 = (Result) o;

        if (!id.equals(result1.id)) return false;
        if (!entry.equals(result1.entry)) return false;
	    if (!type.equals(result1.type)) return false;
        if (!resultValue.equals(result1.resultValue)) return false;
	    if (!date.equals(result1.date)) return false;
        return spentTime.equals(result1.spentTime);

    }

    /**
     * The hash code realization.
     *
     * @return  The resultValue.
     */
    @Override
    public int hashCode() {
        int result1 = id.hashCode();
        result1 = 31 * result1 + entry.hashCode();
	    result1 = 31 * result1 + type.hashCode();
        result1 = 31 * result1 + resultValue.hashCode();
        result1 = 31 * result1 + spentTime.hashCode();
	    result1 = 31 * result1 + date.hashCode();
        return result1;
    }
}
