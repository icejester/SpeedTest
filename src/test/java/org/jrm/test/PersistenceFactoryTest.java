package org.jrm.test;

import org.jrm.persistence.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceFactoryTest {

    Persistence persistenceLayer1, persistenceLayer2;
    PersistenceFactory factory;

    @BeforeEach
    void setUp()
    {
        factory = new PersistenceFactory();
        persistenceLayer2 = factory.getPersistence(PersistenceType.MONGO);
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Persistence layer should be of type MEMORY")
    @Test
    void getMemoryPersistence()
    {
        assertTrue(factory.getPersistence(PersistenceType.MEMORY) instanceof MemoryPersistence);
    }

    @DisplayName("Persistence layer should be of type MONGO")
    @Test
    void getDBPersistence()
    {
        assertTrue(factory.getPersistence(PersistenceType.MONGO) instanceof MLabPersistence);
    }
}