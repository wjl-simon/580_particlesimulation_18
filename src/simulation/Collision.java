package simulation;

public abstract class Collision extends AbstractEvent{
    
    // an array of particle(s) that is(are) involved in this collision
    Particle[] particlesInvolved;
    // statistics of the hits of the involved particles when this Collision
    // event is created
    final int[] originalHits;


    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        super(t);
        particlesInvolved = ps;
        originalHits = new int[ps.length];

        for(int i = 0; i < ps.length; i++)
        {
            originalHits[i] = ps[i].collisions();
        }
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // None of the particles involved should have collided between the
        // creation and the happening of this Collision event

        for(int i = 0; i < originalHits.length; i++)
        {
            if(particlesInvolved[i].collisions() == originalHits[i])
                continue;
            else
                return false;
        }

        return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {

        return particlesInvolved;
    }
}
