package com.coreoz.plume.file.db.daos;

import lombok.Value;

@Value(staticConstructor = "of")
public class FileWithName {

	private final long id;
	private final String fileName;

}
