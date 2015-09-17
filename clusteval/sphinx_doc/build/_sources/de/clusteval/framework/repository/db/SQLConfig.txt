.. java:import:: java.io BufferedReader

.. java:import:: java.io Console

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

SQLConfig
=========

.. java:package:: de.clusteval.framework.repository.db
   :noindex:

.. java:type:: public class SQLConfig

   Wrapper class to store a sql connection configuration.

   :author: Christian Wiwie

Fields
------
DUMMY_CONFIG
^^^^^^^^^^^^

.. java:field:: public static SQLConfig DUMMY_CONFIG
   :outertype: SQLConfig

database
^^^^^^^^

.. java:field:: protected String database
   :outertype: SQLConfig

dbType
^^^^^^

.. java:field:: protected DB_TYPE dbType
   :outertype: SQLConfig

host
^^^^

.. java:field:: protected String host
   :outertype: SQLConfig

username
^^^^^^^^

.. java:field:: protected String username
   :outertype: SQLConfig

usesPassword
^^^^^^^^^^^^

.. java:field:: protected boolean usesPassword
   :outertype: SQLConfig

usesSql
^^^^^^^

.. java:field:: protected boolean usesSql
   :outertype: SQLConfig

Constructors
------------
SQLConfig
^^^^^^^^^

.. java:constructor:: public SQLConfig(boolean usesSql, DB_TYPE dbType, String username, String database, String host, boolean usesPassword)
   :outertype: SQLConfig

   :param usesSql:
   :param dbType:
   :param username:
   :param database:
   :param host:
   :param usesPassword: Whether the sql connection uses a password to connect and thus prompt for it when connecting.

Methods
-------
getDatabase
^^^^^^^^^^^

.. java:method:: public String getDatabase()
   :outertype: SQLConfig

   :return: The name of the database to connect to.

getDatabaseType
^^^^^^^^^^^^^^^

.. java:method:: public DB_TYPE getDatabaseType()
   :outertype: SQLConfig

getHost
^^^^^^^

.. java:method:: public String getHost()
   :outertype: SQLConfig

   :return: The host address to connect to.

getPassword
^^^^^^^^^^^

.. java:method:: public String getPassword()
   :outertype: SQLConfig

   :return: The password used to connect to the sql database.

getUsername
^^^^^^^^^^^

.. java:method:: public String getUsername()
   :outertype: SQLConfig

   :return: The username used to connect to the sql database.

usesPassword
^^^^^^^^^^^^

.. java:method:: public boolean usesPassword()
   :outertype: SQLConfig

usesSql
^^^^^^^

.. java:method:: public boolean usesSql()
   :outertype: SQLConfig

   :return: A boolean indicating, whether the repository that this sql configuration corresponds to uses sql.

