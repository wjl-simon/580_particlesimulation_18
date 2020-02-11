package simulation;

public class Tick extends AbstractEvent
{
    /**
     * Constrcutor
     * @param time specifies the scheduled happen time
     */
    public Tick(double time)
    {
        // TODO
        super(time);

    }

    /**
     * 
     */
    @Override
    public boolean isValid()
    {
        // A tick is always valid
        return true;
    }

    @Override
    public void happen(ParticleEventHandler h)
    {
        h.reactTo(this);
    }
}