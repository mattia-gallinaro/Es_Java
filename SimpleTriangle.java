public class SimpleTriangle{
    
    public SimpleTriangle(int a, int b, int c){
        x = a; 
        y = b; 
        z = c;
    }

    public double area(){
        int semi_p = (x+ y+ z) / 2;
        return Math.sqrt(semi_p * (semi_p-x) * (semi_p - y) * (semi_p - z));
    }

    public int perimeter(){
        return x + y + z;
    }

    public String toString(){
        return "SimpleTriangle "+ x +" " + y +" "+ z +" ";
    }
    int x;
    int y;
    int z;

}