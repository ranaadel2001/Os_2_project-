/**
 *
 * @author User
 */
import java.util.concurrent.ThreadLocalRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
class Philosopher extends Thread{
    int Num;
    static int Number=0;
    private final Chopstick Chop;
    public Philosopher(Chopstick Chop){
	super();
	this.Chop=Chop;
        Num=Number;
	Number++;
    }
    
    private void eating(){
        
        try   
{  
//determines the pseudorandom number between 0 to 1000 that represents the sleep time in milli seconds  
int sleepTime = ThreadLocalRandom.current().nextInt(0, 500);  
System.out.println("Philosopher " + (Num) + " eats for " + sleepTime +"ms"); //sleeps the thread for a specified time  
Thread.sleep(sleepTime);  
}  
catch (Exception e)   
{  
e.printStackTrace(System.out);  
}  
}// end of eat() method  
        
      //  System.out.format("Philosopher\t%d\tis Eating\n", Num);
       // try {Thread.sleep(500);
       // } catch (InterruptedException e) {}
    
    private void thinking(){
        System.out.format("Philosopher\t%d\tis Thinking\n", Num);
        try { Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
    @Override
    public void run(){
        while(true){
            thinking();
            Chop.take();
            eating();
            Chop.release();
        }
    }
}
