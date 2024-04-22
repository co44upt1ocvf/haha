public class Main {

    public static void main(String[] args) {
        Gun guns = new Gun("M249", 10); //создание экземпляра класса
        guns.manufactureMachineGun(); // вызов функций
        guns.sellMachineGun();
        guns.calculateMaintenanceCost();
        guns.manufactureCustomGun();
        guns.reloadGun();
        guns.repairGun();
        guns.sellLeaseGun();
        guns.useHandgun();

        System.out.println("\nИзвините, но это реально плохо...");
    }
}