RepositoryReplaceEvent
======================

.. java:package:: de.clusteval.framework.repository
   :noindex:

.. java:type:: public class RepositoryReplaceEvent implements RepositoryEvent

   A \ :java:ref:`RepositoryReplaceEvent`\  is created, when some repository object is replaced by another repository object, where replacing means, that the old object is unregistered and the new object is registered instead.

   The replace-constraints are enforced by the repository in the register methods. For example an object \ **old**\  is only replaced by another object \ **new**\ , if \ **old.equals(new)**\ .

   When this event is created, the replacement already happend and it is the job of the receiver of this event, to handle the replacement gracefully, e.g. updating references from the old to the new object.

   :author: Christian Wiwie

Fields
------
old
^^^

.. java:field:: protected RepositoryObject old
   :outertype: RepositoryReplaceEvent

   The object, that has been replaced and unregistered from the repository.

replacement
^^^^^^^^^^^

.. java:field:: protected RepositoryObject replacement
   :outertype: RepositoryReplaceEvent

   The object, that has replaced the old object and was registered at the repository.

Constructors
------------
RepositoryReplaceEvent
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RepositoryReplaceEvent(RepositoryObject old, RepositoryObject replacement)
   :outertype: RepositoryReplaceEvent

   :param old: The object, that has been replaced and unregistered from the repository.
   :param replacement: The object, that has replaced the old object and was registered at the repository.

Methods
-------
getOld
^^^^^^

.. java:method:: public RepositoryObject getOld()
   :outertype: RepositoryReplaceEvent

   :return: The object, that has been replaced and unregistered from the repository.

getReplacement
^^^^^^^^^^^^^^

.. java:method:: public RepositoryObject getReplacement()
   :outertype: RepositoryReplaceEvent

   :return: The object, that has replaced the old object and was registered at the repository.

