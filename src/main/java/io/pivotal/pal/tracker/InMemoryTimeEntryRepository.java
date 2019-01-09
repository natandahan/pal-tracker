package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map <Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long counter = 1;

    public TimeEntry create(TimeEntry timeEntry) {
        long id = getNextId();
        TimeEntry timeEntryToSave = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(id, timeEntryToSave);

        return timeEntryToSave;
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        TimeEntry timeEntryToSave = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(id, timeEntryToSave);

        return timeEntryToSave;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }

    private long getNextId(){
        return counter++;
    }
}
