package raftus;

import java.util.LinkedList;
import java.util.List;

public class SeederStore  {

    private String streamName = "";
    private String endpoint = "";
    private List<String> watching = new LinkedList();

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    //TODO methods for watching list
}