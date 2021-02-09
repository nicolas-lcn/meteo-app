package app.appmeteo.controller.CLI.session;
import app.appmeteo.controller.CLI.CLIController;
import app.appmeteo.controller.Commands.*;
import app.appmeteo.model.Favourite;
import app.appmeteo.model.User;

import java.io.IOException;

public class FavouriteSession extends Session {

    protected FavouriteSession(User usr) throws IOException {
        super(usr);
    }

    @Override
    public void treatQuery() throws IOException {
        super.treatQuery();
        switch (user.getQuery().getCommandType()) {
            case FavouritesCommands.ADD: {
                user.favouriteList.addFavourite(user.getQuery().getCommand()[1]);
                break;
            }
            case FavouritesCommands.DEL: {
                user.favouriteList.delFavouriteByName(user.getQuery().getCommand()[1]);
                break;
            }
            case FavouritesCommands.LIST: {
                for (Favourite fav: user.favouriteList.getFavouriteList()) {
                    CLIController.addDisplay(fav.toString());
                }
                break;
            }
        }
    }

    @Override
    public String getHelp() {
        return "Use command:\n"
                + "'-add' + 'existing town name'    to add a town to your favorites\n"
                + "'-del' + 'favourite name' +\n"
                + "             ['favourite id']    to delete a town from your favorites\n"
                + "'-list'                          to get a display of all your current favourites\n"
                + "'quit'                           to get back to main session\n"
                + "'session' + 'session command'    to process another session specific query";
    }

    @Override
    public String toString() {
        return "Favourite Session";
    }
}
