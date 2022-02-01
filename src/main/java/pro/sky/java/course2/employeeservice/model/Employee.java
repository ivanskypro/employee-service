package pro.sky.java.course2.employeeservice.model;

public class Employee {
    private String firstName;
    private String lastName;
    private long salary;
    private Integer department;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Employee(String firstName, String lastName, long salary, Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary ='" + salary + '\'' +
                ", departmentId='" + department +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    //@Override
    //public int hashCode() {
     //   return Objects.hash(firstName, lastName);
    }