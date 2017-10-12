package LemGame;

public class Command {
    private CommandWord commandWord;
    private String secondWord;
    
    
    public Command(CommandWord commandWord, String secondWord){
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    
    public String getSecondWord(){
        return secondWord;
    }
    
    
    public boolean hasSecondWord(){
         if(secondWord != null){
             return true;
         }else return false;

    }
    }
    


