/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.validate;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author dy
 */
@FacesValidator("landlineValidator")
public class PhoneValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String componentValue = value.toString();
        
        pattern = Pattern.compile("6\\d{7}$|1[3,5,8]\\d{9}");
        matcher = pattern.matcher(componentValue);
        if (!matcher.find()) {
        String msg = MessageFormat.format("{0} not a valid phone number format", componentValue);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        throw new ValidatorException(facesMessage);
}
    }
    
}
