.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ProteinStructureSimilarityDataSetType
=====================================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class ProteinStructureSimilarityDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
ProteinStructureSimilarityDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProteinStructureSimilarityDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ProteinStructureSimilarityDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ProteinStructureSimilarityDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProteinStructureSimilarityDataSetType(ProteinStructureSimilarityDataSetType other) throws RegisterException
   :outertype: ProteinStructureSimilarityDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ProteinStructureSimilarityDataSetType

