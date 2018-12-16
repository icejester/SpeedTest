package org.jrm.persistence;

/**
 * Class representation for a persistence factory.
 * Returns a singleton of a persistence type
 * @author Jared Mallas
 * @version 2.0
 * @see Persistence
 * @see PersistenceType
 * @see MemoryPersistence
 * @see MLabPersistence
 *
 */
public class PersistenceFactory
{
    public PersistenceFactory()
    {

    }

    public Persistence getPersistence(PersistenceType type)
    {
        switch (type)
        {
            case MEMORY: return MemoryPersistence.getInstance();
            case MONGO: return MLabPersistence.getInstance();
            default: return null;
        }
    }
}
