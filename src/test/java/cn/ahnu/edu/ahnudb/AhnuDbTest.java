package cn.ahnu.edu.ahnudb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import cn.ahnu.edu.ahnudb.message.SetRequest;
import org.junit.Test;

public class AhnuDbTest {

    ActorSystem system = ActorSystem.create();
    @Test
    public void testSetRequest() {
        TestActorRef<AhnuDb> actorRef = TestActorRef.create(system, Props.create(AhnuDb.class));
        actorRef.tell(new SetRequest("key","value"), ActorRef.noSender());
        AhnuDb ahnuDb = actorRef.underlyingActor();
        assertEquals(ahnuDb.map.get("key"),"value");
    }

}
