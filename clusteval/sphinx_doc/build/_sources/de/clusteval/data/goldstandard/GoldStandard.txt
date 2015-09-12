.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: utils.text TextFileMapParser

.. java:import:: de.clusteval.cluster Cluster

.. java:import:: de.clusteval.cluster ClusterItem

.. java:import:: de.clusteval.cluster Clustering

.. java:import:: de.clusteval.data.goldstandard.format UnknownGoldStandardFormatException

.. java:import:: de.clusteval.framework.repository NoRepositoryFoundException

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

GoldStandard
============

.. java:package:: de.clusteval.data.goldstandard
   :noindex:

.. java:type:: public class GoldStandard extends RepositoryObject

   A wrapper class for a goldstandard on the filesystem.

   :author: Christian Wiwie

Fields
------
clustering
^^^^^^^^^^

.. java:field:: protected Clustering clustering
   :outertype: GoldStandard

   This attribute holds the clustering that corresponds to the goldstandard. Every goldstandard can be interpreted as a clustering: A partition of the data objects into several groups.

   **See also:** :java:ref:`{@linkClustering}`

Constructors
------------
GoldStandard
^^^^^^^^^^^^

.. java:constructor:: public GoldStandard(Repository repository, long changeDate, File absGoldStandardPath) throws RegisterException
   :outertype: GoldStandard

   Instantiates a new goldstandard object.

   :param repository: the repository this goldstandard should be registered at.
   :param changeDate: The change date of this goldstandard is used for equality checks.
   :param absGoldStandardPath: The absolute path of this goldstandard.
   :throws RegisterException:

GoldStandard
^^^^^^^^^^^^

.. java:constructor:: public GoldStandard(GoldStandard goldStandard) throws RegisterException
   :outertype: GoldStandard

   Copy constructor for the GoldStandard class.

   :param goldStandard: The goldstandard to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public GoldStandard clone()
   :outertype: GoldStandard

fuzzySize
^^^^^^^^^

.. java:method:: public float fuzzySize()
   :outertype: GoldStandard

   Fuzzy size.

   :return: the float

getClustering
^^^^^^^^^^^^^

.. java:method:: public Clustering getClustering() throws UnknownGoldStandardFormatException
   :outertype: GoldStandard

   This method returns a reference to the clustering object representing the contents of the goldstandard file.

   If this is not already the case, the contents of the file are parsed by invoking \ :java:ref:`loadIntoMemory()`\ .

   :throws UnknownGoldStandardFormatException: the unknown gold standard format exception
   :return: The clustering object representing the goldstandard.

getFullName
^^^^^^^^^^^

.. java:method:: public String getFullName()
   :outertype: GoldStandard

   Gets the full name of this goldstandard. The full name consists of the minor and the major name, separated by a slash: MAJOR/MINOR

   :return: The full name

getMajorName
^^^^^^^^^^^^

.. java:method:: public String getMajorName()
   :outertype: GoldStandard

   Gets the major name of this goldstandard. The major name corresponds to the folder the goldstandard resides in in the filesystem.

   :return: The major name

getMinorName
^^^^^^^^^^^^

.. java:method:: public String getMinorName()
   :outertype: GoldStandard

   Gets the minor name of this goldstandard. The minor name corresponds to the name of the file of this goldstandard.

   :return: The minor name

isInMemory
^^^^^^^^^^

.. java:method:: public boolean isInMemory()
   :outertype: GoldStandard

   Checks whether this goldstandard is loaded into the memory.

   :return: true, if is in memory

loadIntoMemory
^^^^^^^^^^^^^^

.. java:method:: public boolean loadIntoMemory() throws UnknownGoldStandardFormatException
   :outertype: GoldStandard

   Load this goldstandard into memory. When this method is invoked, it parses the goldstandard file on the filesystem

   :throws UnknownGoldStandardFormatException:
   :return: true, if successful

parseFromFile
^^^^^^^^^^^^^

.. java:method:: public static GoldStandard parseFromFile(File absGoldStandardPath) throws NoRepositoryFoundException, GoldStandardNotFoundException, RegisterException
   :outertype: GoldStandard

   This method parses a goldstandard from a file. Since goldstandard files do not require a header, this method simply creates a wrapper object for the file on the filesystem.

   The actual parsing of the clustering contained in the goldstandard file happens later in the \ :java:ref:`loadIntoMemory()`\  method.

   :param absGoldStandardPath: The absolute path to the goldstandard file that should be parsed.
   :throws NoRepositoryFoundException:
   :throws GoldStandardNotFoundException:
   :throws RegisterException:
   :return: The goldstandard object.

size
^^^^

.. java:method:: public int size()
   :outertype: GoldStandard

   Size.

   :return: the int

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: GoldStandard

unloadFromMemory
^^^^^^^^^^^^^^^^

.. java:method:: public boolean unloadFromMemory()
   :outertype: GoldStandard

   Unload the contents of this dataset from memory.

   :return: true, if successful

