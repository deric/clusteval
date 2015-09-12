.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

MatrixRankRDataStatistic
========================

.. java:package:: de.clusteval.data.statistics
   :noindex:

.. java:type:: public class MatrixRankRDataStatistic extends DoubleValueDataStatistic

   :author: Christian Wiwie

Constructors
------------
MatrixRankRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixRankRDataStatistic(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: MatrixRankRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

MatrixRankRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixRankRDataStatistic(Repository repository, boolean register, long changeDate, File absPath, double value) throws RegisterException
   :outertype: MatrixRankRDataStatistic

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :param value:
   :throws RegisterException:

MatrixRankRDataStatistic
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatrixRankRDataStatistic(MatrixRankRDataStatistic other) throws RegisterException
   :outertype: MatrixRankRDataStatistic

   The copy constructor for this statistic.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: MatrixRankRDataStatistic

requiresGoldStandard
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean requiresGoldStandard()
   :outertype: MatrixRankRDataStatistic

