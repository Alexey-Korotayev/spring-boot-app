package com.epam.springbootapp.services;

import javax.ws.rs.core.Response;

import com.epam.springbootapp.services.responce.ResponseCreator;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import com.epam.springbootapp.services.exceptions.Error;

import java.util.List;
import java.util.Map;

public class PreInvokeHandler implements RequestHandler {

    // just for test
    int count = 0;

    private boolean validate(String ss_id) {
        // just for test
        // needs to implement
        count++;
        System.out.println("SessionID: " + ss_id);
        if (count == 1) {
            return false;
        } else {
            return true;
        }
    }

    public Response handleRequest(Message message, ClassResourceInfo arg1) {
        Map<String, List<String>> headers = CastUtils.cast((Map<?, ?>) message
                .get(Message.PROTOCOL_HEADERS));

        if (headers.get("ss_id") != null && validate(headers.get("ss_id").get(0))) {
            // let request to continue
            return null;
        } else {
            // authentication failed, request the authentication, add the realm
            return ResponseCreator.error(401, Error.NOT_AUTHORIZED.getCode(),Error.NOT_AUTHORIZED.getDescription(), headers.get("version").get(0));
        }

    }

}
