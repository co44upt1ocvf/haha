import java.util.Random;

class Handgun extends Gun {
    public Handgun(String modelName) {
        super(modelName);
    }

    @Override
    public void manufacture(int productionQuantity) {
        System.out.println("Производство пистолета не требуется.");
    }

    @Override
    public void calculateMaintenanceCost(double cost, int maintenanceInterval) {
        System.out.println("Расчет затрат на обслуживание пистолета: " + modelName + ". Затраты: " + cost + ". Интервал обслуживания: " + maintenanceInterval + " месяцев.");

        double wearCost = calculateWearCost(maintenanceInterval);
        cost += wearCost;

        double sparePartsCost = calculateSparePartsCost();
        cost += sparePartsCost;

        System.out.println("Общие затраты на обслуживание пистолета " + modelName + ": " + cost);
        System.out.println("Расчет затрат на обслуживание пистолета " + modelName + " завершен.");
    }

    @Override
    public void use(String target, int bullets) {
        System.out.println("Использование пистолета: " + modelName + ". Цель: " + target);

        Random random = new Random();
        double accuracy = random.nextDouble() * 0.5 + 0.5;

        System.out.println("Точность пистолета " + modelName + ": " + accuracy);

        int remainingBulletsValue = remainingBullets - 1;
        remainingBullets = remainingBulletsValue;

        System.out.println("Осталось патронов: " + remainingBulletsValue);
        System.out.println("Использование пистолета " + modelName + " завершено.");
    }

    @Override
    public void repair() {
        System.out.println("Ремонт пистолета: " + modelName);

        Random random = new Random();
        boolean isFixed = random.nextBoolean();

        if (!isFixed) {
            System.out.println("Не удалось отремонтировать пистолет " + modelName);
            return;
        }

        isBroken = false;

        System.out.println("Ремонт пистолета " + modelName + " завершен.");
    }

    @Override
    public void reload(int bulletQuantity) {
        System.out.println("Перезарядка пистолета: " + modelName + ". Количество патронов: " + bulletQuantity);

        currentBullets += bulletQuantity;
        remainingBullets = currentBullets;

        System.out.println("Перезарядка пистолета " + modelName + " завершена.");
    }
}