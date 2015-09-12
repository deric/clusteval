.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

NamedAttribute
==============

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class NamedAttribute<T> extends RepositoryObject

   This class is a wrapper for variables that should be shared throughout the whole framework and should be unambigiously identifiable by their name.

   :author: Christian Wiwie
   :param <T>:

Fields
------
name
^^^^

.. java:field:: protected String name
   :outertype: NamedAttribute

value
^^^^^

.. java:field:: protected T value
   :outertype: NamedAttribute

Constructors
------------
NamedAttribute
^^^^^^^^^^^^^^

.. java:constructor:: public NamedAttribute(Repository repository, String name, T value) throws RegisterException
   :outertype: NamedAttribute

   :param repository:
   :param name:
   :param value:
   :throws RegisterException:

NamedAttribute
^^^^^^^^^^^^^^

.. java:constructor:: public NamedAttribute(NamedAttribute<T> other) throws RegisterException
   :outertype: NamedAttribute

   The copy constructor of named attributes.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
cloneValue
^^^^^^^^^^

.. java:method:: protected abstract T cloneValue(T value)
   :outertype: NamedAttribute

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: NamedAttribute

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: NamedAttribute

   :return: The name of this attribute.

getValue
^^^^^^^^

.. java:method:: public T getValue()
   :outertype: NamedAttribute

   :return: The value of this attribute.

setValue
^^^^^^^^

.. java:method:: public void setValue(T value)
   :outertype: NamedAttribute

   :param value: The new value of this attribute.

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: NamedAttribute

