.. java:import:: java.util HashMap

.. java:import:: java.util Map

DynamicRepositoryEntityMap
==========================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class DynamicRepositoryEntityMap

Fields
------
map
^^^

.. java:field:: protected Map<Class<? extends RepositoryObject>, DynamicRepositoryEntity<? extends RepositoryObject>> map
   :outertype: DynamicRepositoryEntityMap

Constructors
------------
DynamicRepositoryEntityMap
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DynamicRepositoryEntityMap()
   :outertype: DynamicRepositoryEntityMap

Methods
-------
containsKey
^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean containsKey(Class<T> c)
   :outertype: DynamicRepositoryEntityMap

get
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> DynamicRepositoryEntity<T> get(Class<T> c)
   :outertype: DynamicRepositoryEntityMap

put
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> DynamicRepositoryEntity<T> put(Class<? extends T> c, DynamicRepositoryEntity<T> o)
   :outertype: DynamicRepositoryEntityMap

