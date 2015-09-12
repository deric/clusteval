.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

MCLRunResultFormat
==================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class MCLRunResultFormat extends RunResultFormat

   :author: Christian Wiwie

Constructors
------------
MCLRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCLRunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: MCLRunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

MCLRunResultFormat
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCLRunResultFormat(MCLRunResultFormat other) throws RegisterException
   :outertype: MCLRunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

