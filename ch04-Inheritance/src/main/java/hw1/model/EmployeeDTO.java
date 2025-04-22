package hw1.model;

public class EmployeeDTO extends PersonDTO {
    private int salary;
    private String dept;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        super.setName(name);
    }

    public String information(){
        return "EmployeeDTO{" +
                "salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
