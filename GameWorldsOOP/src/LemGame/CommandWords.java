package LemGame;

import java.util.HashMap;

<<<<<<< HEAD
/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
=======
class CommandWords {
    
    private HashMap<String, CommandWord> validCommands;
    
    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
                for (CommandWord command: CommandWord.values()) {
                    if (command != CommandWord.UNKNOWN) {
                        validCommads.put
                    }
                }
    }
>>>>>>> 19b2eb2590f4a0a0731d82124ac3e06438100243

public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
