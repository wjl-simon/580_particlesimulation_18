package simulation;

public class TwoParticleCollision extends Collision{


    /**
     * Constructor
     * @param t the scheduled time for this collision
     * @param ps the particle invoving 
     * the collision
     */
    public TwoParticleCollision(Particle p1, Particle p2, double t)
    {   
        // the particle is only one but must be in an array
        super(t, new Particle[]{p1, p2});
        // the wall
    }


    /**
     * Making this particel-wall collision happen
     * @param h is the activity that will occur when this event
     * happens
     */
    @Override
    public void happen(ParticleEventHandler h)
    {
        h.reactTo(this);
    }
}