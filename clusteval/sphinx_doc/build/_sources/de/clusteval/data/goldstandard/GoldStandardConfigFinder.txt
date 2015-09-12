.. java:import:: java.io File

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FileFinder

GoldStandardConfigFinder
========================

.. java:package:: de.clusteval.data.goldstandard
   :noindex:

.. java:type:: public class GoldStandardConfigFinder extends FileFinder<GoldStandardConfig>

   Objects of this class look for new run-files in the run-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
GoldStandardConfigFinder
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GoldStandardConfigFinder(Repository repository) throws RegisterException
   :outertype: GoldStandardConfigFinder

   Instantiates a new run finder.

   :param repository: The repository to register the new goldstandard configurations at.
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: GoldStandardConfigFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: GoldStandardConfigFinder

