package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Параметризованные тесты")
public class ParametrizedTestsProTracker extends BaseTest {

  @BeforeEach
  void homeWebStart() {
    open("https://dota2protracker.com");
  }

  @ParameterizedTest(name ="Для поискового запроса {0} должен определяться герой {1}" )
  @CsvFileSource(resources = "/test_data/test_ProTracker_Hero_Resourses.csv")
  @Tag("smoke")
  @DisplayName("Поиск героя по одному слову")
    void whenUserSearchOneWordServiceDefinesRightHero(String searchWord, String rightHero ){
    $("#search").setValue(searchWord).pressEnter();
    $(".hero-header-stats").shouldHave(text(rightHero));
  }

  @ParameterizedTest(name="По поиску игрока с ником {0} выдается список матчей игрока")
  @ValueSource(strings = {"Dendi", "Yatoro", "Ceb","Pure" })
  @Tag("second")
  @DisplayName("Поиск профиля профессионального игрока по никнейму")
  void whenUserSearchProPlayerServiceShowThisPlayerProfile(String searchPlayer){
    $("#search").setValue(searchPlayer).pressEnter();
    $(".wrapper-head-text").shouldHave(text("Matches"));
  }
//  static Stream<Arguments> whenUserSearchProPlayerServiceShowThisPlayerProfile(){
//    return Stream.of(
//            Arguments.of(),
//            Arguments.of()
//    );
  }




