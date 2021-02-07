package app.appmeteo.controller.CLI.session;

import java.io.IOException;
import java.util.Scanner;

import app.appmeteo.controller.CLI.CLIController;
import app.appmeteo.controller.Commands.*;
import app.appmeteo.controller.User;


/**
 * <head>
 *     <font size="5">
 * </head>
 * <body font-size="10px">
 * A Session is basically what it's naming describes.
 * It is a comprehensive abstract class that aims to logically merge and divide the work of this app.<br>
 * Every Session can :
 * <ul>
 *     <li>give insight of how it works (abstract)</li>
 *     <li>give its naming (abstract)</li>
 *     <li>be left (not abstract)</li>
 *     <li>be launched (not abstract)</li>
 *     <li>treat a query (treated both abstractly and not abstractly)</li>
 *     <li>treat other Session's specific queries! (not abstract)</li>
 * </ul>
 * But each different Session gives different way of treating a query
 * </body>
 */
public abstract class Session{

    protected User user;
    protected boolean isOver;

    protected Session(User usr) {
        user = usr;
        isOver = false;
    }

    protected Session(Scanner scan) throws IOException {
        user = new User(scan);
        isOver = false;
    }

    public void launch() throws IOException {
        while (!isOver) {
            System.out.println("\n" + toString() + " --- Please Input your command:");
            user.next();
            treatQuery();
            CLIController.displayData();
        }
    }

    public void treatQuery() throws IOException {
        switch (this.user.getQuery()[0]) {
            case CommandType.HELP: {
                CLIController.addDisplay(getHelp());
                break;
            }
            case CommandType.QUIT: {
                CLIController.addDisplay("Leaving " + toString() + "...");
                user.favouriteList.write();
                this.isOver = true;
                break;
            }
            case CommandType.FAV: {
                if (user.getQueryLength() > 1) {
                    user.setQuery(1);
                    Session fastSession = new FavouriteSession(user);
                    treatOtherSessionQuery(fastSession);
                    break;
                }
            }
            case CommandType.WEATHER: {
                if (user.getQueryLength() > 1) {
                    user.setQuery(1);
                    Session fastSession = new WeatherSession(user);
                    treatOtherSessionQuery(fastSession);
                    break;
                }
            }
        }
    }

    public void treatOtherSessionQuery(Session otherSession) throws IOException {
        otherSession.treatQuery();
        CLIController.displayData();
    }

    public abstract String getHelp();

    @Override
    public abstract String toString();
}
