//package com.iib.gov.config;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//import com.maxmind.db.Reader;
//import com.maxmind.geoip2.DatabaseReader;
//
//@Configuration
//public class GeoLocationConfig {
//
//    private static DatabaseReader readers =null ;
//    private final ResourceLoader resourceLoader;
//
//    public GeoLocationConfig(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
//    @Bean
//    public DatabaseReader databaseReader()  {
//        try {
//			
//		
//          //  log.info("GeoLocationConfig: Trying to load GeoLite2-Country database...");
//        //	 DatabaseReader reader;
//            Resource resource = resourceLoader.getResource("classpath:GeoLite2-City_20230418/GeoLite2-City_20230418/GeoLite2-City.mmdb");
//            InputStream dbAsStream = resource.getInputStream();
//
//        //    log.info("GeoLocationConfig: Database was loaded successfully.");
//
//            // Initialize the reader
//            return readers = new DatabaseReader
//                    .Builder(dbAsStream)
//                    .fileMode(Reader.FileMode.MEMORY)
//                    .build();
//        }
//        
//        
//            catch (Exception e) {
//    			// TODO: handle exception
//            	return null;
//    		}
//        
//        
//        
//    }
//}