/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gui;

import br.rems.ICalculadora;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author lassulfi
 */
public class CallEjb {
    
    public int fatOrb(int v) {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout", "5000");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts", "100:500:100:500");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts", "500:2000:50:100");
        
        return this.lookup(v);
    }
    
    public int fatHttp(int v) {
        Properties environment = new Properties();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "fish.payara.ejb.rest.client.RemoteEJBContextFactory");
        environment.put(Context.PROVIDER_URL, "http://localhost:8080/ejb-invoker");
        
        return this.lookup(v);
    }
    
    private int lookup(int v) {
        InitialContext ejbRemoteContext;
        try {
            ejbRemoteContext = new InitialContext();
        } catch (NamingException nex) {
            return -1;
        }
        
        ICalculadora beanRemote;
        try {
            beanRemote = (ICalculadora) ejbRemoteContext.lookup("java:global/Pratica3-1-0-SNAPSHOT/EJBCalculadora");
            int x = beanRemote.fatorial(v);
            return x;
        } catch (NamingException nex) {
            return -2;
        }
    }
}
