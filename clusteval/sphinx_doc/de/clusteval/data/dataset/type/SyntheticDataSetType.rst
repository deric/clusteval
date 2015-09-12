.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SyntheticDataSetType
====================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class SyntheticDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
SyntheticDataSetType
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SyntheticDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: SyntheticDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SyntheticDataSetType
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SyntheticDataSetType(SyntheticDataSetType other) throws RegisterException
   :outertype: SyntheticDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SyntheticDataSetType

