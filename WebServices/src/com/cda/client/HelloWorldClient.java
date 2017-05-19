package com.cda.client;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.cda.service.HelloWorld;

public class HelloWorldClient{
	
	private static final String WS_URL = "http://10.51.0.200:1234/service/hello?wsdl";
		
	public static void main(String[] args) throws Exception {
	   
		URL url = new URL(WS_URL);
        QName qname = new QName("http://service.cda.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);
        
        /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("fircosoft"));
        headers.put("Password", Collections.singletonList("fircosoft"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
        
        System.out.println(hello.getHelloWorldAsString("Jhonny"));
       
    }

}
