RLibraryNotLoadedException
==========================

.. java:package:: de.clusteval.framework
   :noindex:

.. java:type:: public class RLibraryNotLoadedException extends Exception

   This exception indicates that a certain class required an R library, which could not be loaded.

   :author: Christian Wiwie

Fields
------
className
^^^^^^^^^

.. java:field:: protected String className
   :outertype: RLibraryNotLoadedException

   The name of the class that required the library.

rLibrary
^^^^^^^^

.. java:field:: protected String rLibrary
   :outertype: RLibraryNotLoadedException

   The name of the Rlibrary that could not be loaded.

Constructors
------------
RLibraryNotLoadedException
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public RLibraryNotLoadedException(String className, String rLibrary)
   :outertype: RLibraryNotLoadedException

   :param className: The name of the class that required the library.
   :param rLibrary: The name of the Rlibrary that could not be loaded.

Methods
-------
equals
^^^^^^

.. java:method:: @Override public boolean equals(Object obj)
   :outertype: RLibraryNotLoadedException

getClassName
^^^^^^^^^^^^

.. java:method:: public String getClassName()
   :outertype: RLibraryNotLoadedException

   :return: The name of the class that required the library.

getRLibrary
^^^^^^^^^^^

.. java:method:: public String getRLibrary()
   :outertype: RLibraryNotLoadedException

   :return: The name of the Rlibrary that could not be loaded.

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: RLibraryNotLoadedException

