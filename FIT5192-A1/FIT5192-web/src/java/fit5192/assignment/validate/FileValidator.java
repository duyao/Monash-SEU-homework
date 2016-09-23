/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.validate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author dy
 */
@FacesValidator("fileValidator")
public class FileValidator implements Validator {

    @Override
    public void validate(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;

        if (file.getSize() > 1024000) {
            msgs.add(new FacesMessage("file too big"));
        }
        System.out.println("file.getContentType()-----"+file.getContentType()+"fdsa"+file.getSize());
        if (!"image/jpeg".equals(file.getContentType()) || !"image/png".equals(file.getContentType())) {
            msgs.add(new FacesMessage("not a picture file"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }

    }

}
