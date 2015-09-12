.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

MatrixDataSetFormat
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class MatrixDataSetFormat extends AbsoluteDataSetFormat

   :author: Christian Wiwie

Constructors
------------
MatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: MatrixDataSetFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

MatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixDataSetFormat(MatrixDataSetFormat other) throws RegisterException
   :outertype: MatrixDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: MatrixDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: MatrixDataSetFormat

