.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: de.clusteval.data.dataset DataSet

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

.. java:import:: file FileUtils

BLASTDataSetFormat
==================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class BLASTDataSetFormat extends RelativeDataSetFormat

   :author: Christian Wiwie

Constructors
------------
BLASTDataSetFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BLASTDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: BLASTDataSetFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

BLASTDataSetFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BLASTDataSetFormat(BLASTDataSetFormat other) throws RegisterException
   :outertype: BLASTDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
copyDataSetTo
^^^^^^^^^^^^^

.. java:method:: @Override public boolean copyDataSetTo(DataSet dataSet, File copyDestination, boolean overwrite)
   :outertype: BLASTDataSetFormat

copyDataSetToFolder
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean copyDataSetToFolder(DataSet dataSet, File copyFolderDestination, boolean overwrite)
   :outertype: BLASTDataSetFormat

getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: BLASTDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: BLASTDataSetFormat

