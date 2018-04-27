import java.math.BigDecimal;
import java.util.Random;



public class PiDurchZufall {
    BigDecimal pi = new BigDecimal(0);
    public static final int size = Integer.MAX_VALUE-1;
    public static final long tropfen = Long.MAX_VALUE-1;
    
    long inCircle = 0;
    long outCircle = 0;
   
    
    void regnen(){
        for (long i = 1; i <= tropfen; i++) {
            new Thr().start();
            if(i%10000 == 0){
            	System.out.println("Nach " + (inCircle+outCircle)+ " Tropfen: " + new BigDecimal(4*((double)inCircle/(inCircle+outCircle))));  
            	System.gc();
            }
        }
        pi = new BigDecimal(4*((double)inCircle/tropfen));
        System.out.println(pi);
    }
    
    public static void main(String[] args) {
        new PiDurchZufall().regnen();
    }
    
    private class Thr extends Thread{
    	
		@Override
    	public void run() {
    		super.run();
    		Random rn = new Random();
    		int x = rn.nextInt(size+1);
            int y = rn.nextInt(size+1);
            if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))>size){
                outCircle++;
            }else{
                inCircle++;
            }
    	}
    	
    }
 
}
