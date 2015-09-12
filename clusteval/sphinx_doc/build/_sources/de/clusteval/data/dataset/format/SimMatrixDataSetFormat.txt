.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

SimMatrixDataSetFormat
======================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class SimMatrixDataSetFormat extends RelativeDataSetFormat

   :author: Christian Wiwie

Constructors
------------
SimMatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimMatrixDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: SimMatrixDataSetFormat

   Instantiates a new sim matrix data set format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

SimMatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SimMatrixDataSetFormat(SimMatrixDataSetFormat other) throws RegisterException
   :outertype: SimMatrixDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SimMatrixDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: SimMatrixDataSetFormat

