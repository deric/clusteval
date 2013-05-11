/**
 * 
 */
package de.clusteval.program;

import javax.script.ScriptException;


import de.clusteval.data.DataConfig;
import de.clusteval.framework.repository.RegisterException;
import de.clusteval.framework.repository.Repository;
import de.clusteval.utils.InternalAttributeException;

/**
 * A type of program parameter that only holds string values.
 * 
 * @author Christian Wiwie
 * 
 */
public class StringProgramParameter extends ProgramParameter<String> {

	/**
	 * Parse a string program parameter from strings.
	 * 
	 * @param programConfig
	 *            The program configuration defining this parameter.
	 * @param name
	 *            The name of the parameter.
	 * @param desc
	 *            The description of the parameter.
	 * @param minValue
	 *            The minimal value of the parameter.
	 * @param maxValue
	 *            The maximal value of the parameter.
	 * @param def
	 *            The default value of the parameter.
	 * @return The parsed string program parameter.
	 * @throws RegisterException
	 */
	public static StringProgramParameter parseFromStrings(
			final ProgramConfig programConfig, final String name,
			final String desc, final String minValue, final String maxValue,
			final String def) throws RegisterException {
		final Repository repo = programConfig.getRepository();

		StringProgramParameter result = new StringProgramParameter(repo, true,
				programConfig, name, desc, minValue, maxValue, def);

		result = programConfig.getRepository().getRegisteredObject(result);

		return result;
	}

	/**
	 * The constructor of string program parameters.
	 * 
	 * @param repository
	 *            The repository to register the new parameter.
	 * @param register
	 *            Whether to register the new parameter.
	 * 
	 * @param programConfig
	 *            The program configuration defining this parameter.
	 * @param name
	 *            The name of the parameter.
	 * @param desc
	 *            The description of the parameter.
	 * @param minValue
	 *            The minimal value of the parameter.
	 * @param maxValue
	 *            The maximal value of the parameter.
	 * @param def
	 *            The default value of the parameter.
	 * @throws RegisterException
	 */
	public StringProgramParameter(final Repository repository,
			final boolean register, final ProgramConfig programConfig,
			final String name, final String desc, String minValue,
			String maxValue, String def) throws RegisterException {
		super(repository, register, programConfig, name, desc, minValue,
				maxValue, def);
	}

	/**
	 * The copy constructor of string program parameters.
	 * 
	 * @param other
	 *            The object to clone.
	 * @throws RegisterException
	 */
	public StringProgramParameter(final StringProgramParameter other)
			throws RegisterException {
		super(other);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#clone(program.ProgramParameter)
	 */
	@Override
	public StringProgramParameter clone() {
		try {
			return new StringProgramParameter(this);
		} catch (RegisterException e) {
			// should not occur
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.RepositoryObject#register()
	 */
	@Override
	public boolean register() {
		return this.repository.register(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.RepositoryObject#unregister()
	 */
	@Override
	public boolean unregister() {
		return this.repository.unregister(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#isMinValueSet()
	 */
	@Override
	public boolean isMinValueSet() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#isMaxValueSet()
	 */
	@Override
	public boolean isMaxValueSet() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#evaluateMinValue()
	 */
	@Override
	public String evaluateMinValue(final DataConfig dataConfig,
			final ProgramConfig programConfig)
			throws InternalAttributeException {

		/*
		 * Parse minValue
		 */
		String newMinValue = this.repository.evaluateInternalAttributes(
				minValue, dataConfig, programConfig);

		try {
			newMinValue = this.repository.evaluateJavaScript(newMinValue);
		} catch (ScriptException e) {
			throw new InternalAttributeException("The expression '" + minValue
					+ "' for parameter attribute " + this.programConfig + "/"
					+ this.name + "/minValue is invalid");
		}

		return newMinValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#evaluateMaxValue()
	 */
	@Override
	public String evaluateMaxValue(final DataConfig dataConfig,
			final ProgramConfig programConfig)
			throws InternalAttributeException {

		/*
		 * Parse maxValue
		 */
		String newMaxValue = this.repository.evaluateInternalAttributes(
				maxValue, dataConfig, programConfig);

		try {
			newMaxValue = this.repository.evaluateJavaScript(newMaxValue);
		} catch (ScriptException e) {
			throw new InternalAttributeException("The expression '" + maxValue
					+ "' for parameter attribute " + this.programConfig + "/"
					+ this.name + "/maxValue is invalid");
		}

		return newMaxValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see program.ProgramParameter#evaluateDefaultValue()
	 */
	@Override
	public String evaluateDefaultValue(final DataConfig dataConfig,
			final ProgramConfig programConfig)
			throws InternalAttributeException {

		/*
		 * Parse default
		 */
		String newDefaultValue = this.repository.evaluateInternalAttributes(
				def, dataConfig, programConfig);

		try {
			newDefaultValue = this.repository
					.evaluateJavaScript(newDefaultValue);
		} catch (ScriptException e) {
			throw new InternalAttributeException("The expression '" + def
					+ "' for parameter attribute " + this.programConfig + "/"
					+ this.name + "/def is invalid");
		}

		return newDefaultValue;
	}
}