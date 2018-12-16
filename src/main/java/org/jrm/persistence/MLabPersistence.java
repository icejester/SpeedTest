package org.jrm.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jrm.data.DownloadRecord;
import org.jrm.io.FileInput;

import java.util.Date;

/**
 * Class model for a MongoDB implementation of persistence
 * @author Jared Mallas
 * @version 1.0
 * @see org.jrm.persistence.Persistence
 */
public class MLabPersistence implements Persistence
{
    String connString;
    String db;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private static MLabPersistence inst = null;
    private MLabPersistence ()
    {
        String connString;
        // TODO: Figure out how to best inject this
        FileInput fi = new FileInput("./constring");
        connString = fi.readFile();

        mongoClient = MongoClients.create(connString);
        database = mongoClient.getDatabase("stats");
        collection = database.getCollection("SpeedTests");
    }

    static MLabPersistence getInstance()
    {
        synchronized (MemoryPersistence.class)
        {
            if (inst == null)
            {
                inst = new MLabPersistence();
            }
        }
        return inst;
    }

    @Override
    public void setRecord(Date testStartTime, Date testEndTime, Float downloadRate)
    {
        Document doc = new Document("startDate", testStartTime.toString())
                .append("endDate", testEndTime.toString())
                .append("rate", downloadRate.toString());
        collection.insertOne(doc);
    }

    @Override
    public DownloadRecord getRecord() {
        return null;
    }
}
