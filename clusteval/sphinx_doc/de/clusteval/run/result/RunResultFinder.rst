.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Collection

.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run RUN_STATUS

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils FileFinder

RunResultFinder
===============

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type:: public class RunResultFinder extends FileFinder<RunResult>

   :author: Christian Wiwie

Fields
------
iter
^^^^

.. java:field:: protected RunResultIterator iter
   :outertype: RunResultFinder

Constructors
------------
RunResultFinder
^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFinder(Repository repository) throws RegisterException
   :outertype: RunResultFinder

   Instantiates a new run result finder.

   :param repository: The repository to register the new run results at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RunResultFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RunResultFinder

isRunning
^^^^^^^^^

.. java:method:: protected boolean isRunning(String uniqueRunIdentifier)
   :outertype: RunResultFinder

parseObjectFromFile
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected RunResult parseObjectFromFile(File file) throws Exception
   :outertype: RunResultFinder

