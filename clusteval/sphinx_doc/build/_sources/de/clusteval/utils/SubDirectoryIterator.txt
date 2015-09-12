.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

SubDirectoryIterator
====================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class SubDirectoryIterator implements Iterator<File>

   :author: Christian Wiwie

Fields
------
files
^^^^^

.. java:field:: protected List<File> files
   :outertype: SubDirectoryIterator

pos
^^^

.. java:field:: protected int pos
   :outertype: SubDirectoryIterator

Constructors
------------
SubDirectoryIterator
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SubDirectoryIterator(File file)
   :outertype: SubDirectoryIterator

   :param file:

Methods
-------
hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: SubDirectoryIterator

next
^^^^

.. java:method:: @Override public File next()
   :outertype: SubDirectoryIterator

remove
^^^^^^

.. java:method:: @Override public void remove()
   :outertype: SubDirectoryIterator

