public class Gun {
    private String modelName; // переменные
    private int quantity;

    public Gun(String modelName, int quantity) { // конструктор класса
        this.modelName = modelName;
        this.quantity = quantity;
    }

    public void manufactureMachineGun() {
        System.out.println("Производство пулемета: " + modelName);
    }

    public void sellMachineGun() {
        System.out.println("Продажа пулемета: " + modelName + ", количество: " + quantity);
    }

    public void calculateMaintenanceCost() {
        System.out.println("Расчет затрат на обслуживание оружия: " + modelName);
    }

    public void useHandgun() {
        System.out.println("Использование пистолета: " + modelName);
    }

    public void repairGun() {
        System.out.println("Ремонт оружия: " + modelName);
    }

    public void reloadGun() {
        System.out.println("Перезарядка оружия: " + modelName);
    }

    public void manufactureCustomGun() {
        System.out.println("Производство индивидуального оружия: " + modelName);
    }

    public void sellLeaseGun() {
        System.out.println("Продажа или аренда оружия: " + modelName + ", количество: " + quantity);
    }
}
