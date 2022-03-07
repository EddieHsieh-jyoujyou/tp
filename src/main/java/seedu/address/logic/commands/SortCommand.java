package seedu.address.logic.commands;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.util.SortPersonUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SORT_SUCCESS = "Sort Address Book success.";

    public SortCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        List<Person> persons = new ArrayList<>(model.getAddressBook().getPersonList());
        persons.sort(new SortPersonUtil());

        // reset address book
        model.setAddressBook(new AddressBook());

        // re-add person one by one
        for (Person person : persons) {
            model.addPerson(person);
        }
        return new CommandResult(MESSAGE_SORT_SUCCESS);
    }
}
