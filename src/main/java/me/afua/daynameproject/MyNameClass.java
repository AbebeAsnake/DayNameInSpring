package me.afua.daynameproject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyNameClass {
    private LocalDate theDate;
    private String maleName;
    private String femaleName;
    private DayOfWeek theDay;
    private String myAnimal;


    public MyNameClass() {

    }

    public MyNameClass(String aDate) {
        //Set the value of the date as soon as the class is created.
        DateTimeFormatter enteredFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        theDate = LocalDate.parse(aDate, enteredFormat);
        calculateChineseZodiac();

        //Used the enum value of the day of the week instead of getting a text value.
        //It makes the switch statement more efficient.
        theDay = theDate.getDayOfWeek();
        setAllNames();
    }

    public LocalDate getTheDate() {
        return theDate;
    }

    public void setTheDate(LocalDate theDate) {
        this.theDate = theDate;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    private void setAllNames() {
        //enum values are useful! Look at the code below to see why...
        switch (theDay) {
            case MONDAY:
                //Using setters here, so I don't have call variables directly
                setFemaleName("Adjoa");
                setMaleName("Kojo");
                break;

            case TUESDAY:
                setFemaleName("Abena");
                setMaleName("Kwabena");
                break;

            case WEDNESDAY:
                setFemaleName("Akua");
                setMaleName("Kweku");
                break;

            case THURSDAY:
                setFemaleName("Yaa");
                setMaleName("Yaw");
                break;

            case FRIDAY:
                setFemaleName("Afua");
                setMaleName("Kofi");
                break;

            case SATURDAY:
                setFemaleName("Ama");
                setMaleName("Kwame");
                break;

            case SUNDAY:
                setFemaleName("Akosua");
                setMaleName("Kwesi");
                break;

        }
    }

    public String fullDateFormat()
    {
        //This is so that I can get the full date format as I want it. I can also change the value of the string
        //if I modify the arguments in this method. Try it out! Create a variable called pattern and pass it to the
        //.ofPattern() method.

        DateTimeFormatter myFullDate = DateTimeFormatter.ofPattern("EEEE dd MMM yyyy");
        return theDate.format(myFullDate);
    }

    public DayOfWeek getTheDay() {
        return theDay;
    }

    public void setTheDay(DayOfWeek theDay) {
        this.theDay = theDay;
    }

    public String getMyAnimal() {
        return myAnimal;
    }

    public void setMyAnimal(String myAnimal) {
        this.myAnimal = myAnimal;
    }

    public void calculateChineseZodiac()
    {
        switch(theDate.getYear()%12)
        {
            case 0:
                setMyAnimal("Monkey");
            break;
            case 1:
                setMyAnimal("Rooster");
            break;
            case 2:
                setMyAnimal("Dog");
            break;
            case 3:
                setMyAnimal("Pig");
            break;
            case 4:
                setMyAnimal("Rat");

                break;
            case 5:
                setMyAnimal("Ox");

                break;
            case 6:
                setMyAnimal("Tiger");

                break;
            case 7:
                setMyAnimal("Rabbit");

                break;
            case 8:
                setMyAnimal("Dragon");
            break;
            case 9:
                setMyAnimal("Snake");
            break;
            case 10:
                setMyAnimal("Horse");
            break;
            case 11:
                setMyAnimal("Sheep");
            break;
        }
    }

    public boolean isGemini()
    {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate startGemini = LocalDate.parse("22 05 "+theDate.getYear(),dTF);

        LocalDate endGemini = LocalDate.parse("21 06 "+theDate.getYear(),dTF);
        if(theDate.isBefore(endGemini)&& theDate.isAfter(startGemini)){
                return true;
        }
        else{
        return false;
        }
    }
}
