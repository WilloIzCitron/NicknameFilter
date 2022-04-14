package willoizcitron;

import arc.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;

public class NickNameFilter extends Plugin {

    boolean check(String s) {
        if (s == null) // checks if the String is null
        {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // checks whether the character is not a letter
            // if it is not a letter ,it will return false
            if ((Character.isLetter(s.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void init() {
        Events.on(PlayerConnect.class, event -> {
            if (check(event.player.name.toLowerCase())) {
                event.player.con.kick("Your Username must be a letter not Emoji, ASCII, and Symbols.");
            }
        });
    }
}

