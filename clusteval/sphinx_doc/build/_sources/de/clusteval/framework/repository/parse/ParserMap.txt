.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.framework.repository RepositoryObject

ParserMap
=========

.. java:package:: de.clusteval.framework.repository.parse
   :noindex:

.. java:type:: public class ParserMap

Fields
------
map
^^^

.. java:field:: protected Map<Class<? extends RepositoryObject>, Parser<? extends RepositoryObject>> map
   :outertype: ParserMap

Constructors
------------
ParserMap
^^^^^^^^^

.. java:constructor:: public ParserMap()
   :outertype: ParserMap

Methods
-------
containsKey
^^^^^^^^^^^

.. java:method:: public <T extends RepositoryObject> boolean containsKey(Class<T> c)
   :outertype: ParserMap

get
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> Parser<T> get(Class<T> c)
   :outertype: ParserMap

put
^^^

.. java:method:: @SuppressWarnings public <T extends RepositoryObject> Parser<T> put(Class<T> c, Parser<T> o)
   :outertype: ParserMap

