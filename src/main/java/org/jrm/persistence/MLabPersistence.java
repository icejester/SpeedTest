package org.jrm.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jrm.data.DownloadRecord;
import org.jrm.io.FileInput;

import java.util.Date;

public class MLabPersistence implements Persistence
{
    String connString;
    String db;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    private static MLabPersistence inst = null;
    private MLabPersistence ()
    {
        String connString;
        FileInput fi = new FileInput("./constring");
        connString = fi.readFile();

        mongoClient = MongoClients.create(connString);
        database = mongoClient.getDatabase("stats");
        collection = database.getCollection("SpeedTests");
    }

    public static MLabPersistence getInstance()
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
