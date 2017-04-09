package homeapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Timer implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String task;

  @Column(nullable = false)
  private int hour;
  
  @Column(nullable = false)
  private int minute;

  @Column(nullable = false)
  private Timestamp createdAt;

  public Timer() {}

  public Timer(String task, int hour, int minute) {
    this.task      = task;
    this.hour      = hour;
    this.minute    = minute;
    this.createdAt = new Timestamp(System.currentTimeMillis());
  }

  public void update(String task, int hour, int minute) {
    this.task      = task;
    this.hour      = hour;
    this.minute    = minute;
  }

  public String tell() {
    return hour + "時" + minute + "分";
  }

  public Long getId() {
    return this.id;
  }

  public String getTask() {
    return this.task;
  }

  public int getHour() {
    return this.hour;
  }

  public int getMinute() {
    return this.minute;
  }
}