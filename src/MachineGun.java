import java.util.Random;

class MachineGun extends Gun {
    public MachineGun(String modelName) {
        super(modelName);
    }

    @Override
    public void manufacture(int productionQuantity) {
        System.out.println("Начало производства пулемета: " + modelName + ". Количество: " + productionQuantity);

        boolean resourcesAvailable = checkResourcesAvailability();
        if (!resourcesAvailable) {
            System.out.println("Недостаточно ресурсов для производства пулемета " + modelName);
            return;
        }

        int productionTime = calculateProductionTime(productionQuantity);
        System.out.println("Время производства пулемета " + modelName + ": " + productionTime + " часов.");

        System.out.println("Производство пулемета " + modelName + " завершено.");
    }

    @Override
    public void calculateMaintenanceCost(double cost, int maintenanceInterval) {
        System.out.println("Расчет затрат на обслуживание оружия: " + modelName + ". Затраты: " + cost + ". Интервал обслуживания: " + maintenanceInterval + " месяцев.");

        double wearCost = calculateWearCost(maintenanceInterval);
        cost += wearCost;

        double sparePartsCost = calculateSparePartsCost();
        cost += sparePartsCost;

        System.out.println("Общие затраты на обслуживание оружия " + modelName + ": " + cost);
        System.out.println("Расчет затрат на обслуживание оружия " + modelName + " завершен.");
    }

    @Override
    public void use(String target, int bullets) {
        System.out.println("Использование пулемета: " + modelName + ". Цель: " + target);

        Random random = new Random();
        double accuracy = random.nextDouble() * 0.5 + 0.5;

        System.out.println("Точность пулемета " + modelName + ": " + accuracy);

        int remainingBulletsValue = remainingBullets - 1;
        remainingBullets = remainingBulletsValue;

        System.out.println("Осталось патронов: " + remainingBulletsValue);
        System.out.println("Использование пулемета " + modelName + " завершено.");
    }

    @Override
    public void repair() {
        System.out.println("Ремонт оружия: " + modelName);

        Random random = new Random();
        boolean isFixed = random.nextBoolean();

        if (!isFixed) {
            System.out.println("Не удалось отремонтировать оружие " + modelName);
            return;
        }

        isBroken = false;

        System.out.println("Ремонт оружия " + modelName + " завершен.");
    }

    @Override
    public void reload(int bulletQuantity) {
        System.out.println("Перезарядка оружия: " + modelName + ". Количество патронов: " + bulletQuantity);

        currentBullets += bulletQuantity;
        remainingBullets = currentBullets;

        System.out.println("Перезарядка оружия " + modelName + " завершена.");
    }
}