/**
 * 
 */
package de.clusteval.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Christian Wiwie
 * 
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FormatVersion {

	/**
	 * 
	 * @return The version of a format class as an integer.
	 */
	int version();
}
