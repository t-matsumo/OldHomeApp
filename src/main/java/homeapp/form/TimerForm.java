package homeapp.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TimerForm {
  @NotNull
  @Size(min = 1)
  private String task;

  @NotNull
  @Min(0)
  @Max(23)
  private int hour;
  
  @NotNull
  @Min(0)
  @Max(59)
  private int minute;

  public TimerForm() {}

  public TimerForm(String task, int hour, int minute) {
    this.task  = task;
    this.hour  = hour;
    this.minute = minute;
  }

  public String getTask() {
    return this.task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public int getHour() {
    return this.hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return this.minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }
}