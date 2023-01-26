import Computers.AbstractComputer;

public abstract class Employee {
    private  String name;
    private  String surname;
    private int salary;
    private  String email;
    private  int phoneNumber;
    private AbstractComputer computer;

    public Employee(String name, String surname, int salary, String email, int phoneNumber, AbstractComputer computer) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int raiseSalaryByPercent(int percent){
        return salary += salary * percent / 100;
    }

    public int raiseSalaryByAmount(int amount){
        return salary += amount;
    }

    public AbstractComputer getComputer() {
        return computer;
    }

    public void setComputer(AbstractComputer computer) {
        this.computer = computer;
    }

    public abstract String toString();
}
