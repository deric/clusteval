.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils SubSubDirectoryIterator

RunResultDataSetFinder
======================

.. java:package:: de.clusteval.data.dataset
   :noindex:

.. java:type:: public class RunResultDataSetFinder extends DataSetFinder

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
RunResultDataSetFinder
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultDataSetFinder(Repository repository) throws RegisterException
   :outertype: RunResultDataSetFinder

   Instantiates a new run finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunResultDataSetFinder

