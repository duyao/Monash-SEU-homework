/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.validate;

import java.text.MessageFormat;
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
@FacesValidator("vinValidator")
public class VinValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 0, 1,
            2, 3, 4, 5, 0, 7, 0, 9, 2, 3,
            4, 5, 6, 7, 8, 9};
        int[] weights = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9,
            8, 7, 6, 5, 4, 3, 2};
        String s = value.toString();
        String msg = MessageFormat.format("{0} not a valid VIN format", s);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

        s = s.replaceAll("-", "");
        s = s.toUpperCase();
        if (s.length() != 17) {
            throw new ValidatorException(facesMessage);
        }

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char c = s.charAt(i);
            int vinvalue;
            int weight = weights[i];

            // letter
            if (c >= 'A' && c <= 'Z') {
                vinvalue = values[c - 'A'];
                if (vinvalue == 0) {
                    throw new ValidatorException(facesMessage);
                }
            } // number
            else if (c >= '0' && c <= '9') {
                vinvalue = c - '0';
            } // illegal character
            else {
                throw new ValidatorException(facesMessage);
            }

            sum = sum + weight * vinvalue;

        }

        // check digit
        sum = sum % 11;
        char check = s.charAt(8);
        if (check != 'X' && (check < '0' || check > '9')) {
            throw new RuntimeException("Illegal check digit: " + check);
        }
        if (sum == 10 && check == 'X') {

        } else if (sum == check - '0') {

        } else {
            throw new ValidatorException(facesMessage);
        }

    }

}
