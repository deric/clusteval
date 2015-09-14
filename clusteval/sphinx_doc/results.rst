	
Run Results
----------
When a run is performed, a unique run identifier is determined which includes the start time and date and the name of the run. If the run exampleRun is performed at the 5th of July 2012 at 12:58:38, its unique run identifier is::

	06_05_2012-12_58_38_exampleRun

which is also used as the subfolder to store its results in::

	<REPOSITORY ROOT>/results/06_05_2012-12_58_38_exampleRun.

Every such folder contains some subfolders. Common to all run types are the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/configs : Contains the configuration files that are used in this run, which includes all data-, dataset-, goldstandard- and program configurations as well as the run file.
* <REPOSITORY ROOT>/results/<runIdentifier>/inputs : Contains backups of all the input files used in this run, which includes all datasets referenced by the data configurations.
* <REPOSITORY ROOT>/results/<runIdentifier>/goldstandards : Contains backups of all the goldstandard files used in this run.
* <REPOSITORY ROOT>/results/<runIdentifier>/logs : Contains different log files, one for the complete run and one for every iteration performed during the run.

Execution Run Results
^^^^^^^^
Execution run result folders additionally contain the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/clusters

Analysis Run Results
^^^^^^^^^^^
Analysis run result folders additionally contain the following subfolders:

* <REPOSITORY ROOT>/results/<runIdentifier>/analyses