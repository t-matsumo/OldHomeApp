package homeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import homeapp.repositry.TimerRepository;
import homeapp.entity.Timer;
import homeapp.form.TimerForm;

@Controller
@RequestMapping(value = "/lightUpTimers")
public class LightUpTimerController {
  @Autowired
  private TimerRepository timerRepository;

  @RequestMapping(method = RequestMethod.GET)
  public String index(Model model) {
    Iterable<Timer> timers = timerRepository.findAll();
    
    if (timers == null) {
      return "lightUpTimer/indexNotExistTimer";
    }

    model.addAttribute("timers", timers);

    return "lightUpTimer/index";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String createForm(TimerForm timerForm) {
    return "lightUpTimer/createForm";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String create(TimerForm timerForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "lightUpTimer/createForm";
    }

    String task   = timerForm.getTask();
    int    hour   = timerForm.getHour();
    int    minute = timerForm.getMinute();
    timerRepository.save(new Timer(task, hour, minute));
    return "redirect:";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String detail(@PathVariable("id") int id) {
    return "lightUpTimer/detail";
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public String editForm(@PathVariable("id") long id, Model model) {
    Timer timer = timerRepository.findOne(id);
    model.addAttribute("timer", timer);

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