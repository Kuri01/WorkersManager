import Computers.AbstractComputer;

public class Manager extends Employee{
    private int numberOfEmployees;

    public Manager(String name, String surname, int salary, String email, int phoneNumber, int numberOfEmployees, AbstractComputer computer) {
        super(name, surname, salary, email, phoneNumber, computer);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", salary=" + getSalary() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", numberOfEmployees=" + numberOfEmployees +
                ", computer=" + getComputer() +
                '}';
    }
}
