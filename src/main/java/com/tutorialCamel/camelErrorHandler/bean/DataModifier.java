package com.tutorialCamel.camelErrorHandler.bean;

import com.tutorialCamel.camelErrorHandler.exceptions.ApplicationException;

import java.util.logging.Logger;

public class DataModifier {

    Logger logger = Logger.getLogger(DataModifier.class.getName());

    public String map(String input) throws Exception {
        String newBody = null;
        try {
            newBody = input.replace(",", "*");
        } catch(RuntimeException e) {
            logger.severe("RuntimeException : " + e);
            throw e;
        } catch(Exception e) {
            logger.severe("Exception : " + e);
            throw e;
        }
        return newBody;
    }

    public String mapOnException(String input) throws Exception{
        String newBody = null;

        try {
            newBody =input.replace(",", "*");
        }catch(RuntimeException e) {
            logger.severe("RuntimeException : " + e);
            throw new ApplicationException(e.getMessage());
        }catch(Exception e) {
            logger.severe("Exception : " + e);
            throw e;
        }
        return newBody;
    }
}
