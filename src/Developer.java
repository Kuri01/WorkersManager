import Computers.AbstractComputer;

import java.util.ArrayList;

public class Developer extends Employee{
    private String mainLanguage;
    private ArrayList<String> knownLanguages;

    public Developer(String name, String surname, int salary, String email, int phoneNumber, String mainLanguage, ArrayList<String> knownLanguages, AbstractComputer computer) {
        super(name, surname, salary, email, phoneNumber, computer);
        this.mainLanguage = mainLanguage;
        this.knownLanguages = knownLanguages;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public ArrayList<String> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(ArrayList<String> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    public void addKnownLanuages(String language){
        knownLanguages.add(language);
    }
    public void addKnownLanuages(ArrayList<String> languages){
        knownLanguages.addAll(languages);
    }
    public String toString(){
        return "Developer{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", salary=" + getSalary() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", mainLanguage='" + mainLanguage + '\'' +
                ", knownLanguages=" + knownLanguages +
                ", computer=" + getComputer() +
                '}';
    }
}
