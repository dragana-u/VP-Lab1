<details>
    
<summary>Лабораториска вежба 1</summary> 
    
Креирајте нов Spring Boot проект со група mk.finki.ukim.mk и artefactId=lab кој ги има истите зависности како проектот од аудиториските вежби (зависностите може да ги видите во <dependency> тагoвите во pom.xml).
Дефинирајте пакет mk.ukim.finki.wp.lab.model и во него креирајте ја EventBooking класата. Таа треба да содржи:
String eventName,
String attendeeName,
String attendeeAddress и
Long numberOfTickets.
Во mk.ukim.finki.wp.lab.model креирајте Event класа која ќе содржи:
String name,
String description,
double popularityScore,
Креирајте класа EventRepository во пакетот mk.ukim.finki.wp.lab.repository, во која ќе чувате List<Event> иницијализирана со 10 вредности.
Имплементирајте метод public List<Event> findAll(); кој само ќе ја врати листата.
Имплементирајте метод public List<Event> searchEvents(String text); кој ќе направи пребарување низ листата на настани и ќе ги врати оние во чие име или опис се содржи текстот text кој се праќа како аргумент на методот.
Дефинирајте ги следните интерфејси во mk.ukim.finki.wp.lab.service кои ќе ги претставуваат бизнис функционалностите на апликацијата:

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
}
public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
Имплементирајте ги сервисите (EventService треба да зависи од EventRepository).
Креирајте сервлет EventListSevlet во пакетот mk.ukim.finki.lab.web и мапирајте го на патеката /. Овој сервлет треба да зависи од EventService и да ги прикаже сите добиени настани од методот listAll(). Овозможете корисникот да избере еден од настаните и за истиот да наведе број на карти што сака да ги нарача. Креирајте по едно радио копче за секој настан каде што вредноста на копчето ќе биде имете на настанот, а текстот кој ќе се прикаже ќе биде во форматот: Name: <event_name>, Description: <event_description>, Rating: <popularity_score>

Прилагодете го фајлот listEvents.html за изгледот на оваа страница.
```
<html>
    <head>
        <meta charset="utf-8">
        <title>Event Booking page - Welcome and choose an Event</title>
        <style type="text/css">
            body {
                width: 800px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <header>
             <h1>Welcome to our Event Booking App</h1>
        </header>
        <main>
            <h2>Choose an event:</h2>
            <!-- Display radio buttons for each event,
                    the value should be the event name 
                    and the displayed text should be Name: <event_name>, Description: <event_description>, Rating: <popularity_score> -->

             <h2>Choose number of tickets:</h2>
             <input type="number" name="numTickets" min="1" max="10"><br/>
             <br/>
             <input type="submit" value="Submit">
        </main>
    </body>
</html>
```
При избор на настан, треба да ја прикажете резервацијата на корисникот. За оваа цел креирајте сервлет EventBookingServlet мапиран на /eventBooking.

Овој сервлет треба да ја прикажете страната за потврда на резервацијата
Во фолдерот src/main/resources/templates додадете фајл bookingConfirmation.html.

Прилагодете го фајлот bookingConfirmation.html за изгледот на оваа страница.

    <html>
        <head>
            <meta charset="utf-8">
            <title>Booking - Confirmation</title>
            <style type="text/css">
                 body {
                     width: 800px;
                     margin: auto;
                }
                table {
                     width:100%;
                }
                table, td, th {
                    border: 1px solid black;
                    padding: 3px 2px;
                }
           </style>
        </head>
        <body>
           <section>
               <header>
                   <h1>Event Booking page - Booking confirmation </h1>
               </header>
               <table>
                   <tr>
                       <th colspan="2">
                           Your Booking Status
                      </th>
                  </tr>
                   <tr>
                       <td><b>Attendee Name </b></td>
                       <td>Petko Petkov</td>
                  </tr>
                  <tr>
                      <td><b>Client IP Address</b></td>
                      <td>127.0.0.1</td>
                 </tr>
                 <tr>
                     <td><b>Booking for Event</b></td>
                     <td>Oppenheimer</td>
                 </tr>
                 <tr>
                     <td><b>Number of tickets</b></td>
                     <td>2</td>
                 </tr>
             </table>
           </section>
        </body>
    </html>
Да се имплементира можност за пребарување на настаните на почетната страна listEvents.html. Треба да се прикажат само настаните кои ги исполнуваат условите од пребарувањето. Пребарувањето треба да се изврши според два параметри:
настани кои го содржи текстот испратен од страна на корисникот во нивното име
настани кои имаат рејтинг поголем или еднаков на внесената вредност од страна на корисникот

**Дополнително барање** <br>
Да се додаде страна која се прикажува пред почетната страна каде што се прават резервациите и да содржи input поле за внес на име. По внесот, те пренасочува кон почетната страна каде што се прави резервација и најпосле во bookingconfirmation се прикажува тековната резервација како и сите претходни резервации на моменталниот корисник.

</details>

<details>
    <summary>Лабораториска вежба 2</summary>
