package contact.control;

import contact.model.Contact;
import contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alex on 07.06.2015.
 */
@Controller
public class ContactController {
    @Autowired
    ContactService contactService;



    @RequestMapping(value = "/allContacts", method = RequestMethod.GET)
    public String allContacts(Model model){
        List<Contact> allContacts =  contactService.getAllContact();
        model.addAttribute("contacts", allContacts);
        return "allContacts";
    }

    @RequestMapping(value = "/startPage", method = RequestMethod.POST)
    public String start(){

        return "startPage";
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String registration(){

        return "registrationPage";
    }


    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "registrationPage";
        }
        contactService.addContact(contact);

        model.addAttribute("success", "Contact " + contact.getFirstName()+" "+contact.getLastName()
                + " registered successfully");
        return "redirect:/allContacts";
    }

    @RequestMapping(value = "/delete/{contactId}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("contactId")
                                Integer contactId) {

        contactService.deleteContactById(contactId);

        return "redirect:/authorizationPage";
    }
}
