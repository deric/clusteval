.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.utils FileFinder

DataSetConfigFinder
===================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetConfigFinder extends FileFinder<DataSetConfig>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
DataSetConfigFinder
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DataSetConfigFinder(Repository repository) throws RegisterException
   :outertype: DataSetConfigFinder

   Instantiates a new dataset configuration finder.

   :param repository: The repository to register the new dataset configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataSetConfigFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataSetConfigFinder

