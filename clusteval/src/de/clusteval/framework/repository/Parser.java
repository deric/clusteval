/**
 * 
 */
package de.clusteval.framework.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.clusteval.cluster.paramOptimization.IncompatibleParameterOptimizationMethodException;
import de.clusteval.cluster.paramOptimization.InvalidOptimizationParameterException;
import de.clusteval.cluster.paramOptimization.ParameterOptimizationMethod;
import de.clusteval.cluster.paramOptimization.UnknownParameterOptimizationMethodException;
import de.clusteval.cluster.quality.ClusteringQualityMeasure;
import de.clusteval.cluster.quality.UnknownClusteringQualityMeasureException;
import de.clusteval.context.Context;
import de.clusteval.context.IncompatibleContextException;
import de.clusteval.context.UnknownContextException;
import de.clusteval.data.DataConfig;
import de.clusteval.data.DataConfigNotFoundException;
import de.clusteval.data.DataConfigurationException;
import de.clusteval.data.dataset.DataSetConfigNotFoundException;
import de.clusteval.data.dataset.DataSetConfigurationException;
import de.clusteval.data.dataset.DataSetNotFoundException;
import de.clusteval.data.dataset.IncompatibleDataSetConfigPreprocessorException;
import de.clusteval.data.dataset.NoDataSetException;
import de.clusteval.data.dataset.format.UnknownDataSetFormatException;
import de.clusteval.data.dataset.type.UnknownDataSetTypeException;
import de.clusteval.data.distance.UnknownDistanceMeasureException;
import de.clusteval.data.goldstandard.GoldStandardConfigNotFoundException;
import de.clusteval.data.goldstandard.GoldStandardConfigurationException;
import de.clusteval.data.goldstandard.GoldStandardNotFoundException;
import de.clusteval.data.preprocessing.UnknownDataPreprocessorException;
import de.clusteval.program.NoOptimizableProgramParameterException;
import de.clusteval.program.ProgramConfig;
import de.clusteval.program.ProgramParameter;
import de.clusteval.program.UnknownParameterType;
import de.clusteval.program.UnknownProgramParameterException;
import de.clusteval.program.UnknownProgramTypeException;
import de.clusteval.program.r.UnknownRProgramException;
import de.clusteval.run.ExecutionRun;
import de.clusteval.run.ParameterOptimizationRun;
import de.clusteval.run.RunException;
import de.clusteval.run.result.format.UnknownRunResultFormatException;
import file.FileUtils;

/**
 * @author Christian Wiwie
 * 
 */
public abstract class Parser {

	/**
	 * @param absPath
	 * @return
	 * @throws UnknownDataSetFormatException
	 * @throws GoldStandardNotFoundException
	 * @throws GoldStandardConfigurationException
	 * @throws DataSetConfigurationException
	 * @throws DataSetNotFoundException
	 * @throws DataSetConfigNotFoundException
	 * @throws GoldStandardConfigNotFoundException
	 * @throws NoDataSetException
	 * @throws NumberFormatException
	 * @throws DataConfigurationException
	 * @throws DataConfigNotFoundException
	 * @throws RegisterException
	 * @throws ConfigurationException
	 * @throws FileNotFoundException
	 * @throws UnknownContextException
	 * @throws UnknownParameterType
	 * @throws IncompatibleParameterOptimizationMethodException
	 * @throws UnknownParameterOptimizationMethodException
	 * @throws RunException
	 * @throws UnknownClusteringQualityMeasureException
	 * @throws NoOptimizableProgramParameterException
	 * @throws UnknownProgramParameterException
	 * @throws UnknownRunResultFormatException
	 * @throws NoRepositoryFoundException
	 * @throws InvalidOptimizationParameterException
	 * @throws UnknownProgramTypeException
	 * @throws UnknownRProgramException
	 * @throws IncompatibleContextException
	 * @throws UnknownDistanceMeasureException
	 * @throws UnknownDataSetTypeException
	 * @throws UnknownDataPreprocessorException
	 * @throws IncompatibleDataSetConfigPreprocessorException
	 */
	public static ParameterOptimizationRun parseParameterOptimizationRunFromFile(
			final File absPath) throws UnknownDataSetFormatException,
			GoldStandardNotFoundException, GoldStandardConfigurationException,
			DataSetConfigurationException, DataSetNotFoundException,
			DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			NumberFormatException, DataConfigurationException,
			DataConfigNotFoundException, RegisterException,
			ConfigurationException, FileNotFoundException,
			UnknownContextException, UnknownParameterType,
			IncompatibleParameterOptimizationMethodException,
			UnknownParameterOptimizationMethodException, RunException,
			UnknownClusteringQualityMeasureException,
			NoOptimizableProgramParameterException,
			UnknownProgramParameterException, UnknownRunResultFormatException,
			NoRepositoryFoundException, InvalidOptimizationParameterException,
			UnknownProgramTypeException, UnknownRProgramException,
			IncompatibleContextException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException {
		ParameterOptimizationRunParser p = new ParameterOptimizationRunParser();
		p.parseFromFile(absPath);
		return p.result;
	}
}

class RepositoryObjectParser {

	// the members of the RepositoryObject class

	protected HierarchicalINIConfiguration props;
	protected Repository repo;
	protected long changeDate;
	protected File absPath;
	protected Logger log;

	@SuppressWarnings("unused")
	public void parseFromFile(final File absPath)
			throws NoRepositoryFoundException, ConfigurationException,
			UnknownContextException, UnknownClusteringQualityMeasureException,
			RunException, UnknownDataSetFormatException, FileNotFoundException,
			RegisterException, UnknownParameterType,
			IncompatibleContextException, UnknownRunResultFormatException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, GoldStandardNotFoundException,
			GoldStandardConfigurationException, DataSetConfigurationException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			NumberFormatException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException,
			IncompatibleParameterOptimizationMethodException,
			UnknownParameterOptimizationMethodException,
			NoOptimizableProgramParameterException {

		this.props = new HierarchicalINIConfiguration(absPath.getAbsolutePath());
		this.repo = Repository.getRepositoryForPath(absPath.getAbsolutePath());
		this.changeDate = absPath.lastModified();
		this.absPath = absPath;
		this.log = LoggerFactory.getLogger(this.getClass());
	}
}

class RunParser extends RepositoryObjectParser {

	// the members of the Run class
	protected Context context;

	@Override
	public void parseFromFile(final File absPath)
			throws NoRepositoryFoundException, ConfigurationException,
			UnknownContextException, UnknownClusteringQualityMeasureException,
			RunException, UnknownDataSetFormatException, FileNotFoundException,
			RegisterException, UnknownParameterType,
			IncompatibleContextException, UnknownRunResultFormatException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, GoldStandardNotFoundException,
			GoldStandardConfigurationException, DataSetConfigurationException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			NumberFormatException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException,
			IncompatibleParameterOptimizationMethodException,
			UnknownParameterOptimizationMethodException,
			NoOptimizableProgramParameterException {
		super.parseFromFile(absPath);

		// by default we are in a clustering context
		if (props.containsKey("context"))
			context = Context.parseFromString(repo, props.getString("context"));
		else
			context = Context.parseFromString(repo, "ClusteringContext");
	}
}

class ExecutionRunParser extends RunParser {

	protected List<ProgramConfig> programConfigs;
	protected List<DataConfig> dataConfigs;
	protected List<ClusteringQualityMeasure> qualityMeasures;
	protected List<Map<ProgramParameter<?>, String>> runParamValues;
	protected Map<ProgramParameter<?>, String> paramMap;

	@Override
	public void parseFromFile(final File absPath)
			throws ConfigurationException, UnknownContextException,
			NoRepositoryFoundException,
			UnknownClusteringQualityMeasureException, RunException,
			UnknownDataSetFormatException, FileNotFoundException,
			RegisterException, UnknownParameterType,
			IncompatibleContextException, UnknownRunResultFormatException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, GoldStandardNotFoundException,
			GoldStandardConfigurationException, DataSetConfigurationException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			NumberFormatException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException,
			IncompatibleParameterOptimizationMethodException,
			UnknownParameterOptimizationMethodException,
			NoOptimizableProgramParameterException {
		super.parseFromFile(absPath);

		/*
		 * A run consists of a set of programconfigs and a set of dataconfigs,
		 * that are pairwise combined.
		 */
		programConfigs = new LinkedList<ProgramConfig>();
		dataConfigs = new LinkedList<DataConfig>();
		/*
		 * The quality measures that should be calculated for every pair of
		 * programconfig+dataconfig.
		 */
		qualityMeasures = new LinkedList<ClusteringQualityMeasure>();
		/*
		 * A list with parameter values that are set in the run config. They
		 * will overwrite the default values of the program config.
		 */
		runParamValues = new ArrayList<Map<ProgramParameter<?>, String>>();

		parseProgramConfigurations();

		parseQualityMeasures();

		parseDataConfigurations();

		ExecutionRun.checkCompatibilityQualityMeasuresDataConfigs(dataConfigs,
				qualityMeasures);
	}

	protected void parseDataConfigurations() throws RunException,
			UnknownDataSetFormatException, GoldStandardNotFoundException,
			GoldStandardConfigurationException, DataSetConfigurationException,
			DataSetNotFoundException, DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			NumberFormatException, RegisterException,
			NoRepositoryFoundException, UnknownDistanceMeasureException,
			UnknownDataSetTypeException, UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException {
		if (props.getStringArray("dataConfig").length == 0)
			throw new RunException("At least one data config must be specified");
		for (String dataConfig : props.getStringArray("dataConfig")) {
			dataConfigs.add(repo.getRegisteredObject(DataConfig
					.parseFromFile(new File(FileUtils.buildPath(
							repo.getDataConfigBasePath(), dataConfig
									+ ".dataconfig")))));
		}
	}

	protected void parseProgramConfigurations() throws RunException,
			UnknownContextException, IncompatibleContextException,
			UnknownDataSetFormatException, ConfigurationException,
			FileNotFoundException, RegisterException, UnknownParameterType,
			UnknownRunResultFormatException, NoRepositoryFoundException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, NoOptimizableProgramParameterException {

		if (props.getStringArray("programConfig").length == 0)
			throw new RunException(
					"At least one program config must be specified");
		for (String programConfig : props.getStringArray("programConfig")) {
			ProgramConfig newProgramConfig = ProgramConfig
					.parseFromFile(new File(FileUtils.buildPath(
							repo.getProgramConfigBasePath(), programConfig
									+ ".config")));

			if (!newProgramConfig.getProgram().getContext().equals(context))
				throw new IncompatibleContextException(
						"Incompatible run context (" + context
								+ ") and program context ("
								+ newProgramConfig.getProgram().getContext()
								+ ")");

			newProgramConfig = repo.getRegisteredObject(newProgramConfig);
			programConfigs.add(newProgramConfig);

			/*
			 * parse the overriding parameter-values for this program config
			 */
			parseProgramConfigParams(newProgramConfig);
		}
	}

	protected void parseProgramConfigParams(final ProgramConfig programConfig)
			throws NoOptimizableProgramParameterException,
			UnknownProgramParameterException, RunException {

		paramMap = new HashMap<ProgramParameter<?>, String>();

		if (props.getSections().contains(programConfig.getName())) {
			/*
			 * General parameters, not only for optimization.
			 */
			Iterator<String> itParams = props.getSection(
					programConfig.getName()).getKeys();
			while (itParams.hasNext()) {
				String param = itParams.next();
				if (isParamConfigurationEntry(param))
					try {
						ProgramParameter<?> p = programConfig
								.getParamWithId(param);

						if (checkParamValueToMap(param))
							paramMap.put(p,
									props.getSection(programConfig.getName())
											.getString(param));
					} catch (UnknownProgramParameterException e) {
						log.error("The run " + absPath.getName()
								+ " contained invalid parameter values: "
								+ programConfig.getProgram()
								+ " does not have a parameter " + param);
					}
			}
		}
		runParamValues.add(paramMap);
	}

	protected boolean isParamConfigurationEntry(final String name) {
		return name != null;
	}

	protected boolean checkParamValueToMap(final String param) {
		return true;
	}

	protected void parseQualityMeasures() throws RunException,
			UnknownClusteringQualityMeasureException {

		if (props.getStringArray("qualityMeasures").length == 0)
			throw new RunException(
					"At least one quality measure must be specified");
		/**
		 * We catch the exceptions such that all quality measures are tried to
		 * be loaded once so that they are ALL registered as missing in the
		 * repository.
		 */
		List<UnknownClusteringQualityMeasureException> thrownExceptions = new ArrayList<UnknownClusteringQualityMeasureException>();
		for (String qualityMeasure : props.getStringArray("qualityMeasures")) {
			try {
				qualityMeasures.add(ClusteringQualityMeasure.parseFromString(
						repo, qualityMeasure));
			} catch (UnknownClusteringQualityMeasureException e) {
				thrownExceptions.add(e);
			}
		}
		if (thrownExceptions.size() > 0) {
			// just throw the first exception
			throw thrownExceptions.get(0);
		}
	}
}

class ParameterOptimizationRunParser extends ExecutionRunParser {

	protected ParameterOptimizationRun result;
	protected List<Map<ProgramParameter<?>, String>> parameterValues;
	protected List<List<ProgramParameter<?>>> optimizationParameters;
	protected List<ParameterOptimizationMethod> optimizationMethods;
	protected String[] optimizationParas;
	protected List<ProgramParameter<?>> optParaList;
	protected String paramOptMethod;
	protected List<String> paramOptMethods;

