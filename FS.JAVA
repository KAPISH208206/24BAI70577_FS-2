import java.util.Scanner;

class Employee {
    private String name;
    private double basicSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary > 0) {
            this.basicSalary = basicSalary;
        }
    }

    public double calculateSalary() {
        return basicSalary;
    }
}

class PermanentEmployee extends Employee {
    @Override
    public double calculateSalary() {
        double bonus = getBasicSalary() * 0.20;
        return getBasicSalary() + bonus;
    }
}

class ContractEmployee extends Employee {
    @Override
    public double calculateSalary() {
        double bonus = getBasicSalary() * 0.10;
        return getBasicSalary() + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String type = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            double salary = sc.nextDouble();
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Employee emp;
            if (type.equalsIgnoreCase("P")) {
                emp = new PermanentEmployee();
            } else {
                emp = new ContractEmployee();
            }

            emp.setName(name);
            emp.setBasicSalary(salary);

            System.out.println("Employee: " + emp.getName());
            System.out.printf("Final Salary: %.2f\n", emp.calculateSalary());
        }

        sc.close();
    }
}