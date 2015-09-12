.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

SubSubDirectoryIterator
=======================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class SubSubDirectoryIterator implements Iterator<File>

   :author: Christian Wiwie

Fields
------
files
^^^^^

.. java:field:: protected List<File> files
   :outertype: SubSubDirectoryIterator

pos
^^^

.. java:field:: protected int pos
   :outertype: SubSubDirectoryIterator

Constructors
------------
SubSubDirectoryIterator
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public SubSubDirectoryIterator(File file)
   :outertype: SubSubDirectoryIterator

   :param file:

Methods
-------
hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: SubSubDirectoryIterator

next
^^^^

.. java:method:: @Override public File next()
   :outertype: SubSubDirectoryIterator

remove
^^^^^^

.. java:method:: @Override public void remove()
   :outertype: SubSubDirectoryIterator

