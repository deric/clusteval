.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

TabSeparatedRunResultFormat
===========================

.. java:package:: de.clusteval.run.result.format
   :noindex:

.. java:type:: public class TabSeparatedRunResultFormat extends RunResultFormat

   This is the standard result format of ClustEval. It contains a parameter set together with the resulting clustering in each line. Let the parameters and their values be defined as :math:`p_1 = v_1, ... , p_M = v_M` and let the clusters be :math:`c_1, ..., c_K` with sizes :math:`|c_i| = s_i`. Every cluster :math:`c_i` contains elements :math:`e_{i_1}, ..., e_{i_{s_i}}` with fuzzy coefficients :math:`f_{i_1}, ..., f_{i_{s_i}}`. Then the format describing these parameter values and clustering looks as follows:

   :math:`\begin{tabular}{ll} $p_1$, \ldots , $p_M$ & Clustering \\ $v_1$, \ldots ,$v_M$ & $e_{1_1}:f_{1_1}$, \ldots ,$e_{1_{s_1}}:f_{1_{s_1}}$; \ldots ; $e_{K_1}:f_{K_1}$, \ldots ,$e_{K_{s_1}}:f_{K_{s_1}}$ \end{tabular}`

   The parameter names and values on the left have to be separated by a TAB from the string "Clustering" and the clustering on the right. If the fuzzy coefficients are missing, the framework will not be able to parse the result file.

   Example with two parameters A and B and a clustering of five objects into two clusters::

     A,B    Clustering
     0.1,3    id1:1.0,id4:1.0,id5:1.0;id2:1.0,id3:1.0

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

