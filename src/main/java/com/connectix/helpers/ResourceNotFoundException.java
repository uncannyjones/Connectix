package com.connectix.helpers;

public class ResourceNotFoundException extends RuntimeException{
    
        public ResourceNotFoundException(String message) {
            super(message);
        }
    
        public ResourceNotFoundException(){
            super("Not FOUND");
        }
   
}

