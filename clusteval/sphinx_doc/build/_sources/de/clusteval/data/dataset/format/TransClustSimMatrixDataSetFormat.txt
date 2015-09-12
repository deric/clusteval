.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

TransClustSimMatrixDataSetFormat
================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class TransClustSimMatrixDataSetFormat extends RelativeDataSetFormat

   :author: Christian Wiwie

Constructors
------------
TransClustSimMatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustSimMatrixDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: TransClustSimMatrixDataSetFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

TransClustSimMatrixDataSetFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustSimMatrixDataSetFormat(TransClustSimMatrixDataSetFormat other) throws RegisterException
   :outertype: TransClustSimMatrixDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: TransClustSimMatrixDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: TransClustSimMatrixDataSetFormat

