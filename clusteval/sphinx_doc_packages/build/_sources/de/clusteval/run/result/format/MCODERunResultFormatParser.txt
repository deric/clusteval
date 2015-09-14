.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils StringExt

MCODERunResultFormatParser
==========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class MCODERunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Constructors
------------
MCODERunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCODERunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: MCODERunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: MCODERunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: MCODERunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: MCODERunResultFormatParser

