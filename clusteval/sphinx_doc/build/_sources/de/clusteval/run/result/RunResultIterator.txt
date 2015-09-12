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

RunResultIterator
=================

.. java:package:: de.clusteval.run.result
   :noindex:

.. java:type::  class RunResultIterator implements Iterator<File>

Fields
------
basePath
^^^^^^^^

.. java:field:: protected ArrayIterator<File> basePath
   :outertype: RunResultIterator

lastReturnedResult
^^^^^^^^^^^^^^^^^^

.. java:field:: protected RunResult lastReturnedResult
   :outertype: RunResultIterator

parsedResults
^^^^^^^^^^^^^

.. java:field:: protected List<RunResult> parsedResults
   :outertype: RunResultIterator

repo
^^^^

.. java:field:: protected Repository repo
   :outertype: RunResultIterator

Constructors
------------
RunResultIterator
^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultIterator(Repository repo, File basePath)
   :outertype: RunResultIterator

Methods
-------
getRunResult
^^^^^^^^^^^^

.. java:method:: public RunResult getRunResult()
   :outertype: RunResultIterator

hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: RunResultIterator

next
^^^^

.. java:method:: @Override public File next()
   :outertype: RunResultIterator

remove
^^^^^^

.. java:method:: @Override public void remove()
   :outertype: RunResultIterator

