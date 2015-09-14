.. java:import:: java.io File

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

SocialNetworkDataSetType
========================

.. java:package:: de.clusteval.data.dataset.type
   :noindex:

.. java:type:: public class SocialNetworkDataSetType extends DataSetType

   :author: Christian Wiwie

Constructors
------------
SocialNetworkDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SocialNetworkDataSetType(Repository repository, boolean register, long changeDate, File absPath) throws RegisterException
   :outertype: SocialNetworkDataSetType

   :param repository:
   :param register:
   :param changeDate:
   :param absPath:
   :throws RegisterException:

SocialNetworkDataSetType
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SocialNetworkDataSetType(SocialNetworkDataSetType other) throws RegisterException
   :outertype: SocialNetworkDataSetType

   The copy constructor for this type.

   :param other: The object to clone.
   :throws RegisterException:

Methods
-------
getAlias
^^^^^^^^

.. java:method:: @Override public String getAlias()
   :outertype: SocialNetworkDataSetType

