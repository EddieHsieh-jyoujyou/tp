package seedu.address.commons.util;

import java.util.Comparator;

import seedu.address.model.person.Person;

public class SortPersonUtil implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return (o1 == o2) ? 0 :
                ((o1 == null) ? -1 :
                ((o2 == null) ? 1 :
                        o1.getName().toString().compareTo(o2.getName().toString())));
    }
}
