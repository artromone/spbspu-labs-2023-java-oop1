package org.example.hero;

import org.example.exceptions.UnknownCommandException;

public interface HeroSender {
  void sendHero(String name) throws UnknownCommandException;
}
