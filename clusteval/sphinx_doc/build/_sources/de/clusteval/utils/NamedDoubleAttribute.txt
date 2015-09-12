.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

NamedDoubleAttribute
====================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class NamedDoubleAttribute extends NamedAttribute<Double>

   :author: Christian Wiwie

Constructors
------------
NamedDoubleAttribute
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedDoubleAttribute(Repository repository, String name, Double value) throws RegisterException
   :outertype: NamedDoubleAttribute

   :param repository:
   :param name:
   :param value:
   :throws RegisterException:

NamedDoubleAttribute
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public NamedDoubleAttribute(NamedDoubleAttribute other) throws RegisterException
   :outertype: NamedDoubleAttribute

   The copy constructor of named double attributes.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public NamedDoubleAttribute clone()
   :outertype: NamedDoubleAttribute

cloneValue
^^^^^^^^^^

.. java:method:: @Override protected Double cloneValue(Double value)
   :outertype: NamedDoubleAttribute

register
^^^^^^^^

.. java:method:: @Override public boolean register() throws RegisterException
   :outertype: NamedDoubleAttribute

unregister
^^^^^^^^^^

.. java:method:: @Override public boolean unregister()
   :outertype: NamedDoubleAttribute

