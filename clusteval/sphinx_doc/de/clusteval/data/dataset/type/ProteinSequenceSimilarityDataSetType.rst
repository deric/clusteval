.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

ProteinSequenceSimilarityDataSetType
====================================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class ProteinSequenceSimilarityDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
ProteinSequenceSimilarityDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProteinSequenceSimilarityDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: ProteinSequenceSimilarityDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

ProteinSequenceSimilarityDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProteinSequenceSimilarityDataSetType(ProteinSequenceSimilarityDataSetType other) throws RegisterException
   :outertype: ProteinSequenceSimilarityDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: ProteinSequenceSimilarityDataSetType

