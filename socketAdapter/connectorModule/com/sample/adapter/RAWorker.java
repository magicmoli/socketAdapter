package com.sample.adapter;

import javax.resource.spi.ActivationSpec;
import javax.resource.spi.UnavailableException;
import javax.resource.spi.endpoint.MessageEndpoint;
import javax.resource.spi.endpoint.MessageEndpointFactory;

public class RAWorker  implements javax.resource.spi.work.Work {


    private ActivationSpec _spec;
    private MessageEndpoint _mep;
    private MessageEndpointFactory _mef;
    private RAConnection _conn;
    private boolean ok = true;

    public RAWorker(ActivationSpec spec, MessageEndpointFactory _mef,RAConnection con) {
        // Hold these references for this Work instance
        _spec = spec;
        _mef = _mef;
        _conn = con;
    }

    public void run() {
        while (ok) {
            // Connection receives the trade messages
            RAMessage msg = _conn.receive();
            // Invoke the message endpoint(MDB)'s onMessage
            // for processing a trade message
            if (msg != null) {
                try {
                    _mep = _mef.createEndpoint(null);
                    if (_mep instanceof RAMessageListener) {
                        ((RAMessageListener) _mep).onMessage(msg);
                    }
                } catch (UnavailableException e) {
                    e.printStackTrace();
                }
               
            }
        }
    }

    public void release() {
    }

}
