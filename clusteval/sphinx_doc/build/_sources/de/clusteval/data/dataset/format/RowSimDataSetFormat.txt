.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

RowSimDataSetFormat
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class RowSimDataSetFormat extends RelativeDataSetFormat

   This input format consists of tab-separated rows looking as follows:

   ==========   ==========  ==================
   id1          id2         similarity
   ==========   ==========  ==================
   gi15801179   gi16129025  323.3062153431158
   gi15801179   gi24112473  323.3062153431158
   gi15801179   gi1651519   323.3062153431158
   gi15801179   gi16764519  323.3062153431158
   gi15801179   gi16760039  323.3062153431158
   gi15801179   gi279570    323.3062153431158
   gi15801179   gi1346930   3.0969100130080562
   gi15801179   gi16078614  3.0
   gi15801179   gi3122654   3.0
   gi15801179   gi3024509   1.537602002101044
   gi15801179   gi21294381  0.8538719643217619
   gi15801179   gi400909    0.8239087409443188
   gi15801179   gi279582    0.8239087409443188
   ==========   ==========  ==================

   :author: Christian Wiwie

Constructors
------------
RowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RowSimDataSetFormat(Repository repo, boolean register, long changeDate, File absPath, int version) throws RegisterException
   :outertype: RowSimDataSetFormat

   Instantiates a new row sim data set format.

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :param version:
   :throws RegisterException:

RowSimDataSetFormat
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RowSimDataSetFormat(RowSimDataSetFormat other) throws RegisterException
   :outertype: RowSimDataSetFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: RowSimDataSetFormat

getDataSetFormatParser
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected DataSetFormatParser getDataSetFormatParser()
   :outertype: RowSimDataSetFormat

