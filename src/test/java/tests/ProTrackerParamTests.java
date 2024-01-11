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

@DisplayName("Parameterized tests")
public class ProTrackerParamTests extends BaseTest {
  ProTracker tracker = new ProTracker();

  @BeforeEach
  void setUp(){
    tracker.openHomePage();
  }

  @ParameterizedTest(name = "For search query {0} the hero {1} must be defined")
  @CsvFileSource(resources = "/test_data/test_ProTracker_Hero_Resourses.csv")
  @Tag("smoke")
  @DisplayName("Search for a hero by one word")
  void whenUserSearchOneWordServiceDefinesRightHero(String searchWord, String rightHero) {
    $("#search").setValue(searchWord).pressEnter();
    $(".hero-header-stats").shouldHave(text(rightHero));
  }

  @ParameterizedTest(name = "Searching for a player with the nickname {0} displays a list of the player's matches")
  @ValueSource(strings = {"Dendi", "Yatoro", "Ceb", "Pure"})
  @Tag("regress")
  @DisplayName("Search for a professional player's profile by nickname")
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
  @ParameterizedTest(name = "In the Top Heroes category, filters are written correctly")
  @MethodSource
  @Tag("regress")
  @DisplayName("Checking the correct spelling of filters based on the roles of the best heroes")
  void demirOfficialPageRuRightButtonsNav(List<String> currentButtons) {
    $$("#top-heroes a").filter(visible).shouldHave(texts(currentButtons));
  }
}




