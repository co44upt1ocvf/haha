import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип оружия (MachineGun или Handgun):");
        String gunType = scanner.nextLine();

        System.out.println("Введите название оружия:");
        String modelName = scanner.nextLine();

        Gun gun = createGun(gunType, modelName);
        if (gun == null) {
            System.out.println("Неверный тип оружия.");
            return;
        }

        switch (gunType) {
            case "MachineGun":
                displayMachineGunOptions((MachineGun) gun);
                break;
            case "Handgun":
                displayHandgunOptions((Handgun) gun);
                break;
            default:
                System.out.println("Выберите допустимый тип оружия.");
        }
    }

    public static Gun createGun(String gunType, String modelName) {
        try {
            Class<?> gunClass = Class.forName(gunType);
            return (Gun) gunClass.getConstructor(String.class).newInstance(modelName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void displayMachineGunOptions(MachineGun machineGun) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Производство");
            System.out.println("2. Расчет затрат на обслуживание");
            System.out.println("3. Продажа/Аренда");
            System.out.println("4. Использование");
            System.out.println("5. Перезарядка");
            System.out.println("6. Ремонт");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    machineGun.manufacture(100);
                    break;
                case 2:
                    machineGun.calculateMaintenanceCost(1000.0, 6);
                    break;
                case 3:
                    machineGun.sellLease(50, false, "Customer A");
                    break;
                case 4:
                    machineGun.use("Target 1", 30);
                    break;
                case 5:
                    machineGun.reload(50);
                    break;
                case 6:
                    machineGun.repair();
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 0);
    }

    public static void displayHandgunOptions(Handgun handgun) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Расчет затрат на обслуживание");
            System.out.println("2. Продажа/Аренда");
            System.out.println("3. Использование");
            System.out.println("4. Перезарядка");
            System.out.println("5. Ремонт");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handgun.calculateMaintenanceCost(200.0, 12);
                    break;
                case 2:
                    handgun.sellLease(10, true, "Customer B");
                    break;
                case 3:
                    handgun.use("Target 2", 10);
                    break;
                case 4:
                    handgun.reload(20);
                    break;
                case 5:
                    handgun.repair();
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 0);
    }
}