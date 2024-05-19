import java.util.Random;

abstract class Gun {
    protected String modelName;
    protected int currentBullets;
    protected boolean isBroken;
    protected int remainingBullets;

    public Gun(String modelName) {
        this.modelName = modelName;
        this.currentBullets = 0;
        this.isBroken = false;
        this.remainingBullets = 0;
    }

    public abstract void manufacture(int productionQuantity);
    public abstract void calculateMaintenanceCost(double cost, int maintenanceInterval);
    public abstract void use(String target, int bullets);
    public abstract void repair();
    public abstract void reload(int bulletQuantity);

    public void sellLease(int quantity, boolean isLease, String customerInfo) {
        String transactionType = isLease ? "Аренда" : "Продажа";
        System.out.println(transactionType + " оружия: " + modelName + ", количество: " + quantity + ". Информация о клиенте: " + customerInfo);

        boolean creditCheck = checkCredit(customerInfo);
        if (!creditCheck) {
            System.out.println("Клиент " + customerInfo + " не прошел проверку кредитоспособности.");
            return;
        }

        boolean contractSigned = signContract(customerInfo, transactionType, quantity);
        if (!contractSigned) {
            System.out.println("Не удалось подписать договор с клиентом " + customerInfo);
            return;
        }

        System.out.println(transactionType + " оружия " + modelName + " завершена.");
    }

    protected boolean checkResourcesAvailability() {
        Random random = new Random();
        int availableMaterials = random.nextInt(2000);
        int requiredMaterials = random.nextInt(1000);
        return availableMaterials >= requiredMaterials;
    }

    protected int calculateProductionTime(int productionQuantity) {
        Random random = new Random();
        int productionTimePerUnit = random.nextInt(5) + 1;
        return productionQuantity * productionTimePerUnit;
    }

    protected double calculateWearCost(int maintenanceInterval) {
        Random random = new Random();
        double wearFactor = random.nextDouble() * 0.2;
        double baseWearCost = random.nextInt(200);
        return baseWearCost * wearFactor * maintenanceInterval;
    }

    protected double calculateSparePartsCost() {
        Random random = new Random();
        return random.nextInt(200);
    }

    protected boolean checkCredit(String customerInfo) {
        Random random = new Random();
        return random.nextBoolean();
    }

    protected boolean signContract(String customerInfo, String transactionType, int quantity) {
        Random random = new Random();
        return random.nextBoolean();
    }
}