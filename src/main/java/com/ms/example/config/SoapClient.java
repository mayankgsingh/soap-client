package com.ms.example.config;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ms.example.service.DocResponse;
import com.ms.example.service.WsServiceService;

/**
 * SOAP Client
 */
public class SoapClient {
  private static final Logger log = LoggerFactory.getLogger(SoapClient.class);
  
  private static final String WSURL = "http://localhost:9000/doc?wsdl";
  private final static String OUT_FILE = "c:\\temp\\wsout.pdf"; 
  public static void main(String args[]) throws Exception {
    log.info("Fetching file...");
    WsServiceService ss = new WsServiceService(new URL(WSURL));
    DocResponse doc = ss.getWsServicePort().getDocument("check");
    Files.write(Paths.get(OUT_FILE), doc.getData(), StandardOpenOption.CREATE_NEW);
    log.info("Done. Downloaded at {}", OUT_FILE);
  }
}
