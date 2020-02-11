package simulation;

public abstract class AbstractEvent implements Event {

    // the scheduled time time (in ticks) for the happening
    // of  this event
    private final double scheduleTime;

    /**
     * Constructor for AbstractEvent.
     * @param time specify the time (is in ticks) when this event 
     * will happen
     */
    public AbstractEvent(double time) {
        scheduleTime = time; 
    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        return scheduleTime;
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
