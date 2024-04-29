import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    mainLoop(employees);

    }
    public static void mainLoop(ArrayList<Employee> employees) {
        execute(employees, get());
    }
    public static void execute(ArrayList<Employee> employees, int state) {

        switch (state) {
            case 0:
                Employee.addEmployee(employees);
                mainLoop(employees);
                break;
            case 1:
                Employee temp = Employee.search(employees);
                if(temp != null) {
                    temp.showDetails();
                }
                else {
                    showMessage("Employee not found");
                }
                mainLoop(employees);
                break;
            case 2:
                Employee.payDay(employees);
                mainLoop(employees);
                break;
            default:
                break;

        }
    }
    public static int get(){
        Object[] options = {"Add", "Search", "Pay Salary", "Exit"};
        return JOptionPane.showOptionDialog(null, "Choose an Option:", "Employee Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    public static void showMessage(String a){
        JOptionPane.showMessageDialog(null, a);
    }
}