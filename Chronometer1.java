public class Chronometer1
{
    public Chronometer1(){
        start_time = 0;
        stop_time = 0;
    }
    public void start(){
        start_time = System.currentTimeMillis();
        //System.out.println(start_time);
        stop_time = 0;
    }

    public  String getElapsedTime(){
        //System.out.println((stop_time - start_time));
        return ""+ ((stop_time - start_time) / 1000.0) +"";
    }

    public  boolean isRunning(){
        return start_time != 0 && stop_time == 0;
    }

    public  void stop(){
        if(isRunning()){
            stop_time = System.currentTimeMillis();
        };
    }

    public  String toString(){
        if(start_time == 0){
            return "Chronometer off     time = 0.0";
        }else if(start_time != 0 && stop_time == 0){
            return "Chronometer running time = 0.0";
        }else{
            return "Chronometer ready   time = " + getElapsedTime() + " s";
        }
    }

    public  void reset(){
        if(stop_time != 0){
            start_time = 0;
            stop_time = 0;
        }else{
            start_time = System.currentTimeMillis();
            stop_time = 0;
        }
    }

    private long start_time;
    private long stop_time;
}