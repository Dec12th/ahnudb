package cn.ahnu.edu.ahnudb;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import cn.ahnu.edu.ahnudb.message.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 对请求做相应处理
 * Created by sunyong on 2017/7/17.
 */
public class AhnuDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final Map<String,Object> map = new HashMap<String,Object>();

    private AhnuDb(){
        receive(ReceiveBuilder
                .match(SetRequest.class, message->{
                    log.info("Received SetRequest:{}",message);
                    map.put(message.getKey(),message.getValue());
                })
                .matchAny(o->
                    log.info("Received unknown message:{}",o)
                )
                .build()
        );
    }
}
