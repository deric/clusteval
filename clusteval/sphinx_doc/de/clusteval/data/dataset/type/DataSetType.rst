.. java:import:: java.io File

.. java:import:: java.lang.reflect Constructor

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util LinkedList

.. java:import:: java.util List

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

DataSetType
===========

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public abstract class DataSetType extends RepositoryObject

   Dataset types are used to classify datasets into different thematic groups.

   :author: Christian Wiwie

Constructors
------------
DataSetType
^^^^^^^^^^^

.. java:constructor:: public DataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DataSetType
^^^^^^^^^^^

.. java:constructor:: public DataSetType(DataSetType other) throws RegisterException
   :outertype: DataSetType

   The copy constructor for dataset types.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public final DataSetType clone()
   :outertype: DataSetType

getAlias
^^^^^^^^

.. java:method:: public abstract String getAlias()
   :outertype: DataSetType

   This alias is used whenever this dataset type is visually represented and a readable name is needed.

   :return: The alias of this dataset type.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataSetType parseFromString(Repository repository, String datasetType) throws UnknownDataSetTypeException
   :outertype: DataSetType

   Parses the from string.

   :param repository: the repository
   :param datasetType: the dataset type
   :throws UnknownDataSetTypeException: the unknown data set type exception
   :return: the data set format

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<DataSetType> parseFromString(Repository repo, String[] datasetTypes) throws UnknownDataSetTypeException
   :outertype: DataSetType

   Parses the from string.

   :param repo: the repo
   :param datasetTypes: the dataset Types
   :throws UnknownDataSetTypeException: the unknown data set type exception
   :return: the list

