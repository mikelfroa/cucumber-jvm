package com.mutua.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CargadorPropiedades {
	
	public Properties cargarPropiedades() {
		Properties props = new Properties();
		String filePath = new File((System.getProperty("user.dir") + "/src/test/resources/parametros.properties")).getAbsolutePath();
		File file = new File(filePath);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			props.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if (fileInput != null) {
		        try {
		        	fileInput.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		    }
		}
		return props;
	}
}