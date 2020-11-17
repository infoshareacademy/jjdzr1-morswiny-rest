package com.isa.morswiny.Dao;


public class EventCRUDRepositoryTest {

//    private static Event testEvent;
//    private static EventCRUDRepository eventCRUDRepository;
//    private static Event event;
//
//    @BeforeAll
//    static void setUpData() {
//        eventCRUDRepository = new EventCRUDRepository();
//        event = new Event();
//        event.setId(2);
//        eventCRUDRepository.createEvent(event);
//
//    }
//
//
//    public void testGetAllEventsList() {
//    }
//
//    @Test
//    @Disabled
//    //test nie zadziala bo getByID inicjuje na nowo liste eventow i tracimy ten dodany event....
//    public void testGetEventByID() {
//
////        // given
////        LocalDateTime startDate = LocalDateTime.now();
////        LocalDateTime endDate = LocalDateTime.now();
////        Place testPlace = new Place("1",
////                "subname of the place",
////                "super place");
////        EventURL eventURL = new EventURL(
////                "www.wg.com",
////                "1"
////        );
////        Integer id = 1;
////        Attachment[] attachments = new Attachment[0];
////        Ticket tickets = new Ticket("theater",
////                "0",
////                "22");
////
////
////        testEvent = new Event(id,
////                testPlace,
////                "2020-07-22T02:00:00+0200",
////                "eventName",
////                eventURL,
////                attachments,
////                "Opis wydarzenia-bardzo dlugi",
////                "2",
////                "2020-06-22T02:00:00+0200",
////                null,
////                1,
////                tickets,
////                startDate,
////                endDate);
////
////        //when
////        eventCRUDRepository.getAllEventsList();
////        eventCRUDRepository.createEvent(testEvent);
////        Event event = eventCRUDRepository.getEventByID(1);
////
////        //then
////        assertEquals(testEvent, eventCRUDRepository.getEventByID(1));
//// //       assertNotEquals(testEvent, eventCRUDRepository.getEventByID(id+1));
//    }
//
//    @Test
//    public void testIsEventExisting() {
//
//        //given
//        Event newEvent = new Event();
//
//
//        //when
//
//
//        //then
//        assertTrue(eventCRUDRepository.isEventExisting(event));
//        assertFalse(eventCRUDRepository.isEventExisting(newEvent));
//
//    }
//
//    public void testGetNextID() {
//    }
//
//    @Test
//    public void testCreateExistingEvent() {
//
//        //given
//        Event newEvent = new Event();
//        int newId = eventCRUDRepository.getNextID() -1;
//        newEvent.setId(newId);
//
//        //when
//        eventCRUDRepository.createEvent(newEvent);
//
//        //then
//        assertFalse(eventCRUDRepository.createEvent(newEvent));
//       //assertEquals(newEvent,eventCRUDRepository.getEventByID(newId));
//    }
//
//    @Test
//    public void testCreateENonExistingEvent(){
//        //given
//        Event newEvent = new Event();
//
//        //when
//
//        //then
//        assertTrue(eventCRUDRepository.createEvent(newEvent));
//
//    }
//
//    @Test
//    public void testDeleteEvent() {
//        Event eventToDelete = new Event();
//        int newId = eventCRUDRepository.getNextID() -1;
//        eventToDelete.setId(newId);
//        eventCRUDRepository.createEvent(eventToDelete);
//
//        assertTrue(eventCRUDRepository.deleteEvent(newId));
//        //assertEquals(null,eventCRUDRepository.getEventByID(id));
//
//    }
//
//    public void testUpdateEvent() {
//    }
}