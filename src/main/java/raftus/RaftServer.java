package raftus;


import io.atomix.AtomixClient;
import io.atomix.AtomixReplica;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.Client;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.cluster.Node;
import io.atomix.cluster.discovery.BootstrapDiscoveryProvider;
import io.atomix.copycat.client.CopycatClient;
import io.atomix.copycat.server.CopycatServer;
import io.atomix.copycat.server.storage.Storage;
import io.atomix.copycat.server.storage.StorageLevel;
import io.atomix.core.Atomix;
import io.atomix.core.AtomixBuilder;
import io.atomix.core.map.DistributedMap;
import io.atomix.core.map.DistributedMapBuilder;
import io.atomix.core.map.impl.AtomicMapClient;
import io.atomix.core.profile.Profile;
import io.atomix.protocols.backup.partition.PrimaryBackupPartitionGroup;
import io.atomix.protocols.raft.MultiRaftProtocol;
import io.atomix.protocols.raft.ReadConsistency;
import io.atomix.protocols.raft.partition.RaftPartitionGroup;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class RaftServer{


    public static void main(String[] args) {

//        AtomixBuilder builder = Atomix.builder();
//
//        builder.withMembershipProvider(BootstrapDiscoveryProvider.builder()
//                .withNodes(
//                        Node.builder()
//                                .withId("member1")
//                                .withAddress("10.192.19.181")
//                                .build(),
//                        Node.builder()
//                                .withId("member2")
//                                .withAddress("10.192.19.182")
//                                .build(),
//                        Node.builder()
//                                .withId("member3")
//                                .withAddress("10.192.19.183")
//                                .build())
//                .build());
//
//
//        AtomixBuilder atomix = AtomixBuilder
//                .withMemberId("client1")
//                .withAddress("10.192.19.180:6000")
//                .withMembershipProvider(BootstrapDiscoveryProvider.builder()
//                        .withNodes(
//                                Node.builder()
//                                        .withId("member1")
//                                        .withAddress("10.192.19.181:5000")
//                                        .build(),
//                                Node.builder()
//                                        .withId("member2")
//                                        .withAddress("10.192.19.182:5000")
//                                        .build(),
//                                Node.builder()
//                                        .withId("member3")
//                                        .withAddress("10.192.19.183:5000")
//                                        .build())
//                        .build());
//
//        DistributedMap<Object, Object> map = atomix.mapBuilder("my-map")
//                .withCacheEnabled()
//                .build();
//
//        map.put("foo", "Hello world!");
//
//        String value = map.get("foo");
//
//        if (map.replace("foo", value, "Hello world again!")) {
//  ...
//        }
    }
}