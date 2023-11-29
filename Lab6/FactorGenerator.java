public class FactorGenerator{
	public FactorGenerator(int x){
		if(num <= 1){
			throw new IllegalArgumentException();
		}else{
			num = x;
			last_factor = 0;
			num_fact = getFactors();  
		}
	}
	
	private int getFactors(){
		int tmp = num + 0; 
		int tot = 0;
		for(int i = 2; i*i < tmp; i++){
			if(isPrime(i)){
			 while(tmp % i == 0){
		 			tot += 1;
		 			tmp /= i;
		 		}	
			}
		}
		return tot; 
	}
	
	private boolean isPrime(int x){
		for(int i = 2; i <= x/2 ; i++){
			if(x % i == 0){
				return false;
			}
		}
		return true;
	}
	public int nextFactor(){
		if(last_factor < num_fact){
			int tmp = num + 0;
			int tot = 0;
			for(int i = 2; i*i < tmp; i++){
				if(isPrime(i)){
			 		while(tmp % i == 0){
			 			if(tot == last_factor){
			 				last_factor++;
			 				return i;
			 			}
		 				tot += 1;
		 				tmp /= i;
		 			}	
				}
			}
		}else{
			throw new IllegalStateException();
		}
	}
	
	public boolean hasNextFactor(){
		return last_factor + 1 <  num_fact;
	}
	private int num;
	private int last_factor;
	private int num_fact;	
}
