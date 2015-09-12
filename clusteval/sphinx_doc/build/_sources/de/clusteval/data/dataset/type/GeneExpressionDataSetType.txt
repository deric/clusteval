.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

GeneExpressionDataSetType
=========================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class GeneExpressionDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
GeneExpressionDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GeneExpressionDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: GeneExpressionDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

GeneExpressionDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public GeneExpressionDataSetType(GeneExpressionDataSetType other) throws RegisterException
   :outertype: GeneExpressionDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: GeneExpressionDataSetType

