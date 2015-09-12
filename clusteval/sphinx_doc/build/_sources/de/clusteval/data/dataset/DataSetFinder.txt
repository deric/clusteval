.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FileFinder

.. java:import:: de.clusteval.utils SubDirectoryIterator

DataSetFinder
=============

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class DataSetFinder extends FileFinder<DataSet>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
DataSetFinder
^^^^^^^^^^^^^

.. java:constructor:: public DataSetFinder(Repository repository) throws RegisterException
   :outertype: DataSetFinder

   Instantiates a new run finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: DataSetFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: DataSetFinder

