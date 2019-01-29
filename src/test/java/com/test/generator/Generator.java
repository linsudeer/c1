package com.test.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {

	private static Logger logger = LoggerFactory.getLogger(Generator.class);

	public static void main(String[] args)  {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ConfigurationParser cp = new ConfigurationParser(warnings);
			String resPath = "/generator.xml";
			InputStream is = Generator.class.getResourceAsStream(resPath);
			if(is == null){
				logger.error("["+ resPath+"] is not found!");
				return;
			}
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			logger.info("Generator Success!");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
