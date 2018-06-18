package com.hr.spring.beans.collections;

import java.util.Properties;

public class DataSource {

			private Properties properties;

			public Properties getProperties() {
				return properties;
			}

			public void setProperties(Properties properties) {
				this.properties = properties;
			}

			@Override
			public String toString() {
				return "DateSource [properties=" + properties + "]";
			}
			
			
			
			
}
