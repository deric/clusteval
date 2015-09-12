.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

MCODERunResultFormat
====================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class MCODERunResultFormat extends RunResultFormat

   :author: Christian Wiwie

Constructors
------------
MCODERunResultFormat
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCODERunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: MCODERunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

MCODERunResultFormat
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MCODERunResultFormat(MCODERunResultFormat other) throws RegisterException
   :outertype: MCODERunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

