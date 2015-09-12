.. java:import:: ch.qos.logback.classic Level

.. java:import:: ch.qos.logback.classic.pattern.color HighlightingCompositeConverter

.. java:import:: ch.qos.logback.classic.spi ILoggingEvent

MyHighlightingCompositeConverter
================================

.. java:package:: de.clusteval.utils
   :noindex:

.. java:type:: public class MyHighlightingCompositeConverter extends HighlightingCompositeConverter

   :author: Christian Wiwie

Constructors
------------
MyHighlightingCompositeConverter
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MyHighlightingCompositeConverter()
   :outertype: MyHighlightingCompositeConverter

Methods
-------
getForegroundColorCode
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected String getForegroundColorCode(ILoggingEvent event)
   :outertype: MyHighlightingCompositeConverter

