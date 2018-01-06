/**
 * Created by Toufik on 5/16/2016.
 */
import java.util.Random;

/**
 * Created by Toufik on 5/16/2016.
 */
class Queue
{
    int q[];
    int Maxlength;
    int length;
    int front;
    int rare;
    Boolean valueSet = false;
    Queue(int i)
    {
        Maxlength = i;
        front = rare = 0;
        length = 0;
        q = new int[i];
    }
    synchronized int get() throws InterruptedException {
        if(!valueSet || q.length==0)
        {
            try {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println ( "Interrupted Exception" );
            }

        }
        valueSet = false;
        int k = front;
        front = (front+1)%Maxlength;
        length--;
        notifyAll();
        return q[k];
    }
    synchronized void put(int n) {
        if(length==Maxlength || valueSet == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        q[rare%Maxlength] = n;
        rare = (rare+1)%Maxlength;
        length++;
        valueSet = true;
        System.out.println(" Puts: " + n);
        notifyAll();
    }

}

class ProducerC implements Runnable {
    Queue q;
    String Name;
    ProducerC(Queue q,String name) {
        this.q = q;
        Name = name;
        new Thread(this,Name).start();
    }

    public void run() {
        while(true) {

            try {
                Random r = new Random ();
                //System.out.print (Name);
                q.put(r.nextInt (100));
                Thread.sleep(250);
            } catch(InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}

class ConsumerC implements Runnable {
    Queue q;
    String Name;
    ConsumerC(Queue q,String name) {
        this.q = q;
        Name = name;
        new Thread(this, Name).start();
    }

    public void run() {
        while(true) {
            try {
                System.out.println ( Name + " gets " + q.get ());
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Queue q = new Queue(10);
        Thread.sleep (1000);
        new ProducerC(q,"Producer 1");
        new ProducerC(q,"Producer 2");
        new ConsumerC(q,"Consumer 1");
        new ConsumerC(q,"Consumer 2");
        System.out.println("Press Control-C to stop.");
    }

}

