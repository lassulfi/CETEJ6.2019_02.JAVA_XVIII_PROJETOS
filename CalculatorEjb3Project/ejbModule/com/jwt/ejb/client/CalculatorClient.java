package com.jwt.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jwt.ejb.business.Calculator;
import com.jwt.ejb.client.utils.ScreenUtils;

public class CalculatorClient {
	
	private static final String LOOKUP_STRING = "CalculatorBean/remote";
	
	private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
	
	private static final String PROVIDER_URL = "jnp://localhost:1099";
	
	private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
	
	private static Context mInitialContext;

	public static void main(String[] args) {
		Calculator bean = doLookup();
		
		try {
			Double a = ScreenUtils.readNumber("Informe um número: ");
			Double b = ScreenUtils.readNumber("Informe outro número: ");
			
			Double sum = bean.add(a, b);
			
			ScreenUtils.displayResult("Resultado da soma: ", sum);
			ScreenUtils.closeScanner();			
		} catch (NumberFormatException e) {
			System.out.println("Um erro ocorreu: " + e.getMessage());
			System.out.println("Finalizando aplicação...");
		}
	}
	
	private static Calculator doLookup() {
		Context context = null;
		Calculator bean = null;
		
		try {
			context = getInitialContext();
			bean = (Calculator) context.lookup(LOOKUP_STRING);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return bean;
	}

	private static Context getInitialContext() throws NamingException {
		if (mInitialContext == null) {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			props.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
			props.put(Context.PROVIDER_URL, PROVIDER_URL);
			
			mInitialContext = new InitialContext(props);
		}
		
		return mInitialContext;
	}
}
