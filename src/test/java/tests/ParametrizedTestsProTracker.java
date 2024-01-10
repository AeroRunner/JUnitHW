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

@DisplayName("����������������� �����")
public class ParametrizedTestsProTracker extends BaseTest {

  @BeforeEach
  void homeWebStart() {
    open("https://dota2protracker.com");
  }

  @ParameterizedTest(name ="��� ���������� ������� {0} ������ ������������ ����� {1}" )
  @CsvFileSource(resources = "/test_data/test_ProTracker_Hero_Resourses.csv")
  @Tag("smoke")
  @DisplayName("����� ����� �� ������ �����")
    void whenUserSearchOneWordServiceDefinesRightHero(String searchWord, String rightHero ){
    $("#search").setValue(searchWord).pressEnter();
    $(".hero-header-stats").shouldHave(text(rightHero));
  }

  @ParameterizedTest(name="�� ������ ������ � ����� {0} �������� ������ ������ ������")
  @ValueSource(strings = {"Dendi", "Yatoro", "Ceb","Pure" })
  @Tag("second")
  @DisplayName("����� ������� ����������������� ������ �� ��������")
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




