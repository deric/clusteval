/**
 * 
 */
package de.clusteval.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Christian Wiwie
 * 
 */
public class RecursiveSubDirectoryIterator implements Iterator<File> {

	protected List<File> files;
	protected int pos;

	/**
	 * @param file
	 */
	public RecursiveSubDirectoryIterator(final File file) {
		this.files = new ArrayList<File>();
		this.pos = 0;
		search(file);
	}

	protected void search(final File file) {
		if (file.isDirectory())
			for (File child : file.listFiles())
				search(child);
		else
			this.files.add(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.pos < this.files.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public File next() {
		return this.files.get(this.pos++);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		// not supported
	}

}
