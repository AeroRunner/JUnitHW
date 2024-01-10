package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ProTracker;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("����������������� �����")
public class ProTrackerParamTests extends BaseTest {
  ProTracker tracker = new ProTracker();

  @BeforeEach
  void setUp(){
    tracker.openHomePage();
  }

  @ParameterizedTest(name = "��� ���������� ������� {0} ������ ������������ ����� {1}")
  @CsvFileSource(resources = "/test_data/test_ProTracker_Hero_Resourses.csv")
  @Tag("smoke")
  @DisplayName("����� ����� �� ������ �����")
  void whenUserSearchOneWordServiceDefinesRightHero(String searchWord, String rightHero) {
    $("#search").setValue(searchWord).pressEnter();
    $(".hero-header-stats").shouldHave(text(rightHero));
  }

  @ParameterizedTest(name = "�� ������ ������ � ����� {0} �������� ������ ������ ������")
  @ValueSource(strings = {"Dendi", "Yatoro", "Ceb", "Pure"})
  @Tag("regress")
  @DisplayName("����� ������� ����������������� ������ �� ��������")
  void whenUserSearchProPlayerServiceShowThisPlayerProfile(String searchPlayer) {
    $("#search").setValue(searchPlayer).pressEnter();
    $(".wrapper-head-text").shouldHave(text("Matches"));
  }

  static Stream<Arguments> demirOfficialPageRuRightButtonsNav() {
    return Stream.of(
            Arguments.of(List.of
                    ("All","Carry","Mid","Off","Pos 4","Pos 5"))
    );
  }
  @ParameterizedTest(name = "� ��������� Top Heroes ���������� ��������� ��������")
  @MethodSource
  @Tag("regress")
  @DisplayName("�������� ����������� ��������� �������� �� ����� ������ ������")
  void demirOfficialPageRuRightButtonsNav(List<String> currentButtons) {
    $$("#top-heroes a").filter(visible).shouldHave(texts(currentButtons));
  }
}




