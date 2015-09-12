.. java:import:: java.io File

.. java:import:: java.util HashMap

.. java:import:: java.util Iterator

.. java:import:: java.util Map

.. java:import:: java.util NoSuchElementException

.. java:import:: org.apache.commons.configuration ConfigurationException

.. java:import:: org.apache.commons.configuration HierarchicalINIConfiguration

.. java:import:: org.apache.commons.configuration SubnodeConfiguration

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.framework ClustevalBackendServer

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository.db SQLConfig

.. java:import:: de.clusteval.framework.repository.db SQLConfig.DB_TYPE

RepositoryConfig
================

.. java:package:: de.clusteval.framework.repository.config
   :noindex:

.. java:type:: public class RepositoryConfig

   A repository configuration determines certain settings and options for a \ :java:ref:`Repository`\  and also for the complete backend. This includes for example whether an sql database should be used or how often the supervising threads of the repository should scan for changes.

   :author: Christian Wiwie

Fields
------
mysqlConfig
^^^^^^^^^^^

.. java:field:: protected SQLConfig mysqlConfig
   :outertype: RepositoryConfig

   The configuration of the mysql connection of the repository.

threadingSleepingTimes
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Long> threadingSleepingTimes
   :outertype: RepositoryConfig

   This map holds the sleeping times for all threads that check the repository for changes.

Constructors
------------
RepositoryConfig
^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryConfig(SQLConfig mysqlConfig, Map<String, Long> threadingSleepTimes)
   :outertype: RepositoryConfig

   Creates a new repository configuration.

   :param mysqlConfig: The mysql configuration for the repository.
   :param threadingSleepTimes: The sleep times of the threads created for the repository.

Methods
-------
getMysqlConfig
^^^^^^^^^^^^^^

.. java:method:: public SQLConfig getMysqlConfig()
   :outertype: RepositoryConfig

   :return: The mysql configuration of this repository.

getThreadSleepTimes
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<String, Long> getThreadSleepTimes()
   :outertype: RepositoryConfig

   :return: The thread sleep times for the repository.

   **See also:** :java:ref:`.threadingSleepingTimes`

parseFromFile
^^^^^^^^^^^^^

.. java:method:: public static RepositoryConfig parseFromFile(File absConfigPath) throws RepositoryConfigNotFoundException, RepositoryConfigurationException
   :outertype: RepositoryConfig

   This method parses a repository configuration from the file at the given absolute path.

   A repository configuration contains several sections and possible options:

   ..

   * \ **[mysql]**\
   * \ **[threading]**\
   * \ **NameOfTheThreadSleepTime**\ : Sleeping time of the thread 'NameOfTheThread'. This option can be used to control the frequency, with which the threads check for changes on the filesystem.

   :param absConfigPath: The absolute path of the repository configuration file.
   :throws RepositoryConfigurationException:
   :throws RepositoryConfigNotFoundException:
   :return: The parsed repository configuration.

setMysqlConfig
^^^^^^^^^^^^^^

.. java:method:: public void setMysqlConfig(SQLConfig mysqlConfig)
   :outertype: RepositoryConfig

   Override the mysql configuration of this repository.

   :param mysqlConfig: The new mysql configuration.

