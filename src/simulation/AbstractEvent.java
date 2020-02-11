package simulation;

public abstract class AbstractEvent implements Event {

    private final double scheduledTime;

    /**
     * Constructor for AbstractEvent.
     */
    public AbstractEvent(double time) {
        // TODO implement the constructor
        scheduledTime = time; 
    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        // TODO implement this method
        return scheduledTime;
    }

    /**
     * Compares this object with the specified Event.
     */
    @Override
    public int compareTo(Event that) {
        if(this.time() > that.time())
        {
            return 1;
        }
        else if(this.time() < that.time())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
