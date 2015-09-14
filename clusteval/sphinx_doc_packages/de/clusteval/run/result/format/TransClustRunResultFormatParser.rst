.. java:import:: java.io IOException

.. java:import:: java.util Map

TransClustRunResultFormatParser
===============================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class TransClustRunResultFormatParser extends RunResultFormatParser

   :author: Christian Wiwie

Constructors
------------
TransClustRunResultFormatParser
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustRunResultFormatParser(Map<String, String> internalParams, Map<String, String> params, String absFilePath) throws IOException
   :outertype: TransClustRunResultFormatParser

   :param internalParams:
   :param params:
   :param absFilePath:
   :throws IOException:

Methods
-------
convertToStandardFormat
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void convertToStandardFormat() throws IOException
   :outertype: TransClustRunResultFormatParser

getLineOutput
^^^^^^^^^^^^^

.. java:method:: @Override protected String getLineOutput(String[] key, String[] value)
   :outertype: TransClustRunResultFormatParser

processLine
^^^^^^^^^^^

.. java:method:: @Override protected void processLine(String[] key, String[] value)
   :outertype: TransClustRunResultFormatParser

