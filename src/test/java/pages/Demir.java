package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Demir {
    public SelenideElement
    demirHome = $("https://detmir.com/");
    public Demir openHomePage(){
        open("https://detmir.com/");
        return this;
    }

    }

