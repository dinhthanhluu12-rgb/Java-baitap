public class Student {
    private String StudenId;
    private String name;
    private int age;
    private Car car;

    public Student(String StudenId,String name,int age,Car car){
        this.StudenId = StudenId;
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getStudenId(){
        return StudenId;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Car getCar(){
        return car;
    }

    
}
