.. java:import:: java.io IOException

.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.framework RLibraryNotLoadedException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RunResultRepository

.. java:import:: de.clusteval.framework.threading RunSchedulerThread

.. java:import:: de.clusteval.run Run

.. java:import:: de.clusteval.utils RNotAvailableException

IterationRunnable
=================

.. java:package:: de.clusteval.run.runnable
   :noindex:

.. java:type:: public abstract class IterationRunnable<IW extends IterationWrapper> implements Runnable

   :author: Christian Wiwie

Fields
------
interruptedException
^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected InterruptedException interruptedException
   :outertype: IterationRunnable

ioException
^^^^^^^^^^^

.. java:field:: protected IOException ioException
   :outertype: IterationRunnable

iterationWrapper
^^^^^^^^^^^^^^^^

.. java:field:: protected IW iterationWrapper
   :outertype: IterationRunnable

log
^^^

.. java:field:: protected Logger log
   :outertype: IterationRunnable

rLibraryException
^^^^^^^^^^^^^^^^^

.. java:field:: protected RLibraryNotLoadedException rLibraryException
   :outertype: IterationRunnable

rNotAvailableException
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected RNotAvailableException rNotAvailableException
   :outertype: IterationRunnable

startTime
^^^^^^^^^

.. java:field:: protected long startTime
   :outertype: IterationRunnable

Constructors
------------
IterationRunnable
^^^^^^^^^^^^^^^^^

.. java:constructor:: public IterationRunnable(IW iterationWrapper)
   :outertype: IterationRunnable

Methods
-------
afterRun
^^^^^^^^

.. java:method:: protected void afterRun()
   :outertype: IterationRunnable

beforeRun
^^^^^^^^^

.. java:method:: protected void beforeRun()
   :outertype: IterationRunnable

doRun
^^^^^

.. java:method:: protected abstract void doRun() throws InterruptedException
   :outertype: IterationRunnable

getInterruptedException
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public InterruptedException getInterruptedException()
   :outertype: IterationRunnable

getIoException
^^^^^^^^^^^^^^

.. java:method:: public IOException getIoException()
   :outertype: IterationRunnable

   :return: the ioException

getParentRunnable
^^^^^^^^^^^^^^^^^

.. java:method:: public RunRunnable getParentRunnable()
   :outertype: IterationRunnable

getRun
^^^^^^

.. java:method:: public Run getRun()
   :outertype: IterationRunnable

getStartTime
^^^^^^^^^^^^

.. java:method:: public long getStartTime()
   :outertype: IterationRunnable

getrLibraryException
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public RLibraryNotLoadedException getrLibraryException()
   :outertype: IterationRunnable

   :return: the rLibraryException

getrNotAvailableException
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public RNotAvailableException getrNotAvailableException()
   :outertype: IterationRunnable

   :return: the rNotAvailableException

run
^^^

.. java:method:: @Override public final void run()
   :outertype: IterationRunnable

