package com.finance.validators;


import com.finance.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.finance.model.Client;

@Component
public class ClientValidator implements Validator{

    @Autowired
    private ServiceImpl service;

    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        Client client = (Client) o;

        String namePattern = "[^a-zA-Z]{2,20}";

        String phoneNumberPattern = "^\\+(38).*050.*|.*063.*|.*066.*|.*067.*|.*068.*|" +
                                        ".*093.*|.*095.*|.*096.*|.*097.*|.*098.*|.*099.*\\d{7}";

        String emailPattern = "\\w+@\\w+\\.\\w{2,3}";

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "Required");
        if(client.getFirstname().length() < 2 || client.getFirstname().length() > 20) errors.rejectValue("firstname", "Length.clientForm.name");
        if(client.getFirstname().matches(namePattern)) errors.rejectValue("firstname", "Format.clientForm.name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "Required");
        if(client.getLastname().length() < 2 || client.getLastname().length() > 20) errors.rejectValue("lastname", "Length.clientForm.name");
        if(client.getLastname().matches(namePattern)) errors.rejectValue("lastname", "Format.clientForm.name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if(client.getEmail().length() > 50) errors.rejectValue("email", "Length.clientForm.email");
        if(client.getEmail().matches(emailPattern)) errors.rejectValue("email", "Format.clientForm.email");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(client.getPassword().length() < 8 || client.getPassword().length() > 30) errors.rejectValue("password", "Length.clientForm.password");
        if(client.getPassword().matches("[^\\w]{8,30}")) errors.rejectValue("password", "Format.clientForm.password");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "Required");
        if(!(client.getPhonenumber().matches(phoneNumberPattern))) errors.rejectValue("phonenumber", "Format.clientForm.phonenumber");
        if(service.findClientByPhonenumber(client.getPhonenumber()) != null) errors.rejectValue("phonenumber", "Revice.clientForm.phonenumber");

    }
}
