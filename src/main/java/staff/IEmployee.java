package staff;

import main.Rating;

public interface IEmployee {
    String getName();

    void setName(String name);
    int getAge();
    void setAge(int age);
    int getSalary();
    void setSalary(int salary);
    void setRating(Rating rating);

    void recalculateSalary();
}
