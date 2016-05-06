package com.mahubet.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.mahubet.services.Card;
import com.mahubet.services.Login;
import com.mahubet.services.Purchase;

public class CardApp extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public CardApp() {
		singletons.add(new Login());
		singletons.add(new Card());
		singletons.add(new Purchase());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
