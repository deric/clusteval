.. java:import:: java.io File

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.program.r RLibraryInferior

RunResultPostprocessor
======================

.. java:package:: de.clusteval.run.result.postprocessing
   :noindex:

.. java:type:: public abstract class RunResultPostprocessor extends RepositoryObject implements RLibraryInferior

   :author: Christian Wiwie

Fields
------
parameters
^^^^^^^^^^

.. java:field:: protected RunResultPostprocessorParameters parameters
   :outertype: RunResultPostprocessor

Constructors
------------
RunResultPostprocessor
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessor(Repository repository, boolean register, long changeDate, File absPath, RunResultPostprocessorParameters parameters) throws RegisterException
   :outertype: RunResultPostprocessor

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RunResultPostprocessor
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultPostprocessor(RunResultPostprocessor other) throws RegisterException
   :outertype: RunResultPostprocessor

   The copy constructor of data preprocessors.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public RunResultPostprocessor clone()
   :outertype: RunResultPostprocessor

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static List<RunResultPostprocessor> parseFromString(Repository repository, String[] runResultPostprocessor, RunResultPostprocessorParameters[] parameters) throws UnknownRunResultPostprocessorException
   :outertype: RunResultPostprocessor

   Parses a list of runresult postprocessor from a string array.

   :param repository: the repository
   :param runResultPostprocessor: The array containing simple names of the runresult postprocessor class.
   :throws UnknownRunResultPostprocessorException:
   :return: A list containing runresult postprocessor.

parseFromString
^^^^^^^^^^^^^^^

.. java:method:: public static RunResultPostprocessor parseFromString(Repository repository, String runResultPostProcessor, RunResultPostprocessorParameters parameters) throws UnknownRunResultPostprocessorException
   :outertype: RunResultPostprocessor

   Parses a data preprocessor from string.

   :param repository: the repository
   :param runResultPostProcessor: The simple name of the data preprocessor class.
   :throws UnknownRunResultPostprocessorException:
   :return: the data preprocessor

postprocess
^^^^^^^^^^^

.. java:method:: public abstract Clustering postprocess(Clustering clustering)
   :outertype: RunResultPostprocessor

   This method is reponsible for postprocessing the passed clustering and creating a new clustering object corresponding to the newly created postprocessed clustering.

   :param clustering: The clustering to be postprocessed.
   :return: The postprocessed clustering.

