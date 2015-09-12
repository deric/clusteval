RUN_STATUS
==========

.. java:package:: de.clusteval.run
   :noindex:

.. java:type:: public enum RUN_STATUS

   During execution of a run, the corresponding object has a certain status.

Enum Constants
--------------
FINISHED
^^^^^^^^

.. java:field:: public static final RUN_STATUS FINISHED
   :outertype: RUN_STATUS

   When the job containing all its subprocesses is completely finished, its status is changed to FINISHED.

INACTIVE
^^^^^^^^

.. java:field:: public static final RUN_STATUS INACTIVE
   :outertype: RUN_STATUS

   When a job is just inactive

RUNNING
^^^^^^^

.. java:field:: public static final RUN_STATUS RUNNING
   :outertype: RUN_STATUS

   As soon as ressourcess are available, the scheduler starts the job and its status is changed to RUNNING.

SCHEDULED
^^^^^^^^^

.. java:field:: public static final RUN_STATUS SCHEDULED
   :outertype: RUN_STATUS

   Immediately after giving the command to execute the job, it is added to the queue of the \ :java:ref:`de.clusteval.framework.threading.RunSchedulerThread`\  with status SCHEDULED.

TERMINATED
^^^^^^^^^^

.. java:field:: public static final RUN_STATUS TERMINATED
   :outertype: RUN_STATUS

   When a job is terminated before it was finished, its status is changed to TERMINATED.

