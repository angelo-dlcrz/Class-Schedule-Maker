package app.components;
import app.entities.Section;
import app.entities.Subject;
import app.entities.Instructor;
import app.entities.Room;
import app.repositories.SectionRepository;
import app.repositories.SubjectRepository;
import app.repositories.InstructorRepository;
import app.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SectionInitializer {

    @Autowired
    private SectionRepository secrepo;

    @Autowired
    private SubjectRepository subrepo;

    @Autowired
    private InstructorRepository insrepo;

    @Autowired
    private RoomRepository roomrepo;

    public void init() {
        if (secrepo.count() == 0) {

            Section sec[] = new Section[3];
            // Create sections
            for (int x = 0; x < 3; x++) {
                sec[x] = new Section();
            }

            // Fetch Room and Instructor entities (make sure they are managed)
            Instructor i1 = insrepo.findByInstructorPk(1L);  // Assuming 'findByInstructorPk' method exists
            Room r1 = roomrepo.findByRoomPk(1L);  // Assuming 'findByRoomPk' method exists
            Subject s1 = subrepo.findBySubjectCode("THEO 11");  // Assuming 'findBySubjectCode' method exists

            // Ensure these entities are managed (re-attach if necessary)
            if (r1 != null) {
                r1 = roomrepo.saveAndFlush(r1);  // Re-attach Room to the session
            }
            if (i1 != null) {
                i1 = insrepo.saveAndFlush(i1);  // Re-attach Instructor to the session
            }

            // Set up Section B2
            sec[0].setSectionName("B2");
            sec[0].setDayOfTheWeekSchedule("M-TH");
            sec[0].setTimeStart("08:00");
            sec[0].setTimeEnd("09:30");
            sec[0].setSlots(30);
            sec[0].setSubject(s1);
            sec[0].getInstructors().add(i1);
            sec[0].setRoom(r1);

            // Set up Section C2
            sec[1].setSectionName("C2");
            sec[1].setDayOfTheWeekSchedule("M-TH");
            sec[1].setTimeStart("09:30");
            sec[1].setTimeEnd("11:00");
            sec[1].setSlots(30);
            sec[1].setSubject(s1);
            sec[1].getInstructors().add(i1);
            sec[1].setRoom(r1);

            // Set up Section E2
            sec[2].setSectionName("E2");
            sec[2].setDayOfTheWeekSchedule("M-TH");
            sec[2].setTimeStart("14:00");
            sec[2].setTimeEnd("15:30");
            sec[2].setSlots(30);
            sec[2].setSubject(s1);
            sec[2].getInstructors().add(i1);
            sec[2].setRoom(r1);

            // Save sections to the repository (use saveAndFlush to ensure entities are managed)
            for (int x = 0; x < 3; x++) {
                secrepo.save(sec[x]);
            }
        }
    }
}
