.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

TabSeparatedRunResultFormat
===========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class TabSeparatedRunResultFormat extends RunResultFormat

   The Class InternalRunResultFormat.

   :author: Christian Wiwie

Constructors
------------
TabSeparatedRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TabSeparatedRunResultFormat(Repository repo, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: TabSeparatedRunResultFormat

   :param repo:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

TabSeparatedRunResultFormat
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public TabSeparatedRunResultFormat(TabSeparatedRunResultFormat other) throws RegisterException
   :outertype: TabSeparatedRunResultFormat

   The copy constructor for this format.

   :param other: The object to clone.
   :throws RegisterException:

