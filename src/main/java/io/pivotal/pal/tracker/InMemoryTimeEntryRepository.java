package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    private long currentTimeId = 0L;
    private final Map<Long,TimeEntry> inMemoryDataBase = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry = new TimeEntry(++currentTimeId,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        inMemoryDataBase.put(currentTimeId,entry);
        return entry;
    }

    public TimeEntry find(long id) {

        return inMemoryDataBase.get(id);

    }

    public List<TimeEntry> list() {

        return new ArrayList<TimeEntry>(inMemoryDataBase.values());

    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        TimeEntry entry = inMemoryDataBase.get(id);

        if(entry == null){
            return null;
        }
        entry.setProjectId(timeEntry.getProjectId());
        entry.setUserId(timeEntry.getUserId());
        entry.setDate(timeEntry.getDate());
        entry.setHours(timeEntry.getHours());
        return entry;
    }

    public void delete(long id) {
        inMemoryDataBase.remove(id);
    }
}
