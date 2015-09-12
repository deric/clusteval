.. java:import:: java.util HashMap

.. java:import:: java.util Map

.. java:import:: de.clusteval.run.result.format RunResultFormat

.. java:import:: de.clusteval.run.result.format RunResultFormatParser

RunResultFormatRepositoryEntity
===============================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RunResultFormatRepositoryEntity extends DynamicRepositoryEntity<RunResultFormat>

   :author: Christian Wiwie

Fields
------
runResultFormatParser
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map<String, Class<? extends RunResultFormatParser>> runResultFormatParser
   :outertype: RunResultFormatRepositoryEntity

   A map containing all runresult format parsers registered in this repository.

Constructors
------------
RunResultFormatRepositoryEntity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RunResultFormatRepositoryEntity(Repository repository, DynamicRepositoryEntity<RunResultFormat> parent, String basePath)
   :outertype: RunResultFormatRepositoryEntity

   :param repository:
   :param parent:
   :param basePath:

Methods
-------
getRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Class<? extends RunResultFormatParser> getRunResultFormatParser(String runResultFormatName)
   :outertype: RunResultFormatRepositoryEntity

   This method looks up and returns (if it exists) the class of the runresult format parser corresponding to the runresult format with the given name.

   :param runResultFormatName: The runresult format name.
   :return: The runresult format parser for the given runresult format name, or null if it does not exist.

isRegisteredForRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForRunResultFormat(Class<? extends RunResultFormat> runResultFormat)
   :outertype: RunResultFormatRepositoryEntity

   This method checks whether a parser has been registered for the given runresult format class.

   :param runResultFormat: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

isRegisteredForRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean isRegisteredForRunResultFormat(String runResultFormatName)
   :outertype: RunResultFormatRepositoryEntity

   This method checks whether a parser has been registered for the dataset format with the given class name.

   :param runResultFormatName: The class for which we want to know whether a parser has been registered.
   :return: True, if the parser has been registered.

registerRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean registerRunResultFormatParser(Class<? extends RunResultFormatParser> runResultFormatParser)
   :outertype: RunResultFormatRepositoryEntity

   This method registers a new runresult format parser class.

   :param runResultFormatParser: The new class to register.
   :return: True, if the new class replaced an old one.

unregisterRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean unregisterRunResultFormatParser(Class<? extends RunResultFormatParser> object)
   :outertype: RunResultFormatRepositoryEntity

   This method unregisters the passed object.

   :param object: The object to be removed.
   :return: True, if the object was remved successfully

