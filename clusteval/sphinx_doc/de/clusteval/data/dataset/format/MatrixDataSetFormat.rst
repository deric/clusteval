.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

MatrixDataSetFormat
===================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class MatrixDataSetFormat extends AbsoluteDataSetFormat

   This input format is an absolute dataset format, that means it contains
   samples together with their absolute coordinates:

   == ====================  =================== ====================
   id Coordinate 1          Coordinate 2        More Coordinates ...
   == ====================  =================== ====================
   1  0.3906545801525463    -1.0438401650637388
   2  -0.11979296618862012  -1.3270683467388154
   3  -0.7806096346173024   -1.3467960953712463
   4  -0.7524701467920664   -1.2837891183793544
   5  1.2399528585508164    -1.195667176693678
   6  0.04637030350829807   -1.3973623137921094
   7  0.7002680213377306    -0.6829767350107432
   8  1.308168258994284     -0.9344943936914205
   9  -0.8152683055235531   -1.4669268283993007
   10 1.2038097787482234    -0.8748601958155633
   11 0.8899462850502733    -0.6867149177938701
   12 -0.998549301559696    -0.9267734743654727
   13 -1.1530071769533163   -0.7855240635573864
   == ====================  =================== ====================

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

