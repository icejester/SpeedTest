package org.jrm.persistence;

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
