package simulation;

public class Tick extends AbstractEvent
{
    /**
     * Constrcutor
     * @param time specifies the time (in ticks) for this tick
     */
    public Tick(double time)
    {
        super(time);
    }

    /**
     * A tick is always valid
     */
    @Override
    public boolean isValid()
    {
        return true;
    }

    /**
     * Making this event happen
     * @param h is the activity that will occur when this event
     * happens
     */
    @Override
    public void happen(ParticleEventHandler h)
    {
        h.reactTo(this);
    }
}