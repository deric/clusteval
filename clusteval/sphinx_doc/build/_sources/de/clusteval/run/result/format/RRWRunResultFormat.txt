.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

RRWRunResultFormat
==================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class RRWRunResultFormat extends RunResultFormat

   :author: Christian Wiwie

Constructors
------------
RRWRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RRWRunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: RRWRunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

RRWRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RRWRunResultFormat(RRWRunResultFormat other) throws RegisterException
   :outertype: RRWRunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

