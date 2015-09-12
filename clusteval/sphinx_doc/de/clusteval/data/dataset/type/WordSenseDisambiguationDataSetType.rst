.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

WordSenseDisambiguationDataSetType
==================================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class WordSenseDisambiguationDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
WordSenseDisambiguationDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public WordSenseDisambiguationDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: WordSenseDisambiguationDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

WordSenseDisambiguationDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public WordSenseDisambiguationDataSetType(WordSenseDisambiguationDataSetType other) throws RegisterException
   :outertype: WordSenseDisambiguationDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: WordSenseDisambiguationDataSetType

