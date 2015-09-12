.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

TransClustRunResultFormat
=========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class TransClustRunResultFormat extends RunResultFormat

   :author: Christian Wiwie

Constructors
------------
TransClustRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustRunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: TransClustRunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

TransClustRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TransClustRunResultFormat(TransClustRunResultFormat other) throws RegisterException
   :outertype: TransClustRunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

