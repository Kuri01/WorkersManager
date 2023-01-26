import Computers.AbstractComputer;
import Computers.Mac;
import Computers.Windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Interface {

    List<Employee> employees = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public void displayInterface() {

        ArrayList<String> knownLanguages1 = new ArrayList<>();
        knownLanguages1.add("Python");
        knownLanguages1.add("CSS");
        ArrayList<String> knownLanguages2 = new ArrayList<>();
        knownLanguages2.add("Ruby");
        knownLanguages2.add("HTML");
        Manager manager = new Manager("Amil", "Bka", 10000, "amil.bka@gmail.com", 1, 10, new Mac("MacBook Pro", "Intel Core i7", "16GB", true));
        Developer developer = new Developer("Jane", "Doe", 3000, "jane.doe@gmail.com", 1, "Java", knownLanguages1, new Mac("MacBook Pro", "M1", "16GB", true));
        Developer developer2 = new Developer("Bob", "Kit", 4000, "bob.kit@gmail.com", 1, "Java", knownLanguages2, new Windows("Cool Windows", "Intel Core i7", "16GB", 98));
        employees.add(manager);
        employees.add(developer);
        employees.add(developer2);

    display();


    }

    private void display(){
        System.out.println("Witaj w menadzerze pracowników firmy KURI!"
                + "\n" + "Wybierz jedną z opcji: "
                + "\n" + "1. Dodaj pracownika"
                + "\n" + "2. Usuń pracownika"
                + "\n" + "3. Wyświetl pracowników"
                + "\n" + "4. Wyświetl pracowników z bardziej szczegolowymi informacjami"
                + "\n" + "5. Daj podwyżkę pracownikowi o daną liczbę"
                + "\n" + "6. Daj podwyżkę pracownikowi o procent"
                + "\n" + "9. Wyjście");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {addEmployee(); display();}
            case 2 -> {removeEmployee(); display();}
            case 3 -> {showEmployees(); display();}
            case 4 -> {showEmployeesWithDetails(); display();}
            case 5 -> {giveRaise(); display();}
            case 6 -> {givePercentageRaise(); display();}
            case 9 -> System.exit(0);
            default -> {
                System.out.println("Nie ma takiej opcji!");
                display();
            }
        }
    }

    private void addEmployee() {
        System.out.println("Dodajesz Menadzera czy Developera? (1/2)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> employees.add(choosedManager());
            case 2 -> employees.add(choosedDeveloper());
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }


    }

    private Manager choosedManager() {
        List<String> employee = createEmployee();
        AbstractComputer computer = getCompterInfo();

        System.out.println("Podaj liczbę pracowników podległych: ");
        int numberOfEmployees = scanner.nextInt();

        return new Manager(employee.get(0), employee.get(1), Integer.parseInt(employee.get(2)), employee.get(3), Integer.parseInt(employee.get(4)), numberOfEmployees, computer);
    }

    private Developer choosedDeveloper() {
        List<String> employee = createEmployee();
        AbstractComputer computer = getCompterInfo();
        ArrayList<String> knownLanguages = new ArrayList<>();

        System.out.println("Podaj główny język programowania: ");
        String mainLanguage = scanner.nextLine();

        do {
            System.out.println("Podaj język programowania: ");
            knownLanguages.add(scanner.nextLine());
            System.out.println("Czy chcesz dodać kolejny język? (t/n)");
        } while (scanner.nextLine().equals("t"));

        return new Developer(employee.get(0), employee.get(1), Integer.parseInt(employee.get(2)), employee.get(3), Integer.parseInt(employee.get(4)), mainLanguage, knownLanguages, computer);

    }

    private List<String> createEmployee() {
        ArrayList<String> employee = basicEmployeeQuestions();
        return employee;
    }

    private ArrayList<String> basicEmployeeQuestions() {
        ArrayList<String> employee = new ArrayList<>();
        scanner.nextLine();
        System.out.println("Podaj imię pracownika: ");
        String name = scanner.nextLine();
        employee.add(name);

        System.out.println("Podaj nazwisko pracownika: ");
        String surname = scanner.nextLine();
        employee.add(surname);

        System.out.println("Podaj pensję pracownika: ");
        String salary = scanner.nextLine();
        employee.add(salary);

        System.out.println("Podaj email pracownika: ");
        String email = scanner.nextLine();
        employee.add(email);

        System.out.println("Podaj numer telefonu pracownika: ");
        String phoneNumber = scanner.nextLine();
        employee.add(phoneNumber);

        return employee;
    }

    private AbstractComputer getCompterInfo() {
        AbstractComputer computer;
        System.out.println("Podaj komputer pracownika (Mac - wpisz 1/Widnows - wpisz 2): ");
        int computerChoice = scanner.nextInt();

        switch (computerChoice) {
            case 1 -> {
                System.out.println("Czy ma AirDropa? (Tak/Nie) ");
                scanner.nextLine();
                String airDrop = scanner.nextLine();
                if (airDrop.equals("Tak")) {
                    computer = new Mac("Mac", "M1", "8", true);
                } else if (airDrop.equals("Nie")) {
                    computer = new Mac("Mac", "M1", "8", false);
                } else {
                    throw new IllegalStateException("Unexpected value: " + airDrop);
                }
            }
            case 2 -> {
                System.out.println("Jaka ma wersje Windowsa?");
                String windowsVersion = scanner.nextLine();
                computer = new Computers.Windows("Windows", "Intel", "16", Integer.parseInt(windowsVersion));
            }
            default -> throw new IllegalStateException("Unexpected value: " + computerChoice);

        }
        return computer;
    }

    private void removeEmployee() {
        showEmployees();
        System.out.println("Podaj numer pracownika do usunięcia: ");
        int employeeNumber = scanner.nextInt() + 1;
        employees.remove(employeeNumber);
    }

    private void showEmployees() {
        AtomicInteger number = new AtomicInteger(1);
        employees.forEach(employee -> {
            System.out.println(number + ". " + employee.getName() + " " + employee.getSurname());
            number.getAndIncrement();
        });
    }

    private void showEmployeesWithDetails() {
        AtomicInteger number = new AtomicInteger(1);
        employees.forEach(employee -> {
            System.out.println(number + ". " + employee.getName() + " " + employee.getSurname() + " \n" + employee.getSalary() + " \n" + employee.getEmail() + " \n" + employee.getPhoneNumber() + " \n" + employee.getComputer().getName());
            number.getAndIncrement();
        });
    }

    private void giveRaise() {
        showEmployees();
        System.out.println("Podaj numer pracownika do podwyżki: ");
        int employeeNumber = scanner.nextInt()-1;
        System.out.println("Podaj o ile podwyżki: ");
        int raise = scanner.nextInt();
        employees.get(employeeNumber).setSalary(employees.get(employeeNumber).raiseSalaryByAmount(raise));
    }
    private void givePercentageRaise(){
        showEmployees();
        System.out.println("Podaj numer pracownika do podwyżki: ");
        int employeeNumber = scanner.nextInt()-1;
        System.out.println("Podaj o ile podwyżki: ");
        int raise = scanner.nextInt();
        employees.get(employeeNumber).setSalary(employees.get(employeeNumber).raiseSalaryByPercent(raise));
    }

}
