package com.finance.validators;


import com.finance.service.ServiceImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.finance.model.Client;

public class ClientValidator implements Validator{

    private ServiceImpl service;

    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "Required");
        if(client.getFirstname().length() < 2 || client.getFirstname().length() > 20) errors.rejectValue("firstname", "");
        if(client.getFirstname().matches("[^a-zA-Z]{2,20}")) errors.rejectValue("firstname", "");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "Required");
        if(client.getLastname().length() < 2 || client.getLastname().length() > 20) errors.rejectValue("lastname", "");
        if(client.getLastname().matches("[^a-zA-Z]{2,20}")) errors.rejectValue("lastname", "");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "Required");

    }
}
