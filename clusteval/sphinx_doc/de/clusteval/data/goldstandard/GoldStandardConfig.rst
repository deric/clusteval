.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: de.clusteval.framework.repository DumpableRepositoryObject

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryEvent

.. java:import:: de.clusteval.framework.repository RepositoryMoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryObjectDumpException

.. java:import:: de.clusteval.framework.repository RepositoryRemoveEvent

.. java:import:: de.clusteval.framework.repository RepositoryReplaceEvent

GoldStandardConfig
==================

.. java:package:: de.clusteval.data.goldstandard
   :noindex:

.. java:type:: public class GoldStandardConfig extends DumpableRepositoryObject

   A goldstandard configuration encapsulates options and settings for a goldstandard. During the execution of a run, when goldstandards are used, settings are required that control the behaviour of how the goldstandard has to be handled.

   A goldstandard configuration corresponds to and is parsed from a file on the filesystem in the corresponding folder of the repository (see \ :java:ref:`Repository.goldStandardConfigBasePath`\  and \ :java:ref:`GoldStandardConfigFinder`\ ).

   There are several options, that can be specified in the goldstandard configuration file (see \ :java:ref:`parseFromFile(File)`\ ).

   :author: Christian Wiwie

Constructors
------------
GoldStandardConfig
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GoldStandardConfig(Repository repository, long changeDate, File absPath, GoldStandard goldstandard) throws RegisterException
   :outertype: GoldStandardConfig

   Instantiates a new goldstandard configuration.

   :param repository: The repository this goldstandard configuration should be registered at.
   :param changeDate: The change date of this goldstandard configuration is used for equality checks.
   :param absPath: The absolute path of this goldstandard configuration.
   :param goldstandard: The encapsulated goldstandard.
   :throws RegisterException:

GoldStandardConfig
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GoldStandardConfig(GoldStandardConfig goldstandardConfig) throws RegisterException
   :outertype: GoldStandardConfig

   The copy constructor for goldstandard configurations.

   :param goldstandardConfig: The goldstandard configuration to be cloned.
   :throws RegisterException:

Methods
-------
clone
^^^^^

.. java:method:: @Override public GoldStandardConfig clone()
   :outertype: GoldStandardConfig

dumpToFileHelper
^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void dumpToFileHelper() throws RepositoryObjectDumpException
   :outertype: GoldStandardConfig

getGoldstandard
^^^^^^^^^^^^^^^

.. java:method:: public GoldStandard getGoldstandard()
   :outertype: GoldStandardConfig

   :return: The goldstandard this configuration belongs to.

   **See also:** :java:ref:`.goldStandard`

notify
^^^^^^

.. java:method:: @Override public void notify(RepositoryEvent e) throws RegisterException
   :outertype: GoldStandardConfig

setGoldStandard
^^^^^^^^^^^^^^^

.. java:method:: public void setGoldStandard(GoldStandard goldStandard)
   :outertype: GoldStandardConfig

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: GoldStandardConfig

