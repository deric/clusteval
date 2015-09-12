.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: java.util.concurrent ConcurrentHashMap

.. java:import:: de.clusteval.data.dataset.format DataSetFormat

.. java:import:: de.clusteval.data.dataset.format DataSetFormatParser

.. java:import:: de.clusteval.data.dataset.format UnknownDataSetFormatException

DataSetFormatRepositoryEntity
=============================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class DataSetFormatRepositoryEntity extends DynamicRepositoryEntity<DataSetFormat>

   :author: Christian Wiwie

Fields
------
dataSetFormatCurrentVersions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Integer> dataSetFormatCurrentVersions
   :outertype: DataSetFormatRepositoryEntity

   This map holds the current versions of the available dataset formats.

dataSetFormatParser
^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Class<? extends DataSetFormatParser>> dataSetFormatParser
   :outertype: DataSetFormatRepositoryEntity

   A map containing all classes of dataset format parsers registered in this repository.

Constructors
------------
DataSetFormatRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetFormatRepositoryEntity(Repository repository, DynamicRepositoryEntity<DataSetFormat> parent, String basePath)
   :outertype: DataSetFormatRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getCurrentDataSetFormatVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getCurrentDataSetFormatVersion(String formatClass) throws UnknownDataSetFormatException
   :outertype: DataSetFormatRepositoryEntity

   This method returns the latest and current version of the given format. It is used by default, if no other version for a format is specified. If the current version of a format changes, add a static block to that formats class and overwrite the format version.

   :param formatClass: The dataset format class for which we want to know the current version.
   :throws UnknownDataSetFormatException:
   :return: The current version for the given dataset format class.

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends DataSetFormatParser> getDataSetFormatParser(String dataSetFormatName)
   :outertype: DataSetFormatRepositoryEntity

   This method looks up and returns (if it exists) the class of the parser corresponding to the dataset format with the given name.

   :param dataSetFormatName: The name of the class of the dataset format.
   :return: The class of the dataset format parser with the given name or null, if it does not exist.

isRegisteredForDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForDataSetFormat(Class<? extends DataSetFormat> dsFormat)
   :outertype: DataSetFormatRepositoryEntity

   This method checks whether a parser has been registered for the given dataset format class.

   :param dsFormat: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

putCurrentDataSetFormatVersion
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void putCurrentDataSetFormatVersion(String formatClass, int version)
   :outertype: DataSetFormatRepositoryEntity

   :param formatClass: The dataset format class for which we want to set the current version.
   :param version: The new version of the dataset format class.

registerDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerDataSetFormatParser(Class<? extends DataSetFormatParser> dsFormatParser)
   :outertype: DataSetFormatRepositoryEntity

   This method registers a dataset format parser.

   :param dsFormatParser: The dataset format parser to register.
   :return: True, if the dataset format parser replaced an old object.

