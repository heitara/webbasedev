package net.jforum.cache;

import java.util.Collection;

public class NoCacheEngine implements CacheEngine {

	@Override
	public void add(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String fqn, String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(String fqn, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String fqn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection getValues(String fqn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String fqn, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String fqn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
