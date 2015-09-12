.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NamedStringAttribute
====================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class NamedStringAttribute extends NamedAttribute<String>

   :author: Christian Wiwie

Constructors
------------
NamedStringAttribute
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedStringAttribute(Repository repository, String name, String value) throws RegisterException
   :outertype: NamedStringAttribute

   :param repository:
   :param name:
   :param value:
   :throws RegisterException:

NamedStringAttribute
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedStringAttribute(NamedStringAttribute other) throws RegisterException
   :outertype: NamedStringAttribute

   The copy constructor of named double attributes.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public NamedStringAttribute clone()
   :outertype: NamedStringAttribute

cloneValue
^^^^^^^^^^

.. java:method:: @Override protected String cloneValue(String value)
   :outertype: NamedStringAttribute

register
^^^^^^^^

.. java:method:: @Override public boolean register() throws RegisterException
   :outertype: NamedStringAttribute

unregister
^^^^^^^^^^

.. java:method:: @Override public boolean unregister()
   :outertype: NamedStringAttribute

