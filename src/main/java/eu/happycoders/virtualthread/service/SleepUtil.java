package eu.happycoders.virtualthread.service;

import java.util.concurrent.ThreadLocalRandom;

public final class SleepUtil {

  private SleepUtil() {}

  public static void sleepApproximately(long millis) throws InterruptedException {
    long min = millis * 9 / 10;
    long max = millis * 11 / 10;

    Thread.sleep(ThreadLocalRandom.current().nextLong(min, max));
  }
}
