package com.connectix.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

public class Helper {
    
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public static String getEmailOfLoggedInUser(Authentication authentication) {
        // Check if the user is authenticated
        if (authentication != null) {
            logger.info("Getting data from local database");
            return authentication.getName(); // Return the username for local authentication
        }
        
        logger.warn("No authentication found");
        return null; // Return null if not authenticated
    }
}