	@Override
	public void parseFromFile(final File absPath) throws RegisterException,
			IncompatibleParameterOptimizationMethodException,
			NumberFormatException, UnknownParameterOptimizationMethodException,
			RunException, UnknownClusteringQualityMeasureException,
			NoOptimizableProgramParameterException,
			UnknownProgramParameterException, UnknownDataSetFormatException,
			ConfigurationException, FileNotFoundException,
			UnknownContextException, UnknownParameterType,
			UnknownRunResultFormatException, NoRepositoryFoundException,
			InvalidOptimizationParameterException, UnknownProgramTypeException,
			UnknownRProgramException, IncompatibleContextException,
			GoldStandardNotFoundException, GoldStandardConfigurationException,
			DataSetConfigurationException, DataSetNotFoundException,
			DataSetConfigNotFoundException,
			GoldStandardConfigNotFoundException, NoDataSetException,
			DataConfigurationException, DataConfigNotFoundException,
			UnknownDistanceMeasureException, UnknownDataSetTypeException,
			UnknownDataPreprocessorException,
			IncompatibleDataSetConfigPreprocessorException {

		this.optimizationParameters = new ArrayList<List<ProgramParameter<?>>>();
		/*
		 * The optimization methods, for every program one method.
		 */
		this.optimizationMethods = new ArrayList<ParameterOptimizationMethod>();

		super.parseFromFile(absPath);

		ClusteringQualityMeasure optimizationCriterion = null;

		String paramOptCriterion = props.getString("optimizationCriterion");
		optimizationCriterion = ClusteringQualityMeasure.parseFromString(repo,
				paramOptCriterion);
		if (!qualityMeasures.contains(optimizationCriterion))
			throw new UnknownClusteringQualityMeasureException(
					"The optimization criterion is not contained in the list of quality measures.");

		String paramOptIterations = props.getString("optimizationIterations");
		if (!props.containsKey("optimizationIterations"))
			throw new RunException(
					"The number of optimization iterations has to be specified as attribute 'optimizationIterations'");

		for (int i = 0; i < programConfigs.size(); i++) {
			for (int j = 0; j < dataConfigs.size(); j++) {

				optimizationMethods.add(ParameterOptimizationMethod
						.parseFromString(
								repo,
								paramOptMethods.get(i),
								// first we initialize the object with a null
								// reference instead of the run
								null, programConfigs.get(i),
								dataConfigs.get(j),
								optimizationParameters.get(i),
								optimizationCriterion,
								Integer.valueOf(paramOptIterations), false));
			}
		}

		result = new ParameterOptimizationRun(repo, context, changeDate,
				absPath, programConfigs, dataConfigs, qualityMeasures,
				runParamValues, optimizationParameters, optimizationMethods);
		result = (ParameterOptimizationRun) repo.getRegisteredObject(result,
				false);

		// now we set the run reference of the methods
		// added 21.03.2013: handle registering of the methods
		for (int i = 0; i < optimizationMethods.size(); i++) {
			ParameterOptimizationMethod method = optimizationMethods.get(i);
			method.setRun(result);

			method.register();
			optimizationMethods.set(i, repo.getRegisteredObject(method));
		}

		ParameterOptimizationRun.checkCompatibilityParameterOptimizationMethod(
				optimizationMethods, programConfigs, dataConfigs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.clusteval.framework.repository.ExecutionRunParser#
	 * isParamConfigurationEntry(java.lang.String)
	 */
	@Override
	protected boolean isParamConfigurationEntry(String name) {
		return super.isParamConfigurationEntry(name)
				&& !name.equals("optimizationParameters")
				&& !name.equals("optimizationMethod");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.clusteval.framework.repository.ExecutionRunParser#addParamValueToMap()
	 */
	@Override
	protected boolean checkParamValueToMap(final String param) {
		for (String optPa : optimizationParas)
			if (optPa.equals(param))
				return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.clusteval.framework.repository.ExecutionRunParser#
	 * parseProgramConfigurations()
	 */
	@Override
	protected void parseProgramConfigurations() throws RunException,
			UnknownContextException, IncompatibleContextException,
			UnknownDataSetFormatException, ConfigurationException,
			FileNotFoundException, RegisterException, UnknownParameterType,
			UnknownRunResultFormatException, NoRepositoryFoundException,
			InvalidOptimizationParameterException,
			UnknownProgramParameterException, UnknownProgramTypeException,
			UnknownRProgramException, NoOptimizableProgramParameterException {

		/*
		 * Default optimization method for all programs, where no specific
		 * method is defined
		 */
		paramOptMethod = props.getString("optimizationMethod");
		paramOptMethods = new ArrayList<String>();

		super.parseProgramConfigurations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.clusteval.framework.repository.ExecutionRunParser#
	 * parseProgramConfiguration(de.clusteval.program.ProgramConfig,
	 * java.util.Map)
	 */
	@Override
	protected void parseProgramConfigParams(ProgramConfig programConfig)
			throws NoOptimizableProgramParameterException,
			UnknownProgramParameterException, RunException {

		super.parseProgramConfigParams(programConfig);

		optParaList = new ArrayList<ProgramParameter<?>>();

		if (props.getSections().contains(programConfig.getName())) {

			/*
			 * These parameters are used for parameter optimization. If we are
			 * in parameter optimization mode and there are concrete values for
			 * this parameters in this section, they will be ignored.
			 */
			final String[] optimizationParas = props.getSection(
					programConfig.getName()).getStringArray(
					"optimizationParameters");

			/*
			 * Check whether the given optimization parameter are indeed defined
			 * as optimizable parameters in the program config.
			 */
			for (String optPa : optimizationParas) {
				try {
					ProgramParameter<?> p = programConfig.getParamWithId(optPa);
					if (!programConfig.getOptimizableParams().contains(p))
						throw new NoOptimizableProgramParameterException(
								"The run config "
										+ absPath.getName()
										+ " contained invalid optimization parameters: "
										+ optPa
										+ " is not an optimizable program parameter of program "
										+ programConfig.getProgram());
					optParaList.add(p);
				} catch (UnknownProgramParameterException e) {
					/*
					 * Modify the message
					 */
					throw new UnknownProgramParameterException("The run "
							+ absPath.getName()
							+ " contained invalid parameter values: "
							+ programConfig.getProgram()
							+ " does not have a parameter " + optPa);
				}
			}

			if (props.getSection(programConfig.getName()).containsKey(
					"optimizationMethod")) {
				paramOptMethods.add(props.getSection(programConfig.getName())
						.getString("optimizationMethod"));
			}
			/*
			 * Default optimization method of this run config
			 */
			else
				paramOptMethods.add(paramOptMethod);
		}
		/*
		 * If there are no explicit optimization parameters set in the run
		 * config, use all optimizable parameters of program config.
		 */
		else {
			optParaList.addAll(programConfig.getOptimizableParams());
			paramOptMethods.add(paramOptMethod);
		}

		if (optParaList.isEmpty())
			throw new RunException(
					"At least one optimization parameter must be specified for program configuration "
							+ programConfig);

		optimizationParameters.add(optParaList);
	}
}