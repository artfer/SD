package raftus;


import com.alipay.sofa.jraft.Node;
import com.alipay.sofa.jraft.RaftServiceFactory;
import com.alipay.sofa.jraft.conf.Configuration;
import com.alipay.sofa.jraft.entity.PeerId;
import com.alipay.sofa.jraft.option.NodeOptions;
import com.alipay.sofa.jraft.util.Endpoint;

public class RaftServer {


    Node node = new Node();
    RaftServiceFactory raftServiceFactory = new RaftServiceFactory();


    RaftServer(final NodeOptions nodeOptions){

    }

    public static void main(String[] args) {
        Endpoint addr = new Endpoint("localhost", 8080);
        Configuration conf = new Configuration();

        for(int i=8080; i < 8090; i++) {
            conf.addPeer(new PeerId("localhost", i));
        }

        System.out.println(conf.getPeers().toString());

        final Node node = new Node();
        node.start();
   }



}
