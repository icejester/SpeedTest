package org.jrm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jrm.io.FileInput;

public class MongoMain
{
    public static void main(String[] args)
    {
        String cStr;
        FileInput fi = new FileInput("./constring");
        cStr = fi.readFile();
        System.out.println(cStr);

        MongoClient mongoClient = MongoClients.create(cStr);

        // get handle to "stats" database
        MongoDatabase database = mongoClient.getDatabase("stats");

        // get a handle to the "SpeedTests" collection
        MongoCollection<Document> collection = database.getCollection("SpeedTests");

        // make a document and insert it
        /*
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));
        // RESULTS IN //
        {
            "_id": {
            "$oid": "5c047cdd942f43a5aff1713e"
        },
            "name": "MongoDB",
                "type": "database",
                "count": 1,
                "info": {
            "x": 203,
                    "y": 102
        }
        }
        */

        Document doc = new Document("date", "Sat Dec 02 06:41:34 CST 2018").append("rate", "17.481482");
        collection.insertOne(doc);
        // RESULTS IN //
        /*
        * {
            "_id":
            {
              "$oid": "5c047fed942f43a5e14d5578"
            },
           "date": "Sat Dec 01 06:41:34 CST 2018",
           "rate": "17.481482"
          }
        */

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // release resources
        mongoClient.close();
    }
}
