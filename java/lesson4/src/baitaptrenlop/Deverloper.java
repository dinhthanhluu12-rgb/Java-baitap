package baitaptrenlop;

public class Deverloper extends Employee {
    private double overTimeHouse;

    public Deverloper(String id,String name,double baseSalary, double overTimeHouse){
        super(id,name,baseSalary);
        this.overTimeHouse = overTimeHouse;

        @Override
        public double getMonthLyInCome(){
            return getBasesalary() + overTimeHouse*200000;
        }
    }
}
