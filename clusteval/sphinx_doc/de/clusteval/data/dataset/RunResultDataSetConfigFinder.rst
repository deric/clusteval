.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FileFinder

RunResultDataSetConfigFinder
============================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RunResultDataSetConfigFinder extends FileFinder<DataSetConfig>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
RunResultDataSetConfigFinder
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetConfigFinder(Repository repository) throws RegisterException
   :outertype: RunResultDataSetConfigFinder

   Instantiates a new dataset configuration finder.

   :param repository: The repository to register the new dataset configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunResultDataSetConfigFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunResultDataSetConfigFinder

