/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */


import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */


  



public class hotelTest {
    public static void main(String[] args){
		
        room CH = new room();
            new customer(CH).start();
            new customer(CH).start();
            new customer(CH).start();
            new customer(CH).start();
            new customer(CH).start();
           
       
            
             try { Thread.sleep(10000);
             } catch (InterruptedException e) {}
        

 
System.exit(0);
            
            
    }
}


class customer extends Thread{
    int Num;
    static int Number=0;
    private final room ro;
    public customer(room ro){
	super();
	this.ro=ro;
        Num=Number;
	Number++;
    }
    
    private void reserving(){
        
        try   
{  
 
int sleepTime = ThreadLocalRandom.current().nextInt(0, 500);  
System.out.println("customer " + (Num) + " reserve for " + sleepTime +"ms");  
Thread.sleep(sleepTime);  
}  
catch (Exception e)   
{  
e.printStackTrace(System.out);  
}  
}
    
    private void waitingList(){
        System.out.format("customer\t%d\tis waiting\n", Num);
        try { Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
    @Override
    public void run(){
        while(true){
            waitingList();
            ro.book();
            reserving();
            ro.release();
        }
    }
}







class room{
    private final boolean[] booking={false,false,false,false,false};
    public synchronized void release(){
	customer phi=(customer) Thread.currentThread();
	int Num=phi.Num;
	System.out.format("customer\t%d\t free left room\n", Num);
        System.out.format("customer\t%d\t free right room\n", Num);
	booking[Num]=false;
	booking[((Num+1)%5)]=false;
	notifyAll();
    }
    public synchronized void book(){
	customer cu=(customer) Thread.currentThread();
	int Num=cu.Num;
	while(booking[((Num+1)%5)] || booking[Num]){
            try {wait();} catch (InterruptedException e){}
        }
        System.out.format("customer\t%d\tbook left room\n", Num);
        System.out.format("customer\t%d\tbook right room\n", Num);
        booking[Num]=true;
        booking[((Num+1)%5)]=true;
    }
}

 


