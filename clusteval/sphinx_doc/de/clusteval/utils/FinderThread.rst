.. java:import:: org.slf4j Logger

.. java:import:: org.slf4j LoggerFactory

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.framework.repository RepositoryObject

.. java:import:: de.clusteval.framework.threading ClustevalThread

.. java:import:: de.clusteval.framework.threading SupervisorThread

FinderThread
============

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public abstract class FinderThread<T extends RepositoryObject> extends ClustevalThread

   :author: Christian Wiwie

Fields
------
checkOnce
^^^^^^^^^

.. java:field:: protected boolean checkOnce
   :outertype: FinderThread

classToFind
^^^^^^^^^^^

.. java:field:: protected Class<T> classToFind
   :outertype: FinderThread

currentFinder
^^^^^^^^^^^^^

.. java:field:: protected Finder<T> currentFinder
   :outertype: FinderThread

log
^^^

.. java:field:: protected Logger log
   :outertype: FinderThread

repository
^^^^^^^^^^

.. java:field:: protected Repository repository
   :outertype: FinderThread

sleepTime
^^^^^^^^^

.. java:field:: protected long sleepTime
   :outertype: FinderThread

Constructors
------------
FinderThread
^^^^^^^^^^^^

.. java:constructor:: public FinderThread(SupervisorThread supervisorThread, Repository repository, Class<T> classToFind, boolean checkOnce)
   :outertype: FinderThread

   :param supervisorThread:
   :param repository:
   :param classToFind:
   :param checkOnce:

FinderThread
^^^^^^^^^^^^

.. java:constructor:: public FinderThread(SupervisorThread supervisorThread, Repository repository, Class<T> classToFind, long sleepTime, boolean checkOnce)
   :outertype: FinderThread

   :param supervisorThread:
   :param repository:
   :param classToFind:
   :param sleepTime:
   :param checkOnce:

Methods
-------
afterFind
^^^^^^^^^

.. java:method:: protected void afterFind()
   :outertype: FinderThread

beforeFind
^^^^^^^^^^

.. java:method:: protected void beforeFind()
   :outertype: FinderThread

getFinder
^^^^^^^^^

.. java:method:: protected abstract Finder<T> getFinder() throws RegisterException
   :outertype: FinderThread

run
^^^

.. java:method:: @Override public void run()
   :outertype: FinderThread

