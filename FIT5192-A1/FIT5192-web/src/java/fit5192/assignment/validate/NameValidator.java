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
@FacesValidator("nameValidator")
public class NameValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String componentValue = value.toString();
        pattern = Pattern.compile("[^\\d]+$");
        matcher = pattern.matcher(componentValue);
        if (!matcher.find()) {
        String msg = MessageFormat.format("{0} not a valid name format", componentValue);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        throw new ValidatorException(facesMessage);
}
    }
    
}
