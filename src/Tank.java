public class Tank {

    static final String MODEL = "T34";
    static int ntanks;
    private int x = 0;
    private int y = 0;
    private int dir = 0;
    private int fuel = 100;
    private int n;

    Tank(int x, int y) {
        this(x, y, 100);
    }
    Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        if (fuel>=0) {
            this.fuel = fuel;
        } else {
            System.out.println("Irregular fuel value");
        }
        n = ++ntanks;
    }
    Tank() {
        this(0, 0, 100);
    }
    public void goForward(int i) {
        if (this.fuel>0 && this.fuel>=Math.abs(i)) {
            this.fuel = fuel - Math.abs(i);
        } else if (this.fuel>0 && this.fuel<Math.abs(i)) {
            i = i*fuel/Math.abs(i);
            this.fuel = this.fuel - this.fuel;
//            System.out.println("Fuel ran out");
        } else {
            this.fuel = 0;
            i = 0;
//            System.out.println("Fuel ran out");
        }
        if (dir == 0) x += i;
        else if (dir == 1) y += i;
        else if (dir == 2) x -= i;
        else y -= i;
    }

    public void printPosition() {
        System.out.println("The Tank " + MODEL + "-" + n + " is at " + x +", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }
}

