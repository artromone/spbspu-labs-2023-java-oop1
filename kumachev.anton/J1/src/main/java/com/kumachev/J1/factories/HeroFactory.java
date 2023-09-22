package com.kumachev.J1.factories;

import com.kumachev.J1.Hero;
import com.kumachev.J1.exceptions.InvalidCommandException;

public interface HeroFactory {
    Hero createFromCmd(String cmd) throws InvalidCommandException;
}
