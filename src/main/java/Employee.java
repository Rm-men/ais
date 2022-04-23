@DBTable(name = "EMPLOYEE")
public class Employee {

    @ColumnInteger(name = "ID_EMPLOYEE", constraints = @Constraints(primaryKey = true))
    private Integer id;

    @ColumnString(30)
    private String firstName;

    @ColumnString(50)
    private String lastName;

    @ColumnInteger
    private Integer age;

    @ColumnInteger
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
