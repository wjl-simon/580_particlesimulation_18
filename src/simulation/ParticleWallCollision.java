package simulation;

public class ParticleWallCollision extends Collision{

    // thw wall involved for this particel-wall collison
    Wall wallInvolved;

    /**
     * Constructor
     * @param t the scheduled time for this collision
     * @param ps the particle invoving 
     * the collision
     */
    public ParticleWallCollision(Particle p, Wall w, double t)
    {   
        // the particle is only one but must be in an array
        super(t, new Particle[]{p});
        // the wall
        wallInvolved = w;
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