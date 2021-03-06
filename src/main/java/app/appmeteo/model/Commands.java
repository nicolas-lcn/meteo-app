package app.appmeteo.model;

/**
 * Contains every type of command a user can possibly do
 */
public class Commands {
    /**
     * Commands types, first thing to check when the user does a query
     * if a command type does not begin with one of those, then it's a weather query
     */
    public static class CommandType {
        public static final String WEATHER = "weather";
        public static final String FAV = "fav";
        public static final String HELP = "help";
        public static final String QUIT = "quit";
    }

    /**
     * weather related commands, for no commandtype case
     */
    public static class WeatherCommands {
        public static final String TEMP = "-temp";
        public static final String WIND = "-wind";
        public static final String MORNING = "-morning";
        public static final String EVENING = "-evening";
        public static final String NIGHT = "-night";
        public static final String PRECISE = "-precise";
    }

    /**
     * favourites related commands
     */
    public static class FavouritesCommands {
        public static final String ADD = "add";
        public static final String DEL = "del";
        public static final String LIST = "list";
        public static final String WEATHER = "getw";
    }


}
