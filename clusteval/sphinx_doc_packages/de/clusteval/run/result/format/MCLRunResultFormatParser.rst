.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils StringExt

MCLRunResultFormatParser
========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class MCLRunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Constructors
------------
MCLRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCLRunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: MCLRunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: MCLRunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: MCLRunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: MCLRunResultFormatParser

