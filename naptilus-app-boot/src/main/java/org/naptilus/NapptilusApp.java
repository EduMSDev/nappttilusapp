package org.naptilus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.naptilus")
public class NapptilusApp {

  public static void main(String[] args) {
    SpringApplication.run(NapptilusApp.class, args);
  }
}