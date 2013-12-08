/**
 * 
 */
package de.clusteval.framework.repository;

import java.util.HashMap;
import java.util.Map;

//TODO: rename
public class RepositoryObjectEntityMap {

	protected Map<Class<? extends RepositoryObject>, RepositoryObjectEntity<? extends RepositoryObject>> map;

	/**
	 * 
	 */
	public RepositoryObjectEntityMap() {
		super();
		this.map = new HashMap<Class<? extends RepositoryObject>, RepositoryObjectEntity<? extends RepositoryObject>>();
	}

	@SuppressWarnings("unchecked")
	public <T extends RepositoryObject> RepositoryObjectEntity<T> put(
			final Class<? extends T> c, final RepositoryObjectEntity<T> o) {
		return (RepositoryObjectEntity<T>) this.map.put(c, o);
	}

	@SuppressWarnings("unchecked")
	public <T extends RepositoryObject> RepositoryObjectEntity<T> get(
			final Class<T> c) {
		Object o = this.map.get(c);
		if (o != null)
			return (RepositoryObjectEntity<T>) o;
		return null;
	}

	public <T extends RepositoryObject> boolean containsKey(final Class<T> c) {
		return this.map.containsKey(c);
	}
}