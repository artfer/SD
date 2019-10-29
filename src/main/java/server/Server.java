package server;

import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;


public class Server {
    public static void main(String args[])  {

        try {
            MongoClient mongoClient = new MongoClient();
            
            MongoDatabase database = ( mongoClient.getDatabase("Project_Octopus"));
            for (String coll : database.listCollectionNames()){
                System.out.println(coll);
            }







            //DBCollection collection = database.getCollection("TheCollectionName");

        } catch (Exception e) {
            System.out.println(e.toString());
        }




    }

}
