.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.cluster.quality ClusteringQualityMeasure

.. java:import:: de.clusteval.data.dataset DataSetConfig

.. java:import:: de.clusteval.data.goldstandard GoldStandardConfig

.. java:import:: de.clusteval.framework.repository DumpableRepositoryObject

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryObjectDumpException

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

DataConfig
==========

.. java:package:: de.clusteval.data
   :noindex:

.. java:type:: public class DataConfig extends DumpableRepositoryObject

   A data configuration encapsulates options and settings for all kinds of data (dataset and goldstandard). During the execution of a run, when programs are applied to datasets and goldstandards, settings are required that control the behaviour of how this data has to be handled.

   A data configuration corresponds to and is parsed from a file on the filesystem in the corresponding folder of the repository (see \ :java:ref:`Repository.dataConfigBasePath`\  and \ :java:ref:`DataConfigFinder`\ ).

   There are several options, that can be specified in the data configuration file (see \ :java:ref:`parseFromFile(File)`\ ).

   :author: Christian Wiwie

Fields
------
dataSetConfig
^^^^^^^^^^^^^

.. java:field:: protected DataSetConfig dataSetConfig
   :outertype: DataConfig

   A data configuration encapsulates a dataset configuration. This dataset configuration contains options and settings how to handle the encapsulated dataset.

goldstandardConfig
^^^^^^^^^^^^^^^^^^

.. java:field:: protected GoldStandardConfig goldstandardConfig
   :outertype: DataConfig

   A data configuration encapsulates a goldstandard configuration. This goldstandard configuration contains options and settings how to handle the encapsulated goldstandard.

standardDataSetConfig
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected DataSetConfig standardDataSetConfig
   :outertype: DataConfig

   The original dataset config. is only != null, if the corresponding dataset was converted into a different format

Constructors
------------
DataConfig
^^^^^^^^^^

.. java:constructor:: public DataConfig(Repository repository, long changeDate, File absPath, DataSetConfig datasetConfig, GoldStandardConfig gsConfig) throws RegisterException
   :outertype: DataConfig

   Instantiates a new data configuration.

   :param repository: The repository this data configuration should be registered at.
   :param changeDate: The change date of this data configuration is used for equality checks.
   :param absPath: The absolute path of this data configuration.
   :param datasetConfig: The dataset configuration encapsulated by this data configuration.
   :param gsConfig: The goldstandard configuration encapsulated by this data configuration.
   :throws RegisterException:

DataConfig
^^^^^^^^^^

.. java:constructor:: public DataConfig(DataConfig dataConfig) throws RegisterException
   :outertype: DataConfig

   The copy constructor for data configurations. This copy constructor creates a deep copy by not only copying the references of attribute variables, but also cloning those.

   :param dataConfig: the data config
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataConfig clone()
   :outertype: DataConfig

cloneDataConfigurations
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public static List<DataConfig> cloneDataConfigurations(List<DataConfig> dataConfigs)
   :outertype: DataConfig

   A helper method for cloning a list of data configurations.

   :param dataConfigs: The list of data configurations to clone.
   :return: The list containing the cloned objects of the input list.

dumpToFileHelper
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void dumpToFileHelper() throws RepositoryObjectDumpException
   :outertype: DataConfig

getDatasetConfig
^^^^^^^^^^^^^^^^

.. java:method:: public DataSetConfig getDatasetConfig()
   :outertype: DataConfig

   :return: If during the execution of a run the dataset has been converted to a different format, this method returns the converted dataset configuration. If no conversion has been performed, this method returns the original dataset configuration.

getGoldstandardConfig
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public GoldStandardConfig getGoldstandardConfig()
   :outertype: DataConfig

   :return: The goldstandard configuration of this data configuration. Is null, if there is no goldstandard configuration.

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: DataConfig

   The name of a data configuration is the filename of the corresponding file on the filesystem, without the file extension.

   :return: The name of this data configuration.

hasGoldStandardConfig
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasGoldStandardConfig()
   :outertype: DataConfig

   Use this method to check, whether this DataConfig has a goldstandard configuration or not. Some clustering quality measures do not require a goldstandard to evaluate a clustering (see \ :java:ref:`ClusteringQualityMeasure.requiresGoldstandard()`\ ).

   :return: True, if this data configuration has a goldstandard, false otherwise.

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: DataConfig

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: DataConfig

