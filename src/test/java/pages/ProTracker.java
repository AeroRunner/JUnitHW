package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProTracker {
    public SelenideElement proTrackerHome = $("https://dota2protracker.com");
    public ProTracker openHomePage(){
        open("https://dota2protracker.com");
        return this;
    }
}
