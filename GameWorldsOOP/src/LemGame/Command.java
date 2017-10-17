package LemGame;


public class Command
{
<<<<<<< HEAD
    private CommandWord commandWord;
    private String secondWord;

    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
=======
    
    private String secondWord;
    private CommandWord commandWord;
    
    public Command(CommandWord commandWord, String secondWord) {
    this.commandWord = commandWord;
    this.secondWord = secondWord;
    }
    
    public CommandWord getCommandWord() {
        return commandWord;
    }
    
    public String getSecondWord() {
        return secondWord;
    }
    
    /*public boolean isUnknown() {
     return (this.commandWord == commandWord.UNKNOWN);   
    }*/
>>>>>>> 19b2eb2590f4a0a0731d82124ac3e06438100243
}