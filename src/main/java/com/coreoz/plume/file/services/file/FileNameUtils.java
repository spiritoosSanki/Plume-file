package com.coreoz.plume.file.services.file;

import java.net.FileNameMap;
import java.net.URLConnection;

public class FileNameUtils {

	private static final FileNameMap MIME_TYPE_FILENAME_MAP = URLConnection.getFileNameMap();

	/**
	 * Remove all weird characters while trying to ensure
	 * the sanitize filename is close to the original one:
	 * accent are stripped, spaces are replaced by -,
	 * upper case chars are converted to lower case.
	 *
	 * If the filename is null, null is returned
	 */
	public static String sanitize(String filename) {
		if(filename == null) {
			return null;
		}

		return StringUtils
				.stripAccents(filename)
				.toLowerCase()
				.replaceAll("\\s+", "-")
				.replaceAll("[^a-z0-9-_\\.]", "");
	}

	/**
	 * Find the corresponding mime type for the file name.
	 *
	 * If no mime type if found or the file name is empty,
	 * null is returned.
	 */
	public static String guessMimeType(String filename) {
		if(filename == null) {
			return null;
		}

		return MIME_TYPE_FILENAME_MAP.getContentTypeFor(filename);
	}

}
