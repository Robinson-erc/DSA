package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 *
 * @author (sdb and PUT YOUR NAME HERE)
 * @version (2020)
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private boolean able;
    private int pages;
    private int size;

    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
        this.speed=speed;
        this.id=id;
        docs = new Queue<Doc>();
        able=true;
    }

    /** Add a document to this printer's queue
     Display the document and printer on stdout.
     */
    public void add (Doc doc)
    {

        docs.add(doc);
        this.size++;
        //////////// Do not change this println statement ///////////////
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     *
     */
    public void print()
    {
        if(!docs.isEmpty()){
            if(able){
                pages=docs.peek().size();
                able =false;
            }
            pages -= speed;

            if(pages <= 0){
                System.out.println("\tPrint completed on "+ id +": for "+ docs.remove());
                able=true;
            }
        }

    }

    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return this.size;  }

    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}
