package learn.java8.entities;

import learn.java8.entities.util.CalculationType;
import learn.java8.util.StringUtils;

import javax.persistence.*;

/**
 * Class Entry
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
@Entity
@Table(name = "ENTRY")
@NamedQueries(
        {
                @NamedQuery(name = "Entry.getAllEntries", query = "SELECT entry FROM Entry entry"),
                @NamedQuery(name = "Entry.deleteAllEntries", query = "DELETE FROM Entry")
        })
public class Entry {

    /**
     * The id.
     */
    private Long id;

    /**
     * The title of the entry.
     */
    private CalculationType type;

    /**
     * The value.
     */
    private Long value;

    /**
     * The number of iterations for calculation the average time was spent.
     */
    private Integer iterations;

    /**
     * The default constructor.
     */
    public Entry() {
    }

    /**
     * The full constructor.
     *
     * @param type          The type of calculation.
     * @param value         The end value for the factorial.
     * @param iterations    The number of iterations for calculation the average time was spent.
     */
    public Entry(CalculationType type, Long value, Integer iterations) {
        this.type = type;
        this.value = value;
        this.iterations = iterations;
    }

    /**
     * Gets the id.
     *
     * @return  The id.
     */
    @Id
    @Column(name = "ENTR_ID")
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
     * Gets the type.
     *
     * @return  The type.
     */
    @Column(name = "ENTR_CALC_TYPE")
    public CalculationType getType() {
        return type;
    }

    /**
     * Sets the new type.
     *
     * @param type The new type.
     */
    public void setType(CalculationType type) {
        this.type = type;
    }

    /**
     * Gets the value.
     *
     * @return  The value.
     */
    @Column(name = "ENTR_VALUE")
    public Long getValue() {
        return value;
    }

    /**
     * Sets the new value.
     *
     * @param value The new value.
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * Gets the number of iterations.
     *
     * @return  The number of iterations.
     */
    @Column(name = "ENTR_ITER")
    public Integer getIterations() {
        return iterations;
    }

    /**
     * Sets the number of iterations.
     *
     * @param iterations    The number of iterations.
     */
    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    /**
     * To string.
     *
     * @return  The string.
     */
    @Override
    public String toString() {
	    return new StringBuffer(StringUtils.BIG_DELIMITER_ABOVE)
			    .append("ID: ").append("\t\t\t\t\t\t").append(id).append("\n")
			    .append("The type: ").append("\t\t\t\t\t").append(type).append("\n")
			    .append("The value: ").append("\t\t\t\t\t").append(value).append("\n")
			    .append("The number of iterations: ").append("\t").append(iterations)
			    .append(StringUtils.BIG_DELIMITER_BELOW).toString();
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
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!id.equals(entry.id)) return false;
        if (!type.equals(entry.type)) return false;
        if (!value.equals(entry.value)) return false;
        return iterations.equals(entry.iterations);

    }

    /**
     * The hash code realization.
     *
     * @return  The hash code.
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + iterations.hashCode();
        return result;
    }
}
