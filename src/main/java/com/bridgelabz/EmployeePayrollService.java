package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
    private List<EmployeePayrollData>employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData>employeePayrollList){
        this.employeePayrollList = employeePayrollList;
    }


    public static void main(String[] args) {
        ArrayList<EmployeePayrollData>employeePayrollList=new ArrayList<>();
        EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }
    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter the id");
        int id=consoleInputReader.nextInt();
        System.out.println("Enter the name");
        String name=consoleInputReader.next();
        System.out.println("Enter the salary");
        double salary=consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));
    }
    private void writeEmployeePayrollData(){
        System.out.println("\n Writing employee Payroll to console"+employeePayrollList);
    }

    public static class EmployeePayrollData {
        public int id;
        public String name;
        public double salary;
        public EmployeePayrollData(int id, String name, double salary) {
            this.id=id;
            this.name=name;
            this.salary=salary;
        }
        public String toString(){
            return "id=" +id+ ",name=" +name+ ",salary=" +salary;
        }
    }
}
