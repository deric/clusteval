.. java:import:: java.util HashMap

.. java:import:: java.util Map

StaticRepositoryEntityMap
=========================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class StaticRepositoryEntityMap

Fields
------
map
^^^

.. java:field:: protected Map<Class<? extends RepositoryObject>, StaticRepositoryEntity<? extends RepositoryObject>> map
   :outertype: StaticRepositoryEntityMap

Constructors
------------
StaticRepositoryEntityMap
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public StaticRepositoryEntityMap()
   :outertype: StaticRepositoryEntityMap

Methods
-------
containsKey
^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean containsKey(Class<T> c)
   :outertype: StaticRepositoryEntityMap

get
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> StaticRepositoryEntity<T> get(Class<T> c)
   :outertype: StaticRepositoryEntityMap

put
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> StaticRepositoryEntity<T> put(Class<? extends T> c, StaticRepositoryEntity<T> o)
   :outertype: StaticRepositoryEntityMap

