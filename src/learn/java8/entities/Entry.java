package learn.java8.entities;

/**
 * Class Entry
 * <p>
 * Created by Starostin Konstantin
 * on 05.06.2016.
 */
public class Entry {

    /**
     * The id.
     */
    private Long id;

    /**
     * The title of the entry.
     */
    private String title;

    /**
     * The end value for the factorial.
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
     * @param title         The title of the entry.
     * @param value         The end value for the factorial.
     * @param iterations    The number of iterations for calculation the average time was spent.
     */
    public Entry(String title, Long value, Integer iterations) {
        this.title = title;
        this.value = value;
        this.iterations = iterations;
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
     * Gets the title.
     *
     * @return  The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the new title.
     *
     * @param title The new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value.
     *
     * @return  The value.
     */
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
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value=" + value +
                ", iterations=" + iterations +
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
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!id.equals(entry.id)) return false;
        if (!title.equals(entry.title)) return false;
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
        result = 31 * result + title.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + iterations.hashCode();
        return result;
    }
}
