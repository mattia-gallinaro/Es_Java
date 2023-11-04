public class SimpleCar{

    public SimpleCar(){
        speed = 0;
        gear = 0;
    }

    public void speedUp(){
        if(gear == 0){
            return;
        }
        else if(speed == 0){
            speed = INITIAL_SPEED;
        }else{
            speed = speed * SPEED_INCREMENT_PERCENT;
        }
    }
    public void brake(){
        if(speed <= 5){
            speed = 0;
        }else {
            speed = speed * SPEED_DECREMENT_PERCENT;
        }
    }

    public void gearUp(){
        if(gear < MAX_GEAR){
            gear++;
        }
    }

    public void gearDown(){
        if(gear > MIN_GEAR){
            gear--;
        }
    }

    public String toString() {
        return "SimpleCar: marcia = "+ gear +", velocita' = "+speed +" km/h";
    }

    public final static double INITIAL_SPEED = 10;
    public final static int MAX_GEAR = 6;
    public final static int MIN_GEAR = 0;
    public final static double SPEED_INCREMENT_PERCENT = 1.50;
    public final static double SPEED_DECREMENT_PERCENT = 0.70;
    private double speed;
    private int gear;
}