.. java:import:: java.io File

.. java:import:: de.clusteval.data DataConfig

IterationWrapper
================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public class IterationWrapper

Fields
------
dataConfig
^^^^^^^^^^

.. java:field:: protected DataConfig dataConfig
   :outertype: IterationWrapper

isResume
^^^^^^^^

.. java:field:: protected boolean isResume
   :outertype: IterationWrapper

logfile
^^^^^^^

.. java:field:: protected File logfile
   :outertype: IterationWrapper

   A temporary variable holding a file object pointing to the absolute path of the current log output file during execution of the runnable

runnable
^^^^^^^^

.. java:field:: protected RunRunnable runnable
   :outertype: IterationWrapper

Constructors
------------
IterationWrapper
^^^^^^^^^^^^^^^^

.. java:constructor:: public IterationWrapper()
   :outertype: IterationWrapper

Methods
-------
getDataConfig
^^^^^^^^^^^^^

.. java:method:: protected DataConfig getDataConfig()
   :outertype: IterationWrapper

getLogfile
^^^^^^^^^^

.. java:method:: protected File getLogfile()
   :outertype: IterationWrapper

getRunnable
^^^^^^^^^^^

.. java:method:: protected RunRunnable getRunnable()
   :outertype: IterationWrapper

isResume
^^^^^^^^

.. java:method:: public boolean isResume()
   :outertype: IterationWrapper

setDataConfig
^^^^^^^^^^^^^

.. java:method:: protected void setDataConfig(DataConfig dataConfig)
   :outertype: IterationWrapper

setLogfile
^^^^^^^^^^

.. java:method:: protected void setLogfile(File logfile)
   :outertype: IterationWrapper

setResume
^^^^^^^^^

.. java:method:: public void setResume(boolean isResume)
   :outertype: IterationWrapper

setRunnable
^^^^^^^^^^^

.. java:method:: protected void setRunnable(RunRunnable runnable)
   :outertype: IterationWrapper

