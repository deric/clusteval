RepositoryRemoveEvent
=====================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RepositoryRemoveEvent implements RepositoryEvent

   A \ :java:ref:`RepositoryRemoveEvent`\  is created, when some \ :java:ref:`RepositoryObject`\  is unregistered from the repository, but not replaced.

   When this event is created, the removal already happend and it is the job of the receiver of this event, to handle the removal gracefully, e.g. remove themselves from the repository, in case they depended on the removed object.

   :author: Christian Wiwie

Fields
------
old
^^^

.. java:field:: protected RepositoryObject old
   :outertype: RepositoryRemoveEvent

   The object, that has been unregistered from the repository.

Constructors
------------
RepositoryRemoveEvent
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryRemoveEvent(RepositoryObject old)
   :outertype: RepositoryRemoveEvent

   :param old: The object, that has been unregistered from the repository.

Methods
-------
getRemovedObject
^^^^^^^^^^^^^^^^

.. java:method:: public RepositoryObject getRemovedObject()
   :outertype: RepositoryRemoveEvent

   :return: The object, that has been unregistered from the repository.

