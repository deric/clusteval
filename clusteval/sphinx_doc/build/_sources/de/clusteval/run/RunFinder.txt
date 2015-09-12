.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository.parse Parser

.. java:import:: de.clusteval.utils FileFinder

RunFinder
=========

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public class RunFinder extends FileFinder<Run>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository (see \ :java:ref:`Repository.runBasePath`\ ).

   :author: Christian Wiwie

Constructors
------------
RunFinder
^^^^^^^^^

.. java:constructor:: public RunFinder(Repository repository) throws RegisterException
   :outertype: RunFinder

   Instantiates a new run finder.

   :param repository: The repository to register the new runs at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunFinder

parseObjectFromFile
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected Run parseObjectFromFile(File file) throws Exception
   :outertype: RunFinder

