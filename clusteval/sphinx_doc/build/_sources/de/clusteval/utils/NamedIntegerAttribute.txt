.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NamedIntegerAttribute
=====================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class NamedIntegerAttribute extends NamedAttribute<Integer>

   :author: Christian Wiwie

Constructors
------------
NamedIntegerAttribute
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedIntegerAttribute(Repository repository, String name, Integer value) throws RegisterException
   :outertype: NamedIntegerAttribute

   :param repository:
   :param name:
   :param value:
   :throws RegisterException:

NamedIntegerAttribute
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedIntegerAttribute(NamedIntegerAttribute other) throws RegisterException
   :outertype: NamedIntegerAttribute

   The copy constructor of named integer attributes.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public NamedIntegerAttribute clone()
   :outertype: NamedIntegerAttribute

cloneValue
^^^^^^^^^^

.. java:method:: @Override protected Integer cloneValue(Integer value)
   :outertype: NamedIntegerAttribute

register
^^^^^^^^

.. java:method:: @Override public boolean register() throws RegisterException
   :outertype: NamedIntegerAttribute

unregister
^^^^^^^^^^

.. java:method:: @Override public boolean unregister()
   :outertype: NamedIntegerAttribute

