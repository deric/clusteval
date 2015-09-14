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

   The BLAST dataset format expects an all-vs-all BLAST file in m8 format and a corresponding FASTA file.

   Please note, that the FASTA file has to be named exactly as the BLAST file plus the additional .fasta extension. If the BLAST file is named like MyBlastFile.blast, then the FASTA file only be found by the framework, when it lies in the same directory and is named MyBlastFile.blast.fasta.

   ========  ========= =====   ================ ========== ============ ======= ===== ======= ===== ======= =========
   Query     Subject   % id    alignment length mismatches gap openings q.start q.end s.start s.end e-value bit score
   ========  ========= =====   ================ ========== ============ ======= ===== ======= ===== ======= =========
   d1dlwa\_  d1dlwa\_  77.59   116              0          0            1       116   1       116   4.4e-46 172.6
   d1dlwa\_  d1idra\_  40.30   67               40         0            19      85    31      97    3.2e-12 60.08
   d1dlwa\_  d1dlya\_  32.00   100              62         1            19      116   19      118   1.6e-11 57.77
   d1dlwa\_  d2gdm\_\_ 45.45   22               12         0            60      81    89      110   0.435   23.10
   d1dlwa\_  d1cqxa1   37.50   24               15         0            62      85    79      102   0.969   21.94
   d1dlwa\_  d1cqxa1   40.00   5                3          0            71      75    134     138   4975.0  9.62
   d1dlwa\_  d1kr7a\_  31.25   32               22         0            41      72    45      76    4.8     19.63
   ========  ========= =====   ================ ========== ============ ======= ===== ======= ===== ======= =========

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

