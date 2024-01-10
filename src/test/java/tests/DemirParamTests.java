package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.Country;
import pages.Demir;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemirParamTests extends BaseTest {
    Demir demir = new Demir();
    @BeforeEach
    void demirSetUP(){
        demir.openHomePage();
    }
    @ParameterizedTest(name = "�� ����� �������� ��� ���� ������ {0}")
    @EnumSource(Country.class)
    @DisplayName("�������� ������� ������ ������ �� ������� �������� �������� ������� ���")
    @Tag("smoke")
    void demirHomePageHaveCountries(Country country){
    $$(".content").find(text(country.name()));

    }
    }

