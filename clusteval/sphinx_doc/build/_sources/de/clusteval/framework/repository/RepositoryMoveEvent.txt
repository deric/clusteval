RepositoryMoveEvent
===================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RepositoryMoveEvent implements RepositoryEvent

   A \ :java:ref:`RepositoryMoveEvent`\  is created, when some repository object is replaced by another repository object, where replacing means, that the old object is unregistered and the new object is registered instead.

   The replace-constraints are enforced by the repository in the register methods. For example an object \ **old**\  is only replaced by another object \ **new**\ , if \ **old.equals(new)**\ .

   When this event is created, the replacement already happend and it is the job of the receiver of this event, to handle the replacement gracefully, e.g. updating references from the old to the new object.

   :author: Christian Wiwie

Fields
------
object
^^^^^^

.. java:field:: protected RepositoryObject object
   :outertype: RepositoryMoveEvent

   The object, that has been moved.

Constructors
------------
RepositoryMoveEvent
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryMoveEvent(RepositoryObject object)
   :outertype: RepositoryMoveEvent

   :param object: The object, that has been moved.

Methods
-------
getObject
^^^^^^^^^

.. java:method:: public RepositoryObject getObject()
   :outertype: RepositoryMoveEvent

   :return: The object, that has been replaced and unregistered from the repository.

