package baitaptrenlop;

public class Employee {

    private String id;
    private String name;
    private double baseSalary;

    public Employee(String id,String name, double baseSalary){
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getMonthLyInCome(){
        return baseSalary;
    }
}
