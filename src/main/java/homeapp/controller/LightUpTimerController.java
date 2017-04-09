package homeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/lightUpTimers")
public class LightUpTimerController {
  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "lightUpTimer/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String createForm() {
    return "lightUpTimer/createForm";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String create() {
    return "redirect: /lightUpTimers";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") int id) {
    return "lightUpTimer/detail";
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public String editForm(@PathVariable("id") int id) {
    return "lightUpTimer/editForm";
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
  public String edit(@PathVariable("id") int id) {
    return "redirect: /lightUpTimers/" + id;
  }

  @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
  public String delete(@PathVariable("id") int id) {
    return "redirect: /lightUpTimers";
  }
}