.. java:import:: java.io IOException

.. java:import:: java.util Map

.. java:import:: utils StringExt

RRWRunResultFormatParser
========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class RRWRunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Constructors
------------
RRWRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RRWRunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: RRWRunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: RRWRunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: RRWRunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: RRWRunResultFormatParser

