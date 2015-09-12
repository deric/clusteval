.. java:import:: java.io File

.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

RecursiveSubDirectoryIterator
=============================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class RecursiveSubDirectoryIterator implements Iterator<File>

   :author: Christian Wiwie

Fields
------
files
^^^^^

.. java:field:: protected List<File> files
   :outertype: RecursiveSubDirectoryIterator

pos
^^^

.. java:field:: protected int pos
   :outertype: RecursiveSubDirectoryIterator

Constructors
------------
RecursiveSubDirectoryIterator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RecursiveSubDirectoryIterator(File file)
   :outertype: RecursiveSubDirectoryIterator

   :param file:

Methods
-------
hasNext
^^^^^^^

.. java:method:: @Override public boolean hasNext()
   :outertype: RecursiveSubDirectoryIterator

next
^^^^

.. java:method:: @Override public File next()
   :outertype: RecursiveSubDirectoryIterator

remove
^^^^^^

.. java:method:: @Override public void remove()
   :outertype: RecursiveSubDirectoryIterator

search
^^^^^^

.. java:method:: protected void search(File file)
   :outertype: RecursiveSubDirectoryIterator

