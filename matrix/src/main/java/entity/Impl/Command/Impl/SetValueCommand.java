package entity.Impl.Command.Impl;

import entity.Impl.Command.CommandManager;
import entity.Impl.Command.Interfaces.ICommand;
import entity.Interfaces.IMatrix;

public class SetValueCommand extends ACommand {

    private Double value;
    private Double prevValue;
    private int i;
    private int j;

    public SetValueCommand(IMatrix matrix, CommandManager commandManager, int i, int j, Double value) {
        super(matrix, commandManager);
        this.prevValue = matrix.getValue(i, j);
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public void execute() {
        super.execute();
        super.matrix.setValue(i, j, value);
    }

    @Override
    public ICommand copy() {
        return new SetValueCommand(matrix, commandManager, i, j, value);
    }

    @Override
    public void undo() {
        matrix.setValue(i, j, prevValue);
    }
}
