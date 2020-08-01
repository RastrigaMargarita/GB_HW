import java.util.Random;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


    public void printInfo() {
        System.out.println("name= '" + name + '\'' +
                ", position= '" + position + '\'' +
                ", email= '" + email + '\'' +
                ", phone= '" + phone + '\'' +
                ", salary= " + String.format("%d.00",salary) +
                ", age= " + age
                );
    }

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        String[] surnames = new String[]{"Ivanov", "Petrov", "Stepanov", "Vasilyev", "Veselkin"};
        String[] names = new String[]{"Ivan", "Petr", "Stepan", "Vasiliy", "Inokentiy"};
        String[] positions = new String[]{"Engeneer", "Accountant", "Programmer", "Director", "Marketer"};
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            String surname = surnames[random.nextInt(5)];
            String name = names[random.nextInt(5)];
            String position = positions[random.nextInt(5)];
            ;
            String email = surname + name.charAt(0) + "@ourcompany.com";
            String phone = String.format("+7(495)%d-%02d-%02d", random.nextInt(900)+100, random.nextInt(100), random.nextInt(100));
            int salary = random.nextInt(200) + 50;
            int age = random.nextInt(40) + 18;
            persArray[i] = new Employee(surname + " " + name, position, email, phone, salary, age);
        }

        for (Employee e : persArray
        ) {
            if (e.age > 40) {
                e.printInfo();
            }
        }

    }

}

