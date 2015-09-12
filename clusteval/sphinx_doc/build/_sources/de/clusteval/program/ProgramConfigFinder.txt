.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FileFinder

ProgramConfigFinder
===================

.. java:package:: de.clusteval.program
   :noindex:

.. java:type:: public class ProgramConfigFinder extends FileFinder<ProgramConfig>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
ProgramConfigFinder
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ProgramConfigFinder(Repository repository) throws RegisterException
   :outertype: ProgramConfigFinder

   Instantiates a new run finder.

   :param repository: The repository to register the new program configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: ProgramConfigFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: ProgramConfigFinder

