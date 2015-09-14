.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

OtherDataSetType
================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class OtherDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
OtherDataSetType
^^^^^^^^^^^^^^^^

.. java:constructor:: public OtherDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: OtherDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

OtherDataSetType
^^^^^^^^^^^^^^^^

.. java:constructor:: public OtherDataSetType(OtherDataSetType other) throws RegisterException
   :outertype: OtherDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: OtherDataSetType

