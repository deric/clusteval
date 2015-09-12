.. java:import:: java.util.concurrent.atomic AtomicBoolean

ClustevalThread
===============

.. java:package:: de.clusteval.framework.threading
   :noindex:

.. java:type:: public class ClustevalThread extends Thread

   :author: Christian Wiwie

Fields
------
supervisorThread
^^^^^^^^^^^^^^^^

.. java:field:: protected SupervisorThread supervisorThread
   :outertype: ClustevalThread

Constructors
------------
ClustevalThread
^^^^^^^^^^^^^^^

.. java:constructor:: public ClustevalThread(SupervisorThread supervisorThread)
   :outertype: ClustevalThread

   :param supervisorThread:

Methods
-------
getSupervisorThread
^^^^^^^^^^^^^^^^^^^

.. java:method:: public SupervisorThread getSupervisorThread()
   :outertype: ClustevalThread

   :return: The supervisor thread that created this thread.

setInitialized
^^^^^^^^^^^^^^

.. java:method:: protected void setInitialized()
   :outertype: ClustevalThread

start
^^^^^

.. java:method:: @Override public synchronized void start()
   :outertype: ClustevalThread

waitFor
^^^^^^^

.. java:method:: public void waitFor()
   :outertype: ClustevalThread