Спецификација за лабораториската вежба <br>
Во оваа вежба ќе треба да продолжите со работа во рамки на проектот од претходната лабораториска вежба.<br>
Во класата Event додадете уште едно својство, private Long id, кое е уникатно за секој настан. Притоа, id генерирајте за секој настан, како што е направено во рамки на аудиториската вежба.<br>
Додадете класа Location во рамки на пакетот mk.ukim.finki.wp.lab.model. Во истата ќе чувате:<br>
private Long id<br>
private String name<br>
private String address<br>
private String capacity<br>
private String description<br>
Во класата Event додадете врска до класата Location како посебно својство.<br>
private Location location<br>
Креирајте LocationRepository класа во пакетот mk.ukim.finki.wp.lab.repository, и во неа иницијализирајте листа во која ќе има 5 локации. Во рамки на класата напишете и метод public List<Location> findAll() кој ги враќа сите локации што постојат во системот. За секој од настаните иницијализирајте некоја од локациите во атрибутот location.<br>
Во рамки на пакетот mk.ukim.finki.wp.lab.service креирајте интерфејс LocationService како и класа која го имплементира LocationServiceImpl (во impl потпакетот). Нека во овој сервис се креира метод public List<Location> findAll() кој го повикува соодветниот метод од LocationRepository.<br>
Дефинирајте пакет mk.ukim.finki.wp.lab.web.controller и во него креирајте ја EventController класата.<br>
Имплементирајте метод public String getEventsPage(@RequestParam(required = false) String error, Model model) кој само треба да го прикаже погледот на сите настани. Нека одговара на mapping /events. Погледот на сите настани нека биде listEvents.html, со тоа што во него ќе ги направите потребните промени со приказ на името на локацијата, притоа оставајќи ја функционалноста на избирање на настан и број на билети што сака да ги нарача. Дополнително до секој настан додадете две копчиња, едно кое ќе преставува линк за пренасочување кон страницата за едитирање на тој настан, и второто кое ќе овозможи бришење на настанот.<br>
Имплементирајте метод public String saveEvent() кој ќе овозможи додавање на нов настан и кој како request параметри ќе ги прими името на настанот name, описот на настанот description, рејтингот popularityScore и id-то на локацијата кој корисникот ќе го бира од паѓачко мени (<select> таг). Нека одговара на mapping /events/add, и при успешно додаден настан нека редиректира кон погледот со сите настани.<br>
Имплементирајте метод public String editEvent(@PathVariable Long eventId) кој ќе овозможи ажурирање на настаните кој како request параметри ќе ги прими името на настанот name, описот на настанот description, рејтингот popularityScore и id-то на локацјата кој корисникот ќе го бира од паѓачко мени (<select> таг). Како предефинирани вредности на сите полиња треба да се земат од настанот што се уредува. Нека одговара на mapping /events/edit/{eventId} каде eventId е id-то на настанот што се уредува и при успешно ажурирање нека редиректира кон погледот со сите настани.
Имплементирајте метод public String deleteEvent(@PathVariable Long id). Нека одговара на mapping /evnts/delete/{id}, и при успешно избришан настан од листата повторно нека ја прикажува листата со настани.<br>
Внимавајте како ќе бидат анотирани методите од барањето 6, зависно нивната функционалност.<br>
Имајќи ги предвид методите на web слојот кои треба да ги имплементирате, креирајте ги сите потребни методи во рамки на сервисниот слој.<br>
Имајќи ги предвид методите на service слојот кои треба да ги имплементирате, креирајте ги сите потребни методи во рамки на repository слојот.<br>
Креирајте страна add-event.html, која треба да прикажува форма за додавање на нов настан. Истата форма би требало да се употреби и за едитирање на настан, при што за еден настан може да ги менуваме само името, описот и локацијата (за ова може да искористите готов html template или пак оној од проектот од аудиториски вежби, што соодветно ќе го прилагодите). Дополнително, имајте предвид дека за локацијата би имале <select> таг, односно ќе може да избираме од листа со сите локации.<br>
Во рамки на listEvents.html, додадете копчe за бришење на настан и копче за едитирање на настан (во рамки на секој item во листата). Дополнително, додадете копче за додавање на нов настан кон листата (слично како што се прави во рамки на аудиториската вежба).<br>
До овој момент треба да имате целосна функционалност на прикажување на сите настани во листата, како и бришење на еден настан од истата. Повторно, потребно е да ја надополните EventController класата.<br>
Имплементирајте метод public String getEditEventForm(), кој одговара на mapping /events/edit-form/{id}. Направете ги сите потребни промени во дефиницијата на методот за да го овозможите ова. Овој метод треба да ја прикаже add-event.html страната. Кога едитираме настан, потребно е во рамки на формата да се прикажуваат неговите моментални податоци (слично како во проектот од аудиториската вежба). Дополнително, доколку се пристапи патеката /events/edit-form/{id}, со id за кое нема настан во рамки на листата, нека се направи редирект кон листата со настани, при што ќе се прикаже и порака за грешка.<br>
Имплементирајте метод public String getAddEventPage(), кој одговара на mapping /events/add-form и ја прикажува add-event.html страната.<br>
Формата која се наоѓа на add-event.html страната, ќе прави POST барање кон EventController, со што ќе овозможите креирање на нов настан или пак едитирање на настан.<br>
Функционалноста на сервлетот EventBookingServlet при додавање на нова нарачка, заменете ја со контролер (EventBookingController) во кој ќе овозможете креирање на нова резервација и приказ на страницата со потврда на резервацијата.<br>
При тестирање проверете<br>
дали успешно ја прикажувате листата со настани<br>
дали можете да креирате нов настан, да едитирате настан и да избришете настан<br>
дали работат функционалностите од претходната вежба, односно успешно стигате до потврда за резервацијата<br>
дали успешно ја прикажувате резервацијата на моменталниот корисник <br>
Дополнително барање: Во табелата со сите настани да се додаде копче Details и при клик да се прикажат деталите за настанот, како и сите резервации кои се направени за тој настан.
</details>
