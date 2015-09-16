.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils FormatVersion

SimMatrixDataSetFormat
======================

.. java:package:: de.clusteval.data.dataset.format
   :noindex:

.. java:type:: @FormatVersion public class SimMatrixDataSetFormat extends RelativeDataSetFormat

   The SimMatrixDataSetFormat is a complete quadratic tab-separated similarity matrix with header row and column (containing ids). There are no spaces in this file, only tabs. It does not necessarily need to be symmetric, it depends on the clustering method, whether it supports asymmetric similarity data.

   Example:

   ===== === === === === === ===
   tab   Id1 Id2 Id3 Id4 Id5 ...
   ===== === === === === === ===
   Id1   1.0 0.6 0.2 0.5 0.6 ...
   Id2   0.6 1.0 0.1 0.5 0.4 ...
   Id3   0.2 0.1 1.0 0.7 0.1 ...
   Id4   0.5 0.5 0.7 1.0 0.4 ...
   Id5   0.6 0.4 0.1 0.4 1.0 ...
   ...   ... ... ... ... ... ...
   ===== === === === === === ===

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

