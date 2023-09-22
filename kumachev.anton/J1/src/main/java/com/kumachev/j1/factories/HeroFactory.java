package com.kumachev.j1.factories;

import com.kumachev.j1.Hero;
import com.kumachev.j1.exceptions.InvalidCommandException;

public interface HeroFactory {
    Hero createFromCmd(String cmd) throws InvalidCommandException;
}
