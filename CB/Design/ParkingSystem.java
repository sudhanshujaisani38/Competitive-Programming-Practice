public class ParkingSystem {
    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.small = small;
        this.medium = medium;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big == 0)
                    return false;
                else
                    big--;
                return true;
            case 2:
                if (medium == 0)
                    return false;
                else
                    medium--;
                return true;
            case 3:
                if (small == 0)
                    return false;
                else
                    small--;
                return true;
            default:
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */