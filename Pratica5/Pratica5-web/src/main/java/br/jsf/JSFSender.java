/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author lassulfi
 */
@Named(value = "jSFSender")
@RequestScoped
public class JSFSender {

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/AulaMD")
    private Queue queue;
    
    private String text;
    
    /**
     * Creates a new instance of JSFSender
     */
    public JSFSender() {
    }
    
    public void send() {
        try {
            JMSContext context = connectionFactory.createContext();
            context.createProducer().send(queue, this.text);
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
