.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: utils SimilarityMatrix.NUMBER_PRECISION

.. java:import:: de.clusteval.data.dataset.format ConversionInputToStandardConfiguration

.. java:import:: de.clusteval.data.dataset.format ConversionStandardToInputConfiguration

.. java:import:: de.clusteval.data.preprocessing DataPreprocessor

.. java:import:: de.clusteval.framework.repository DumpableRepositoryObject

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryMoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryObjectDumpException

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

DataSetConfig
=============

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetConfig extends DumpableRepositoryObject

   A dataset configuration encapsulates options and settings for a dataset. During the execution of a run, when programs are applied to datasets, settings are required that control the behaviour of how the dataset has to be handled.

   A dataset configuration corresponds to and is parsed from a file on the filesystem in the corresponding folder of the repository (see \ :java:ref:`Repository.dataSetConfigBasePath`\  and \ :java:ref:`DataSetConfigFinder`\ ).

   There are several options, that can be specified in the dataset configuration file (see \ :java:ref:`parseFromFile(File)`\ ).

   :author: Christian Wiwie

Fields
------
configInputToStandard
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ConversionInputToStandardConfiguration configInputToStandard
   :outertype: DataSetConfig

   This variable holds the configuration needed, when \ :java:ref:`dataset`\  is converted from its original input format to the internal standard format of the framework.

configStandardToInput
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected ConversionStandardToInputConfiguration configStandardToInput
   :outertype: DataSetConfig

   This variable holds the configuration needed, when \ :java:ref:`dataset`\  is converted from the internal standard format of the framework to the input format of a program.

dataset
^^^^^^^

.. java:field:: protected DataSet dataset
   :outertype: DataSetConfig

   A dataset configuration encapsulates a dataset. This attribute stores a reference to the dataset wrapper object.

Constructors
------------
DataSetConfig
^^^^^^^^^^^^^

.. java:constructor:: public DataSetConfig(Repository repository, long changeDate, File absPath, DataSet ds, ConversionInputToStandardConfiguration configInputToStandard, ConversionStandardToInputConfiguration configStandardToInput) throws RegisterException
   :outertype: DataSetConfig

   Instantiates a new dataset configuration.

   :param repository: The repository this dataset configuration should be registered at.
   :param changeDate: The change date of this dataset configuration is used for equality checks.
   :param absPath: The absolute path of this dataset configuration.
   :param ds: The encapsulated dataset.
   :param configInputToStandard: The configuration needed, when \ :java:ref:`dataset`\  is converted from its original input format to the internal standard format of the framework.
   :param configStandardToInput: The configuration needed, when \ :java:ref:`dataset`\  is converted from the internal standard format of the framework to the input format of a program.
   :throws RegisterException:

DataSetConfig
^^^^^^^^^^^^^

.. java:constructor:: public DataSetConfig(DataSetConfig datasetConfig) throws RegisterException
   :outertype: DataSetConfig

   The copy constructor for dataset configurations.

   :param datasetConfig: The dataset configuration to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataSetConfig clone()
   :outertype: DataSetConfig

dumpToFileHelper
^^^^^^^^^^^^^^^^

.. java:method:: @Override public void dumpToFileHelper() throws RepositoryObjectDumpException
   :outertype: DataSetConfig

getConversionInputToStandardConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ConversionInputToStandardConfiguration getConversionInputToStandardConfiguration()
   :outertype: DataSetConfig

   :return: The configuration for conversion from the original input format to the standard format.

   **See also:** :java:ref:`.configInputToStandard`

getConversionStandardToInputConfiguration
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public ConversionStandardToInputConfiguration getConversionStandardToInputConfiguration()
   :outertype: DataSetConfig

   :return: The configuration for conversion from standard format to the input format of the clustering method.

   **See also:** :java:ref:`.configStandardToInput`

getDataSet
^^^^^^^^^^

.. java:method:: public DataSet getDataSet()
   :outertype: DataSetConfig

   :return: The dataset, this configuration belongs to.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: DataSetConfig

setDataSet
^^^^^^^^^^

.. java:method:: public void setDataSet(DataSet dataset)
   :outertype: DataSetConfig

   :param dataset: The new dataset

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DataSetConfig

