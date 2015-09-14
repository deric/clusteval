.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

PPIDataSetType
==============

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class PPIDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
PPIDataSetType
^^^^^^^^^^^^^^

.. java:constructor:: public PPIDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: PPIDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

PPIDataSetType
^^^^^^^^^^^^^^

.. java:constructor:: public PPIDataSetType(PPIDataSetType other) throws RegisterException
   :outertype: PPIDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: PPIDataSetType

