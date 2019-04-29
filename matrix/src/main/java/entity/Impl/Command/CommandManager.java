package entity.Impl.Command;

import entity.Impl.Command.Impl.ACommand;
import entity.Impl.Command.Impl.InitCommand;
import entity.Impl.Command.Interfaces.ICommand;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandManager {

    private volatile AtomicBoolean locked = new AtomicBoolean(false);
    private static Deque<ICommand> commands = new ConcurrentLinkedDeque<>();
    private static CommandManager instance;

    private CommandManager() {
        commands.addLast((ACommand)new InitCommand(this));
    }

    public static CommandManager getInstance(){
        return instance != null ? instance : new CommandManager();
    }

    public void registry(ICommand command) {
        commands.addFirst((ACommand)command);
    }

    public void rollback(){
        locked.set(true);
        commands.iterator().forEachRemaining(el -> ((ACommand)el).undo());
        commands.clear();
        commands.addLast(new ACommand(this));
        locked.set(false);
    }

    public void undoLastCommand(ICommand command) {
        if (!commands.contains(command))
            throw new UnregisteredCommandException();
        if(commands.isEmpty())
            return;

        locked.set(true);
        ICommand currentCommand = commands.getLast();
        Deque<ICommand> currentCommands = new ConcurrentLinkedDeque<>();

        Iterator<ICommand> iterator = commands.descendingIterator();

        while(currentCommand != command){
            currentCommands.addLast(currentCommand);
            currentCommand = iterator.next();
        }

        rollback();
        currentCommands.iterator().forEachRemaining(ICommand::execute);
        locked.set(false);
    }

}
