package LemGame;


public class Command
{
    
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
}