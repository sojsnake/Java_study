package hw1.model;

public class PersonDTO {
    private String name;
    private int age;
    private double height;
    private double weight;

    public void setName(String name) {
        this.name = name;
    }

    public PersonDTO() {
    }

    public PersonDTO(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

//    public String information(){}
}
