package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class NameTest {

  @DisplayName("이름객체 생성 테스트.")
  @Test
  void createNameTest() {
    assertThat(new Name("test")).isEqualTo(new Name("test"));
  }

  @DisplayName("입력된 사용자명 최대 5자 검증.")
  @ParameterizedTest
  @CsvSource(value = {"user12:user1","가나다라마바:가나다라마"},delimiter = ':')
  void nameLengthValidationTest(String wrongName, String fineName) {
    assertThatThrownBy(
        () -> new Name(wrongName)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Name.MSG_ERROR_FAIL_NAME_LENGTH);

    assertThat(new Name(fineName)).isNotNull();
  }

  @DisplayName("입력된 사용자명 빈값 검증.")
  @ParameterizedTest
  @NullSource
  @EmptySource
  void nameEmptyValidationTest(String value) {
    assertThatThrownBy(
        () -> new Name(value)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Name.MSG_ERROR_FAIL_NAME_EMPTY);
  }
}