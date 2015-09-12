.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

DataPreprocessor
================

.. java:package:: de.clusteval.data.preprocessing
   :noindex:

.. java:type:: public abstract class DataPreprocessor extends RepositoryObject implements RLibraryInferior

   :author: Christian Wiwie

Constructors
------------
DataPreprocessor
^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessor(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: DataPreprocessor

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

DataPreprocessor
^^^^^^^^^^^^^^^^

.. java:constructor:: public DataPreprocessor(DataPreprocessor other) throws RegisterException
   :outertype: DataPreprocessor

   The copy constructor of data preprocessors.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public DataPreprocessor clone()
   :outertype: DataPreprocessor

getCompatibleDataSetFormats
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public abstract Set<String> getCompatibleDataSetFormats()
   :outertype: DataPreprocessor

   :return: A set with simple names of all classes, this preprocessor is compatible to.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<DataPreprocessor> parseFromString(Repository repository, String[] dataPreprocessors) throws UnknownDataPreprocessorException
   :outertype: DataPreprocessor

   Parses a list of data preprocessors from a string array.

   :param repository: the repository
   :param dataPreprocessors: The array containing simple names of the data preprocessor class.
   :throws UnknownDataPreprocessorException:
   :return: A list containing data preprocessors.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static DataPreprocessor parseFromString(Repository repository, String dataPreprocessor) throws UnknownDataPreprocessorException
   :outertype: DataPreprocessor

   Parses a data preprocessor from string.

   :param repository: the repository
   :param dataPreprocessor: The simple name of the data preprocessor class.
   :throws UnknownDataPreprocessorException:
   :return: the data preprocessor

preprocess
^^^^^^^^^^

.. java:method:: public abstract DataSet preprocess(DataSet dataSet) throws InterruptedException
   :outertype: DataPreprocessor

   This method is reponsible for preprocessing the passed data and creating a new dataset object corresponding to the newly created preprocessed dataset.

   :param dataSet: The dataset to be preprocessed.
   :throws InterruptedException:
   :return: The preprocessed dataset.

