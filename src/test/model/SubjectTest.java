//package model;
//
//import model.recordrepetitions.RepetitionsMap;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//
//public class SubjectTest {
//
//    private Subject subject;
//    private RepetitionObserver observer;
//
//    @BeforeEach
//    public void runBefore(){
//        subject = new Subject();
//        observer = new RepetitionsMap();
//    }
//
//    @Test
//    public void testAddObserver(){
//        assertEquals(0, subject.getListOfObservers().size());
//        subject.addObserver(observer);
//        assertEquals(1, subject.getListOfObservers().size());
//        subject.addObserver(observer);
//        assertEquals(1, subject.getListOfObservers().size());
//    }
//
////    @Test
////    public void testNotifyObserver(){
////        subject.notifyObserver("Test", 1);
////    }
//
//    @Test
//    public void testSaveAndLoad() throws IOException, ClassNotFoundException {
//        subject.save("testsubjectsavefile.txt");
//        subject.addObserver(observer);
//        assertEquals(1, subject.getListOfObservers().size());
//        subject.load("testsubjectsavefile.txt");
//        assertEquals(0, subject.getListOfObservers().size());
//    }
//}
