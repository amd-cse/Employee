import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Employee {


    String EmployeeName;
    String EmployeeID;
    String Designation;
    long salary;
    long paidSalary;
    static long noEmps = 0;
    static Date lastPayDay;
    public Employee(String EmployeeName, String EmployeeID, String Designation, long salary) {
        this.EmployeeName = EmployeeName;
        this.EmployeeID = EmployeeID;
        this.Designation = Designation;
        this.salary = salary;
        String lastPayDayString = "01-01-1970";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            lastPayDay = sdf.parse(lastPayDayString);
        }
        catch (ParseException e) {
                e.printStackTrace();
        }
        noEmps++;
    }
    public static String generateID(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMDD");
        return sdf.format(new Date())+noEmps;
    }
    public static void addEmployee(ArrayList<Employee> employees){
        String name = getWhat("Name");
        String Salary = getWhat("Salary");
        String Designation = getWhat("Designation");
        String id = generateID();

        employees.add(new Employee(name, id, Designation, Long.parseLong(Salary)));
    }
    public static String getWhat(String a){
        return JOptionPane.showInputDialog("Enter " + a + ": ");
    }
    public static Employee search(ArrayList<Employee> employees){
        String name = getWhat("Name");
        for(Employee employee : employees){
            if(employee.EmployeeName.equals(name)){
                return employee;
            }
        }
        return null;
    }
    public void showDetails(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String message = "Employee Name: " + this.EmployeeName + "\nEmployee ID: " + this.EmployeeID;
        message += "\nDesignation: " + this.Designation + "\nSalary: " + this.salary;
        message += "\n Last Pay Date: " + sdf.format(this.lastPayDay);
        message += "\n Paid Salary: " + this.paidSalary;
        JOptionPane.showMessageDialog(null, message);
    }
    public static void payDay(ArrayList<Employee> employees){
        for(Employee employee : employees){
            employee.paySalary();
        }
    }

    public void paySalary(){
        this.paidSalary += this.salary;
        lastPayDay = new Date();
    }


}
