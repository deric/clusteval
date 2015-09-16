.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

TransClustSimMatrixDataSetFormat
================================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class TransClustSimMatrixDataSetFormat extends RelativeDataSetFormat

   This format is used by Transitivity Clustering. The number in the first line is the number of objects. It is followed by all object ids in the next lines. Then it follows the tab-separated upper half of the similarity matrix. This format expects that the similarity matrix is symmetric.

   Example::

     3
     id1
     id2
     id3
     id4
     0.1  0.2  0.6
     0.3  0.5
     0.8

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

