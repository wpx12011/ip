package duke.command;

import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Represents a command which searches through the task list.
 */
public class FindCommand extends Command {

    protected String taskName;

    /**
     * Class constructor.
     * @param commandName Input command name.
     * @param taskName Target task name.
     */
    public FindCommand(String commandName, String taskName) {
        super(commandName);
        this.taskName = taskName;
    }

    /**
     * Executes the command to search for matching task.
     * @param tasks Current task list.
     * @param ui Ui to show task list.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        String result = "";
        result = result + ui.showSearchInformation() + "\n";
        int taskNo = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            if (curTask.toString().contains(this.taskName)) {
                taskNo += 1;
                result = result + ui.showTask(tasks.get(i), taskNo) + "\n";
            }
        }
        if (taskNo == 0) {
            return ui.showZeroSearchResult();
        }
        return result;
    }
}
