/*
 * Copyright (C) 2021 Elytrium
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.elytrium.limbofilter.config;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Settings extends Config {

  @Ignore
  public static final Settings IMP = new Settings();

  @Final
  public String VERSION = "1.0.0";

  public String PREFIX = "&5&fLimboFilter &6>>&f";

  @Create
  public MAIN MAIN;

  public static class MAIN {
    public boolean ENABLE = true;
    public boolean LOGGING_ENABLED = true;
    public boolean CHECK_CLIENT_SETTINGS = true;
    @Comment({
        "Verify Online Mode connection before AntiBot.",
        "False: verify after antibot, online mode player needs to reconnect",
        "True: verify before antibot, consumes more cpu and network on attack"
    })
    public boolean ONLINE_MODE_VERIFY = false;
    public boolean CHECK_CLIENT_BRAND = true;
    public long PURGE_CACHE_MILLIS = 3600000;
    public int CAPTCHA_ATTEMPTS = 2;
    public int NON_VALID_POSITION_XZ_ATTEMPTS = 10;
    public int NON_VALID_POSITION_Y_ATTEMPTS = 10;
    public int FALLING_CHECK_TICKS = 128;
    public double MAX_VALID_POSITION_DIFFERENCE = 0.01;
    public String BRAND = "ElytraProxy BotFilter";
    @Comment({
        "If the player needs to reconnect after passing AntiBot check.",
        "If ONLINE_MODE_NEED_AUTH here and online-mode in velocity.toml is set, then premium players need to reconnect"
    })
    public boolean NEED_TO_RECONNECT = false;

    @Comment("Available - ONLY_POSITION, ONLY_CAPTCHA, CAPTCHA_POSITION, CAPTCHA_ON_POSITION_FAILED, SUCCESSFULLY")
    public String CHECK_STATE = "CAPTCHA_POSITION";
    @Comment({
        "If the player's nickname contains something from this list, hes connection will be rejected",
        "In lowercase"
    })
    public List<String> BANNED_NICK_PATTERNS = Arrays.asList(
        "dropbot", "mcspam", "mcdrop", "mcrage", "mcstorm", "extremebot", "cipher", "biboran"
    );

    @Create
    public MAIN.CAPTCHA_GENERATOR CAPTCHA_GENERATOR;

    public static class CAPTCHA_GENERATOR {
      @Comment("Path to the background image to draw on captcha (any format, 128x128), none if empty")
      public String BACKPLATE_PATH = "";
      @Comment("Path to the font files to draw on captcha (ttf), can be empty")
      public List<String> FONTS_PATH = List.of("");
      @Comment("Use standard fonts(SANS_SERIF/SERIF/MONOSPACED), use false only if you provide fonts path")
      public boolean USE_STANDARD_FONTS = true;
      public int FONT_SIZE = 50;
      public boolean FONT_OUTLINE = true;
      public boolean FONT_ROTATE = true;
      public boolean FONT_RIPPLE = true;
      public boolean FONT_BLUR = true;
      public String PATTERN = "abcdefghijklmnopqrtuvwxyz1234567890";
      public int LENGTH = 3;
    }

    @Comment(
        "Available dimensions: OVERWORLD, NETHER, THE_END"
    )
    public String BOTFILTER_DIMENSION = "THE_END";
    public boolean HARDCORE_HEARTS = true;

    @Create
    public MAIN.STRINGS STRINGS;

    public static class STRINGS {
      public String CHECKING = "{PRFX} Bot-Filter check was started, please wait..";
      public String CHECKING_CAPTCHA = "{PRFX} Please, solve the captcha";
      public String SUCCESSFUL_CRACKED = "{PRFX} Successfully passed Bot-Filter check. ";
      public String SUCCESSFUL_PREMIUM = "{PRFX} Successfully passed Bot-Filter check. Please, rejoin the server";
      public String CAPTCHA_FAILED = "{PRFX} You've mistaken in captcha check. Please, rejoin the server.";
      public String TOO_BIG_PACKET = "{PRFX} Your client sent too big packet.";
      public String FALLING_CHECK_FAILED = "{PRFX} Falling Check was failed. Please, rejoin the server.";
    }

    @Create
    public MAIN.CAPTCHA_COORDS CAPTCHA_COORDS;

    public static class CAPTCHA_COORDS {
      public double X = 0;
      public double Y = 0;
      public double Z = 0;
      public double YAW = 0;
      public double PITCH = 0;
    }
  }

  public void reload(File file) {
    load(file);
    save(file);
  }
  @Create
  public DATABASE DATABASE;

  @Comment("Database settings")
  public static class DATABASE {
    @Comment("Database type: mysql, postgre, h2, or sqlite")
    public String STORAGE_TYPE = "h2";

    @Comment("Settings for File-based databases (Like H2, SQLite): ")
    public String FILENAME = "elytraproxy.db";

    @Comment("Settings for Network-based database (like MySQL): ")
    public String HOSTNAME = "127.0.0.1:3306";
    public String USER = "user";
    public String PASSWORD = "password";
    public String DATABASE = "elytraproxy";
  }
}
