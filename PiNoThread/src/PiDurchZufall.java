import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class PiDurchZufall {
    BigDecimal pi = new BigDecimal(0);
    public static final long size = Long.MAX_VALUE-1;
    public static final long tropfen = Long.MAX_VALUE-1;
    
    long inCircle = 0;
    long outCircle = 0;
    /*
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    
   	PiDurchZufall(){
	   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	   
	   JScrollPane scroll = new JScrollPane(panel);
	   scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.getContentPane().add(scroll);
	   frame.setSize(800, 800);
	   frame.setVisible(true);
   }*/
    
    void regnen(){
        for (long i = 1; i <= tropfen; i++) {
            
        	//new Thr().start();
        	start();
            
            if(i%100000000 == 0){ //100.000.000
            	System.out.println("Nach " + (inCircle+outCircle)+ " Tropfen: " + new BigDecimal(4*((double)inCircle/(inCircle+outCircle))));  
            	//System.gc();
            }
        }
        pi = new BigDecimal(4*((double)inCircle/tropfen));
        System.out.println(""+pi);
    }
    
    /*void print(String str){ 	
    	panel.add(new JTextField(str));
    	frame.validate();
    }*/
    
    void start() {
    	long x = ThreadLocalRandom.current().nextLong(size+1);
        long y = ThreadLocalRandom.current().nextLong(size+1);
        if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))>size){
            outCircle++;
        }else{
            inCircle++;
        }
    }
    
    public static void main(String[] args) {
        new PiDurchZufall().regnen();
    }
    
    
    private class Thr extends Thread{
    	
		@Override
    	public void run() {
    		super.run();
    		long x = ThreadLocalRandom.current().nextLong(size+1);
            long y = ThreadLocalRandom.current().nextLong(size+1);
            if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))>size){
                outCircle++;
            }else{
                inCircle++;
            }
    	}
    	
    }
 
}
