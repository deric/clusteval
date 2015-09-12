.. java:import:: java.io File

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RunResultDataSetConfig
======================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RunResultDataSetConfig extends DataSetConfig

   :author: Christian Wiwie

Constructors
------------
RunResultDataSetConfig
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetConfig(Repository repository, long changeDate, File absPath, DataSet ds, ConversionInputToStandardConfiguration configInputToStandard, ConversionStandardToInputConfiguration configStandardToInput) throws RegisterException
   :outertype: RunResultDataSetConfig

   :param repository:
   :param changeDate:
   :param absPath:
   :param ds:
   :param configInputToStandard:
   :param configStandardToInput:
   :throws RegisterException:

RunResultDataSetConfig
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetConfig(DataSetConfig datasetConfig) throws RegisterException
   :outertype: RunResultDataSetConfig

   :param datasetConfig:
   :throws RegisterException:

