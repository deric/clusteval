.. java:import:: java.io File

.. java:import:: java.net MalformedURLException

.. java:import:: java.net URL

.. java:import:: java.net URLClassLoader

.. java:import:: java.util Iterator

.. java:import:: utils ArrayIterator

.. java:import:: de.clusteval.framework.repository RegisterException

.. java:import:: de.clusteval.framework.repository Repository

.. java:import:: de.clusteval.utils JARFinder

RProgramFinder
==============

.. java:package:: de.clusteval.program.r
   :noindex:

.. java:type:: public class RProgramFinder extends JARFinder<RProgram>

   Objects of this class look for new RPrograms in the program-directory defined in the corresponding repository.

   :author: Christian Wiwie

Constructors
------------
RProgramFinder
^^^^^^^^^^^^^^

.. java:constructor:: public RProgramFinder(Repository repository) throws RegisterException
   :outertype: RProgramFinder

   Instantiates a new RProgram finder.

   :param repository: the repository
   :throws RegisterException:

Methods
-------
checkFile
^^^^^^^^^

.. java:method:: @Override protected boolean checkFile(File file)
   :outertype: RProgramFinder

classNamesForJARFile
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String[] classNamesForJARFile(File f)
   :outertype: RProgramFinder

getIterator
^^^^^^^^^^^

.. java:method:: @Override protected Iterator<File> getIterator()
   :outertype: RProgramFinder

getURLClassLoader0
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected URLClassLoader getURLClassLoader0(File f, ClassLoader parent) throws MalformedURLException
   :outertype: RProgramFinder

isJARLoaded
^^^^^^^^^^^

.. java:method:: @Override protected boolean isJARLoaded(File f)
   :outertype: RProgramFinder

