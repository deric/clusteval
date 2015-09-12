.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

clusterONERunResultFormat
=========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class clusterONERunResultFormat extends RunResultFormat

   :author: Christian Wiwie

Constructors
------------
clusterONERunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public clusterONERunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: clusterONERunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

clusterONERunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public clusterONERunResultFormat(clusterONERunResultFormat other) throws RegisterException
   :outertype: clusterONERunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

